package com.thecherno.cherno.engine.interfaces;

import com.thecherno.cherno.engine.graphics.Screen;

public interface Renderable {

	public int getWidth();

	public int getHeight();

	public int[] getPixels();

	public void render(int x, int y, Screen screen);

}
