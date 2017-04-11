package fi.saimia.ekoodi.sandbox.layer.service.ldap.biz;

import org.springframework.context.annotation.Configuration;

import fi.saimia.ekoodi.sandbox.layer.service.ldap.InetOrgPerson;

@Configuration
public class LdapBiz {
	
	public InetOrgPerson updatePerson( InetOrgPerson person ) throws Exception{
		if ( true ) throw new Exception("KOSKA KÄYTTÄJÄN HETU ON VÄÄRÄ : 358989");

		return person;
	}

}
