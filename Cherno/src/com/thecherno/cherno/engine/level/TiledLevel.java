package com.thecherno.cherno.engine.level;

import java.util.HashMap;
import java.util.Map;

import com.thecherno.cherno.engine.graphics.Screen;
import com.thecherno.cherno.engine.graphics.Texture;
import com.thecherno.cherno.engine.level.tile.Tile;

public class TiledLevel extends Level {

	private int tileSize = 64;
	private int[] tiles;
	private Map<Integer, Tile> tileCodes = new HashMap<Integer, Tile>();

	public TiledLevel(int width, int height) {
		super(width, height);
	}

	public TiledLevel(String file) {
		super(file);
	}

	public void setTileSize(int tileSize) {
		this.tileSize = tileSize;
	}

	public void load(String fileName) {
		Texture level = Texture.load(fileName);
		tiles = level.getPixels(Texture.FORMAT_RGB);
		width = level.getWidth();
		height = level.getHeight();
	}

	public void addTileCode(int code, Tile name) {
		tileCodes.put(code, name);
	}

	public void generate() {
	}

	/**
	 * Returns teh tiles.
	 * 
	 * @param x
	 * @param y
	 * @return
	 */
	public Tile getTile(int x, int y) {
		if (x < 0 || x >= width || y < 0 || y >= height) return null;
		int key = tiles[x + y * width];
		if (!tileCodes.containsKey(key)) return null;
		return tileCodes.get(key);
	}

	public int[] getPixels() {
		return tiles;
	}

	public void render(int x, int y, Screen screen) {
		int x0 = xOffset / tileSize;
		int x1 = (int) (x0 + screen.getWidth() / screen.getScale() / tileSize) + 2;
		int y0 = yOffset / tileSize;
		int y1 = (int) (y0 + screen.getHeight() / screen.getScale() / tileSize) + 2;
		// System.out.println("Boundaries: " + x0 + "->" + x1 + ", " + y0 + "->" + y1);
		for (int yy = 0; yy < height; yy++) {
			for (int xx = 0; xx < width; xx++) {
				if (xx < x0 || xx >= x1 || yy < y0 || yy >= y1) continue;
				Tile tile = getTile(xx, yy);
				if (tile == null) continue;
				int tx = -xOffset + xx * tile.getWidth();
				int ty = -yOffset + yy * tile.getHeight();
				screen.render(tx, ty, tile);
			}
		}
		super.render(screen);
	}

	public int getTileSize() {
		return tileSize;
	}
}
