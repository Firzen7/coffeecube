package net.firzen.coffeecube.cube.solver;

import java.util.List;

import net.firzen.coffeecube.cube.Move;

public interface Solver {
	public List<Move> getSolution() throws Exception;
}
