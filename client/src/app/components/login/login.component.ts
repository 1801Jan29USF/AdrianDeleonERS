import {Component, forwardRef, OnInit} from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { environment } from '../../../environments/environment';
import { CookieService } from 'angular2-cookie/services/cookies.service';
import {Router} from "@angular/router";

@Component({
  selector: 'ers-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  credential = {
    user: '',
    pass: ''
  };

  constructor(private client: HttpClient,
              private cookie: CookieService,
              private router: Router) { }

  ngOnInit() {
  }

  login() {
    this.client.post(`${environment.context}login`, this.credential,
      {withCredentials: true})
      .subscribe(
        (succ: any) => {
          this.cookie.putObject('user', succ);
          this.router.navigateByUrl("/employee-home");
        },
        (err) => {
          alert('failed to log in');
        }
      );
  }

}
