package school.sptech.game.strategies.movement;

import school.sptech.game.Piece;

public interface PieceMovementStrategy {
    void movePiece(Piece[][] board, Integer[] clickedSquare, Integer[] releasedSquare);
    Boolean isNormalMovementValid(MovementContext ctx);
    default void changePiecesPosition(Piece[][] board, Integer[] clickedSquare, Integer[] releasedSquare) {
        board[releasedSquare[0]][releasedSquare[1]] = board[clickedSquare[0]][clickedSquare[1]];
        board[clickedSquare[0]][clickedSquare[1]] = null;
    }
}
