package com.thecherno.cherno.engine.graphics;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Texture {

	private int width, height;
	private int[] pixels;

	private Texture(int width, int height, int[] pixels) {
		this.width = width;
		this.height = height;
		this.pixels = pixels;
	}

	public static Texture load(String path) {
		int width = 0, height = 0;
		int[] pixels = null;
		try {
			//BufferedImage image = ImageIO.read(Texture.class.getResource(path));
			//Change this as so - 
			BufferedImage image = ImageIO.read(new FileInputStream(path));
			width = image.getWidth();
			height = image.getHeight();
			pixels = new int[width * height];
			image.getRGB(0, 0, width, height, pixels, 0, width);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return new Texture(width, height, pixels);
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

}
