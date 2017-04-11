package fi.saimia.ekoodi.sandbox.layer.service.ldap;

import org.apache.commons.lang3.text.WordUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import fi.saimia.ekoodi.sandbox.layer.service.ldap.biz.LdapBiz;

@RestController
@RequestMapping("/ldap")
public class LdapService {
	
	@Autowired
	private LdapBiz biz;
	
	private static final Log LOG = LogFactory.getLog(LdapService.class); 


	
	@RequestMapping(method = RequestMethod.POST, value="/person/create")
	public LdapVO createPerson(@RequestBody LdapVO vo) {
		LOG.info("createPerson");
		ServiceEvent event = new ServiceEvent();
		vo.setEvent(event);
		vo.getPerson().setGivenName(  WordUtils .capitalize(vo.getPerson().getGivenName())  );
		return vo;
	}
	
	@RequestMapping(method = RequestMethod.POST, value="/person/update")
	public LdapVO updatePerson(@RequestBody LdapVO vo) throws Exception{
		LOG.info("updatePerson");
		ServiceEvent event = new ServiceEvent();
		try {
			biz.updatePerson(vo.getPerson());
		} catch (Exception e) {
			LOG.error("UPDATE ERROR",e);
			event.setMessage("VOIVOI");
			event.setStatus(500);
			event.setSeverity( Severity.ERROR  );
			LOG.error("UUID " + event.getUuid());
			vo.setEvent(event);
			return vo;
		}
		event.setMessage("WORKS FINE");
		return vo;
	}
	
	
	
}
