import { Component } from '@angular/core';
import { InetOrgPerson,LdapVO,ServiceEvent,Severity } from './model';
import { LdapService } from './ldap.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'app works!';
  
  person : InetOrgPerson = new InetOrgPerson();
  
  
 constructor(
            private service: LdapService
            /*,
            private router: Router,
            private location: Location
            */
      ) { }  
  
  
  onCreatePerson( person : InetOrgPerson  ):void {
    console.log( person.givenName );
    let vo = new LdapVO();
    vo.person=person;
    
    this.service.createPerson(vo).then(item => {
      console.log(item.event);
      this.person = item.person;
            
    });    
    
    
    
    
  }
  
}
