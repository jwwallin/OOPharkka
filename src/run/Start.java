package run;

import org.fusesource.jansi.AnsiConsole;

import chess.ChessBoard;
import chess.pieces.Rook;
import chess.pieces.Soldier;
import chess.types.PieceColour;

import static org.fusesource.jansi.Ansi.*;
import static org.fusesource.jansi.Ansi.Color.*;

import java.io.IOException;

/**
 * @author Jussi Wallin, Tero Yrjölä, Niklas Niemelä
 *
 */
public class Start {

	public static void main(String[] args) {
		AnsiConsole.systemInstall();
		
		ChessBoard j = new ChessBoard();
		Rook R = new Rook(PieceColour.BLACK, null);
		j.addPiece(R, 2, 2);
		j.addPiece(new Soldier(PieceColour.WHITE, null), 3, 2);
		
		j.showBoard();
		try {
			System.in.read();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		AnsiConsole.systemUninstall();

	}

}
