import {Injectable} from '@angular/core';
import {HttpClient, HttpParams} from "@angular/common/http";
import {RegisterRequest} from "../../model/RegisterRequest";
import {my_link} from "../../constant/constant";
import {Observable} from "rxjs";
import {AuthenticationRequest} from "../../model/AuthenticationRequest";

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  constructor(private http: HttpClient) {
  }

  link: string = my_link

  public register(registration: RegisterRequest): Observable<any> {
    return this.http.post(this.link + "/auth/register", registration)
  }

  public authenticate(authenticationRequest: AuthenticationRequest): Observable<any> {
    return this.http.post(this.link + "/auth/authenticate", authenticationRequest)
  }

  public activate_account(code: string): Observable<any> {
    let params = new HttpParams().set("token", code);
    return this.http.get(this.link + "/auth/activate-account", { params: params });
  }
}
