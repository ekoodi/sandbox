package fi.saimia.ekoodi.sandbox.layer.service.ldap;

import java.io.Serializable;

public class LdapVO implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ServiceEvent event;
	private InetOrgPerson person;
	
	public ServiceEvent getEvent() {
		return event;
	}
	
	public void setEvent(ServiceEvent event) {
		this.event = event;
	}
	
	public InetOrgPerson getPerson() {
		return person;
	}
	
	public void setPerson(InetOrgPerson person) {
		this.person = person;
	}

}
