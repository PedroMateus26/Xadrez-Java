package application;

import java.util.InputMismatchException;

import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;
import java.util.stream.Collectors;

import java.util.List;
import java.util.Arrays;

import chess.ChessMatch;
import chess.ChessPiece;
import chess.ChessPosition;
import chess.Color;

public class UI {

	static int delay = 1000; // delay de 5 seg.
	static int interval = 1000; // intervalo de 1 seg.
	static Timer timer = new Timer();

	public static ChessPosition readChessPosition(Scanner sc) {
		try {
			String s = sc.nextLine();
			char column = s.charAt(0);
			int row = Integer.parseInt(s.substring(1));
			return new ChessPosition(column, row);
		} catch (RuntimeException e) {
			throw new InputMismatchException("Erro ao acessar a posi��o do xadrez, valores v�lidos v�o de a1 � h8");
		}
	}

	public static void printMatch(ChessMatch chessMatch, List<ChessPiece> captured) {
		printBoard(chessMatch.getPieces());
		System.out.println();
		printCapturedPieces(captured);
		System.out.println();
		System.out.println("Turno : " + chessMatch.getTurn());
		if (!chessMatch.getCheckMate()) {
			System.out.println("Esperando jogador: " + ((chessMatch.getCurrentPlayer()==Color.BRANCO)?"BRANCO (Pe�as com w)":"PRETO (Pe�as com b)"));
			;
			
			if (chessMatch.getCheck()) {
				System.out.println("CHECK!");
			}
		} else {
			System.out.println("CHECKMATE!");
			System.out.println("Vencedor: " + chessMatch.getCurrentPlayer());
		}
	}

	public static void printBoard(ChessPiece[][] pieces) {
		for (int i = 0; i < pieces.length; i++) {
			System.out.print((8 - i) + "  ");
			for (int j = 0; j < pieces.length; j++) {
				printPiece(pieces[i][j], false);
			}
			System.out.println();
		}
		System.out.println("   a   b   c   d   e   f   g   h");
	}

	public static void printBoard(ChessPiece[][] pieces, boolean[][] possibleMoves) {
		for (int i = 0; i < pieces.length; i++) {
			System.out.print((8 - i) + "  ");
			for (int j = 0; j < pieces.length; j++) {
				printPiece(pieces[i][j], possibleMoves[i][j]);
			}
			System.out.println();
		}
		System.out.println("   a   b   c   d   e   f   g   h");
	}

	private static void printPiece(ChessPiece piece, boolean background) {
		if (background) {
			if (piece != null) {
					System.out.print("o ");
				
			} else {
				System.out.print("x ");
			}
		} else if (piece == null) {
			System.out.print("- ");
		} else {
			System.out.print(piece);
		}
		System.out.print("  ");
	}

	private static void printCapturedPieces(List<ChessPiece> captured) {
		List<ChessPiece> white = captured.stream().filter(x -> x.getColor() == Color.BRANCO)
				.collect(Collectors.toList());
		List<ChessPiece> black = captured.stream().filter(x -> x.getColor() == Color.PRETO)
				.collect(Collectors.toList());
		System.out.println("Pecas capturadas:");
		System.out.print("Branco: ");
		System.out.println(Arrays.toString(white.toArray()));
		System.out.print("Preto: ");
		System.out.println(Arrays.toString(black.toArray()));

	}
}
