package it.dipvvf.abr.app.mail.soap;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Attachment {
	private String name;
	private byte[] data;
	
	public Attachment() {
	}
	
	public Attachment(String name, byte[] data) {
		super();
		this.name = name;
		this.data = data;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public byte[] getData() {
		return data;
	}
	
	public void setData(byte[] data) {
		this.data = data;
	}
}
