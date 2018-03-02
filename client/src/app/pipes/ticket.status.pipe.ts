import { Pipe, PipeTransform } from '@angular/core';
/*
 * Raise the value exponentially
 * Takes an exponent argument that defaults to 1.
 * Usage:
 *   value | exponentialStrength:exponent
 * Example:
 *   {{ 2 | exponentialStrength:10 }}
 *   formats to: 1024
*/
@Pipe({name: 'ticketStatusPipe'})
export class TicketStatusPipe implements PipeTransform {
  transform(value: number) {
    if(value === 0){
      return 'Pending'
    }
    else if(value === 1){
      return 'Accepted'
    }
    else if(value === 2){
      return 'Declined'
    }
  }
}
