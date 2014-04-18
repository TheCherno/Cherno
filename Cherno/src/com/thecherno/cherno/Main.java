package com.thecherno.cherno;

import java.awt.event.KeyEvent;

import com.thecherno.cherno.engine.Cherno;
import com.thecherno.cherno.engine.GrassTile;
import com.thecherno.cherno.engine.RockTile;
import com.thecherno.cherno.engine.State;
import com.thecherno.cherno.engine.graphics.Color;
import com.thecherno.cherno.engine.graphics.Sprite;
import com.thecherno.cherno.engine.graphics.Texture;
import com.thecherno.cherno.engine.input.Keyboard;
import com.thecherno.cherno.engine.input.Mouse;
import com.thecherno.cherno.engine.interfaces.Action;
import com.thecherno.cherno.engine.level.TiledLevel;
import com.thecherno.cherno.engine.menu.Menu;
import com.thecherno.cherno.engine.menu.MenuOption;

public class Main extends Cherno {

	private int x = 50, y = 50;
	private int mx, my;

	private TiledLevel test;

	private Sprite grass, rock;
	private Menu menu = new Menu(new MenuOption[] { new MenuOption("Play", new Action() {
		public void action() {
			State.setState(State.GAME);
		}
	}), new MenuOption("Options", null), new MenuOption("About", null), new MenuOption("Quit", new Action() {
		public void action() {
			System.exit(0);
		}
	}) });

	private void levels() {
		test = new TiledLevel("res/levels/level_BIG.png");
		test.addTileCode(0xffffff, new GrassTile(grass.getWidth(), grass.getHeight(), grass));
		test.setTileSize(32);
		test.addTileCode(0xff00ff, new RockTile(rock));
	}

	protected void init() {
		grass = new Sprite(Texture.load("res/grass.png"));
		rock = new Sprite(Texture.load("res/rock.png"));
		levels();
		createDisplay("Cherno 0.1a", 960, 540, 2.0);
		setInput(KEYBOARD | MOUSE);
		start();
		State.setState(State.MENU);
	}

	protected void update() {
		mx = Mouse.getX();
		my = Mouse.getY();
		if (Keyboard.keyPressed(KeyEvent.VK_UP)) y--;
		if (Keyboard.keyPressed(KeyEvent.VK_DOWN)) y++;
		if (Keyboard.keyPressed(KeyEvent.VK_LEFT)) x--;
		if (Keyboard.keyPressed(KeyEvent.VK_RIGHT)) x++;
		if (State.getState() == State.GAME) {
			if (Keyboard.keyTyped(KeyEvent.VK_ESCAPE)) State.setState(State.MENU);
		}
		menu.update();
		test.setOffset(x, y);
	}

	protected void render() {
		clear(Color.WHITE);
		if (State.getState() == State.GAME) {
			render(0, 0, test);
		} else if (State.getState() == State.MENU) {
			fillRect(0, 0, 960, 540, new Color(0xff00ff));
			screen.render(mx, my, grass);
			menu.render(50, 50, screen);
		}
		show();
	}

	public static void main(String[] args) {
		Main main = new Main();
		main.init();
	}

}
