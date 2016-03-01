package run;

import org.fusesource.jansi.AnsiConsole;

import chess.ChessBoard;
import chess.pieces.Rook;
import chess.pieces.Pawn;
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
		/**
		 * 
		 */
		NewGame.newGame(j);
		
		
		for (int rank=0;rank<8;rank++){
			for (int file=0;file<8;file++){
				switch(rank){
				case 1:
					Pawn blackPawn = new Pawn(PieceColour.BLACK,file,rank);
					j.addPiece(blackPawn,file,rank);
					break;
					
				case 7:
					Pawn whitePawn = new Pawn(PieceColour.WHITE,file,rank);
					j.addPiece(whitePawn,file,rank-1);
					break;
					
					
				}
			}
		}
		
		/*
		//positions for Pieces(named by Piece + initial file)
		//rank8
		int[] pos_Ra = {0,0};
		int[] pos_Nb = {1,0};
		int[] pos_Bc = {2,0};
		int[] pos_Kd = {3,0};
		int[] pos_Qe = {4,0};
		int[] pos_Bf = {5,0};
		int[] pos_Ng = {6,0};
		int[] pos_Rh = {7,0};
		//rank7
		int[] pos_Pa = {0,1};
		int[] pos_Pb = {1,1};
		int[] pos_Pc = {2,1};
		int[] pos_Pd = {3,1};
		int[] pos_Pe = {4,1};
		int[] pos_Pf = {5,1};
		int[] pos_Pg = {6,1};
		int[] pos_Ph = {7,1};
		//rank2
		int[] pos_pa = {0,6};
		int[] pos_pb = {1,6};
		int[] pos_pc = {2,6};
		int[] pos_pd = {3,6};
		int[] pos_pe = {4,6};
		int[] pos_pf = {5,6};
		int[] pos_pg = {6,6};
		int[] pos_ph = {7,6};
		//rank1
		int[] pos_ra = {0,7};
		int[] pos_nb = {1,7};
		int[] pos_bc = {2,7};
		int[] pos_qd = {3,7};
		int[] pos_ke = {4,7};
		int[] pos_bf = {5,7};
		int[] pos_ng = {6,7};
		int[] pos_rh = {7,7};
		
		//Creating Pieces for the pos
		//rank8
		Rook Ra = new Rook(PieceColour.BLACK, pos_Ra);
		j.addPiece(Ra,pos_Ra);
		/* Pieces not yet implemented
		Knight Nb = new Knight(PieceColour.BLACK, pos_Nb);
		j.addPiece(Ra,pos_Nb);
		Bishop Bc = new Bishop(PieceColour.BLACK, pos_Bc);
		j.addPiece(Ra,pos_Bc);
		King Kd = new King(PieceColour.BLACK, pos_Kd);
		j.addPiece(Ra,pos_Kd);
		Queen Qe = new Queen(PieceColour.BLACK, pos_Qe);
		j.addPiece(Ra,pos_Qe);
		Bishop Bf = new Bishop(PieceColour.BLACK, pos_Bf);
		j.addPiece(Ra,pos_Bf);
		Knight Ng = new Knight(PieceColour.BLACK, pos_Ng);
		j.addPiece(Ra,pos_Ng);
		
		Rook Rh = new Rook(PieceColour.BLACK, pos_Rh);
		j.addPiece(Ra,pos_Rh);
		//rank7
		Pawn Pa = new Pawn(PieceColour.BLACK, pos_Pa);
		j.addPiece(Pa,pos_Pa);
		Pawn Pb = new Pawn(PieceColour.BLACK, pos_Pb);
		j.addPiece(Pb,pos_Pb);
		Pawn Pc = new Pawn(PieceColour.BLACK, pos_Pc);
		j.addPiece(Pc,pos_Pc);
		Pawn Pd = new Pawn(PieceColour.BLACK, pos_Pd);
		j.addPiece(Pd,pos_Pd);
		Pawn Pe = new Pawn(PieceColour.BLACK, pos_Pe);
		j.addPiece(Pe,pos_Pe);
		Pawn Pf = new Pawn(PieceColour.BLACK, pos_Pf);
		j.addPiece(Pf,pos_Pf);
		Pawn Pg = new Pawn(PieceColour.BLACK, pos_Pg);
		j.addPiece(Pg,pos_Pg);
		Pawn Ph = new Pawn(PieceColour.BLACK, pos_Ph);
		j.addPiece(Ph,pos_Ph);
		
		
		//rank2
		Pawn pa = new Pawn(PieceColour.WHITE, pos_pa);
		j.addPiece(Pa,pos_pa);
		Pawn pb = new Pawn(PieceColour.WHITE, pos_pb);
		j.addPiece(Pb,pos_pb);
		Pawn pc = new Pawn(PieceColour.WHITE, pos_pc);
		j.addPiece(Pc,pos_pc);
		Pawn pd = new Pawn(PieceColour.WHITE, pos_pd);
		j.addPiece(Pd,pos_pd);
		Pawn pe = new Pawn(PieceColour.WHITE, pos_pe);
		j.addPiece(Pe,pos_pe);
		Pawn pf = new Pawn(PieceColour.WHITE, pos_pf);
		j.addPiece(Pf,pos_pf);
		Pawn pg = new Pawn(PieceColour.WHITE, pos_pg);
		j.addPiece(Pg,pos_pg);
		Pawn ph = new Pawn(PieceColour.WHITE, pos_ph);
		j.addPiece(Ph,pos_ph);
		//rank1
		Rook ra = new Rook(PieceColour.WHITE, pos_ra);
		j.addPiece(Ra,pos_ra);
		/* Pieces not yet implemented
		Knight nb = new Knight(PieceColour.WHITE, pos_nb);
		j.addPiece(Ra,pos_nb);
		Bishop bc = new Bishop(PieceColour.WHITE, pos_bc);
		j.addPiece(Ra,pos_bc);
		Queen qd = new Queen(PieceColour.WHITE, pos_qd);
		j.addPiece(Ra,pos_qd);
		King ke = new King(PieceColour.WHITE, pos_ke);
		j.addPiece(Ra,pos_ke);
		Bishop bf = new Bishop(PieceColour.WHITE, pos_bf);
		j.addPiece(Ra,pos_bf);
		Knight ng = new Knight(PieceColour.WHITE, pos_ng);
		j.addPiece(Ra,pos_ng);
		
		Rook rh = new Rook(PieceColour.WHITE, pos_rh);
		j.addPiece(Ra,pos_rh);
		*/
		
		j.showBoard();
		//j.move(P.getPosition(), pos);
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
