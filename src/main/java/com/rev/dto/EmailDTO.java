package com.rev.dto;

public class EmailDTO {
	
	private String subject;
	private String from;
	private String bcc;
	private String[] cc;
	private String[] toAddress;
	private String file;
	private String templateName;
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getFrom() {
		return from;
	}
	public void setFrom(String from) {
		this.from = from;
	}
	public String getBcc() {
		return bcc;
	}
	public void setBcc(String bcc) {
		this.bcc = bcc;
	}
	public String[] getCc() {
		return cc;
	}
	public void setCc(String[] cc) {
		this.cc = cc;
	}
	public String[] getToAddress() {
		return toAddress;
	}
	public void setToAddress(String[] toAddress) {
		this.toAddress = toAddress;
	}
	public String getFile() {
		return file;
	}
	public void setFile(String file) {
		this.file = file;
	}
	public String getTemplateName() {
		return templateName;
	}
	public void setTemplateName(String templateName) {
		this.templateName = templateName;
	}

}
