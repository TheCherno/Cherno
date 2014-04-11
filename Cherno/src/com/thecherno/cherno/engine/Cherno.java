package com.thecherno.cherno.engine;

import com.thecherno.cherno.engine.graphics.Color;
import com.thecherno.cherno.engine.graphics.Display;
import com.thecherno.cherno.engine.graphics.Screen;
import com.thecherno.cherno.engine.graphics.Texture;
import com.thecherno.cherno.engine.graphics.Window;
import com.thecherno.cherno.engine.input.Keyboard;
import com.thecherno.cherno.engine.input.Mouse;

/**
 * {@code Cherno} engine template class. This class should be the superclass of your main game class. All of the methods
 * required for the main game loop, rendering and creating graphics, as well as creating a context for the graphics to
 * run inside of are in this class.
 * 
 * <p>
 * 
 * Methods to override: <br>
 * <ul>
 * <li>{@code init()}</li>
 * <li>{@code update()}</li>
 * <li>{@code render()}</li>
 * </ul>
 * Make sure you call {@code show()} at the end of your {@code render()} method to push the graphics to the screen!
 * <p>
 * Your implementation of the {@code init()} method should contain the following calls, in the specified order:
 * <ol>
 * <li>{@code createDisplay(title, width, height)}</li>
 * <li>{@code setInput(device(s))}</li>
 * <li>{@code start()}</li>
 * </ol>
 * This will create the display with the appropriate input, and start the main game loop.
 * 
 * @version 0.1a
 * @author Yan Chernikov
 * 
 */
public abstract class Cherno implements Runnable {

	// Whether or not the game is running, which dictates whether the main game loop runs or not.
	private boolean running = false;
	// The Screen object, for rendering.
	public Screen screen;
	// The Display object, for pushing Screen elements to the Window.
	private Display display;

	// The Thread object for handling the main game loop thread.
	private Thread thread;
	// A long to track how long it takes to load the engine when the game starts.
	private long startTimer = 0L;

	// The byte code for the keyboard.
	protected final byte KEYBOARD = Keyboard.CODE;
	// The byte code for the mouse.
	protected final byte MOUSE = Mouse.CODE;

	/**
	 * Starts the main game loop on a new thread, called "Cherno".
	 */
	protected final void start() {
		running = true;
		thread = new Thread(this, "Cherno");
		thread.start();
	}

	/**
	 * Creates a new Display and Window with the given name and size.
	 * 
	 * @param name
	 *            The title of the window.
	 * @param width
	 *            The width of the display (and window) in pixels.
	 * @param height
	 *            The height of the display (and window) in pixels.
	 */
	protected final void createDisplay(String name, int width, int height) {
		startTimer = System.currentTimeMillis();
		display = new Display(new Window(name, width, height));
		screen = new Screen(width, height);
	}

	/**
	 * Sets which devices the engine will use for input. Rather than running this method twice, you can specify two (or
	 * more) devices, separated by a bitwise or ("|").
	 * 
	 * <p>
	 * <strong>eg.</strong> {@code setInput(KEYBOARD | MOUSE);}
	 * 
	 * @param device
	 *            The device(s) code (grab this from the {@link Cherno} or relevant device class.
	 * 
	 */
	protected final void setInput(int device) {
		display.enable((byte) device);
	}

	/**
	 * The {@code run()} method: this contains the main game loop (and various timers) of the engine.
	 */
	public final void run() {
		long lastTime = System.nanoTime();
		double delta = 0;
		double ns = 1000000000.0 / 60.0;
		long timer = System.currentTimeMillis();
		int frames = 0;
		int updates = 0;
		System.out.println("Took " + ((System.currentTimeMillis() - startTimer) / 1000.0) + " seconds to load!");
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

	/**
	 * Returns the {@code Screen}'s pixel array.
	 * 
	 * @return The array of pixels that get rendered onto the screen.
	 */
	protected final int[] getPixels() {
		return screen.getPixels();
	}

	/**
	 * Pushes the pixel array to the screen and swaps buffers. Use this at the <strong>end</strong> of your
	 * {@code render()} method to show what you've rendered on the screen!
	 */
	protected final void show() {
		screen.copy();
		display.drawImage(screen.getImage());
		display.show();
	}

	/**
	 * Clears the pixel array (and thus the screen). This method will clear the screen to black; use the
	 * {@link #clear(Color) clear(Color)} method to specify a custom color to clear to.
	 */
	protected final void clear() {
		screen.clear();
	}

	/**
	 * Clears the pixel array (and thus the screen) to the specified {@link Color}.
	 * 
	 * @param col
	 */
	protected final void clear(Color col) {
		screen.clear(col);
	}

	/**
	 * Renders a texture onto the screen.
	 * 
	 * @param texture
	 *            The {@link Texture} to render.
	 * @param x
	 *            The x-coordinate (in pixels) of where to start rendering the texture (top left corner).
	 * @param y
	 *            The y-coordinate (in pixels) of where to start rendering the texture (top left corner).
	 */
	protected final void renderTexture(Texture texture, int x, int y) {
		screen.renderTexture(texture, x, y);
	}

	/**
	 * Fills a rectangle of pixels onto the screen, at the specified position with the specified size and color.
	 * 
	 * @param x
	 *            The x-coordinate (in pixels) of the rectangle.
	 * @param y
	 *            The y-coordinate (in pixels) of the rectangle.
	 * @param width
	 *            The width of the rectangle.
	 * @param height
	 *            The height of the rectangle.
	 * @param color
	 *            The {@link Color} of the rectangle.
	 */
	protected final void fillRect(int x, int y, int width, int height, Color color) {
		screen.fillRect(x, y, width, height, color);
	}

	/**
	 * Override this method to initialise the game.
	 */
	protected abstract void init();

	/**
	 * Override this method to update the game.
	 */
	protected abstract void update();

	/**
	 * Override this method to render the game.
	 */
	protected abstract void render();

}
