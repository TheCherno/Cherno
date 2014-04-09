package com.thecherno.cherno.engine;

import com.thecherno.cherno.engine.graphics.Display;
import com.thecherno.cherno.engine.graphics.Screen;
import com.thecherno.cherno.engine.graphics.Window;

/**
 * {@code Cherno} engine template class.
 * 
 * @author Yan Chernikov
 * 
 */
public abstract class Cherno implements Runnable {

	private boolean running = false;
	protected Screen screen;
	private Display display;

	private Thread thread;

	protected final void start() {
		running = true;
		thread = new Thread(this, "Cherno");
		thread.start();
	}

	protected void createDisplay(String name, int width, int height) {
		display = new Display(new Window(name, width, height));
		screen = new Screen(width, height);
	}

	public void run() {
		while (running) {
			update();
			render();
		}
	}

	protected final void show() {
		display.drawImage(screen.getImage());
		display.show();
	}

	protected abstract void init();

	protected abstract void update();

	protected abstract void render();

}
