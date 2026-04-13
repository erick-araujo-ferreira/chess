package school.sptech.game.strategies.movement;

import school.sptech.game.Piece;

public class MovementContext {
    public final Piece[][] board;
    public final Integer[] clickedSquare;
    public final Integer[] releasedSquare;
    public final Piece clickedPiece;
    public final int direction;

    public MovementContext(Piece[][] board, Integer[] clicked, Integer[] released) {
        this.board = board;
        this.clickedSquare = clicked;
        this.releasedSquare = released;
        this.clickedPiece = board[clicked[0]][clicked[1]];
        this.direction = clickedPiece.isWhite() ? -1 : 1;
    }
}
