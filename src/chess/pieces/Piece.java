package chess.pieces;

import chess.ChessBoard;
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
	 * @param position the position to set, max length 2
	 * 
	 * @PRE position.length == 2
	 */
	public void setPosition(int[] position) {
		if (position.length == 2)
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
	
	
	//Constructors----------------------------------------------------------------------------------------------------------------------------------
	
	/**
	 * @param player the player colour
	 * @param position pieces initial position, max length 2
	 * @param hasMoved whether piece has moved yet
	 * @param isTaken whether piece has been taken
	 * @param canJump whether piece can jump over other pieces
	 */
	public Piece(PieceColour player, int[] position, boolean hasMoved, boolean isTaken, boolean canJump) {
		this.player = player;
		this.position = position;
		this.hasMoved = hasMoved;
		this.isTaken = isTaken;
		this.canJump = canJump;
	}
	

	//Methods----------------------------------------------------------------------------------------------------------------------------------
	
	
	public abstract void move(ChessBoard currentBoard, int x, int y);
	public abstract boolean isLegalMove(ChessBoard currentBoard, int x, int y);
}
