package fi.saimia.ekoodi.sandbox.layer.service.biz;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;

import fi.saimia.ekoodi.sandbox.layer.service.cc.DaoException;
import fi.saimia.ekoodi.sandbox.layer.service.cc.mdl.InetOrgPerson;
import fi.saimia.ekoodi.sandbox.layer.service.dao.PersonDAO;

@Configuration
public class OrgService {

	@Autowired
	@Qualifier("PersonDAO")
	private PersonDAO dao;
	
	public InetOrgPerson updatePerson( InetOrgPerson person ) throws Exception{
		if ( true ) throw new Exception("KOSKA KÄYTTÄJÄN HETU ON VÄÄRÄ : 358989");

		return person;
	}
	
	public InetOrgPerson readPerson( InetOrgPerson person ) throws DaoException {
		return dao.readInetOrgPerson(person);
	}

}
