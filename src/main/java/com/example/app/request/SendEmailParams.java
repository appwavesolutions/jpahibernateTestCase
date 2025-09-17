package com.example.app.request;

public class SendEmailParams extends Params {
	private String to;
	private String subject;
	private int retries;

	public SendEmailParams() {}

	public String getTo() {
		return to;
	}

	public void setTo(String to) {
		this.to = to;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public int getRetries() {
		return retries;
	}

	public void setRetries(int retries) {
		this.retries = retries;
	}
}

