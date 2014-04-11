package com.thecherno.cherno;

import java.awt.event.KeyEvent;

import com.thecherno.cherno.engine.Cherno;
import com.thecherno.cherno.engine.graphics.Color;
import com.thecherno.cherno.engine.graphics.Sprite;
import com.thecherno.cherno.engine.graphics.Texture;
import com.thecherno.cherno.engine.input.Keyboard;
import com.thecherno.cherno.engine.input.Mouse;

public class Main extends Cherno {

	private int x = 50, y = 50;
	private int mx, my;

	private Sprite sprite;

	public Main() {
	}

	protected void init() {
		sprite = new Sprite(Texture.load("res/sprite.png"));
		createDisplay("Cherno 0.1a", 960, 540);
		setInput(KEYBOARD | MOUSE);
		start();
	}

	protected void update() {
		mx = Mouse.getX();
		my = Mouse.getY();
		if (Keyboard.keyPressed(KeyEvent.VK_UP)) y--;
		if (Keyboard.keyPressed(KeyEvent.VK_DOWN)) y++;
		if (Keyboard.keyPressed(KeyEvent.VK_LEFT)) x--;
		if (Keyboard.keyPressed(KeyEvent.VK_RIGHT)) x++;
	}

	protected void render() {
		clear(Color.WHITE);
		fillRect(mx, my, 80, 80, Color.ORANGE);
		sprite.render(x, y, getScreen());
		show();
	}

	public static void main(String[] args) {
		Main main = new Main();
		main.init();
	}

}
