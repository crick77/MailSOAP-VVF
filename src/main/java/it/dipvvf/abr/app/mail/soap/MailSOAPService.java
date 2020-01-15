package it.dipvvf.abr.app.mail.soap;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Future;

import javax.xml.ws.AsyncHandler;

import org.apache.cxf.annotations.UseAsyncMethod;
import org.apache.cxf.jaxws.ServerAsyncResponse;

public class MailSOAPService implements MailSOAP {	
	@Override
	@UseAsyncMethod
	public boolean sendMail(String sender, List<String> recipients, String subject, String body, List<Attachment> attachments) {
		attachments = (attachments!=null) ? attachments : new ArrayList<>();
		System.out.println("Invio email...");
		System.out.printf("Da: %s a: %s\n", sender, recipients);
		System.out.printf("Oggetto: %s\n", subject);
		System.out.printf("Corpo: %s\n", body);
		for(Attachment att : attachments) {
			System.out.printf("Allegati: %s di %d bytes\n", att.getName(), (att.getData()!=null) ? att.getData().length : 0);
		}
		
		return true;
	}
	
	@Override
	public Future<?> sendMailAsync(final String sender, 
							  final List<String> recipients, 
							  final String subject, 
							  final String body, 
							  final List<Attachment> attachments,
							  AsyncHandler<MailReturnResponse> asyncHandler) {
		final ServerAsyncResponse<MailReturnResponse> asyncResponse = new ServerAsyncResponse<>();
		
		new Thread() {
            public void run() {
            	final List<Attachment> lAtt = (attachments!=null) ? attachments : new ArrayList<>();
            	System.out.println("Invio email (in Async)...");
        		System.out.printf("Da: %s a: %s\n", sender, recipients);
        		System.out.printf("Oggetto: %s\n", subject);
        		System.out.printf("Corpo: %s\n", body);
        		for(Attachment att : lAtt) {
        			System.out.printf("Allegati: %s di %d bytes\n", att.getName(), (att.getData()!=null) ? att.getData().length : 0);
        		}
        		
        		try {
        			// Resta in attesa per almeno 3 secondi e fino 13 secondi
        			long wait = (int)(Math.random()*10000)+3000;
        			System.out.println("L'invio email richiede "+(wait/1000)+" secondi...");
        			Thread.sleep(wait);
        		}
        		catch(InterruptedException ie) {}
        		   		
        		asyncResponse.set(new MailReturnResponse(Boolean.TRUE));
        		asyncHandler.handleResponse(asyncResponse);
        		
        		System.out.println("Email INVIATA!");
            }
		}.start();
		
		return asyncResponse;
	}
}
