import { NgModule,Injectable }      from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { FormsModule }   from '@angular/forms';
import { HttpModule,Http, Response, RequestOptions, Headers, Request, RequestMethod,Jsonp, URLSearchParams  }    from '@angular/http';
import { Observable }        from 'rxjs/Observable';
import { Subject }           from 'rxjs/Subject';
import 'rxjs/add/operator/toPromise';


import { InetOrgPerson, LdapVO, ServiceEvent, Severity } from './model';
import { environment } from '../environments/environment';


@Injectable()
export class LdapService {

  crud = environment.crud;
  ldap = environment.ldap;

  constructor(private http: Http) {
    //this.headers.append("Content-Type", this.api.content );
   }

  public createPerson(vo: LdapVO): Promise<LdapVO> {
    let headers = new Headers();
    headers.append('Content-Type', 'application/json');
    let url = this.ldap.uri + this.ldap.personuri + this.crud.c;
    let params = new URLSearchParams();
    return this.http.post(url, JSON.stringify(vo), { headers: headers })
      .toPromise()
      .then(res => {
        return <LdapVO>res.json();
      }
      )
      .catch(this.handleError);
  }
  
  
  private handleError(error: any): Promise<any> {
      console.error('An error occurred', error); // for demo purposes only
      return Promise.reject(error.message || error);
    }  
    

}
