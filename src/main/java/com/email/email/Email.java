package com.email.email;

import jakarta.mail.Multipart;

public class Email {
	
	private Integer id;
	
	private String to;
	
	private String from;
	
	private String subject;
	
	private String text;
	
	private String content;
	
	

	

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTo() {
		return to;
	}

	public void setTo(String to) {
		this.to = to;
	}

	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public Email(Integer id, String to, String from, String subject, String text, String content) {
		super();
		this.id = id;
		this.to = to;
		this.from = from;
		this.subject = subject;
		this.text = text;
		this.content = content;
	}

	public Email() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Email [id=" + id + ", to=" + to + ", from=" + from + ", subject=" + subject + "]";
	}
	
	
	

}
