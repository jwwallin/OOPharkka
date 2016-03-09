package run;

import org.fusesource.jansi.AnsiConsole;

import chess.ChessBoard;
import chess.pieces.King;
import chess.pieces.Piece;
import chess.types.PieceColour;

import java.io.IOException;
import java.util.Scanner;

/**
 * @author Jussi Wallin, Tero Yrjölä, Niklas Niemelä
 *
 */
public class Start {

	public static void main(String[] args) {
		AnsiConsole.systemInstall();
		Scanner sc = new Scanner(System.in);
		
		ChessBoard j = new ChessBoard();
		//Create Pieces and put them in place
		NewGame.newGame(j);
		
		j.showBoard();
		while (executeCommand(sc, j)) {
			j.showBoard();
			
			if (j.isCheck() != 0) {
				switch (j.isCheck()) {
				case -1:
					System.out.println("Black player is in check!");
					break;
				case 1:
					System.out.println("White player is in check!");
					break;
				}
			}
		}
		
		sc.close();
		AnsiConsole.systemUninstall();

	}
	
	private static boolean executeCommand(Scanner sc, ChessBoard board) {
		String command = sc.next();
		
		switch (command) {
		case "exit":
			return false;
		case "move":
			int[] currentPiece = interpretCoord(sc.next());
			int[] targetSquare = interpretCoord(sc.next());
			Piece pieceToMove = board.getPiece(currentPiece[0], currentPiece[1]);
			
			if (board.isWhitePlayerTurn() == (pieceToMove.getPlayer() == PieceColour.WHITE)) { //if it is current piece's player's turn to move

				if (pieceToMove.getPlayer() == PieceColour.BLACK && board.isCheck() == -1) {//if moving black and black is in check
					if (!(pieceToMove instanceof King)) { //if not moving king
						System.out.println("Siirrä kunkkua! Paina Enter jatkaaksesi.");
						try {
							System.in.read(); //wait for enter key
						} catch (IOException e) {
						}
					} else {
						if (board.move(currentPiece[0], currentPiece[1], targetSquare[0], targetSquare[1])) { //if move succee change turn
							board.setWhitePlayerTurn(!board.isWhitePlayerTurn());
						}
					}
				} else if (pieceToMove.getPlayer() == PieceColour.WHITE && board.isCheck() == 1) {//if moving white and white is in check
					if (!(pieceToMove instanceof King)) {//if not moving king
						System.out.println("Siirrä kunkkua! Paina Enter jatkaaksesi.");
						try {
							System.in.read(); //wait for enter key
						} catch (IOException e) {
						}
					} else {
						if (board.move(currentPiece[0], currentPiece[1], targetSquare[0], targetSquare[1])) { //if move succee change turn
							board.setWhitePlayerTurn(!board.isWhitePlayerTurn());
						}
					}
				} else {
					if (board.move(currentPiece[0], currentPiece[1], targetSquare[0], targetSquare[1])) { //if move succee change turn
						board.setWhitePlayerTurn(!board.isWhitePlayerTurn());
					}
				}
			} else {
				System.out.println("Et voi siirtää omaa nappulaa kahdesti peräkkäin!");
				try {
					System.in.read(); //wait for enter key
				} catch (IOException e) {
				}
			}
			return true;
		case "help":
			System.out.println("This is the help! hihi!");
			try {
				System.in.read(); //wait for enter key
			} catch (IOException e) {
			}
			return true;
		default:
		}
		return true;
	}

	private static int[] interpretCoord(String ChessCoord) {
		int[] coords = {0, 0};
		if (ChessCoord.length() != 2) {
			
		}
		char file = Character.toLowerCase(ChessCoord.charAt(0));
		char rank = ChessCoord.charAt(1);
		switch(file){
		case 'a':
			coords[0] = 0;
			break;
		case 'b':
			coords[0] = 1;
			break;
		case 'c':
			coords[0] = 2;
			break;
		case 'd':
			coords[0] = 3;
			break;
		case 'e':
			coords[0] = 4;
			break;
		case 'f':
			coords[0] = 5;
			break;
		case 'g':
			coords[0] = 6;
			break;
		case 'h':
			coords[0] = 7;
			break;
		}
		switch(rank){
		case '1':
			coords[1] = 0;
			break;
		case '2':
			coords[1] = 1;
			break;
		case '3':
			coords[1] = 2;
			break;
		case '4':
			coords[1] = 3;
			break;
		case '5':
			coords[1] = 4;
			break;
		case '6':
			coords[1] = 5;
			break;
		case '7':
			coords[1] = 6;
			break;
		case '8':
			coords[1] = 7;
			break;
		}
		return coords;
	}

	private static void saveGame() {
		//TODO save
	}
	
	private static void loadGame() {
		//TODO load
	}
}
