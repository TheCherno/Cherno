package com.thecherno.cherno.engine.level.tile;

import com.thecherno.cherno.engine.graphics.Sprite;
import com.thecherno.cherno.engine.interfaces.Renderable;

public abstract class Tile implements Renderable {

	private Sprite sprite;
	protected int width = 64, height = 64;

	public Tile(Sprite sprite) {
		this.sprite = sprite;
	}

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}

	public int[] getPixels() {
		return sprite.getPixels();
	}

	public boolean solid() {
		return false;
	}
}
