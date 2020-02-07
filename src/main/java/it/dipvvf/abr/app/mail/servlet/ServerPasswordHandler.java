package it.dipvvf.abr.app.mail.servlet;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.UnsupportedCallbackException;

import org.apache.wss4j.common.ext.WSPasswordCallback;

public class ServerPasswordHandler implements CallbackHandler {
	private final static String SECURITY_PROPERTIES = "security.properties";
	private Properties users = new Properties();
	
	public ServerPasswordHandler() {
		super();
	
		InputStream is = ServerPasswordHandler.class.getResourceAsStream(SECURITY_PROPERTIES);
		if(is==null) throw new IllegalArgumentException("Impossibile caricare "+SECURITY_PROPERTIES);
		try {
			users.load(is);
			is.close();
			System.out.println(SECURITY_PROPERTIES+" caricato, utenti censiti: "+users.size());
		}
		catch(Exception e) {
			throw new RuntimeException("Errore caricamento "+SECURITY_PROPERTIES, e);
		}
	}

	public void handle(Callback[] callbacks) throws IOException, UnsupportedCallbackException {
		WSPasswordCallback pc = (WSPasswordCallback) callbacks[0];

		if(pc.getIdentifier()!=null) {		
			pc.setPassword(users.getProperty(pc.getIdentifier()));
		}
	}

}