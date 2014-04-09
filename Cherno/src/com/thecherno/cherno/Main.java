package com.thecherno.cherno;

import com.thecherno.cherno.engine.Cherno;

public class Main extends Cherno {

	public Main() {
	}

	protected void init() {
		createDisplay("Cherno 0.1a", 960, 540);
		start();
	}

	protected void update() {

	}

	protected void render() {
		screen.clear(0xff00ff);
		show();
	}

	public static void main(String[] args) {
		Main main = new Main();
		main.init();
	}

}
