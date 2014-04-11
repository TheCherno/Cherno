package com.thecherno.cherno.engine.error;

public class ChernoError {

	private Object cls;
	private String message;

	public ChernoError(Object cls, String message) {
		this.cls = cls;
		this.message = message;
	}

	public void show() {
		System.err.println(message + " : " + cls);
	}

}
