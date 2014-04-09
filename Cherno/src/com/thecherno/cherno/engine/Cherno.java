package com.thecherno.cherno.engine;

import com.thecherno.cherno.engine.graphics.Color;
import com.thecherno.cherno.engine.graphics.Display;
import com.thecherno.cherno.engine.graphics.Screen;
import com.thecherno.cherno.engine.graphics.Texture;
import com.thecherno.cherno.engine.graphics.Window;

/**
 * {@code Cherno} engine template class.
 * 
 * @author Yan Chernikov
 * 
 */
public abstract class Cherno implements Runnable {

	private boolean running = false;
	public Screen screen;
	private Display display;

	private Thread thread;
	private long ls = 0L;

	protected final byte KEYBOARD = 0x0;
	protected final byte MOUSE = 0x1;

	protected final void start() {
		running = true;
		thread = new Thread(this, "Cherno");
		thread.start();
	}

	protected void createDisplay(String name, int width, int height) {
		ls = System.currentTimeMillis();
		display = new Display(new Window(name, width, height));
		screen = new Screen(width, height);
	}

	protected void setInput(byte device) {
		display.enable(device);
	}

	public void run() {
		long lastTime = System.nanoTime();
		double delta = 0;
		double ns = 1000000000.0 / 60.0;
		long timer = System.currentTimeMillis();
		int frames = 0;
		int updates = 0;
		System.out.println("Took " + ((System.currentTimeMillis() - ls) / 1000.0) + " seconds to load!");
		while (running) {
			long now = System.nanoTime();
			delta += (now - lastTime) / ns;
			lastTime = now;
			if (delta >= 1) {
				update();
				updates++;
				delta--;
			}
			render();
			frames++;
			if (System.currentTimeMillis() - timer > 1000) {
				timer += 1000;
				System.out.println(updates + "ups, " + frames + " fps");
				updates = 0;
				frames = 0;
			}
		}
	}

	public int[] getPixels() {
		return screen.getPixels();
	}

	protected final void show() {
		screen.copy();
		display.drawImage(screen.getImage());
		display.show();
	}

	protected void clear() {
		screen.clear();
	}

	protected void clear(Color col) {
		screen.clear(col);
	}

	protected void renderTexture(Texture texture, int x, int y) {
		screen.renderTexture(texture, x, y);
	}

	protected void fillRect(int x, int y, int width, int height, Color color) {
		screen.fillRect(x, y, width, height, color);
	}

	protected abstract void init();

	protected abstract void update();

	protected abstract void render();

}
