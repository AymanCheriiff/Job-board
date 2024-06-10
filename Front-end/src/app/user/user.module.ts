import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { UserRoutingModule } from './user-routing.module';
import { LandingPageComponent } from './landing-page/landing-page.component';
import { HomeUserComponent } from './home-user/home-user.component';
import { NavbarUserComponent } from './navbar-user/navbar-user.component';
import {FormsModule} from "@angular/forms";


@NgModule({
  declarations: [
    LandingPageComponent,
    HomeUserComponent,
    NavbarUserComponent
  ],
    imports: [
        CommonModule,
        UserRoutingModule,
        FormsModule
    ]
})
export class UserModule { }
