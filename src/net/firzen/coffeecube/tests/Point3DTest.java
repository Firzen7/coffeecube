package net.firzen.coffeecube.tests;

import static org.junit.Assert.fail;

import java.util.List;

import org.junit.Test;

import net.firzen.coffeecube.cube.Move;
import net.firzen.coffeecube.cube.geom.Point3D;

public class Point3DTest {

	@Test
	public void testRotate() {
		double max = 100.0;
		
		double x = Math.round(Math.random() * max);
		double y = Math.round(Math.random() * max);
		double z = Math.round(Math.random() * max);
		
		Point3D center = new Point3D(Math.random() * max, Math.random() * max,
				Math.random() * max);
		Point3D pt = new Point3D(x, y, z);
		Point3D ptCopy = new Point3D(x, y, z);
		
		try {
			for(int i = 0; i < 100; i++) {
				List<Move> moves = Move.getRandomMoves(2, 50);
				moves.addAll(Move.getInvertedMoves(moves));
				
				System.out.println("Moves: " + moves);
				System.out.println("Pt: " + pt);
				
				for(Move move : moves) {
					if(!move.isInverted()) {
						pt.rotate(move.getBasicMove(), center, 90);						
					}
					else {
						pt.rotate(move.getBasicMove(), center, -90);
					}
					
					System.out.println("Pt: " + pt);
				}
			}
		}
		catch (Exception e) {
			e.printStackTrace();
			fail();
		}
		
		if(!ptCopy.equals(pt)) {
			fail("Points " + ptCopy + " and " + pt + " are not equal!");
		}
	}
}
