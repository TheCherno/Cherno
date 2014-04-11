package com.thecherno.cherno.engine.error;

public class ChernoError {

	private String message;
	private Object cls;

	public ChernoError(String message, Object cls) {
		this.message = message;
		this.cls = cls;
	}

	public void show() {
		System.err.println(message + " : " + cls);
	}

}
