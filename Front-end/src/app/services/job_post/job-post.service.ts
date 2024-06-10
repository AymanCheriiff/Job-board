import {Injectable} from '@angular/core';
import {HttpClient, HttpHeaders, HttpParams} from "@angular/common/http";
import {my_link} from "../../constant/constant";
import {Observable} from "rxjs";
import {PostJob_Post} from "../../model/Job_Post";

@Injectable({
  providedIn: 'root'
})
export class JobPostService {

  constructor(private http: HttpClient) {
  }

  token: string = sessionStorage.getItem("token") as string;
  auth_head: HttpHeaders = new HttpHeaders().append("Authorization", "Bearer " + this.token);
  link: string = my_link

  public saveJobPost(jobPost: PostJob_Post): Observable<any> {
    return this.http.post(this.link + "/job_post/save", jobPost, {headers: this.auth_head});
  }

  public getJobPosts(i: number): Observable<any> {
    const params = new URLSearchParams();
    params.set('page', "0");
    params.set('size', i.toString());
    return this.http.get(this.link + "/job_post/get/all" + "?" + params.toString(), {headers: this.auth_head});
  }
}
