package com.thecherno.cherno.engine.graphics;

import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;

public class Display {

	private double scale = 0.0;

	private Window window;
	private Graphics g;
	private BufferStrategy bs;

	public Display(Window window) {
		this.window = window;
		createBufferStrategy();
		bs = window.getBufferStrategy();
		g = bs.getDrawGraphics();
	}

	public void setScale(double scale) {
		this.scale = scale;
	}

	/**
	 * Creates a new buffer strategy.
	 * <p>
	 * <strong>Must be called before render() or show() is called!</strong>
	 */
	protected void createBufferStrategy() {
		window.createBufferStrategy(3);
	}

	public void drawImage(BufferedImage image) {
		g = bs.getDrawGraphics();
		g.drawImage(image, 0, 0, window.getWidth(), window.getHeight(), null);
	}

	public void show() {
		g.dispose();
		bs.show();
	}
}
