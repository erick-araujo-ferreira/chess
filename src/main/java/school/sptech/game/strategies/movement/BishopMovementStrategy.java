package school.sptech.game.strategies.movement;

import school.sptech.game.Piece;

public class BishopMovementStrategy implements PieceMovementStrategy{
    @Override
    public Boolean isMovementValid(Piece[][] board, Integer[] clickedSquare, Integer[] releasedSquare) {
        Piece clickedPiece = board[clickedSquare[0]][clickedSquare[1]];

        System.out.println("PEÇA CLICADA: " + clickedPiece);

        return (Math.pow((releasedSquare[0] - clickedSquare[0]), 2) == Math.pow((releasedSquare[1] - clickedSquare[1]), 2));
    }
}
