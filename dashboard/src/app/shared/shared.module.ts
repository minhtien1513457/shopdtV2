import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';

import { MatButtonModule } from '@angular/material/button';
import { MatToolbarModule } from '@angular/material/toolbar';
import { MatIconModule } from '@angular/material/icon';
import { MatBadgeModule } from '@angular/material/badge';
import { MatSidenavModule } from '@angular/material/sidenav';
import { MatListModule } from '@angular/material/list';
import { MatGridListModule } from '@angular/material/grid-list';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatInputModule } from '@angular/material/input';
import { MatSelectModule } from '@angular/material/select';
import { MatRadioModule } from '@angular/material/radio';
import { MatDatepickerModule } from '@angular/material/datepicker';
import { MatNativeDateModule } from '@angular/material/core';
import { MatChipsModule } from '@angular/material/chips';
import { MatTooltipModule } from '@angular/material/tooltip';
import { MatTableModule } from '@angular/material/table';
import { MatPaginatorModule } from '@angular/material/paginator';
import { MatCardModule } from '@angular/material/card';
import { MatAutocompleteModule } from '@angular/material/autocomplete';
import { MatButtonToggleModule } from '@angular/material/button-toggle';
import { MatCheckboxModule } from '@angular/material/checkbox';
import { MatStepperModule } from '@angular/material/stepper';
import { MatDialogModule } from '@angular/material/dialog';
import { MatExpansionModule } from '@angular/material/expansion';
import { MatMenuModule } from '@angular/material/menu';
import { MatProgressBarModule } from '@angular/material/progress-bar';
import { MatProgressSpinnerModule } from '@angular/material/progress-spinner';
import { MatRippleModule } from '@angular/material/core';
import { MatSliderModule } from '@angular/material/slider';
import { MatSlideToggleModule } from '@angular/material/slide-toggle';
import { MatSnackBarModule } from '@angular/material/snack-bar';
import { MatSortModule } from '@angular/material/sort';
import { MatTabsModule } from '@angular/material/tabs';
import { RouterModule } from '@angular/router';
import { CdkTableModule } from '@angular/cdk/table';


@NgModule({
   declarations: [
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
   MatTooltipModule
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
  ],
  providers: [
     MatDatepickerModule,
  ]
})

export class SharedModule { }
