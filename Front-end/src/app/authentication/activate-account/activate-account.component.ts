import {Component} from '@angular/core';
import {AuthService} from "../../services/auth/auth.service";
import {Router} from "@angular/router";

@Component({
  selector: 'app-activate-account',
  templateUrl: './activate-account.component.html',
  styleUrls: ['./activate-account.component.css']
})
export class ActivateAccountComponent {

  constructor(private authService: AuthService,
              private router: Router) {
  }

  code: string[] = ['', '', '', '', '', '', '', ''];
  postCode: string = ""
  errors: Error[] = []
  accountActivated: boolean = false

  pasteCodeFromFirst(event: any) {
    const value = event.target.value;
    this.postCode = value
    if (value.length === 8) {
      this.code = value.split('');
      for (let i = 1; i < 8; i++) {
        const input = document.querySelectorAll('input')[i] as HTMLInputElement;
        input.readOnly = false;
      }
    }
  }

  public activateAccount() {
    this.authService.activate_account(this.postCode).subscribe({
      next:(res)=>{
        this.accountActivated = true
      },
      error: (err) => {
        if (err.status != 200) {
          err.error.validationErrors.map((error: Error) => this.errors.push(error))
        }
      }
    })
  }

  public navigateToLogin(){
    this.router.navigate(['authenticate'])
  }
}
