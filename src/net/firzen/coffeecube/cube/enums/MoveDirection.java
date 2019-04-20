package net.firzen.coffeecube.cube.enums;

import net.firzen.coffeecube.cube.geom.Point;

public enum MoveDirection {
	HORIZONTAL, VERTICAL;
	
	public static MoveDirection parseVector(Point pt) {
		if(pt.getX() == 0) {
			return VERTICAL;
		}
		else {
			return HORIZONTAL;
		}
	}
}
