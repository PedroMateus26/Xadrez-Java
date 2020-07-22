package boardgame;

public class Piece {
	
	private Position position;
	private Board board;
	
	public Piece(Position position, Board board) {
		this.position = null;
		this.board = board;
	}

	public Position getPosition() {
		return position;
	}

	public void setPosition(Position position) {
		this.position = position;
	}

	protected Board getBoard() {
		return board;
	}

	
	
}
