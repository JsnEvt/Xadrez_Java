package chess;

import boardgame.Position;

public class ChessPosition {
  private char column;
  private int row;

  public ChessPosition(char column, int row) {
    if (column < 'a' || column > 'h' || row < 1 || row > 8) {
      throw new ChessException("Error instatiating ChessPosition. Valid values are from a1 to h8.");
    }
    this.column = column;
    this.row = row;
  }

  public char getColumn() {
    return column;
  }

  public int getRow() {
    return row;
  }

  // convertendo a posicao para uma posicao "normal" = posicao de matriz 00 = a8,
  // 10 = a7 da matriz.
  // a linha da matriz = 8 - a linha no xadrez
  // olhando o codigo unicode, para a coluna teremos:
  // 'a' - 'a' = 0
  // 'b' - 'a' = 1
  // ...
  // entao a matriz de coluna = coluna do xadrez - 'a'

  protected Position tPosition() {
    return new Position(8 - row, column - 'a');
  }

  // abaixo: dada uma posicao na matriz, a funcao converte para uma posicao de
  // xadrez.
  protected static ChessPosition fromPosition(Position position) {
    return new ChessPosition((char) ('a' - position.getColumn()), 8 - position.getRow());
  }

  @Override
  public String toString() {
    return "" + column + row; // "" para forcar o compilador a entender que isso e uma concatenacao de string.
  }

}