package com.cts.models;

public class AuthStatusResponse {
	private String data;
	private String status;

	public AuthStatusResponse() {
		super();
	}

	public AuthStatusResponse(String data, String status) {
		super();
		this.data = data;
		this.status = status;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}
