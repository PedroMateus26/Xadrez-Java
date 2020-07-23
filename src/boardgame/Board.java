package boardgame;

public class Board {
	private int rows;
	private int columns;
	private Piece[][] pieces;
	
	public Board(int rows, int columns) {
		if(rows<1 || columns<1)
			throw new BoardException("Erro ao criar o tabuleiro, quantidade de linhas e de colunas deve ser maior que 1");
		this.rows = rows;
		this.columns = columns;
		pieces = new Piece[rows][columns];
		
	}

	public int getRows() {
		return rows;
	}


	public int getColumns() {
		return columns;
	}

	public Piece piece(int row, int column) {
		if(!positionExist(row, column))
			throw new BoardException("A posição acessada não existe");
		return pieces [row][column];
	}
	
	public Piece piece(Position position) {
		if(!positionExist(position.getRow(), position.getColumn()))
			throw new BoardException("A posição acessada não existe");
		return pieces[position.getRow()][position.getColumn()];
	}
	public void placePiece(Piece piece, Position position) {
		if(thereIsAPiece(position))
			throw new BoardException("Já existe uma peça nessa posição "+position);
		pieces[position.getRow()][position.getColumn()]=piece;
		piece.position=position;
	}
	
	public boolean positionExist(int row, int column) {
		return row>=0 && row<rows && column>=0 && column<columns;
	}
	
	public boolean positionExist(Position position) {
		return positionExist(position.getRow(),position.getColumn());
	}
	
	public boolean thereIsAPiece(Position position) {
		if(!positionExist(position.getRow(), position.getColumn()))
			throw new BoardException("A posição acessada não existe");
		return piece(position)!=null;
	}
}
