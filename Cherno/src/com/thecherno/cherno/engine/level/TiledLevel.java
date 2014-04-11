package com.thecherno.cherno.engine.level;

import java.util.HashMap;
import java.util.Map;

import com.thecherno.cherno.engine.graphics.Texture;
import com.thecherno.cherno.engine.level.tile.Tile;

public class TiledLevel extends Level {

	private int[] tiles;
	private Map<Integer, Tile> tileCodes = new HashMap<Integer, Tile>();

	public TiledLevel(int width, int height) {
		super(width, height);
	}

	public TiledLevel(String file) {
		super(file);
	}

	public void load(String fileName) {
		int[] pixels = Texture.load(fileName).getPixels();
	}

	public void addTileCode(int code, Tile name) {
		tileCodes.put(code, name);
	}

	public void generate() {
	}

	public Tile getTile(int x, int y) {
		if (x < 0 || x >= width || y < 0 || y >= height) return null;
		int key = tiles[x + y * width];
		if (!tileCodes.containsKey(key)) return null;
		return tileCodes.get(key);
	}
}
