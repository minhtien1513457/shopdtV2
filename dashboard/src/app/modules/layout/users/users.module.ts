import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { UsersRoutingModule } from './users-routing.module';
import { UsersComponent } from './users.component';
import { SharedModule } from 'src/app/shared/shared.module';
import { EditUserModalComponent } from './edit-user-modal/edit-user-modal.component';
import { DetailUserModalComponent } from './detail-user-modal/detail-user-modal.component';
import { CreateUserModalComponent } from './create-user-modal/create-user-modal.component';

@NgModule({
  declarations: [UsersComponent, CreateUserModalComponent, EditUserModalComponent, DetailUserModalComponent],
  imports: [
    CommonModule,
    UsersRoutingModule,
    SharedModule
  ]
})
export class UsersModule { }
