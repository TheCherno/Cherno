package com.thecherno.cherno.engine.level;

import java.util.ArrayList;
import java.util.List;

import com.thecherno.cherno.engine.entity.Entity;

public abstract class Level {

	protected int width, height;
	protected List<Entity> entities = new ArrayList<Entity>();

	protected Level(int width, int height) {
		this.width = width;
		this.height = height;
	}

	protected Level(String fileName) {
		load(fileName);
	}

	public abstract void load(String fileName);

	public abstract void generate();

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}

	public void add(Entity e) {
		e.init(this);
		entities.add(e);
	}
}
