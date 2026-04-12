package school.sptech.game.strategies.movement;

import school.sptech.game.Piece;

public interface PieceMovementStrategy {
    Boolean isMovementValid(Piece[][] board, Integer[] clickedSquare, Integer[] releasedSquare);
}
