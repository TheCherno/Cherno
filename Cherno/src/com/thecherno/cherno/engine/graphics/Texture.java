package com.thecherno.cherno.engine.graphics;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.FileInputStream;
import javax.imageio.ImageIO;

public class Texture {

	private int width, height;
	private int[] pixels, pixelsrgb;

	public static final int FORMAT_RGB = 0x0;
	public static final int FORMAT_RGBA = 0x1;

	private Texture(int width, int height, int[] pixels) {
		this.width = width;
		this.height = height;
		this.pixels = pixels;
	}

	public static Texture load(String path) {
		int width = 0, height = 0;
		int[] pixels = null;
		try {
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

	public int[] getPixels(int format) {
		if (format == FORMAT_RGBA) return pixels;
		if (pixelsrgb != null) return pixelsrgb;
		pixelsrgb = new int[width * height];
		for (int i = 0; i < width * height; i++) {
			int r = (pixels[i] & 0xff0000) >> 16;
			int g = (pixels[i] & 0xff00) >> 8;
			int b = (pixels[i] & 0xff);
			pixelsrgb[i] = r << 16 | g << 8 | b;
		}
		return pixelsrgb;
	}
}
