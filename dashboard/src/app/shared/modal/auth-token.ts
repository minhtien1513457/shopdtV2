/* eslint-disable camelcase */
export interface AuthToken {
  access_token: string;
  refresh_token?: string;
  expires_in: number;
  refresh_expires_in?: number;
  token_type: string;
  id_token: string;
}
