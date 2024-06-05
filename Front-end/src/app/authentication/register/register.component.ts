import {Component} from '@angular/core';
import {RegisterRequest} from "../../model/RegisterRequest";
import {AuthService} from "../../services/auth/auth.service";

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent {


  constructor(private authService: AuthService) {
  }

  errors: Array<Error> = []
  authenticated: boolean = false
  registerRequest: RegisterRequest = {
    firstName: "",
    lastName: "",
    email: "",
    password: "",
    role: ""
  };

  public selectRole(event: any) {
    this.registerRequest.role = (event.target.value);
  }

  public register(): void {
    this.authService.register(this.registerRequest).subscribe({
      next:(res)=>{
        this.authenticated = true
      },
      error: (err) => {
        if (err.status != 200) {
          err.error.validationErrors.map((error: Error) => this.errors.push(error))
        }
      }
    })
  }
}
