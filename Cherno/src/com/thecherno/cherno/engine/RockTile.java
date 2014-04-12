package com.thecherno.cherno.engine;

import com.thecherno.cherno.engine.graphics.Screen;
import com.thecherno.cherno.engine.graphics.Sprite;
import com.thecherno.cherno.engine.level.tile.Tile;

public class RockTile extends Tile {

	public RockTile(Sprite sprite) {
		super(sprite);
		width = 32;
		height = 32;
	}

	public void render(int x, int y, Screen screen) {
		screen.render(x, y, this);
	}

}
