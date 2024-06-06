import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { UserRoutingModule } from './user-routing.module';
import { LandingPageComponent } from './landing-page/landing-page.component';
import { HomeUserComponent } from './home-user/home-user.component';
import { NavbarUserComponent } from './navbar-user/navbar-user.component';


@NgModule({
  declarations: [
    LandingPageComponent,
    HomeUserComponent,
    NavbarUserComponent
  ],
  imports: [
    CommonModule,
    UserRoutingModule
  ]
})
export class UserModule { }
