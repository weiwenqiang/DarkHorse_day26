package com.example.entity;

public class Note {
	private String body;
	private String date;
	private String address;
	private String type;

	@Override
	public String toString() {
		return "Note [body=" + body + ", date=" + date + ", address=" + address
				+ ", type=" + type + "]";
	}

	public Note() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Note(String body, String date, String address, String type) {
		super();
		this.body = body;
		this.date = date;
		this.address = address;
		this.type = type;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
}
