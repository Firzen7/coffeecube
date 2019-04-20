package net.firzen.coffeecube.examples;

import net.firzen.coffeecube.cube.Cube;
import net.firzen.coffeecube.cube.interfaces.ICube;

public class Example {
	public static void main(String[] args) throws Exception {
		ICube cube = new Cube(3);
		cube.doMoves("U U D D R R L L F F B B");
		System.out.println(cube);
	}
}
