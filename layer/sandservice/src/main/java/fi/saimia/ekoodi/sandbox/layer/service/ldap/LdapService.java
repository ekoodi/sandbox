package fi.saimia.ekoodi.sandbox.layer.service.ldap;

import org.apache.commons.lang3.text.WordUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ldap")
public class LdapService {

	
	@RequestMapping(method = RequestMethod.POST, value="/person/create")
	public LdapVO createPerson(@RequestBody LdapVO vo) {
		ServiceEvent event = new ServiceEvent();
		event.setMessage("WORKS FINE");
		vo.setEvent(event);
		vo.getPerson().setGivenName(  WordUtils .capitalize(vo.getPerson().getGivenName())  );
		return vo;
	}
	
}
