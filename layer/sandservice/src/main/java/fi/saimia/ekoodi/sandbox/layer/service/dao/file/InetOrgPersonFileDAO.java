package fi.saimia.ekoodi.sandbox.layer.service.dao.file;

import java.io.File;
import java.io.FileReader;
import java.net.URI;

import org.springframework.stereotype.Component;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;

import fi.saimia.ekoodi.sandbox.layer.service.cc.DaoException;
import fi.saimia.ekoodi.sandbox.layer.service.dao.PersonDAO;
import fi.saimia.ekoodi.sandbox.layer.service.mdl.InetOrgPerson;

@Component("PersonDAOImpl")
public class InetOrgPersonFileDAO  implements PersonDAO{

	private static String fname = "file:///D:/work/ekoodi/sandbox/layer/sandservice/src/main/resources/mock/person.json";
	private Gson gson = new Gson();
	
	public InetOrgPerson readInetOrgPerson(InetOrgPerson person) throws DaoException{
		InetOrgPerson R = null;
		try {
			URI uri = new URI(fname);
			JsonReader reader = new JsonReader(new FileReader(new File(uri)));
			R = this.gson.fromJson(reader, InetOrgPerson.class);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw new DaoException("ERROR TO READ FILE", "3k00d1_dao_error_read_file", e);
		}
		
		
		return R;
	}

	@Override
	public InetOrgPerson createInetOrgPerson(InetOrgPerson person) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
