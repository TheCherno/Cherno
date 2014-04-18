package com.thecherno.cherno.engine;

public class State {

	public final static int GAME = 0x0;
	public final static int MENU = 0x1;
	private static int state = GAME;

	public static void setState(int state) {
		State.state = state;
	}

	public static int getState() {
		return state;
	}

}
