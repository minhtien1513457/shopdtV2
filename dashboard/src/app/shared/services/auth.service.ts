import { Injectable } from '@angular/core';
import { HttpBackend, HttpClient } from "@angular/common/http";
import { ConfigService } from "./config.service";
import jwtDecode from "jwt-decode";
import { EMPTY, Observable, Subscription, forkJoin, of, throwError } from "rxjs";
// import {AuthUser} from "../auth/models/auth-user";
import { catchError, map, mergeMap, tap } from "rxjs/operators";
import { v4 } from "uuid";
import * as shaJs from 'sha.js';
import { Buffer } from 'buffer';
import { LocalStorageService } from './local-storage.service';
import { AuthToken } from '../modal/auth-token';


@Injectable({
  providedIn: 'root'
})
export class AuthService {
  constructor(
    private http: HttpClient,
    private httpBackend: HttpBackend,
    private localStorageService: LocalStorageService
  ) { }

  private setAuthToken(auth: AuthToken): void {
    this.localStorageService.setTokenType(auth.token_type, auth.expires_in * 1000)
    this.localStorageService.setAccessToken(auth.access_token, auth.expires_in * 1000)
    if (auth.refresh_token) {
      this.localStorageService.setRefreshToken(auth.refresh_token, auth.refresh_expires_in * 1000)
    }
    const accessPayload = jwtDecode<any>(auth.access_token);
    this.localStorageService.setIdToken(auth.id_token, auth.expires_in * 1000);
    this.localStorageService.setEmail(accessPayload.email);
  }

  callbackLogin(params: { code: string; appState: string }): Observable<any> {
    const parsedUrl = new URL(window.location.href);
    parsedUrl.searchParams.delete('code');
    parsedUrl.searchParams.delete('session_state');
    const redirectUri = parsedUrl.toString();
    const codeVerifier = this.localStorageService.getCodeVerifier();
    // case app state
    // if (this.localStorageService.getAppState() !== params.appState) {
    //     this.logout(redirectUri);
    //     throw new Error();
    // }

    const body = `client_id=${ConfigService.config.oauth_client_id}` +
      `&grant_type=authorization_code` +
      `&code=${params.code}` +
      `&code_verifier=${encodeURIComponent(codeVerifier)}` +
      `&redirect_uri=${encodeURIComponent(redirectUri)}`;

    return this.http
      .post<AuthToken>(
        ConfigService.config.key_cloak_url + '/auth/realms/my-shopdt/protocol/openid-connect/token',
        body,
        {
          headers: {
            "Content-Type": 'application/x-www-form-urlencoded'
          },
        },
      )
      .pipe(
        tap((token) => {
          this.clearAuthInfo();
          this.setAuthToken(token);
        }),
        // mergeMap(() => this.getAuthUserInfo(true)),
        catchError((err) => {
          // this.toastService.showError('Login failed', err.toString());
          setTimeout(() => {
            this.logout(redirectUri);
          }, 2000);
          return throwError(err);
        }),
      );
  }

  refreshToken(): Observable<AuthToken> {
    return of(this.localStorageService.getRefreshToken()).pipe(
      mergeMap((token) => {
        if (!token) {
          throw new Error();
        }
        const newHttpClient = new HttpClient(this.httpBackend);
        const body = `client_id=${ConfigService.config.oauth_client_id}` +
          `&grant_type=refresh_token` +
          `&refresh_token=${token}`;
        return newHttpClient.post<AuthToken>(
          ConfigService.config.key_cloak_url + '/auth/realms/my-shopdt/protocol/openid-connect/token',
          body,
          {
            headers: {
              'Content-Type': 'application/x-www-form-urlencoded'
            },
          },
        );
      }),
      tap((token) => {
        this.setAuthToken(token);
      }),
    );
  }

  logout(appUrl?: string): void {
    const backUri = appUrl || window.location.href;
    const email = this.localStorageService.getEmail();
    const tokenHint = this.localStorageService.getIdToken();
    this.revokeToken().add(() => {
      this.clearAuthInfo()
      if (email) {
        this.redirectToRootLogoutUrl(backUri, tokenHint);
      }else {
        this.redirectToLoginUrl(backUri);
      }
    });
  }

