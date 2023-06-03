package boardgame;

public class Board {
  private int rows;
  private int columns;
  private Piece[][] pieces;

  public Board(int rows, int columns) {
    if (rows < 1 || columns < 1) {
      throw new BoardException("Error creating board: there must be at least 1 row and 1 column");
    }
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

  // o metodo abaixo retorna o tipo da peca no xadrez
  public Piece piece(int row, int column) {
    if (!positionExists(row, column)) {
      throw new BoardException("Position not on the board");
    }
    return pieces[row][column];
  }

  // o metodo abaixo retorna a posicao da peca em questao
  public Piece piece(Position position) {
    if (!positionExists(position)) {
      throw new BoardException("Position not on the board");
    }

    return pieces[position.getRow()][position.getColumn()];
  }

  // colocando a peca no tabuleiro
  public void placePiece(Piece piece, Position position) {
    if (thereIsAPiece(position)) {
      throw new BoardException("There is already a piece on position" + position);
    }
    pieces[position.getRow()][position.getColumn()] = piece;
    piece.position = position;
  }

  // isso e pra faciliar a implementacao do proximo metodo.
  // posicao existe quando existe algum valor no array da matriz de linhas e
  // colunas
  private boolean positionExists(int row, int column) {
    // linhas e colunas = a dimensao do tabuleiro
    // a linha abaixo representa o intervalo dos valores do array.
    return row >= 0 && row < rows && column >= 0 && column < columns;
  }

  public boolean positionExists(Position position) {
    return positionExists(position.getRow(), position.getColumn());
  }

  public boolean thereIsAPiece(Position position) {
    if (!positionExists(position)) {
      throw new BoardException("Position not on the board");
    }

    return piece(position) != null;
    // a linha acima indica que ha uma peca nessa posicao.
  }
}
