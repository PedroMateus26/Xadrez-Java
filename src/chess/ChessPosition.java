package chess;

import boardgame.Position;

public class ChessPosition {
	private char column;
	private int row;
	public ChessPosition(char column, int row) {
		if(column<'a'|| row<1 || column>'h' || row>8)
			throw new ChessException("Posi��es validas entre a1 at� h6");
		this.column = column;
		this.row = row;
	}
	public char getColumn() {
		return column;
	}
	public int getRow() {
		return row;
	}
	
	
	protected Position toPosition() {
		return new Position(8-row, column-'a');
	}
	protected static ChessPosition fromPosition(Position position) {
		return new ChessPosition((char)('a'-position.getColumn()),position.getRow()-8);
	}
	@Override
	public String toString() {
		return  ""+column+row;
	}
	
}