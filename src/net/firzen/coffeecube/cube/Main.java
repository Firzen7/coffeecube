package net.firzen.coffeecube.cube;

import java.util.List;

import net.firzen.coffeecube.cube.enums.BasicMove;
import net.firzen.coffeecube.cube.enums.FieldType;
import net.firzen.coffeecube.cube.enums.SideType;
import net.firzen.coffeecube.cube.enums.Sticker;
import net.firzen.coffeecube.cube.geom.Point3D;
import net.firzen.coffeecube.cube.solver.Solver3;
import net.firzen.coffeecube.exceptions.CreateException;
import net.firzen.coffeecube.exceptions.FieldException;
import net.firzen.coffeecube.exceptions.FilterCharsError;
import net.firzen.coffeecube.exceptions.ParseException;
import net.firzen.coffeecube.exceptions.PointException;
import net.firzen.coffeecube.exceptions.UnknownException;
import net.firzen.coffeecube.other.Useful;

public class Main {

	public static void main(String[] args) throws FieldException, CreateException, PointException, UnknownException, ParseException, FilterCharsError {
		cubeCommander();
//		List<Rgb> fields = new ArrayList<Rgb>();
//		fields.add(new Rgb(0, 147, 139));
//		fields.add(new Rgb(247, 123, 96));
//		fields.add(new Rgb(253, 254, 253));
//		fields.add(new Rgb(163, 39, 37));
//		fields.add(new Rgb(0, 161, 158));
//		fields.add(new Rgb(252, 140, 117));
//		fields.add(new Rgb(195, 231, 160));
//		fields.add(new Rgb(0, 156, 151));
//		fields.add(new Rgb(0, 144, 249));
		
//		List<List<Integer>> groups = similars(fields);
		
//		for(List<Integer> group : groups) {
//			System.out.println(group);
//		}
	}
		
//	public static List<List<Integer>> similars(List<Rgb> fields) {
//		List<List<Integer>> output = new ArrayList<List<Integer>>();
//		List<Integer> groupedIndexes = new ArrayList<Integer>();
//		int size = fields.size();
//		for(int i = 0; i < size; i++) {
//			if(!groupedIndexes.contains(i)) {
//				List<Integer> newGroup = new ArrayList<Integer>();
//				for(int j = 0; j < size; j++) {
//					if(fields.get(j).distance(fields.get(i)) < 20
//							|| fields.get(j).hueDistance(fields.get(i)) < 20) {
//						groupedIndexes.add(j);
//						newGroup.add(j);
//					}
//				}
//				output.add(newGroup);
//			}
//		}
//		return output;
//	}
	
	public static void cubeCommander() {
		Cube cube;
		try {
			cube = new Cube(3);
		} catch (Exception e) {
			System.out.println("Nepodařilo se inicializovat kostku!");
			return;
		}
		
		System.out.println(cube);
		for(;;) {
			System.out.println("Zadejte tahy: ");
			String moves = Useful.readString();
			try {
				if(moves.equals("undo")) {
					cube.undo();
				}
				else if(moves.equals("show")) {
					System.out.println(cube);
					continue;
				}
				else if(moves.equals("redo")) {
					cube.redo();
				}
				else if(moves.equals("scramble")) {
					List<Move> rnd = Move.getRandomMoves(3, 100);
					System.out.print("Tahy pro zamíchání: " + rnd);
					cube.doMoves(rnd);
				}
				else if(moves.equals("solve")) {
					Solver3 solver = new Solver3(cube);
					List<Move> solution = solver.getSolution();
					System.out.print("Tahy pro řešení kostky: ");
					System.out.println(solution);
					continue;
				}
				else {
					cube.doMoves(moves);
				}
				System.out.println("Kostka po provedení tahů: ");
				System.out.println(cube);
			} catch (Exception e) {
				System.out.println("Chyba při vykonávání tahů!");
				e.printStackTrace();
			}
		}
	}
	
	public static void field() throws FieldException, PointException {
		Field field = new Field(FieldType.CORNER);
		field.setSticker(SideType.UP, Sticker.parseName("white"));
		field.setSticker(SideType.BACK, Sticker.parseName("red"));
		field.setSticker(SideType.LEFT, Sticker.parseName("blue"));

		System.out.println(field);
		field.rotate(new Move(BasicMove.FRONT, 0),
				new Point3D(0.5, 0, 0.5));
		System.out.println(field);
	}
	
	public static void cube() throws Exception {
		Cube cube = new Cube(3);
		
//		System.out.println(cube);
		cube.doMove(new Move(BasicMove.FRONT_INVERTED));
//		System.out.println("----------------");
		
		System.out.println(cube);
	}
}
