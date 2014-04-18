package com.thecherno.cherno.engine.menu;

import java.awt.Font;
import java.awt.event.KeyEvent;

import com.thecherno.cherno.engine.graphics.Color;
import com.thecherno.cherno.engine.graphics.Screen;
import com.thecherno.cherno.engine.input.Keyboard;
import com.thecherno.cherno.engine.interfaces.Renderable;
import com.thecherno.cherno.engine.interfaces.Updatable;

public class Menu implements Renderable, Updatable {

	protected int selected;
	protected final int MAX_SELECTED;
	private MenuOption[] options;
	protected Font font = new Font("Helvetica", 0, 40);

	public Menu(MenuOption[] options) {
		this.options = options;
		MAX_SELECTED = options.length - 1;
	}

	public void update() {
		if (Keyboard.keyTyped(KeyEvent.VK_UP) && selected > 0) {
			selected--;
		} else if (Keyboard.keyTyped(KeyEvent.VK_DOWN) && selected < MAX_SELECTED) {
			selected++;
		}
		if (Keyboard.keyTyped(KeyEvent.VK_ENTER) || Keyboard.keyTyped(KeyEvent.VK_SPACE)) {
			options[selected].action();
		}
	}

	public int getWidth() {
		return 0;
	}

	public int getHeight() {
		return 0;
	}

	public int[] getPixels() {
		return null;
	}

	public void render(int x, int y, Screen screen) {
		Color color = Color.WHITE;
		for (int i = 0; i < options.length; i++) {
			if (selected == i) color = new Color(0x444444);
			else color = Color.ORANGE;
			screen.drawString(options[i].getTitle(), x, y + i * 44, font, color);
		}
	}

}
