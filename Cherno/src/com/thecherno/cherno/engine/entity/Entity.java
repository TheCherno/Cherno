package com.thecherno.cherno.engine.entity;

import com.thecherno.cherno.engine.interfaces.Renderable;
import com.thecherno.cherno.engine.interfaces.Updatable;

public abstract class Entity implements Renderable, Updatable {

	protected int x, y;
	private boolean removed = false;

	public boolean isRemoved() {
		return removed;
	}

	public void remove() {
		removed = true;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public void init(/*Level level*/) {

	}

}
