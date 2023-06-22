import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { LayoutRoutingModule } from './layout-routing.module';
import { LayoutComponent } from './layout.component';
import { SharedModule } from 'src/app/shared/shared.module';
import { HeaderSidebarComponent } from '../components/header-sidebar/header-sidebar.component';
import { HeaderComponent } from '../components/header/header.component';

@NgModule({
  declarations: [
    HeaderSidebarComponent,
    HeaderComponent,
    LayoutComponent,
  ],
  imports: [
    SharedModule,
    CommonModule,
    LayoutRoutingModule
  ]
})
export class LayoutModule { }
