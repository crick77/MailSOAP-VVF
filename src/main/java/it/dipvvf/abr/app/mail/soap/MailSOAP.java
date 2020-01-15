package it.dipvvf.abr.app.mail.soap;

import java.util.List;
import java.util.concurrent.Future;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.ParameterStyle;
import javax.xml.ws.AsyncHandler;
import javax.xml.ws.ResponseWrapper;

@WebService
public interface MailSOAP {
	@WebMethod
	@ResponseWrapper(localName = "mailReturnResponse", className = "it.dipvvf.abr.app.mail.soap.MailReturnResponse")
	@SOAPBinding(parameterStyle = ParameterStyle.WRAPPED)
	public boolean sendMail(@WebParam(name = "sender") String sender, 
							@WebParam(name = "recipients") List<String> recipients, 
							@WebParam(name = "subject") String subject, 
							@WebParam(name = "body") String body, 
							@WebParam(name = "attachments") List<Attachment> attachments);
	
	@WebMethod
	@ResponseWrapper(localName = "mailReturnResponse", className = "it.dipvvf.abr.app.mail.soap.MailReturnResponse")
	@SOAPBinding(parameterStyle = ParameterStyle.WRAPPED)
	public Future<?> sendMailAsync(@WebParam(name = "sender") String sender, 
								   @WebParam(name = "recipients") List<String> recipients, 
								   @WebParam(name = "subject") String subject, 
								   @WebParam(name = "body") String body, 
								   @WebParam(name = "attachments") List<Attachment> attachments,
								   AsyncHandler<MailReturnResponse> asyncHandler);
}
