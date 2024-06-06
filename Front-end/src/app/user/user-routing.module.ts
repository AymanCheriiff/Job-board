import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {LandingPageComponent} from "./landing-page/landing-page.component";
import {HomeUserComponent} from "./home-user/home-user.component";

const routes: Routes = [
  {
    path: "", component: LandingPageComponent, children: [
      {path: "home", component: HomeUserComponent},
      {path: "", pathMatch: "full", redirectTo: "home"}
    ]
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class UserRoutingModule {
}
