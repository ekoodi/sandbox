package fi.saimia.ekoodi.sandbox.layer.service.dao;

import fi.saimia.ekoodi.sandbox.layer.service.cc.DaoException;
import fi.saimia.ekoodi.sandbox.layer.service.cc.mdl.InetOrgPerson;

public interface PersonDAO {

	InetOrgPerson createInetOrgPerson(InetOrgPerson person);

	
	InetOrgPerson readInetOrgPerson(InetOrgPerson person) throws DaoException;
	
	
}
