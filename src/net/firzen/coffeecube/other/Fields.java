package net.firzen.coffeecube.other;

import java.util.ArrayList;
import java.util.List;

import net.firzen.coffeecube.cube.Field;
import net.firzen.coffeecube.cube.enums.FieldType;
import net.firzen.coffeecube.cube.enums.Sticker;

public class Fields {
	
	public static List<Field> filterByColor(List<Field> fields, Sticker color) {
		List<Field> output = new ArrayList<Field>();

		for(Field field : fields) {
			if(field.containsSticker(color)) {
				output.add(field);
			}
		}
		
		return output;
	}
	
	public static List<Field> filterByType(List<Field> fields, FieldType type) {
		List<Field> output = new ArrayList<Field>();
		for(Field field : fields) {
			if(field.getType() == type) {
				output.add(field);
			}
		}
		return output;
	}
	
	public static boolean areInLine(List<Field> fields) {
		int x = -1;
		int y = -1;
		boolean sameX = true;
		boolean sameY = true;
		
		for(Field field : fields) {
			if(x == -1) {
				x = (int) field.getLocation().getX();
			}
			if(y == -1) {
				y = (int) field.getLocation().getY();
			}
			
			if(field.getLocation().getX() != x) {
				sameX = false;
			}
			if(field.getLocation().getY() != y) {
				sameY = false;
			}			
		}
		
		return sameX || sameY;
	}
}
