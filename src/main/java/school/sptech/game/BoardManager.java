package school.sptech.game;

import school.sptech.gui.PieceType;

import java.util.Arrays;

import static school.sptech.game.GameConfig.PAWN_ROW;
import static school.sptech.game.GameConfig.ROYAL_ROW;

public class BoardManager {
    private Piece[][] board;

    public BoardManager() {
        this.board = new Piece[8][8];
        startBoard();
    }

    public void startBoard() {
        initializeBlackPieces();
        initializeWhitePieces();
    }

    // Board fill utils
    public void createRow(Piece[] piecesToInsert, Integer row) {
        for (int i = 0; i < 8; i++) {
            board[row][i] = piecesToInsert[i];
        }
    }

    public void initializeWhitePieces() {
        Piece[] whiteRoyalPieces = Arrays.stream(ROYAL_ROW)
                .map(pieceType -> new Piece(pieceType, true))
                .toArray(Piece[]::new);

        initializePawnPieces(true);

        createRow(whiteRoyalPieces, 0);
    }

    public void initializeBlackPieces() {
        Piece[] blackRoyalPieces = Arrays.stream(ROYAL_ROW)
                .map(pieceType -> new Piece(pieceType, false))
                .toArray(Piece[]::new);

        initializePawnPieces(false);

        createRow(blackRoyalPieces, 7);
    }

    public void initializePawnPieces(Boolean isWhite) {
        Piece[] pawnPieces = Arrays.stream(PAWN_ROW)
                .map(pieceType -> new Piece(pieceType, isWhite))
                .toArray(Piece[]::new);

        if (isWhite) createRow(pawnPieces, 1);
        else createRow(pawnPieces, 6);
    }

    public Piece[][] getBoard() {
        return board;
    }
}
