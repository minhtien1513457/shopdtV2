import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { LayoutComponent } from './layout.component';
import { CombinedGuardGuard } from 'src/app/shared/guard/combined-guard.guard';
import { AuthGuard } from 'src/app/shared/guard/auth-guard';

const guards = [AuthGuard]

const routes: Routes = [
  {
    path: '',
    component: LayoutComponent,
    children: [
      {path: '', redirectTo: 'dashboard', pathMatch: 'full'  },

      {path: 'dashboard',
      canActivate: [CombinedGuardGuard],
      data: {
        guards: guards,
      },

      loadChildren: () => import('./dashboard/dashboard.module').then(m => m.DashboardModule)},
      {path: 'phone',
      canActivate: [CombinedGuardGuard],
      data: {
        guards: guards,
      },

      loadChildren: () => import('./phone/phone.module').then(m => m.PhoneModule)},
      {path: 'laptop',
      canActivate: [CombinedGuardGuard],
      data: {
        guards: guards,
      },

      loadChildren: () => import('./laptop/laptop.module').then(m => m.LaptopModule)},
      {path: 'tablet',
      canActivate: [CombinedGuardGuard],
      data: {
        guards: guards,
      },

      loadChildren: () => import('./tablet/tablet.module').then(m => m.TabletModule)},
      {path: 'user',
      canActivate: [CombinedGuardGuard],
      data: {
        guards: guards,
      },
      loadChildren: () => import('./users/users.module').then(m => m.UsersModule)},
      {path: 'type',
      canActivate: [CombinedGuardGuard],
      data: {
        guards: guards,
      },

      loadChildren: () => import('./laptop/laptop.module').then(m => m.LaptopModule)},
    ]
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class LayoutRoutingModule { }
