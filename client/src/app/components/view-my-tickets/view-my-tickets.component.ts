import { Component, OnInit } from '@angular/core';
import {environment} from "../../../environments/environment";
import {HttpClient, HttpHeaders} from "@angular/common/http";

@Component({
  selector: 'app-view-my-tickets',
  templateUrl: './view-my-tickets.component.html',
  styleUrls: ['./view-my-tickets.component.css']
})
export class ViewMyTicketsComponent implements OnInit {
  val = decodeURIComponent(document.cookie).substr('user='.length);
  user = JSON.parse(this.val);
  all;
  pending = [];
  approved = [];
  declined = [];
  tickets;
  constructor(private client:HttpClient) { }

  ngOnInit() {
    console.log(this.user.id);
    this.client.get(`${environment.context}my-tickets`,
      {headers: new HttpHeaders().set('author', [this.user.id])})
      .subscribe(
        (succ: any) => {
          console.log(succ);
          this.all = succ;
          this.generatePending();
          this.generateApproved();
          this.generateDeclined();
          this.getAll();
        },
        (err) => {
          alert('failed to find tickets');
        }
      );
  }

  generatePending(){
    for(let x in this.all){
      if(this.all.hasOwnProperty(x)){
        if(this.all[x].status_id === 0){
          this.pending.push(this.all[x]);
          console.log('pending');
          console.log(this.all[x]);
        }
      }
    }
  }

  generateApproved(){
    for(let x in this.all){
      if(this.all.hasOwnProperty(x)){
        if(this.all[x].status_id === 1){
          this.approved.push(this.all[x]);
          console.log('approved');
          console.log(this.all[x]);
        }
      }
    }
  }
  generateDeclined(){
    for(let x in this.all){
      if(this.all.hasOwnProperty(x)){
        if(this.all[x].status_id === 2){
          this.declined.push(this.all[x]);
          console.log('declined');
          console.log(this.all[x]);
        }
      }
    }
  }
  getAll(){
    this.tickets = this.all;
  }
  getPending(){
    this.tickets = this.pending;
  }
  getApproved(){
    this.tickets = this.approved;
  }
  getDeclined(){
    this.tickets = this.declined;
  }
}
