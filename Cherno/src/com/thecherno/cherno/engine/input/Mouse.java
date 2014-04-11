package com.thecherno.cherno.engine.input;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Mouse extends MouseAdapter {

	private static int x, y;

	private static int button = -1;

	public static final int LEFT_BUTTON = 1;
	public static final int MIDDLE_BUTTON = 2;
	public static final int RIGHT_BUTTON = 3;

	public static final byte CODE = 0x2;

	public void mousePressed(MouseEvent e) {
		button = e.getButton();
	}

	public void mouseReleased(MouseEvent e) {
		button = -1;
	}

	public void mouseMoved(MouseEvent e) {
		x = e.getX();
		y = e.getY();
	}

	public void mouseDragged(MouseEvent e) {
		x = e.getX();
		y = e.getY();
	}

	public static boolean buttonDown(int button) {
		return Mouse.button == button;
	}

	public static int getX() {
		return x;
	}

	public static int getY() {
		return y;
	}
}
