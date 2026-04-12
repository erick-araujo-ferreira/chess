package school.sptech.game.strategies.movement;

import school.sptech.game.Piece;

public class RookMovementStrategy implements PieceMovementStrategy{
    @Override
    public Boolean isMovementValid(Piece[][] board, Integer[] clickedSquare, Integer[] releasedSquare) {
        Piece clickedPiece = board[clickedSquare[0]][clickedSquare[1]];

        System.out.println("PEÇA CLICADA: " + clickedPiece);

        return (!(releasedSquare[0].equals(clickedSquare[0])) ^ !(releasedSquare[1].equals(clickedSquare[1])));
    }
}
