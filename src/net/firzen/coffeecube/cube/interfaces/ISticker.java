package net.firzen.coffeecube.cube.interfaces;

import net.firzen.coffeecube.cube.enums.SideType;
import net.firzen.coffeecube.exceptions.UnknownException;


public interface ISticker {
	public IRgb getColor();
	public void setColor(IRgb color);
	public String getName();
	public void setName(String name);
	public IField getParent();
	public void setParent(IField parent);

	public SideType getSide() throws UnknownException;
}
