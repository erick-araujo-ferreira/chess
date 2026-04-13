package school.sptech.game;

import java.util.Arrays;

public class MovementValidator {
    public Boolean isBasicMovementValid(Piece[][] board, Integer[] clickedSquare, Integer[] releasedSquare) {
        return (!Arrays.equals(clickedSquare, releasedSquare)
                && isCaptureValid(board, clickedSquare, releasedSquare));
    }

    private Boolean isCaptureValid(Piece[][] board, Integer[] clickedSquare, Integer[] releasedSquare) {
        // todo: make a centralized handler to null pieces on board
        if (board[releasedSquare[0]][releasedSquare[1]] == null) return true;

        Piece pieceToCapture = board[releasedSquare[0]][releasedSquare[1]];
        Piece pieceToMove = board[clickedSquare[0]][clickedSquare[1]];

        return (!pieceToCapture.isWhite() == pieceToMove.isWhite());
    }
}
