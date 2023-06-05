package chess;

import boardgame.Board;
import chessPieces.King;
import chessPieces.Rook;

public class ChessMatch {
  private Board board;

  public ChessMatch() {
    board = new Board(8, 8);
    initialSetup();
  }

  // O código abaixo RETORNA o conjunto de pecas na partida de xadrez.
  // Seria como se houvesse uma nova RENDERIZACAO A CADA PARTIDA.
  public ChessPiece[][] getPieces() {
    ChessPiece[][] mat = new ChessPiece[board.getRows()][board.getColumns()];
    for (int i = 0; i < board.getRows(); i++) {
      for (int j = 0; j < board.getColumns(); j++) {
        mat[i][j] = (ChessPiece) board.piece(i, j);
      }
    }
    return mat;
  }

  // Metodo para receber as coordenadas do xadrez.
  // E instanciar uma ChessPosition com os dados abaixo:
  // A linha abaixo passa as pecas na coordenada do xadrez.
  private void placeNewPiece(char column, int row, ChessPiece piece) {
    board.placePiece(piece, new ChessPosition(column, row).tPosition());
  }

  // Metodo responsavel por iniciar as partidas de xadrez,
  // colocando as pecas no tabuleiro.

  private void initialSetup() {
    placeNewPiece('b', 6, new King(board, Color.WHITE));
    placeNewPiece('e', 8, new King(board, Color.BLACK));
    placeNewPiece('e', 1, new Rook(board, Color.WHITE));
  }

}
