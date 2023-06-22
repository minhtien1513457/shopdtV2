import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class LocalStorageService {

  private static AUTH_TOKEN_TYPE_KEY = 'auth-token-type';
  private static AUTH_ACCESS_TOKEN_KEY = 'auth-access-token';
  private static AUTH_REFRESH_TOKEN_KEY = 'auth-refresh-token';
  private static CODE_VERIFIER = 'code_verifier';
  private static APP_STATE = 'app_state';
  private static ID_TOKEN = 'auth-id-token';
  private static EMAIL = 'user-email';



  setWithExpiry(key, value, ttl) {
    const now = new Date()

    // `item` is an object which contains the original value
    // as well as the time when it's supposed to expire
    const item = {
      value: value,
      expiry: now.getTime() + ttl,
    }
    localStorage.setItem(key, JSON.stringify(item));
  }

  getWithExpiry(key) {
    const itemStr = localStorage.getItem(key);
    // if the item doesn't exist, return null
    if (!itemStr) {
      return null;
    }
    const item = JSON.parse(itemStr);
    const now = new Date();
    // compare the expiry time of the item with the current time
    if (now.getTime() > item.expiry) {
      // If the item is expired, delete the item from storage
      // and return null
      localStorage.removeItem(key);
      return null;
    }
    return item.value;
  }

  setTokenType(data, ttl) {
    this.setWithExpiry(LocalStorageService.AUTH_TOKEN_TYPE_KEY, data, ttl);
  }
  getTokenType() {
    return this.getWithExpiry(LocalStorageService.AUTH_TOKEN_TYPE_KEY);
  }

  setAccessToken(data, ttl) {
    this.setWithExpiry(LocalStorageService.AUTH_ACCESS_TOKEN_KEY, data, ttl);
  }
  getAccessToken() {
    return this.getWithExpiry(LocalStorageService.AUTH_ACCESS_TOKEN_KEY);
  }

  setRefreshToken(data, ttl) {
    this.setWithExpiry(LocalStorageService.AUTH_REFRESH_TOKEN_KEY, data, ttl);
  }
  getRefreshToken() {
    return this.getWithExpiry(LocalStorageService.AUTH_REFRESH_TOKEN_KEY);
  }

  setCodeVerifier(data) {
    localStorage.setItem(LocalStorageService.CODE_VERIFIER, data);
  }
  getCodeVerifier() {
    return localStorage.getItem(LocalStorageService.CODE_VERIFIER);
  }

  setAppState(data) {
    localStorage.setItem(LocalStorageService.APP_STATE, data);
  }
  getAppState() {
    return localStorage.getItem(LocalStorageService.APP_STATE);
  }

  setIdToken(data, ttl) {
    this.setWithExpiry(LocalStorageService.ID_TOKEN, data, ttl);
  }
  getIdToken() {
    return this.getWithExpiry(LocalStorageService.ID_TOKEN);
  }

  setEmail(data) {
    localStorage.setItem(LocalStorageService.EMAIL, data);
  }
  getEmail() {
    return localStorage.getItem(LocalStorageService.EMAIL);
  }
}

