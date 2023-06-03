package boardgame;

public class Piece {
  protected Position position;
  public Board board;

  public Piece(Board board) {
    this.board = board;
    this.position = null;
    // this.position pode ser nulo pq nao ira, no inicio,
    // assumir nenhuma posicao no tabuleiro.
  }

  protected Board getBoard() {
    return board;
  }

}
