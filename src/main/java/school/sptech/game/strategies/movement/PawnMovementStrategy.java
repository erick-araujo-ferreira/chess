package school.sptech.game.strategies.movement;

import school.sptech.game.Piece;

public class PawnMovementStrategy implements PieceMovementStrategy{
    @Override
    public Boolean isMovementValid(Piece[][] board, Integer[] clickedSquare, Integer[] releasedSquare) {
        Piece clickedPiece = board[clickedSquare[0]][clickedSquare[1]];
        int direction = clickedPiece.isWhite() ? -1 : 1;

        System.out.println("PEÇA CLICADA: " + clickedPiece + " DIRECAO: " + direction);

        System.out.println("RELEASE VALIDO: " + (clickedSquare[0] + direction));

        if (releasedSquare[1].equals(clickedSquare[1])
            && releasedSquare[0].equals(clickedSquare[0] + direction)){
            return true;
        }

        // If pawn was not moved yet, it can move 2 squares :d
        if ((releasedSquare[1].equals(clickedSquare[1])
            && releasedSquare[0].equals(clickedSquare[0] + direction * 2)) && !clickedPiece.wasMoved())
            return true;

        return false;
    }
}
