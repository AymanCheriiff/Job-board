import {CanActivateFn, Router} from '@angular/router';

export const userGuard: CanActivateFn = (route, state) => {
  let router: Router = new Router();
  let token: string = sessionStorage.getItem('token') as string;
  if (!token) {
    router.navigate(['/authenticate']);
    return false;
  } else {
    return true
  }
};
