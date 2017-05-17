package fi.saimia.ekoodi.sandbox.layer.service.cc.mdl;

import java.io.Serializable;

public class InetOrgPerson implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String givenName;
	private String sn;
	private String cn;
	
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
	public String getCn() {
		return cn;
	}
	public void setCn(String cn) {
		this.cn = cn;
	}

}
