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
@Pipe({name: 'ticketTypePipe'})
export class TicketTypePipe implements PipeTransform {
  transform(value: number) {
    if(value === 0){
      return 'Other'
    }
    else if(value === 1){
      return 'Food'
    }
    else if(value === 2){
      return 'Travel'
    }
    else if(value === 3){
      return 'Lodging'
    }
  }
}
