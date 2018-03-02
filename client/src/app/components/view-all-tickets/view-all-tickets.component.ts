import { Component, OnInit } from '@angular/core';
import {environment} from "../../../environments/environment";
import {HttpClient, HttpHeaders} from "@angular/common/http";

@Component({
  selector: 'app-view-all-tickets',
  templateUrl: './view-all-tickets.component.html',
  styleUrls: ['./view-all-tickets.component.css']
})
export class ViewAllTicketsComponent implements OnInit {
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
    this.client.get(`${environment.context}all-tickets`)
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

  isNotMine(id:number) {
    return id != this.user.id;
  }

  accept(id:number){
    this.client.post(`${environment.context}pending-tickets`,
      {
        'tk_id': id,
        'bool': true,
      }
    ).subscribe(
      (succ: any) => {
        alert('success');
        window.location.reload();
      },
      (err) => {
        alert('cant do that')
      }
    );
  }
  decline(id:number){
    this.client.post(`${environment.context}pending-tickets`,
      {
        'tk_id': id,
        'bool': false,
      }
    ).subscribe(
      (succ: any) => {
        alert('success');
        window.location.reload();
        console.log(this.tickets);
      },
      (err) => {
        alert('cant do that')
      }
    );
  }

  generatePending(){
    for(let x in this.all){
      if(this.all.hasOwnProperty(x)){
        if(this.all[x].status_id === 0){
          this.pending.push(this.all[x]);
        }
      }
    }
  }

  generateApproved(){
    for(let x in this.all){
      if(this.all.hasOwnProperty(x)){
        if(this.all[x].status_id === 1){
          this.approved.push(this.all[x]);
        }
      }
    }
  }
  generateDeclined(){
    for(let x in this.all){
      if(this.all.hasOwnProperty(x)){
        if(this.all[x].status_id === 2){
          this.declined.push(this.all[x]);

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
