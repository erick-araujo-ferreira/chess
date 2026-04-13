package school.sptech.game.strategies.movement;

import school.sptech.game.MovementValidator;
import school.sptech.game.Piece;

public class KingMovementStrategy implements PieceMovementStrategy{
    private final MovementValidator validator = new MovementValidator();

    @Override
    public void movePiece(Piece[][] board, Integer[] clickedSquare, Integer[] releasedSquare) {
        if (validator.isBasicMovementValid(board, clickedSquare, releasedSquare)) {
            MovementContext ctx = new MovementContext(board, clickedSquare, releasedSquare);
            validateKingMovement(ctx);
        }
    }

    @Override
    public Boolean isNormalMovementValid(MovementContext ctx) {
        return (Math.pow((ctx.releasedSquare[0] - ctx.clickedSquare[0]), 2) == 1 || (ctx.releasedSquare[0] - ctx.clickedSquare[0]) == 0)
                && (Math.pow((ctx.releasedSquare[1] - ctx.clickedSquare[1]), 2) == 1 || (ctx.releasedSquare[1] - ctx.clickedSquare[1]) == 0);
    }

    private void validateKingMovement(MovementContext ctx) {
        if (isNormalMovementValid(ctx)) {
            changePiecesPosition(ctx.board, ctx.clickedSquare, ctx.releasedSquare);
        }

        Integer xTower = ctx.releasedSquare[1] == 6 ? 7 :0;
        Piece tower = ctx.board[ctx.releasedSquare[0]][xTower];

        if (isCastlingValid(ctx, tower)) {
            castling(ctx.board, ctx.clickedSquare, ctx.releasedSquare, ctx.clickedPiece, tower, xTower);
        }
    }

    public void castling(Piece[][] board, Integer[] clickedSquare, Integer[] releasedSquare, Piece king, Piece tower, Integer xTower) {
        if (!tower.wasMoved())  {
            board[clickedSquare[0]][clickedSquare[1]] = null;
            board[releasedSquare[0]][xTower] = null;
            xTower = xTower == 7 ? 5 : 3;
            System.out.println("TESTE " + xTower + " AHHHH " + releasedSquare[1]);
            board[releasedSquare[0]][xTower] = tower;
            board[releasedSquare[0]][releasedSquare[1]] = king;
        }
    }

    public Boolean isCastlingValid(MovementContext ctx, Piece tower) {

        return ((ctx.releasedSquare[0] == 0 || ctx.releasedSquare[0] == 7) && (ctx.releasedSquare[1] == 2 || ctx.releasedSquare[1] == 6)
            && (!tower.wasMoved() && !ctx.clickedPiece.wasMoved()));
    }
}
