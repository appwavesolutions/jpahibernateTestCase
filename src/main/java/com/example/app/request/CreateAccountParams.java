package com.example.app.request;

public class CreateAccountParams extends Params {
	private String email;
	private String plan;

	public CreateAccountParams() {}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPlan() {
		return plan;
	}

	public void setPlan(String plan) {
		this.plan = plan;
	}
}

