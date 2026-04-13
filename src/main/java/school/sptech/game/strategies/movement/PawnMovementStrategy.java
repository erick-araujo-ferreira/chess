package school.sptech.game.strategies.movement;

import school.sptech.game.MovementValidator;
import school.sptech.game.Piece;

public class PawnMovementStrategy implements PieceMovementStrategy{
    private final MovementValidator validator = new MovementValidator();

    @Override
    public void movePiece(Piece[][] board, Integer[] clickedSquare, Integer[] releasedSquare) {
        if (validator.isBasicMovementValid(board, clickedSquare, releasedSquare)) {
            MovementContext ctx = new MovementContext(board, clickedSquare, releasedSquare);
            validatePawnMovement(ctx);
        }
    }

    private void validatePawnMovement(MovementContext ctx) {
        if (isNormalMovementValid(ctx) || isDiagonalCapture(ctx) || isDoubleSquareMovimentValid(ctx)) {
            changePiecesPosition(ctx.board, ctx.clickedSquare, ctx.releasedSquare);
        }
        else if (isEnPassantCapture(ctx)) {
            enPassantChangePosition(ctx);
        }
    }

    @Override
    public Boolean isNormalMovementValid(MovementContext ctx) {
        return (ctx.releasedSquare[1].equals(ctx.clickedSquare[1])
                && ctx.releasedSquare[0].equals(ctx.clickedSquare[0] + ctx.direction)
                && ctx.board[ctx.releasedSquare[0]][ctx.releasedSquare[1]] == null);
    }

    private Boolean isDiagonalCapture(MovementContext ctx) {
        // Diagonal capture validation :0
        return (Math.pow(ctx.releasedSquare[1] - ctx.clickedSquare[1], 2) == 1
                && ctx.releasedSquare[0].equals(ctx.clickedSquare[0] + ctx.direction)
                && Math.pow(ctx.releasedSquare[0] - ctx.clickedSquare[0], 2) == 1
                && ctx.board[ctx.releasedSquare[0]][ctx.releasedSquare[1]] != null
                && ctx.board[ctx.releasedSquare[0]][ctx.releasedSquare[1]].isWhite() != ctx.clickedPiece.isWhite()
                );
    }

    private Boolean isDoubleSquareMovimentValid(MovementContext ctx) {
        // Double square validation *~*
        ctx.board[ctx.clickedSquare[0]][ctx.clickedSquare[1]].setEnPassantVulnerable(true);
        return ((ctx.releasedSquare[1].equals(ctx.clickedSquare[1])
                && ctx.releasedSquare[0].equals(ctx.clickedSquare[0] + ctx.direction * 2)) && !ctx.clickedPiece.wasMoved());

    }

    private Boolean isEnPassantCapture(MovementContext ctx) {
        // EnPassant validation 7-7
        return (ctx.board[ctx.releasedSquare[0] + ctx.direction * -1][ctx.releasedSquare[1]] != null
                && ctx.board[ctx.releasedSquare[0] + ctx.direction * -1][ctx.releasedSquare[1]].isWhite() != ctx.clickedPiece.isWhite()
                && ctx.board[ctx.releasedSquare[0] + ctx.direction * -1][ctx.releasedSquare[1]].isEnPassantVulnerable()
                && ctx.releasedSquare[0].equals(ctx.clickedSquare[0] + ctx.direction));
    }

    private void enPassantChangePosition(MovementContext ctx) {
        ctx.board[ctx.releasedSquare[0] + ctx.direction * -1][ctx.releasedSquare[1]] = null;
        changePiecesPosition(ctx.board, ctx.clickedSquare, ctx.releasedSquare);
    }
}
