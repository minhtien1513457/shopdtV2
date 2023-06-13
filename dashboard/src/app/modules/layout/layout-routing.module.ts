import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { LayoutComponent } from './layout.component';


const routes: Routes = [
  {
    path: '', 
    component: LayoutComponent,
    children: [
      {path: '', redirectTo: 'dashboard', pathMatch: 'full'  },
      {path: 'dashboard', loadChildren: () => import('./dashboard/dashboard.module').then(m => m.DashboardModule)},
      {path: 'phone', loadChildren: () => import('./phone/phone.module').then(m => m.PhoneModule)},
      {path: 'laptop', loadChildren: () => import('./laptop/laptop.module').then(m => m.LaptopModule)},
      {path: 'tablet', loadChildren: () => import('./tablet/tablet.module').then(m => m.TabletModule)},
      {path: 'user', loadChildren: () => import('./users/users.module').then(m => m.UsersModule)},
      {path: 'type', loadChildren: () => import('./laptop/laptop.module').then(m => m.LaptopModule)},
    ]
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class LayoutRoutingModule { }
