package com.thecherno.cherno.engine;

import com.thecherno.cherno.engine.graphics.Screen;
import com.thecherno.cherno.engine.graphics.Sprite;
import com.thecherno.cherno.engine.level.tile.Tile;

public class GrassTile extends Tile {

	public GrassTile(int width, int height, Sprite sprite) {
		super(sprite);
		this.width = width;
		this.height = height;
	}

	public void render(int x, int y, Screen screen) {
		screen.render(x, y, this);
	}

}
