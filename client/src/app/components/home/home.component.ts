import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  val = decodeURIComponent(document.cookie).substr('user='.length);
  user = JSON.parse(this.val);
  constructor() { }

  ngOnInit() {
  }

  deleteCookie(){
    document.cookie.split(";").forEach(
      function(c)
      {
        document.cookie = c.replace(/^ +/, "")
          .replace(/=.*/, "=;expires=" + new Date().toUTCString() + ";path=/");
      }
      );
  }
}
