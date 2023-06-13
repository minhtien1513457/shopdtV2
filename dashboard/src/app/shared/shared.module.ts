import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';

import {
   MatButtonModule,
   MatToolbarModule,
   MatIconModule,
   MatBadgeModule,
   MatSidenavModule,
   MatListModule,
   MatGridListModule,
   MatFormFieldModule,
   MatInputModule,
   MatSelectModule,
   MatRadioModule,
   MatDatepickerModule,
   MatNativeDateModule,
   MatChipsModule,
   MatTooltipModule,
   MatTableModule,
   MatPaginatorModule,
   MatCardModule,
   MatAutocompleteModule,
   MatButtonToggleModule,
   MatCheckboxModule,
   MatStepperModule,
   MatDialogModule,
   MatExpansionModule,
   MatMenuModule,
   MatProgressBarModule,
   MatProgressSpinnerModule,
   MatRippleModule,
   MatSliderModule,
   MatSlideToggleModule,
   MatSnackBarModule,
   MatSortModule,
   MatTabsModule
} from '@angular/material';
import { HeaderComponent } from 'src/app/components/header/header.component';
import { FooterComponent } from 'src/app/components/footer/footer.component';
import { HeaderSidebarComponent } from 'src/app/components/header-sidebar/header-sidebar.component';
import { RouterModule } from '@angular/router';
import { CdkTableModule } from '@angular/cdk/table';
import { CreateUserModalComponent } from 'src/app/shared/modal/create-user-modal/create-user-modal.component';
import { DetailUserModalComponent } from 'src/app/shared/modal/detail-user-modal/detail-user-modal.component';
import { EditUserModalComponent } from 'src/app/shared/modal/edit-user-modal/edit-user-modal.component';

@NgModule({
   declarations: [
      HeaderSidebarComponent,
      HeaderComponent,
      FooterComponent,
      CreateUserModalComponent,
      DetailUserModalComponent,
      EditUserModalComponent
   ],

  imports: [
   MatFormFieldModule,
   MatBadgeModule,
   CommonModule,
   FormsModule, 
   ReactiveFormsModule,
   RouterModule,
   CdkTableModule,
   MatAutocompleteModule,
   MatButtonModule,
   MatButtonToggleModule,
   MatCardModule,
   MatCheckboxModule,
   MatChipsModule,
   MatStepperModule,
   MatDatepickerModule,
   MatDialogModule,
   MatExpansionModule,
   MatGridListModule,
   MatIconModule,
   MatInputModule,
   MatListModule,
   MatMenuModule,
   MatNativeDateModule,
   MatPaginatorModule,
   MatProgressBarModule,
   MatProgressSpinnerModule,
   MatRadioModule,
   MatRippleModule,
   MatSelectModule,
   MatSidenavModule,
   MatSliderModule,
   MatSlideToggleModule,
   MatSnackBarModule,
   MatSortModule,
   MatTableModule,
   MatTabsModule,
   MatToolbarModule,
   MatTooltipModule,
  ],
  exports: [
     //export module
     MatFormFieldModule,
     MatBadgeModule,
     CommonModule,
     FormsModule, 
     ReactiveFormsModule,
     RouterModule,
     CdkTableModule,
     MatAutocompleteModule,
     MatButtonModule,
     MatButtonToggleModule,
     MatCardModule,
     MatCheckboxModule,
     MatChipsModule,
     MatStepperModule,
     MatDatepickerModule,
     MatDialogModule,
     MatExpansionModule,
     MatGridListModule,
     MatIconModule,
     MatInputModule,
     MatListModule,
     MatMenuModule,
     MatNativeDateModule,
     MatPaginatorModule,
     MatProgressBarModule,
     MatProgressSpinnerModule,
     MatRadioModule,
     MatRippleModule,
     MatSelectModule,
     MatSidenavModule,
     MatSliderModule,
     MatSlideToggleModule,
     MatSnackBarModule,
     MatSortModule,
     MatTableModule,
     MatTabsModule,
     MatToolbarModule,
     MatTooltipModule,
     //export component
     HeaderSidebarComponent,
     HeaderComponent,
     FooterComponent,
     CreateUserModalComponent,
     DetailUserModalComponent,
     EditUserModalComponent
  ],
  providers: [
     MatDatepickerModule,
  ]
})

export class SharedModule { }
