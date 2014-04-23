package com.thecherno.cherno;

import java.awt.event.KeyEvent;

import com.thecherno.cherno.engine.entity.mob.Mob;
import com.thecherno.cherno.engine.graphics.Screen;
import com.thecherno.cherno.engine.graphics.Sprite;
import com.thecherno.cherno.engine.input.Keyboard;

public class Player extends Mob {

	private Sprite sprite;

	public Player() {
		sprite = new Sprite("res/player.png");
	}

	public int getWidth() {
		return 32;
	}

	public int getHeight() {
		return 32;
	}

	public int[] getPixels() {
		return sprite.getPixels();
	}

	public void update() {
		int xa = 0, ya = 0;
		if (Keyboard.keyPressed(KeyEvent.VK_UP)) {
			ya--;
		}
		if (Keyboard.keyPressed(KeyEvent.VK_DOWN)) {
			ya++;
		}
		if (Keyboard.keyPressed(KeyEvent.VK_LEFT)) {
			xa--;
		}
		if (Keyboard.keyPressed(KeyEvent.VK_RIGHT)) {
			xa++;
		}
		if (xa != 0 || ya != 0) move(xa, ya);
	}

	public void render(int x, int y, Screen screen) {
		screen.render(960 / 8 - 16, 540 / 8 - 16, this);
	}

}
