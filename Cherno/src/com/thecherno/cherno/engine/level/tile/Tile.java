package com.thecherno.cherno.engine.level.tile;

import com.thecherno.cherno.engine.graphics.Sprite;
import com.thecherno.cherno.engine.interfaces.Renderable;

public abstract class Tile implements Renderable {

	private Sprite sprite;
	
	public Tile(Sprite sprite) {
		this.sprite = sprite;
	}

}
