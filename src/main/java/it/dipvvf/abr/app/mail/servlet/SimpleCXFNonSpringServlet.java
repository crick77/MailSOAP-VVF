package it.dipvvf.abr.app.mail.servlet;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletConfig;
import javax.xml.ws.Endpoint;

import org.apache.cxf.Bus;
import org.apache.cxf.BusFactory;
import org.apache.cxf.transport.servlet.CXFNonSpringServlet;
import org.apache.cxf.ws.security.wss4j.WSS4JInInterceptor;
import org.apache.wss4j.dom.WSConstants;
import org.apache.wss4j.dom.handler.WSHandlerConstants;

import it.dipvvf.abr.app.mail.soap.MailSOAPService;

public class SimpleCXFNonSpringServlet extends CXFNonSpringServlet {
	private static final long serialVersionUID = 7246873684803220750L;

	@Override
	public void loadBus(ServletConfig servletConfig) {
		super.loadBus(servletConfig);
		Bus bus = getBus();
		BusFactory.setDefaultBus(bus);
		
		Map<String,Object> inProps = new HashMap<>();
		inProps.put(WSHandlerConstants.ACTION, WSHandlerConstants.USERNAME_TOKEN);
		inProps.put(WSHandlerConstants.PASSWORD_TYPE, WSConstants.PW_TEXT);
		inProps.put(WSHandlerConstants.PW_CALLBACK_CLASS, ServerPasswordHandler.class.getName());
		bus.getInInterceptors().add(new WSS4JInInterceptor(inProps));
		
		Endpoint.publish("/mail", new MailSOAPService());
	}
}
