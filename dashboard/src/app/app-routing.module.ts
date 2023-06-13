import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { SharedModule } from './shared/shared.module';

const routes: Routes = [
  {
    path: '',
    loadChildren: () => import('./modules/layout/layout.module').then(m => m.LayoutModule)
  },
  { path: 'login', loadChildren: () => import('./modules/auth/auth.module').then(m => m.AuthModule)},
  { path: '**', loadChildren: () => import('./modules/components/not-acces/not-acces-routing.module').then(m => m.NotAccesRoutingModule)},
  { path: 'not-access', loadChildren: () => import('./modules/components/not-acces/not-acces-routing.module').then(m => m.NotAccesRoutingModule)},
];
@NgModule({
  imports: [
    RouterModule.forRoot(routes, { onSameUrlNavigation: `reload` }),
    SharedModule
  ],
  exports: [RouterModule]
})
export class AppRoutingModule { }









