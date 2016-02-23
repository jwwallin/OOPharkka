package chess;

import chess.types.*;

public abstract class Piece {
	private PieceColour player;
	private int[] position = new int[2];
	private boolean hasMoved;
	private boolean isTaken;
	private boolean canJump;

	//Getters--------------------------------------------------------------------------------------------------------------------------------------
	
	/**
	 * @return the player
	 */
	public PieceColour getPlayer() {
		return player;
	}
	/**
	 * @return the position
	 */
	public int[] getPosition() {
		return position;
	}
	/**
	 * @return the hasMoved
	 */
	public boolean hasMoved() {
		return hasMoved;
	}
	/**
	 * @return the isTaken
	 */
	public boolean isTaken() {
		return isTaken;
	}
	/**
	 * @return the canJump
	 */
	public boolean canJump() {
		return canJump;
	}

	//Setters--------------------------------------------------------------------------------------------------------------------------------------
	
	/**
	 * @param position the position to set
	 */
	public void setPosition(int[] position) {
		this.position = position;
	}
	/**
	 * @param hasMoved the hasMoved to set
	 */
	public void setHasMoved(boolean hasMoved) {
		this.hasMoved = hasMoved;
	}
	/**
	 * @param isTaken the isTaken to set
	 */
	public void setTaken(boolean isTaken) {
		this.isTaken = isTaken;
	}
	
	
	abstract void move(int x, int y);
	abstract boolean isLegalMove(int x, int y);
}
