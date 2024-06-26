import {Component, OnInit} from '@angular/core';
import {AuthService} from "../../services/auth/auth.service";
import {AuthenticationRequest} from "../../model/AuthenticationRequest";
import {Router} from "@angular/router";

@Component({
  selector: 'app-authenticate',
  templateUrl: './authenticate.component.html',
  styleUrls: ['./authenticate.component.css']
})
export class AuthenticateComponent implements OnInit {

  constructor(private authService: AuthService,
              private router: Router) {
  }

  errors: Error[] = []

  authenticationRequest: AuthenticationRequest = {
    email: "", password: ""
  }

  public authenticate() {
    this.authService.authenticate(this.authenticationRequest).subscribe({
      next: (res) => {
        sessionStorage.setItem("token", res.token);
        this.router.navigate(['user'])
      }, error: (err) => {
        err.error.validationErrors.map((error: Error) => this.errors.push(error))
      }
    })
  }

  public navigateToCreateAccount() {
    this.router.navigate(['register'])
  }

  ngOnInit() {
    if (sessionStorage.getItem('token')) {
      this.router.navigate(['user'])
    }
  }
}
