package chess;

import boardgame.Board;
import boardgame.Position;
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
  // Metodo responsavel por iniciar as partidas de xadrez,
  // colocando as pecas no tabuleiro.

  private void initialSetup() {
    board.placePiece(new Rook(board, Color.WHITE), new Position(2, 1));
    board.placePiece(new King(board, Color.BLACK), new Position(0, 4));
  }

}
