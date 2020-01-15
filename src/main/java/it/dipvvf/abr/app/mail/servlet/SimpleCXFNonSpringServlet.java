package it.dipvvf.abr.app.mail.servlet;

import javax.servlet.ServletConfig;
import javax.xml.ws.Endpoint;

import org.apache.cxf.Bus;
import org.apache.cxf.BusFactory;
import org.apache.cxf.transport.servlet.CXFNonSpringServlet;

import it.dipvvf.abr.app.mail.soap.MailSOAPService;

public class SimpleCXFNonSpringServlet extends CXFNonSpringServlet {
	private static final long serialVersionUID = 7246873684803220750L;

	@Override
	public void loadBus(ServletConfig servletConfig) {
		super.loadBus(servletConfig);
		Bus bus = getBus();
		BusFactory.setDefaultBus(bus);
		Endpoint.publish("/mail", new MailSOAPService());
	}
}
