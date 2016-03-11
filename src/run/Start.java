package run;

import org.fusesource.jansi.AnsiConsole;

import chess.ChessBoard;
import chess.pieces.King;
import chess.pieces.Piece;
import chess.types.PieceColour;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;

/**
 * @author Jussi Wallin, Tero Yrjölä, Niklas Niemelä
 *
 */
public class Start {
	static ChessBoard game;

	public static void main(String[] args) {
		AnsiConsole.systemInstall();
		Scanner sc = new Scanner(System.in);
		
		game = new ChessBoard();
		//Create Pieces and put them in place
		NewGame.newGame(game);
		
		game.showBoard();
		System.out.println("\nIt is white player's turn.");
		while (executeCommand(sc)) {
			game.showBoard();
			if (game.isWhitePlayerTurn()){
				System.out.println("\nIt is white player's turn.");
			}else{
				System.out.println("\nIt is black player's turn.");
			}
			
			if (game.isCheck() != 0) {
				switch (game.isCheck()) {
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
	
	private static boolean executeCommand(Scanner sc) {
		String command = sc.next();
		
		switch (command) {
		case "exit":
			return false;
		case "move":
			int[] currentPiece = interpretCoord(sc.next());
			int[] targetSquare = interpretCoord(sc.next());
			Piece pieceToMove = game.getPiece(currentPiece[0], currentPiece[1]);
			
			if (game.isWhitePlayerTurn() == (pieceToMove.getPlayer() == PieceColour.WHITE)) { //if it is current piece's player's turn to move

				if (pieceToMove.getPlayer() == PieceColour.BLACK && game.isCheck() == -1) {//if moving black and black is in check
					if (!(pieceToMove instanceof King)) { //if not moving king
						System.out.println("Siirrä kunkkua! Paina Enter jatkaaksesi.");
						try {
							System.in.read(); //wait for enter key
						} catch (IOException e) {
						}
					} else {
						if (game.move(currentPiece[0], currentPiece[1], targetSquare[0], targetSquare[1])) { //if move succee change turn
							game.setWhitePlayerTurn(!game.isWhitePlayerTurn());
							game.showBoard();
							
						}
					}
				} else if (pieceToMove.getPlayer() == PieceColour.WHITE && game.isCheck() == 1) {//if moving white and white is in check
					if (!(pieceToMove instanceof King)) {//if not moving king
						System.out.println("Siirrä kunkkua! Paina Enter jatkaaksesi.");
						try {
							System.in.read(); //wait for enter key
						} catch (IOException e) {
						}
					} else {
						if (game.move(currentPiece[0], currentPiece[1], targetSquare[0], targetSquare[1])) { //if move succee change turn
							game.setWhitePlayerTurn(!game.isWhitePlayerTurn());
						}
					}
				} else {
					if (game.move(currentPiece[0], currentPiece[1], targetSquare[0], targetSquare[1])) { //if move succee change turn
						game.setWhitePlayerTurn(!game.isWhitePlayerTurn());
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
			System.out.println("Green color is the white player.\nRed color is the black player.\nFirst type in 'move' and press enter, "
					+ "then the coordinate of the piece you want to move,\nand finally the coordinate of the position you want to move your piece to.\n"
					+ "Type 'save' to save the game and 'load' to load the game. 'newgame' starts a new game.");
			try {
				System.in.read(); //wait for enter key
			} catch (IOException e) {
			}
			return true;
		case "save":
			System.out.println("Are you sure? (y/n)");
			if (sc.next().equals("y")) {
				saveGame();
			}
			break;
		case "load":
			System.out.println("Are you sure? (y/n)");
			if (sc.next().equals("y")) {
				loadGame();
			}
			break;
		case "newgame":
			System.out.println("Are you sure? (y/n)");
			if (sc.next().equals("y")) {
				NewGame.newGame(game);
			}
			
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
		try {
			FileOutputStream fout = new FileOutputStream(".\\save.txt");
			ObjectOutputStream oos = new ObjectOutputStream(fout);
			oos.writeObject(game);
			oos.close();
			System.out.println("Game Saved!");
			System.in.read(); //wait for enter key
		} catch (Exception e) {
			System.out.println("Game Saving Failed!");
			try {
				System.in.read();
			} catch (IOException e1) {
			} //wait for enter key
			e.printStackTrace();
		}
	}
	
	private static void loadGame() {
		try {
			FileInputStream fin = new FileInputStream(".\\save.txt");
			ObjectInputStream ois = new ObjectInputStream(fin);
			game = (ChessBoard) ois.readObject();
			ois.close();
			System.out.println("Game Loaded!");
			System.in.read(); //wait for enter key
		} catch (Exception e) {
			System.out.println("Game Loading Failed!");
			try {
				System.in.read();
			} catch (IOException e1) {
			} //wait for enter key
			e.printStackTrace();
		}
	}
}
