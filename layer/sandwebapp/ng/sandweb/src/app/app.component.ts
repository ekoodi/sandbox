import { Component } from '@angular/core';
import { InetOrgPerson,OrgVO,ServiceEvent,Severity } from './model';
import { OrgService } from './org.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'app works!';
  
  person : InetOrgPerson = new InetOrgPerson();
  
  
 constructor(
            private service: OrgService
            /*,
            private router: Router,
            private location: Location
            */
      ) { }  
  
  
  onCreatePerson( person : InetOrgPerson  ):void {
    console.log( person.givenName );
    let vo = new OrgVO();
    vo.person=person;
    this.service.createPerson(vo).then( item => {
      console.log(item.event);
      this.person = item.person;
            
    });    
  }
  
  onUpdatePerson( person : InetOrgPerson  ):void {
    console.log( person.givenName );
    let vo = new OrgVO();
    vo.person=person;
    this.service.updatePerson(vo).then( item => {
      console.log(item.event);
      
      if ( item.event.status != 200 ){
        // OK MESSAGE
         this.person = item.person;
       
      }else {
        // POPUP ERROR MESSAGE DIALOG ...
        
      }
      
            
    });    
  }
  
    onReadPerson( person : InetOrgPerson  ):void {
    console.log( person.givenName );
    let vo = new OrgVO();
    vo.person=person;
    this.service.readPerson(vo).then( item => {
      console.log(item.person.givenName);
      
      if ( item.event == null ){
        // OK MESSAGE
        
         this.person = item.person;
       
      }else {
        // POPUP ERROR MESSAGE DIALOG ...
        
      }
      
            
    });    
  }
  
}
