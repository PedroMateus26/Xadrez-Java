package chess.pieces;

import boardgame.Board;
import chess.ChessPiece;
import chess.Color;

public class Rook extends ChessPiece{
	private Color color;
	public Rook(Board board, Color color) {
		super(board, color);
		this.color=color;
	}
	
	@Override
	public String toString() {
		if(color==Color.WHITE)
			return "Rw";
		else 
			return "Rb";
	}
	
}
