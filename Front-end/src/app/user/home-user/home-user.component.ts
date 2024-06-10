import {Component, OnInit} from '@angular/core';
import {PostJob_Post} from "../../model/Job_Post";
import {JobPostService} from "../../services/job_post/job-post.service";
import {GetJob_Post} from "../../model/GetJob_Post";

@Component({
  selector: 'app-home-user',
  templateUrl: './home-user.component.html',
  styleUrls: ['./home-user.component.css']
})
export class HomeUserComponent implements OnInit {

  constructor(private service: JobPostService) {
  }

  job_post: PostJob_Post = {
    title: "", description: "", createdAt: new Date(), image: ""
  }

  errors: Array<Error> = []
  job_posts: Array<GetJob_Post> = []
  pageSize: number = 12;

  public getJobPosts() {
    this.service.getJobPosts(this.pageSize).subscribe({
      next: (res) => {
        this.job_posts = res.content;
      }
    })
  }

  public saveJobPost() {
    this.service.saveJobPost(this.job_post).subscribe({
      error: (err) => {
        if (err.status != 200) {
          this.errors.push(err.error.text)
        }
      }
    })
  }

  public handleFileInput(event: any): void {
    const file = event.target.files[0];
    const reader = new FileReader();

    reader.onload = (e: any) => {
      this.job_post.image = reader.result as string;
    };

    reader.readAsDataURL(file);
  }

  public getImageUrl(base64String: string | undefined): string {
    return base64String ? `${base64String}` : ''; // Handle missing image
  }

  ngOnInit() {
    this.getJobPosts();
  }

}
