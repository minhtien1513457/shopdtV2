import { ActivatedRouteSnapshot, CanActivate, Router, RouterStateSnapshot } from '@angular/router';
import { Injectable } from '@angular/core';
import { Observable, of } from 'rxjs';
import { catchError, map } from 'rxjs/operators';
import { AuthService } from '../services/auth.service';


@Injectable({ providedIn: 'root' })
export class AuthGuard implements CanActivate {
  constructor(private authService: AuthService,
    private router: Router,
  ) {
  }


  canActivate(route: ActivatedRouteSnapshot, state: RouterStateSnapshot): boolean | Observable<boolean> {
    if (route.queryParams.hasOwnProperty('code')) {
      return this.handleLoginThread(state);
    } else {
      return this.authService.isTokenValid();
    }
  }

  handleLoginThread(state: RouterStateSnapshot): Observable<boolean> {
    const payload = { code: state.root.queryParams['code'], appState: state.root.queryParams['session_state'] };
    return this.authService.callbackLogin(payload).pipe(
      map(() => {
        const searchParams = new URLSearchParams(state.root.queryParams);
        Object.keys(payload).forEach((k) => searchParams.delete(k));
        const requestParams = searchParams.toString();
        this.router.navigateByUrl(state.url.split('?')[0] + (requestParams.length > 0 ? '?' + requestParams : ''));
        return true;
      }),
      catchError(() => {
        return of(false);
      }),
    );
  }
}
