package com.thecherno.cherno.engine.level;

import java.util.ArrayList;
import java.util.List;

import com.thecherno.cherno.engine.entity.Entity;

/**
*
* Base {@code Level} class, override to create a more advanced {@code Level} object.
*
* @author Yan Chernikov
*/
public abstract class Level {

	/** The width/height of the {@code Level} */
	protected int width, height;

	/** The {@code List} containing the {@code Entity}s in the {@code Level}*/
	protected List<Entity> entities = new ArrayList<Entity>();

	/**
	* Creates an empty {@code Level}
	*
	* @param width The width of the {@code Level}
	* @param height The height of the {@code Level}
	*/
	protected Level(int width, int height) {
		this.width = width;
		this.height = height;
	}

	/**
	* Creates a new {@code Level} object from a file.
	*
	* @param fileName The file to create the {@code Level} from.
	*/
	protected Level(String fileName) {
		load(fileName);
	}

	/**
	* Load a level using the given file
	*
	* @param fileName The file to load the level from
	*
	*/
	public abstract void load(String fileName);

	/**
	* Generate a level
	*
	*/
	public abstract void generate();

	/**
	* Get the width of the {@code Level}
	*
	* @return the width of the {@code Level}
	*/
	public int getWidth() {
		return width;
	}

	/**
	* Get the height of the {@code Level}
	*
	* @return the height of the {@code Level}
	*/
	public int getHeight() {
		return height;
	}

	/**
	* Initialize an {@code Entity} and add it to the {@code Level}'s {@code Entity} list.
	*
	* @return the width of the {@code Level}
	*/
	public void add(Entity e) {
		e.init(this);
		entities.add(e);
	}
}
