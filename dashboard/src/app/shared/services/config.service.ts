import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {environment} from '../../../environments/environment';
import { AppConfig } from '../modal/app-config';

@Injectable()
export class ConfigService {
  static config: AppConfig;

  constructor(private http: HttpClient) {
  }

  load(): Promise<any> {
    let jsonFile = 'assets/config/vserver-portal.json';

    if (!environment.production) {
      jsonFile = 'assets/config/local.json';
    }

    return new Promise((resolve, reject) => {
      this.http.get(jsonFile).subscribe({
        next: (data: AppConfig) => {
          ConfigService.config = data;
          resolve(true);
        },
        error: (error: any) => {
          reject('Unknown error');
        }
      });
    });
  }
}

