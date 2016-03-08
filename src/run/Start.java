package run;

import org.fusesource.jansi.AnsiConsole;

import chess.ChessBoard;
import chess.pieces.King;
import chess.types.PieceColour;

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
			if (board.getPiece(currentPiece[0], currentPiece[1]).getPlayer() == PieceColour.BLACK && board.isCheck() == -1) {
				if (!(board.getPiece(currentPiece[0], currentPiece[1]) instanceof King)) {
					System.out.println("Olet homo! Siirrä kunkkua!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
				} else {
					board.move(currentPiece[0], currentPiece[1], targetSquare[0], targetSquare[1]);
				}
			} else if (board.getPiece(currentPiece[0], currentPiece[1]).getPlayer() == PieceColour.WHITE && board.isCheck() == 1) {
				if (!(board.getPiece(currentPiece[0], currentPiece[1]) instanceof King)) {
					System.out.println("Olet homo! Siirrä kunkkua!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
				} else {
					board.move(currentPiece[0], currentPiece[1], targetSquare[0], targetSquare[1]);
				}
			} else {
				board.move(currentPiece[0], currentPiece[1], targetSquare[0], targetSquare[1]);
			}
			return true;
		case "help":
			System.out.println("This is the help");
			return true;
		default:
		}
		return true;
	}

	private static int[] interpretCoord(String ChessCoord) {
		int[] coords = {0, 0};
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

}
