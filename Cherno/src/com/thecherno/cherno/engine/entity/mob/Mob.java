package com.thecherno.cherno.engine.entity.mob;

import com.thecherno.cherno.engine.entity.Entity;
import com.thecherno.cherno.engine.level.TiledLevel;

public abstract class Mob extends Entity {

	public void move(int xa, int ya) {
		if (xa != 0 && ya != 0) {
			move(xa, 0);
			move(0, ya);
			return;
		}
		if (!collides(xa, ya)) {
			x += xa;
			y += ya;
		}
	}

	private boolean collides(int xa, int ya) {
		if (level instanceof TiledLevel) {
			TiledLevel level = (TiledLevel) this.level;
			for (int c = 0; c < 4; c++) {
				int xt = ((x + xa) - c % 2 * getWidth()) / level.getTileSize();
				int yt = ((y + ya) - c / 2 * getHeight()) / level.getTileSize();
				// System.out.println(xt + ", " + yt);
				if (level.getTile(xt, yt) == null) continue;
				if (level.getTile(xt, yt).solid()) {
					return true;
				}
			}
		}
		return false;
	}

}
