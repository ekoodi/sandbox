package fi.saimia.ekoodi.sandbox.layer.service.cc.util;

import org.apache.commons.logging.Log;
import org.springframework.stereotype.Component;

import fi.saimia.ekoodi.sandbox.layer.service.cc.BaseException;
import fi.saimia.ekoodi.sandbox.layer.service.cc.mdl.ServiceEvent;
import fi.saimia.ekoodi.sandbox.layer.service.cc.mdl.Severity;

@Component
public class EventFactory {

	
	public ServiceEvent initEventByBaseException( ServiceEvent event,  String msg, BaseException ex, Log log  ){
		return this.initEventByException(event, ex.getCode(), msg, ex, log);
	}
	
	
	public ServiceEvent initEventByException( ServiceEvent event, String code, String msg, Exception ex, Log log  ){
		log.error("CODE " + code + " MESSAGE " + msg,ex);
		event.setMessage(msg);
		event.setCode(code);
		event.setStatus(500);
		event.setSeverity( Severity.ERROR  );
		log.error("UUID " + event.getUuid());
		return event;
	}
	
}
