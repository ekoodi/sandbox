import { NgModule, Injectable } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { FormsModule } from '@angular/forms';
import { HttpModule, Http, Response, RequestOptions, Headers, Request, RequestMethod, Jsonp, URLSearchParams } from '@angular/http';
import { Observable } from 'rxjs/Observable';
import { Subject } from 'rxjs/Subject';
import 'rxjs/add/operator/toPromise';


import { InetOrgPerson, OrgVO, ServiceEvent, Severity } from './model';
import { environment } from '../environments/environment';


@Injectable()
export class OrgService {

  crud = environment.crud;
  org = environment.org;

  constructor(private http: Http) {
    //this.headers.append("Content-Type", this.api.content );
  }

  public createPerson(vo: OrgVO): Promise<OrgVO> {
    let headers = new Headers();
    headers.append('Content-Type', 'application/json');

    let url = this.org.uri + this.org.personuri + this.crud.c;

    let params = new URLSearchParams();

    return this.http.post(url,
      JSON.stringify(vo), { headers: headers })
      .toPromise()
      .then(res => {
        return <OrgVO>res.json();
      }
      )
      .catch(this.handleError);
  }

  public updatePerson(vo: OrgVO): Promise<OrgVO> {
    let headers = new Headers();
    headers.append('Content-Type', 'application/json');

    let url = this.org.uri + this.org.personuri + this.crud.u;

    let params = new URLSearchParams();

    return this.http.post(url,
      JSON.stringify(vo), { headers: headers })
      .toPromise()
      .then(res => {
        return <OrgVO>res.json();
      }
      )
      .catch(this.handleError);
  }

    public readPerson(vo: OrgVO): Promise<OrgVO> {
    let headers = new Headers();
    headers.append('Content-Type', 'application/json');

    let url = this.org.uri + this.org.personuri + this.crud.r + "/" + vo.person.cn;

    let params = new URLSearchParams();

    return this.http.get(url,
       { headers: headers })
      .toPromise()
      .then(res => {
        return <OrgVO>res.json();
      }
      )
      .catch(this.handleError);
  }
  
  
  private handleError(error: any): Promise<any> {
    console.error('An error occurred', error); // for demo purposes only
    return Promise.reject(error.message || error);
  }


}
