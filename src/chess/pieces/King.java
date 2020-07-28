package chess.pieces;

import boardgame.Board;
import chess.ChessPiece;
import chess.Color;

public class King extends ChessPiece{
	private Color color;
	public King(Board board, Color color) {
		super(board, color);
		this.color=color;
		
	}

	@Override
	public String toString() {
		if(color==Color.WHITE)
			return "Kw";
		else 
			return "Kb";
	}
	
}
