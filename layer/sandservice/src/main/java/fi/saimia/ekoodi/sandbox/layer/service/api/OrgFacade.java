package fi.saimia.ekoodi.sandbox.layer.service.api;

import org.apache.commons.lang3.text.WordUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import fi.saimia.ekoodi.sandbox.layer.service.biz.OrgService;
import fi.saimia.ekoodi.sandbox.layer.service.cc.BaseException;
import fi.saimia.ekoodi.sandbox.layer.service.mdl.InetOrgPerson;
import fi.saimia.ekoodi.sandbox.layer.service.mdl.ServiceEvent;
import fi.saimia.ekoodi.sandbox.layer.service.util.EventFactory;

@RestController
@RequestMapping("/org")
public class OrgFacade {
	
	@Autowired
	private OrgService biz;
	
	@Autowired
	private EventFactory ehelp;
	
	private static final Log LOG = LogFactory.getLog(OrgFacade.class); 

	@RequestMapping(method = RequestMethod.POST, value="/person/create")
	public OrgVO createPerson(@RequestBody OrgVO vo) {
		ServiceEvent event = new ServiceEvent();
		LOG.info("createPerson " + event.getUuid());
		vo.setEvent(event);
		vo.getPerson().setGivenName(  WordUtils .capitalize(vo.getPerson().getGivenName())  );
		return vo;
	}
	
	@RequestMapping(method = RequestMethod.POST, value="/person/update")
	public OrgVO updatePerson(@RequestBody OrgVO vo) throws Exception{
		ServiceEvent event = new ServiceEvent();
		LOG.info("updatePerson UUID: " + event.getUuid());
		try {
			biz.updatePerson(vo.getPerson());
		} catch (Exception e) {
			vo.setEvent(ehelp.initEventByException(event, "ldap_api_error_generic","UPDATE ERROR", e, LOG));
			return vo;
		}
		event.setMessage("WORKS FINE");
		return vo;
	}
	
	@RequestMapping(method = RequestMethod.GET, value="/person/read/{cn}")
	public OrgVO readPerson(@PathVariable String cn){
		ServiceEvent event = new ServiceEvent();
		OrgVO vo = new OrgVO();
		LOG.info("readPerson UUID: " + event.getUuid());
		InetOrgPerson person = new InetOrgPerson();
		person.setCn(cn);
		try {
			person=biz.readPerson(person);
		} catch (BaseException e) {
			vo.setEvent(ehelp.initEventByBaseException(event, "UPDATE ERROR", e, LOG));
			return vo;
		} catch (Exception e) {
			vo.setEvent(ehelp.initEventByException(event, "ldap_api_error_generic","UPDATE ERROR", e, LOG));
			return vo;
		}
		event.setMessage("WORKS FINE");
		vo.setPerson(person);
		return vo;
	}
	
	
}
