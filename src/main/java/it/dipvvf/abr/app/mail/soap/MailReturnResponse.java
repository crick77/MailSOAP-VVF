package it.dipvvf.abr.app.mail.soap;

public class MailReturnResponse {
	private boolean status;

	public MailReturnResponse() {
	}

	public MailReturnResponse(boolean status) {
		this.status = status;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}
}