  isTokenValid(): Observable<boolean> {
    const accessToken = this.localStorageService.getAccessToken();
    const tokenType = this.localStorageService.getTokenType();
    const refreshToken = this.localStorageService.getRefreshToken();
    if (accessToken && tokenType) {
      return of(true);
    } else if (refreshToken) {
      return this.refreshToken().pipe(
        map(() => true),
        catchError(() => {
          this.logout(window.location.href);
          return of(false);
        }),
      );
    } else {
      this.logout(window.location.href);
      return of(false);
    }
  }

  private setupLoginContext(codeVerifier: string, appState: string): void {
    this.localStorageService.setCodeVerifier(codeVerifier);
    //case have app state
    // this.localStorageService.setAppState(appState);
  }

  private redirectToLoginUrl(backUri: string): void {
    window.location.href = this.initLoginUri(backUri);
  }

  private redirectToRootLogoutUrl(backUri: string, tokenHint: string): void {
    const loginUrl = this.initLoginUri(backUri);
    window.location.href = `${ConfigService.config.oauth_logout_url}?id_token_hint=${encodeURIComponent(tokenHint)}&post_logout_redirect_uri=${encodeURIComponent(ConfigService.config.root_url + '/dashboard')}`;
  }

  private initLoginUri(redirectUri: string): string {
    return ConfigService.config.oauth_login_url + '?' + this.initLoginQueries(redirectUri);
  }

  public initLoginQueries(redirectUri: string): string {
    const cleanUrl = this.cleanLoginUrlQuery(redirectUri);
    const appState = v4();
    const codeVerifier = `${v4()}-${v4()}`;
    const codeChallengeMethod = 'S256';
    const hashType = 'sha256';
    const codeChallenge = shaJs(hashType)
      .update(codeVerifier)
      .digest('base64')
      .replace(/=/g, '')
      .replace(/\+/g, '-')
      .replace(/\//g, '_');
    this.setupLoginContext(codeVerifier, appState);
    let queries = `client_id=${encodeURIComponent(ConfigService.config.oauth_client_id)}`;
    queries += `&response_type=code&code_challenge=${codeChallenge}&code_challenge_method=${codeChallengeMethod}`;
    // case have app state
    // queries += `&app_state=${appState}&redirect_uri=${encodeURIComponent(cleanUrl)}&scope=openid offline_access`;
    queries += `&redirect_uri=${encodeURIComponent(cleanUrl)}&scope=openid offline_access`;
    return queries;
  }

  private clearAuthInfo(): void {
    localStorage.clear();
  }

  private cleanLoginUrlQuery(url: string): string {
    const [baseUrl, queries] = url.split('?');
    let cleanUrl = baseUrl;
    if (queries?.length > 0) {
      const formatQueries = new URLSearchParams(queries);
      formatQueries.delete('code');
      formatQueries.delete('appState');
      if (formatQueries.toString().length > 0) {
        cleanUrl = cleanUrl + '?' + formatQueries.toString();
      }
    }
    return cleanUrl;
  }

  private revokeToken(): Subscription {
    let accessToken = this.localStorageService.getAccessToken();
    let refreshToken = this.localStorageService.getRefreshToken();
    const tokens = [];
    if (accessToken) {
      tokens.push(accessToken);
    }
    if (refreshToken) {
      tokens.push(refreshToken);
    }
    const newHttpClient = new HttpClient(this.httpBackend);
    const calls = tokens.map((token) => {
      let body = `token=${token}`;
      newHttpClient.post(
        ConfigService.config.key_cloak_url + '/auth/realms/my-shopdt/protocol/openid-connect/revoke',
        body,
        {
          headers: {
            'Content-Type': 'application/x-www-form-urlencoded'
          },
        },
      );
    });
    return forkJoin(calls)
      .pipe(catchError(() => EMPTY))
      .subscribe();
  }

}
