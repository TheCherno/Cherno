package com.thecherno.cherno;

import java.awt.event.KeyEvent;

import com.thecherno.cherno.engine.Cherno;
import com.thecherno.cherno.engine.graphics.Color;
import com.thecherno.cherno.engine.graphics.Texture;
import com.thecherno.cherno.engine.input.Keyboard;

public class Main extends Cherno {

	private int x = 50, y = 50;

	private Texture texture;

	public Main() {
	}

	protected void init() {
		texture = Texture.load("/image.png");
		createDisplay("Cherno 0.1a", 960, 540);
		setInput(KEYBOARD);
		start();
	}

	protected void update() {
		if (Keyboard.keyPressed(KeyEvent.VK_UP)) y--;
		if (Keyboard.keyPressed(KeyEvent.VK_DOWN)) y++;
		if (Keyboard.keyPressed(KeyEvent.VK_LEFT)) x--;
		if (Keyboard.keyPressed(KeyEvent.VK_RIGHT)) x++;
	}

	protected void render() {
		clear(Color.ORANGE);
		// fillRect(x, y, 50, 50, Color.ORANGE);
		renderTexture(texture, x, y);
		show();
	}

	public static void main(String[] args) {
		Main main = new Main();
		main.init();
	}

}
