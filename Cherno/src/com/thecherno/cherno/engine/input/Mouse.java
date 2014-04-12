package com.thecherno.cherno.engine.input;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Mouse extends MouseAdapter {

	private static int x, y;

	private static int button = -1;

	public static final int LEFT_BUTTON = 1;
	public static final int RIGHT_BUTTON = 3;

	public static final byte CODE = 0x2;

	private static double scale = 1.0;

	public Mouse() {
	}

	public Mouse(double scale) {
		Mouse.scale = scale;
	}

	public void mousePressed(MouseEvent e) {
		button = e.getButton();
	}

	public void mouseReleased(MouseEvent e) {
		button = -1;
	}

	public void mouseMoved(MouseEvent e) {
		x = (int) (e.getX() / scale / scale);
		y = (int) (e.getY() / scale / scale);
	}

	public void mouseDragged(MouseEvent e) {
		x = (int) (e.getX() / scale / scale);
		y = (int) (e.getY() / scale / scale);
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
