export class Model {
}

export enum Severity{
  emerg =0,
  alert =1,
  crit =2,
  err =3,
  warning =4,
  notice =5,
  info =6,
  debug =7,
  trace =8,
}

export class ServiceEvent {
  severity: Severity = Severity.info;
  status : number = 200;
  message : string = "OK";
  code : string;
  uuid? : string;
}



export class InetOrgPerson{
  givenName? : string;
  sn? :string;
}



export class LdapVO{
  event: ServiceEvent;
  person: InetOrgPerson;
}
