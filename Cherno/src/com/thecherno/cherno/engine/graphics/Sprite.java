package com.thecherno.cherno.engine.graphics;

import com.thecherno.cherno.engine.interfaces.Renderable;

public class Sprite implements Renderable {

	private int width, height;
	private int[] pixels;

	public Sprite(Texture texture) {
		width = texture.getWidth();
		height = texture.getHeight();
		pixels = texture.getPixels();
	}
	
	public Sprite(String fileName) {
		Sprite(Texture.load(fileName);
	}

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}

	public int[] getPixels() {
		return pixels;
	}

	public void render(int x, int y, Screen screen) {
		screen.render(x, y, this);
	}

}
