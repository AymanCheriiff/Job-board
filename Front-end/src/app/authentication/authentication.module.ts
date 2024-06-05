import { NgModule } from '@angular/core';
import {CommonModule, NgOptimizedImage} from '@angular/common';
import { RegisterComponent } from './register/register.component';
import { AuthenticateComponent } from './authenticate/authenticate.component';
import {FormsModule} from "@angular/forms";
import { ActivateAccountComponent } from './activate-account/activate-account.component';
import {RouterLink} from "@angular/router";



@NgModule({
  declarations: [
    RegisterComponent,
    AuthenticateComponent,
    ActivateAccountComponent
  ],
  imports: [
    CommonModule,
    FormsModule,
    RouterLink,
    NgOptimizedImage
  ]
})
export class AuthenticationModule { }
