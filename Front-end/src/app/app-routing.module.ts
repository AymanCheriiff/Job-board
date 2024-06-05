import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {LandingComponent} from "./pages/landing/landing.component";
import {RegisterComponent} from "./authentication/register/register.component";
import {AuthenticateComponent} from "./authentication/authenticate/authenticate.component";
import {ActivateAccountComponent} from "./authentication/activate-account/activate-account.component";
import {HomeComponent} from "./pages/home/home.component";

const routes: Routes = [
  {
    path: "", component: HomeComponent, children: []
  },
  {
    path: "user", component: LandingComponent, children: []
  },
  {path: "register", component: RegisterComponent},
  {path: "authenticate", component: AuthenticateComponent},
  {path: "activate-account", component: ActivateAccountComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {
}
