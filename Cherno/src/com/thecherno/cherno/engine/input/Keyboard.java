package com.thecherno.cherno.engine.input;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

public class Keyboard extends KeyAdapter {

	public static final byte CODE = 0x1;

	private static List<Integer> pressed = new ArrayList<Integer>();
	private static boolean[] keys = new boolean[65536];

	public static boolean keyPressed(int key) {
		return keys[key];
	}

	public static boolean keyTyped(int key) {
		if (!keys[key]) return false;
		if (pressed.contains(new Integer(key))) return false;
		pressed.add(new Integer(key));
		return true;
	}

	public void keyPressed(KeyEvent e) {
		keys[e.getKeyCode()] = true;
	}

	public void keyReleased(KeyEvent e) {
		keys[e.getKeyCode()] = false;
		if (pressed.contains(new Integer(e.getKeyCode()))) pressed.remove(new Integer(e.getKeyCode()));
	}
}
