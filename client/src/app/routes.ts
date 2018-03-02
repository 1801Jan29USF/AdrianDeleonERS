import {Routes} from "@angular/router";
import {LoginComponent} from "./components/login/login.component";
import {HomeNoLogInComponent} from "./components/home-no-log-in/home-no-log-in.component";
import {SubmitTicketComponent} from "./components/submit-ticket/submit-ticket.component";
import {HomeComponent} from "./components/home/home.component";
import {LoggedInGuard} from "./guards/logged-in.guard";
import {ViewMyTicketsComponent} from "./components/view-my-tickets/view-my-tickets.component";
import {ViewAllTicketsComponent} from "./components/view-all-tickets/view-all-tickets.component";
import {IsFinanceManagerGuard} from "./guards/is-finance-manager.guard";

export const appRoutes: Routes = [
  {
    path: 'login',
    component: LoginComponent
  },
  {
    path: 'employee-home',
    component: HomeComponent,
    canActivate: [LoggedInGuard],
  },
  {
    path: 'home',
    component: HomeNoLogInComponent
  },
  {
    path: 'submit-ticket',
    component: SubmitTicketComponent,
    canActivate: [LoggedInGuard],
  },
  {
    path: 'view-my-tickets',
    component: ViewMyTicketsComponent,
    canActivate: [LoggedInGuard],
  },
  {
    path: 'view-all-tickets',
    component: ViewAllTicketsComponent,
    canActivate: [LoggedInGuard, IsFinanceManagerGuard],
  },
  {
    path: '**',
    pathMatch: 'full',
    redirectTo: '/home'
  },
];
