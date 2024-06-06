import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {LandingComponent} from "./pages/landing/landing.component";
import {RegisterComponent} from "./authentication/register/register.component";
import {AuthenticateComponent} from "./authentication/authenticate/authenticate.component";
import {ActivateAccountComponent} from "./authentication/activate-account/activate-account.component";
import {HomeComponent} from "./pages/home/home.component";
import {userGuard} from "./guards/user/user.guard";

const routes: Routes = [
  {
    path: "", component: HomeComponent, children: []
  },
  {path: "register", component: RegisterComponent},
  {path: "authenticate", component: AuthenticateComponent},
  {path: "activate-account", component: ActivateAccountComponent},
  {
    path: "user", canActivate: [userGuard],
    loadChildren: () => import('./user/user.module').then((m) => m.UserModule)
  },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {
}
