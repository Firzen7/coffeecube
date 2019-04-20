package net.firzen.coffeecube.cube.enums;

import net.firzen.coffeecube.cube.color.Rgb;
import net.firzen.coffeecube.cube.interfaces.IRgb;
import net.firzen.coffeecube.exceptions.ParseException;

public enum CubeColor {
	WHITE("white", new Rgb(255, 255, 255)),
	RED("red", new Rgb(255, 0, 0)),
	BLUE("blue", new Rgb(0, 0, 255)),
	GREEN("green", new Rgb(0, 255, 0)),
	YELLOW("yellow", new Rgb(255, 255, 0)),
	ORANGE("orange", new Rgb(255, 128, 0)),
	UNKNOWN("unknown", new Rgb(80, 80, 80)),
	BLACK("black", new Rgb(30, 30, 30));
	
	private IRgb color;
	private String name;
	
	CubeColor(String settingKey, IRgb color) {
		this.color = color;
		this.name = settingKey;
	}
	
	public static CubeColor parseString(String str) {
		CubeColor[] values = CubeColor.values();
		for(CubeColor col : values) {
			if(col.toString().equals(str)) {
				return col;
			}
		}
		return null;
	}
	
	public static CubeColor parseRgb(IRgb rgb) throws ParseException {
		CubeColor[] values = values();
		for(CubeColor val : values) {
			if(val.getColor().equals(rgb)) {
				return val;
			}
		}
		
		throw new ParseException("Cannot parse color " + rgb);
	}
	
	public IRgb getColor() {
		return color;
	}

	public String getName() {
		return name;
	}

	public String toString() {
		return this.name();
	}

	public void setColor(Rgb patternColor) {
		this.color = patternColor;
	}
}
