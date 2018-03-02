import { Injectable } from '@angular/core';
import { CanActivate, ActivatedRouteSnapshot, RouterStateSnapshot, Router } from '@angular/router';
import { Observable } from 'rxjs/Observable';
import { CookieService } from 'angular2-cookie/services/cookies.service';

@Injectable()
export class IsFinanceManagerGuard implements CanActivate {

  constructor(private cookie: CookieService, private router: Router) {}

  canActivate(
    next: ActivatedRouteSnapshot,
    state: RouterStateSnapshot): Observable<boolean> | Promise<boolean> | boolean {
    let val = decodeURIComponent(document.cookie).substr('user='.length);
    let user = JSON.parse(val);
    if (user.role_id === 1) {
      return true;
    } else {
      this.router.navigateByUrl('/employee-home');
    }
  }
}
