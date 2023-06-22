import { APP_INITIALIZER, NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { HttpClientModule } from '@angular/common/http';
import { RouterModule } from '@angular/router';
import { LayoutModule } from './modules/layout/layout.module';
import { SharedModule } from './shared/shared.module';
import { ApiService } from './shared/services/api.service';
import { ConfigService } from './shared/services/config.service';

export function appInit(configService: ConfigService): any {
  return () => configService.load();
}

@NgModule({
  declarations: [
    AppComponent
  ],
  imports: [
    RouterModule,
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    LayoutModule,
    SharedModule,
    HttpClientModule,
  ],
  providers: [
    ApiService,
    ConfigService,
    {
      provide: APP_INITIALIZER,
      useFactory: appInit,
      deps: [ConfigService],
      multi: true,
    },
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
