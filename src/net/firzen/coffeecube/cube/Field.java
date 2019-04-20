package net.firzen.coffeecube.cube;

import net.firzen.coffeecube.cube.abstracts.AbstractField;
import net.firzen.coffeecube.cube.enums.FieldType;
import net.firzen.coffeecube.cube.enums.Sticker;
import net.firzen.coffeecube.cube.geom.Point3D;

public class Field extends AbstractField {
	public Field(FieldType type) {
		stickers = new Sticker[6];
		this.type = type;
	}
	
	public Field(FieldType type, Point3D location) {
		stickers = new Sticker[6];
		this.type = type;
		setLocation(location);
	}
	
	public Field(FieldType type, int x, int y, int z) {
		stickers = new Sticker[6];
		this.type = type;
		setLocation(new Point3D(x, y, z));
	}
}
