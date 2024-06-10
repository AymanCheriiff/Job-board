import {User} from "./User";
import {Industry} from "./Industry";

export interface GetJob_Post {
  id: any;
  title: string;
  description: string;
  createdAt: string;
  updatedAt: string;
  image: string;
  industry: Industry;
  user: User;
}
