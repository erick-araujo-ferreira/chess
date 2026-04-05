package school.sptech.game;

import school.sptech.gui.GameWindowManager;

import java.util.Arrays;

import static school.sptech.game.GameConfig.PAWN_ROW;
import static school.sptech.game.GameConfig.ROYAL_ROW;
import static school.sptech.gui.UIConfig.TILE_SIZE;

public class BoardManager {
    private Piece[][] board;
    private GameWindowManager windowManager;

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

        createRow(whiteRoyalPieces, 7);
    }

    public void initializeBlackPieces() {
        Piece[] blackRoyalPieces = Arrays.stream(ROYAL_ROW)
                .map(pieceType -> new Piece(pieceType, false))
                .toArray(Piece[]::new);

        initializePawnPieces(false);

        createRow(blackRoyalPieces, 0);
    }

    public void initializePawnPieces(Boolean isWhite) {
        Piece[] pawnPieces = Arrays.stream(PAWN_ROW)
                .map(pieceType -> new Piece(pieceType, isWhite))
                .toArray(Piece[]::new);

        if (isWhite) createRow(pawnPieces, 6);
        else createRow(pawnPieces, 1);
    }

    public void movePiece(Integer[] fromRowCol, Integer[] toRowCol) {
        Piece pieceToMove = board[fromRowCol[0]][fromRowCol[1]];

    }

    public void update() {

    }

    public Piece[][] getBoard() {
        return board;
    }

    public void printBoard() {
        char letra;
        for (int row = 0; row < 8; row++) {
            System.out.print((8 - row) + "  "); // numeração estilo xadrez

            for (int col = 0; col < 8; col++) {
                Piece piece = board[row][col];

                if (piece == null) {
                    System.out.print("# ");
                } else {
                    letra = piece.isWhite() ? piece.getPieceType().toString().charAt(0) : piece.getPieceType().toString().toLowerCase().charAt(0);
                    System.out.print(letra + " ");
                }
            }

            System.out.println();
        }

        // letras embaixo
        System.out.println("\n   a b c d e f g h");
    }
}
