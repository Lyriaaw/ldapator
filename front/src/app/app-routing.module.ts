import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { RouterModule, Routes } from '@angular/router';
import {LoginComponent} from './login/login.component';
import {SchoolComponent} from './school/school.component';

const routes: Routes = [
  { path: 'login', component: LoginComponent },
  { path: 'school', component: SchoolComponent }
];

@NgModule({
  imports: [
    CommonModule,
    RouterModule.forRoot(routes)
  ],
  exports: [ RouterModule ],
  declarations: []
})
export class AppRoutingModule { }
