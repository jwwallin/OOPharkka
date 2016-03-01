package chess.pieces;

import chess.ChessBoard;
import chess.types.*;

/**
 * @author Jussi Wallin, Tero Yrjölä, Niklas Niemelä
 *
 */
public abstract class Piece {
	

	private PieceColour player;
	private int x;
	private int y;
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
	/**
	 * @return the x
	 */
	public int getX() {
		return x;
	}
	/**
	 * @return the y
	 */
	public int getY() {
		return y;
	}
	

	//Setters--------------------------------------------------------------------------------------------------------------------------------------
	
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
	/**
	 * @param x the x to set
	 */
	public void setX(int x) {
		this.x = x;
	}
	/**
	 * @param y the y to set
	 */
	public void setY(int y) {
		this.y = y;
	}
	
	//Constructors----------------------------------------------------------------------------------------------------------------------------------
	
	/**
	 * @param player the player colour
	 * @param position pieces initial position, max length 2
	 * @param hasMoved whether piece has moved yet
	 * @param isTaken whether piece has been taken
	 * @param canJump whether piece can jump over other pieces
	 */
	public Piece(PieceColour player, int x, int y, boolean hasMoved, boolean isTaken, boolean canJump) {
		this.player = player;
		this.x = x;
		this.y = y;
		this.hasMoved = hasMoved;
		this.isTaken = isTaken;
		this.canJump = canJump;
	}
	

	//Methods----------------------------------------------------------------------------------------------------------------------------------
	
	
	/**
	 * @param currentBoard the current board the piece is on
	 * @param x horizontal coordinate of target square
	 * @param y vertical coordinate of target square
	 * @return whether moving the piece was successful
	 */
	public abstract boolean move(ChessBoard currentBoard, int x, int y);
	
	/**
	 * @param currentBoard the current board the piece is on
	 * @param x horizontal coordinate of target square
	 * @param y vertical coordinate of target square
	 * @return whether moving the piece to target square is e legal move
	 */
	public abstract boolean isLegalMove(ChessBoard currentBoard, int x, int y);
}
