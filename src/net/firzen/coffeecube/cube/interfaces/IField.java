package net.firzen.coffeecube.cube.interfaces;

import net.firzen.coffeecube.cube.Move;
import net.firzen.coffeecube.cube.enums.FieldType;
import net.firzen.coffeecube.cube.enums.SideType;
import net.firzen.coffeecube.cube.geom.Point3D;
import net.firzen.coffeecube.exceptions.FieldException;
import net.firzen.coffeecube.exceptions.PointException;

public interface IField {
	public Point3D getLocation();
	public void setLocation(Point3D location);
	public void setSticker(SideType side, ISticker color) throws FieldException;
	public void setSticker(int index, ISticker color) throws FieldException;
	public ISticker getSticker(int index);
	public ISticker getSticker(SideType side);
	public boolean hasSticker(SideType side);
	public ISticker[] getStickers();
	public FieldType getType();
	public int getStickersCount();
	public boolean isEmpty();
	public void rotate(Move move, Point3D center) throws PointException;
	public boolean containsSticker(ISticker color);
	
	public boolean isValid();
}
