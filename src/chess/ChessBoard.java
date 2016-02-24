package chess;

import chess.pieces.*;

public class ChessBoard {
	private Piece[][] board;

	public Piece getPiece(int x, int y) {
		return board[x][y];
	}

	public void move(int[] posOrig, int[] posMoveTo) {
		//check if position data is valid
		if (posOrig.length != 2 || posOrig.length != 2) return;
		//move
		if (board[posMoveTo[0]][posMoveTo[1]] == null) {//check if MoveTo position is empty
			//if is
			board[posOrig[0]][posOrig[1]].move(this, posMoveTo[0], posMoveTo[1]); //call move for current piece to move
			board[posMoveTo[0]][posMoveTo[1]] = board[posOrig[0]][posOrig[1]];
			board[posOrig[0]][posOrig[1]] = null;


		} //TODO if MoveTo position is not empty
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
