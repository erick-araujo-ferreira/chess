package school.sptech.game;

import school.sptech.game.strategies.movement.*;
import school.sptech.gui.GameWindowManager;
import school.sptech.gui.MouseTracker;
import school.sptech.gui.MouseTrackerObserver;
import school.sptech.gui.PieceType;
import school.sptech.gui.strategies.pieces.*;

import java.awt.event.MouseEvent;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class MatchManager implements MouseTrackerObserver {
    private final BoardManager boardManager;
    private final GameWindowManager windowManager;
    private final Piece[][] board;

    private final Map<PieceType, PieceMovementStrategy> strategies = Map.of(
            PieceType.BISHOP, new BishopMovementStrategy(),
            PieceType.HORSE, new HorseMovementStrategy(),
            PieceType.KING, new KingMovementStrategy(),
            PieceType.PAWN, new PawnMovementStrategy(),
            PieceType.QUEEN, new QueenMovementStrategy(),
            PieceType.ROOK, new RookMovementStrategy()
    );

    public MatchManager() {
        boardManager = new BoardManager();
        windowManager = new GameWindowManager(boardManager, this);
        board = boardManager.getBoard();
    }

    public void start() {
        windowManager.startWindow();
    }

    @Override
    public void pieceMoved(Integer[] clickedSquare, Integer[] releasedSquare) {
        if (isMovementValid(board, clickedSquare, releasedSquare)) {
            movePiece(board, clickedSquare, releasedSquare);
            windowManager.updateWindow();
        }
    }

    private void movePiece(Piece[][] board, Integer[] clickedSquare, Integer[] releasedSquare) {
        board[releasedSquare[0]][releasedSquare[1]] = board[clickedSquare[0]][clickedSquare[1]];
        board[clickedSquare[0]][clickedSquare[1]] = null;
    }

    private Boolean isMovementValid(Piece[][] board, Integer[] clickedSquare, Integer[] releasedSquare) {
        Piece clickedPiece = board[clickedSquare[0]][clickedSquare[1]];
        PieceMovementStrategy strategy = strategies.get(clickedPiece.getPieceType());

        return (!Arrays.equals(clickedSquare, releasedSquare)
                && strategy.isMovementValid(board, clickedSquare, releasedSquare));
    }
}
