package com.webcheckers.util;

public class Message {

	private String text;
	public enum Type { INFO, ERROR };
	private Type type;

	public Message(String text, Type type) {
		this.text = text;
		this.type = type;
	}

	public String getText() {
		return this.text;
	}

	public Type getType() {
		return this.type;
	}



}
