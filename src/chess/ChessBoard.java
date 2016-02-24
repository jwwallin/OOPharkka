package chess;

import chess.pieces.*;

public class ChessBoard {
	private Piece[][] board;

	public Piece getPiece(int x, int y) {
		return board[x][y];
	}
<<<<<<< HEAD

	public void move(int[] posOrig, int[] posMoveTo) {
=======
	
	public boolean move(int[] posOrig, int[] posMoveTo) {
>>>>>>> 5a77992c1f4887e41016c3d28146084d7c1d5f02
		//check if position data is valid
		if (posOrig.length != 2 || posMoveTo.length != 2) return false;
		//move
		if (board[posMoveTo[0]][posMoveTo[1]] == null) {//if target position is empty
			if (!board[posOrig[0]][posOrig[1]].move(this, posMoveTo[0], posMoveTo[1])) // if current piece not moved successfully
				return false; 
			board[posMoveTo[0]][posMoveTo[1]] = board[posOrig[0]][posOrig[1]];
			board[posOrig[0]][posOrig[1]] = null;
<<<<<<< HEAD


		} //TODO if MoveTo position is not empty
=======
			return true;
			
		} else {
			//TODO if MoveTo position is not empty
			return false;
		}
	}
	
	/**
	 * @return if board drawing is successful
	 */
	public boolean drawBoard() {
		return false;
	}
	
	/**
	 * @return -1, 0, 1 being black player is in check, no check, white player is in check
	 */
	public int isCheck() {
		return 0;

	}

	public void showBoard(){
		boolean white = false;
		System.out.println("_________________________________"); 					//draw the top horizontal line
		
		for (int i = 0; i < 8; i++){
			white = !white;															//after each row, change starting color
			
			if (i > 0){
				System.out.println("---------------------------------");			//draw horizontal lines in between
			}

			for (int j = 0; j < 8; j++){

				System.out.print("|");												//draw a vertical line before each character

				if (/*this.*/getPiece(j,i)==null){
					if (white){
						System.out.print("   ");									//print a space/blackchar if no pieces at (j,i)
						white = !white;
					}else{System.out.print("\u2588\u2588\u2588");
					white = !white;

					}
				}else{																//if a piece is found, print it in the middle of spaces/blackchars
					if (white){
						System.out.print(" " + /*this.*/getPiece(j,i) + " ");
						white = !white;
					}else{System.out.println("/u2588" + /*this.*/getPiece(j,i) + "\u2588");

					}


					if (j==7){
						System.out.println("|");									//after the 8th character, draw a vertical line
					}
				}
			}
			System.out.print( "¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯");					//draw the bottom horizontal line
		}	
	}
}
