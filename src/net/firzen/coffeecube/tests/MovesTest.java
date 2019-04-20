package net.firzen.coffeecube.tests;

import org.junit.Test;

import net.firzen.coffeecube.cube.enums.BasicMove;
import net.firzen.coffeecube.cube.enums.SideType;

public class MovesTest {
	@Test
	public void testSideTypeRotation() {
		SideType side = SideType.UP;
		
		SideType newSide = side.rotate(BasicMove.UP);
		
		System.out.println(side + " vs " + newSide);
	}

}
