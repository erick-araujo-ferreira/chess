package school.sptech.game.strategies.movement;

import school.sptech.game.MovementValidator;
import school.sptech.game.Piece;

public class QueenMovementStrategy implements PieceMovementStrategy{
    private final MovementValidator validator = new MovementValidator();

    @Override
    public void movePiece(Piece[][] board, Integer[] clickedSquare, Integer[] releasedSquare) {
        if (validator.isBasicMovementValid(board, clickedSquare, releasedSquare)) {
            MovementContext ctx = new MovementContext(board, clickedSquare, releasedSquare);
            validateQueenMovement(ctx);
        }
    }

    @Override
    public Boolean isNormalMovementValid(MovementContext ctx) {
        // ^ XOR operator
        return ((!(ctx.releasedSquare[0].equals(ctx.clickedSquare[0])) ^ !(ctx.releasedSquare[1].equals(ctx.clickedSquare[1]))
                || (Math.pow((ctx.releasedSquare[0] - ctx.clickedSquare[0]), 2) == Math.pow((ctx.releasedSquare[1] - ctx.clickedSquare[1]), 2))));
    }

    private void validateQueenMovement(MovementContext ctx) {
        if (isNormalMovementValid(ctx)) changePiecesPosition(ctx.board, ctx.clickedSquare, ctx.releasedSquare);
    }
}
