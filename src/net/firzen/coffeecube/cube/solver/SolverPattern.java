package net.firzen.coffeecube.cube.solver;

import java.util.List;

import net.firzen.coffeecube.cube.Cube;
import net.firzen.coffeecube.cube.Move;
import net.firzen.coffeecube.exceptions.PointException;
import net.firzen.coffeecube.exceptions.UnknownException;

public abstract class SolverPattern implements Solver {
	protected Cube cube = null;
	
	private List<Move> undoBackup;
	private List<Move> redoBackup;
	
	public SolverPattern(Cube cube) {
		setCube(cube);
	}
	
	public Cube getCube() {
		return cube;
	}

	public void setCube(Cube cube) {
		this.cube = cube;
	}
	
	protected void backup() {
		undoBackup = cube.getUndoMoves();
		redoBackup = cube.getRedoMoves();
		cube.clearUndo();
		cube.clearRedo();
	}
	
	protected void restore() throws PointException, UnknownException {
		while(cube.undoPossible()) {
			cube.undo();
		}
		cube.setUndoMoves(undoBackup);
		cube.setRedoMoves(redoBackup);
	}
}
