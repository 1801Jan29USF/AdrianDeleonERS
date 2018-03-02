import { Component, OnInit } from '@angular/core';
import {environment} from "../../../environments/environment";
import {HttpClient} from "@angular/common/http";
import {Router} from "@angular/router";

@Component({
  selector: 'app-submit-ticket',
  templateUrl: './submit-ticket.component.html',
  styleUrls: ['./submit-ticket.component.css']
})
export class SubmitTicketComponent implements OnInit {
  user = JSON.parse(decodeURIComponent(document.cookie).substr('user='.length));
  ticket = {
    'amount' : 0,
    'type' : -1,
    'desc' : '',
    'author' : this.user.id,
  };

  constructor(private client:HttpClient,
              private router:Router) { }

  ngOnInit() {
  }

  submitTicket() {

    this.client.post(`${environment.context}submit-ticket`, this.ticket,
      {withCredentials: true})
      .subscribe(
        (succ: any) => {
          this.router.navigateByUrl("/employee-home");
        },
        (err) => {
          alert('Something went wrong. Check your inputs and try again.');
        }
      );
  }
}
