package school.sptech.game.strategies.movement;

import school.sptech.game.Piece;

public class KingMovementStrategy implements PieceMovementStrategy{
    @Override
    public Boolean isMovementValid(Piece[][] board, Integer[] clickedSquare, Integer[] releasedSquare) {
        Piece clickedPiece = board[clickedSquare[0]][clickedSquare[1]];

        System.out.println("PEÇA CLICADA: " + clickedPiece);

        return ((Math.pow((releasedSquare[0] - clickedSquare[0]), 2) == 1 || (releasedSquare[0] - clickedSquare[0]) == 0)
                && (Math.pow((releasedSquare[1] - clickedSquare[1]), 2) == 1 || (releasedSquare[1] - clickedSquare[1]) == 0));
    }
}
