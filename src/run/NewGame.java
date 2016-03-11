package run;

import chess.ChessBoard;
import chess.pieces.*;
import chess.types.PieceColour;

public class NewGame {
	/**
	 * @param j The Chessboard to make new game to
	 */
	public static void newGame(ChessBoard j){
		j.setWhitePlayerTurn(true);
		
		for (int rank=0;rank<8;rank++){
			for (int file=0;file<8;file++){
				switch(rank){
				case 0:
					if (file == 0 || file == 7){
						Rook blackRook = new Rook(PieceColour.BLACK,file,rank);
						j.addPiece(blackRook, file, rank);
					} else if (file == 1 || file == 6){
						Knight blackKnight = new Knight(PieceColour.BLACK,file,rank);
						j.addPiece(blackKnight, file, rank);
					} else if (file == 2 || file == 5){
						Bishop blackBishop = new Bishop(PieceColour.BLACK,file,rank);
						j.addPiece(blackBishop, file, rank);
					} else if (file == 4){
						King blackKing = new King(PieceColour.BLACK,file,rank);
						j.addPiece(blackKing, file, rank);
					} else if (file == 3){
						Queen blackQueen = new Queen(PieceColour.BLACK,file,rank);
						j.addPiece(blackQueen, file, rank);
					}
					break;
				case 1:
					Pawn blackPawn = new Pawn(PieceColour.BLACK,file,rank);
					j.addPiece(blackPawn, file, rank);
					break;
				case 6:
					Pawn whitePawn = new Pawn(PieceColour.WHITE,file,rank);
					j.addPiece(whitePawn, file, rank);
					break;
				case 7:
					if (file == 0 || file == 7){
						Rook whiteRook = new Rook(PieceColour.WHITE,file,rank);
						j.addPiece(whiteRook, file, rank);
					} else if (file == 1 || file == 6){
						Knight whiteKnight = new Knight(PieceColour.WHITE,file,rank);
						j.addPiece(whiteKnight, file, rank);
					} else if (file == 2 || file == 5){
						Bishop whiteBishop = new Bishop(PieceColour.WHITE,file,rank);
						j.addPiece(whiteBishop, file, rank);
					} else if (file == 4){
						King whiteKing = new King(PieceColour.WHITE,file,rank);
						j.addPiece(whiteKing, file, rank);
					} else if (file == 3){
						Queen whiteQueen = new Queen(PieceColour.WHITE,file,rank);
						j.addPiece(whiteQueen, file, rank);
					}
					break;
				}
			}
		}
	}
}