/**
 * 
 */
package chess.pieces;

import chess.ChessBoard;
import chess.types.PieceColour;

/**
 * @author Jussi Wallin, Tero Yrjölä, Niklas Niemelä
 *
 */
public class Queen extends Piece {

	/**
	 * @param player the player colour
	 * @param position piece's initial position, max length 2
	 * @param hasMoved whether piece has moved yet
	 * @param isTaken whether piece has been taken
	 * @param canJump whether piece can jump over other pieces
	 */
	public Queen(PieceColour player, int x, int y, boolean hasMoved, boolean isTaken, boolean canJump) {
		super(player, x, y, hasMoved, isTaken, canJump);
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * @param player the player colour
	 * @param position piece's initial position, max length 2
	 */
	public Queen(PieceColour player, int x, int y) {
		super(player, x, y, false, false, false);
	}

	/* (non-Javadoc)
	 * @see chess.pieces.Piece#move(chess.ChessBoard, int, int)
	 */
	@Override
	public boolean move(ChessBoard currentBoard, int x, int y) {
		if (!isLegalMove(currentBoard, x, y)) return false;
		this.setX(x);
		this.setY(y);
		return true;
	}

	/* (non-Javadoc)
	 * @see chess.pieces.Piece#isLegalMove(chess.ChessBoard, int, int)
	 */
	@Override
	public boolean isLegalMove(ChessBoard currentBoard, int x, int y) {
		if (currentBoard.getPiece(x, y) == null) { //if target square is empty
			if(Math.abs(x - this.getX()) <= 1 && Math.abs(y - this.getY()) <= 1) { //if moving by one square in any direction
				return true;
			}
			if (Math.abs(x) == Math.abs(y)) { //if moving diagonally
				if (x > this.getX()) { //if moving diagonally to the right
					if (y < this.getY()) { //if moving diagonally up
						int X = this.getX();
						int Y = this.getY();
						
						for (int i = 1; i < Math.abs(x - this.getX()); i++) { //loop through all squares between current and target squares
							if (currentBoard.getPiece(X+i, Y+i) != null) return false; // if there is a piece between current square and target square
						}
						return true;
					} else {
						int X = this.getX();
						int Y = this.getY();
						
						for (int i = 1; i < Math.abs(x - this.getX()); i++) { //loop through all squares between current and target squares
							if (currentBoard.getPiece(X+i, Y-i) != null) return false; // if there is a piece between current square and target square
						}
						return true;
					}
				} else { //moving diagonally to the left
					if (y < this.getY()) { //if moving diagonally up
						int X = this.getX();
						int Y = this.getY();
						
						for (int i = 1; i < Math.abs(x - this.getX()); i++) { //loop through all squares between current and target squares
							if (currentBoard.getPiece(X-i, Y+i) != null) return false; // if there is a piece between current square and target square
						}
						return true;
					} else {
						int X = this.getX();
						int Y = this.getY();
						
						for (int i = 1; i < Math.abs(x - this.getX()); i++) { //loop through all squares between current and target squares
							if (currentBoard.getPiece(X-i, Y-i) != null) return false; // if there is a piece between current square and target square
						}
						return true;
					}
				}
			}
			if (y == this.getY() && x != this.getX()) { //if only moving horizontally
				if (x < this.getX()) { // check which direction move is
					for (int i = this.getX() + 1; i < x; i++) { // loop through all squares between current square and target square
						if (currentBoard.getPiece(i, y) != null) return false; // if there is a piece between current square and target square
					}
					return true;
				} else {
					for (int i = this.getX(); i > x; i--) { // loop through all squares between current square and target square
						if (currentBoard.getPiece(i, y) != null) return false; // if there is a piece between current square and target square
					}
					return true;
				}
			} else if (y != this.getY() && x == this.getX()) { // if only moving vertically
				if (y < this.getY()) { // check which direction move is
					for (int i = this.getY() + 1; i < y; i++) { // loop through all squares between current square and target square
						if (currentBoard.getPiece(x, i) != null) return false; // if there is a piece between current square and target square
					}
					return true;
				} else {
					for (int i = this.getY(); i > y; i--) { // loop through all squares between current square and target square
						if (currentBoard.getPiece(x, i) != null) return false; // if there is a piece between current square and target square
					}
					return true;
				}
			}
		} else {
			if (currentBoard.getPiece(x, y).getPlayer() == this.getPlayer()) return false; //if piece in target square is same colour as this piece
			
			if(Math.abs(x - this.getX()) <= 1 && Math.abs(y - this.getY()) <= 1) { //if moving by one square in any direction
				return true;
			}
			if (Math.abs(x) == Math.abs(y)) { //if moving diagonally
				if (x > this.getX()) { //if moving diagonally to the right
					if (y < this.getY()) { //if moving diagonally up
						int X = this.getX();
						int Y = this.getY();
						
						for (int i = 1; i < Math.abs(x - this.getX()); i++) { //loop through all squares between current and target squares
							if (currentBoard.getPiece(X+i, Y+i) != null) return false; // if there is a piece between current square and target square
						}
						return true;
					} else {
						int X = this.getX();
						int Y = this.getY();
						
						for (int i = 1; i < Math.abs(x - this.getX()); i++) { //loop through all squares between current and target squares
							if (currentBoard.getPiece(X+i, Y-i) != null) return false; // if there is a piece between current square and target square
						}
						return true;
					}
				} else { //moving diagonally to the left
					if (y < this.getY()) { //if moving diagonally up
						int X = this.getX();
						int Y = this.getY();
						
						for (int i = 1; i < Math.abs(x - this.getX()); i++) { //loop through all squares between current and target squares
							if (currentBoard.getPiece(X-i, Y+i) != null) return false; // if there is a piece between current square and target square
						}
						return true;
					} else {
						int X = this.getX();
						int Y = this.getY();
						
						for (int i = 1; i < Math.abs(x - this.getX()); i++) { //loop through all squares between current and target squares
							if (currentBoard.getPiece(X-i, Y-i) != null) return false; // if there is a piece between current square and target square
						}
						return true;
					}
				}
			}
			if (y == this.getY() && x != this.getX()) { //if only moving horizontally
				if (x < this.getX()) { // check which direction move is
					for (int i = this.getX() + 1; i < x; i++) { // loop through all squares between current square and target square
						if (currentBoard.getPiece(i, y) != null) return false; // if there is a piece between current square and target square
					}
					return true;
				} else {
					for (int i = this.getX(); i > x; i--) { // loop through all squares between current square and target square
						if (currentBoard.getPiece(i, y) != null) return false; // if there is a piece between current square and target square
					}
					return true;
				}
			} else if (y != this.getY() && x == this.getX()) { // if only moving vertically
				if (y < this.getY()) { // check which direction move is
					for (int i = this.getY() + 1; i < y; i++) { // loop through all squares between current square and target square
						if (currentBoard.getPiece(x, i) != null) return false; // if there is a piece between current square and target square
					}
					return true;
				} else {
					for (int i = this.getY(); i > y; i--) { // loop through all squares between current square and target square
						if (currentBoard.getPiece(x, i) != null) return false; // if there is a piece between current square and target square
					}
					return true;
				}
			}
		}
		return false;
	}

}
