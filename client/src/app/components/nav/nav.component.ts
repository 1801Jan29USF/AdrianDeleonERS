import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-nav',
  templateUrl: './nav.component.html',
  styleUrls: ['./nav.component.css']
})
export class NavComponent implements OnInit {
  constructor() { }

  ngOnInit() {
  }

  loggedin() {
    try{
      let val = decodeURIComponent(document.cookie).substr('user='.length);
      let user = JSON.parse(val);
      if(user.id >= 0){
        return true;
      }
      else{
        this.deleteCookie();
        return false;
      }
    }
    catch(err){
      this.deleteCookie();
      return false;
    }
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
