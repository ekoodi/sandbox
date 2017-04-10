package fi.saimia.ekoodi.sandbox.layer.service.ldap;

import java.io.Serializable;

public class InetOrgPerson implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String givenName;
	private String sn;
	public String getGivenName() {
		return givenName;
	}
	public void setGivenName(String givenName) {
		this.givenName = givenName;
	}
	public String getSn() {
		return sn;
	}
	public void setSn(String sn) {
		this.sn = sn;
	}

}
