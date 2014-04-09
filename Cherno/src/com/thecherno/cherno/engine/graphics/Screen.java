package com.thecherno.cherno.engine.graphics;

import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;

public class Screen {

	private int width, height;
	private int[] pixels, imagePixels;

	private BufferedImage image;

	public Screen(int width, int height) {
		this.width = width;
		this.height = height;
		pixels = new int[width * height];
		image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
		imagePixels = ((DataBufferInt) image.getRaster().getDataBuffer()).getData();
	}

	public void clear(Color color) {
		for (int i = 0; i < width * height; i++) {
			pixels[i] = color.getColor();
		}
	}

	public void clear() {
		clear(Color.BLACK);
	}

	public int getWidth() {
		return width;
	}

	public int[] getPixels() {
		return pixels;
	}

	public int getHeight() {
		return height;
	}

	public BufferedImage getImage() {
		return image;
	}

	public void copy() {
		for (int i = 0; i < width * height; i++) {
			imagePixels[i] = pixels[i];
		}
	}

	public void fillRect(int x, int y, int width, int height, Color color) {
		for (int yy = y; yy < y + height; yy++) {
			for (int xx = x; xx < x + width; xx++) {
				if (xx < 0 || xx >= this.width || yy < 0 || yy >= this.height) continue;
				pixels[xx + yy * this.width] = color.getColor();
			}
		}
	}

	public void renderTexture(Texture texture, int x, int y) {
		for (int yy = 0; yy < texture.getHeight(); yy++) {
			int yp = yy + y;
			for (int xx = 0; xx < texture.getWidth(); xx++) {
				int xp = xx + x;
				if (xp < 0 || xp >= this.width || yp < 0 || yp >= this.height) continue;
				pixels[xp + yp * this.width] = texture.getPixels()[xx + yy * texture.getWidth()];
			}
		}
	}

}
