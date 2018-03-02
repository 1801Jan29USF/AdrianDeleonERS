import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import {NgbModule} from '@ng-bootstrap/ng-bootstrap';

import { AppComponent } from './app.component';
import { LoginComponent } from './components/login/login.component';
import { HomeNoLogInComponent } from './components/home-no-log-in/home-no-log-in.component';
import { SubmitTicketComponent } from './components/submit-ticket/submit-ticket.component';
import { NavComponent } from './components/nav/nav.component';
import { HomeComponent } from './components/home/home.component';
import {FormsModule} from "@angular/forms";
import {HttpModule} from "@angular/http";
import {HttpClientModule} from "@angular/common/http";
import {RouterModule} from "@angular/router";
import {appRoutes} from "./routes";
import {LoggedInGuard} from "./guards/logged-in.guard";
import {CookieService} from "angular2-cookie/core";
import { ViewAllTicketsComponent } from './components/view-all-tickets/view-all-tickets.component';
import { ViewMyTicketsComponent } from './components/view-my-tickets/view-my-tickets.component';
import {IsFinanceManagerGuard} from "./guards/is-finance-manager.guard";
import {TicketStatusPipe} from "./pipes/ticket.status.pipe";
import {TicketTypePipe} from "./pipes/ticket.type.pipe";

@NgModule({
  imports: [
    BrowserModule,
    FormsModule,
    HttpModule,
    HttpClientModule,
    NgbModule.forRoot(),
    RouterModule.forRoot(appRoutes, {useHash: true}),
  ],
  declarations: [
    AppComponent,
    LoginComponent,
    HomeNoLogInComponent,
    SubmitTicketComponent,
    NavComponent,
    HomeComponent,
    ViewAllTicketsComponent,
    ViewMyTicketsComponent,
    TicketStatusPipe,
    TicketTypePipe
  ],
  providers: [
    LoggedInGuard,
    CookieService,
    IsFinanceManagerGuard,
  ],
  bootstrap: [
    AppComponent]
})
export class AppModule { }
