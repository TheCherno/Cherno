package com.thecherno.cherno.engine.graphics;

import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;

public class Screen {

	private int width, height;
	private int[] pixels;

	private BufferedImage image;

	public Screen(int width, int height) {
		this.width = width;
		this.height = height;
		image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
		pixels = ((DataBufferInt) image.getRaster().getDataBuffer()).getData();
	}

	public void clear(int color) {
		for (int i = 0; i < width * height; i++) {
			pixels[i] = color;
		}
	}

	public void clear() {
		clear(0);
	}

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}

	public BufferedImage getImage() {
		return image;
	}

}
