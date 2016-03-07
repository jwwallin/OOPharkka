package run;

import org.fusesource.jansi.AnsiConsole;

import chess.ChessBoard;
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
			
			board.move(currentPiece[0], currentPiece[1], targetSquare[0], targetSquare[1]);
			return true;
		case "help":
			System.out.println("This is the help");
			return true;
		}
		return true;
	}

	private static int[] interpretCoord(String ChessCoord) {
		int[] coords = {0, 0};
		
		return coords;
	}

}
