package school.sptech.game;

import school.sptech.gui.BoardCoordinatesMapper;
import school.sptech.gui.PieceType;

import java.util.Arrays;

import static school.sptech.game.GameConfig.PAWN_ROW;
import static school.sptech.game.GameConfig.ROYAL_ROW;
import static school.sptech.gui.UIConfig.TILE_SIZE;

public class BoardManager {
    private Piece[][] board;
    private final BoardCoordinatesMapper coordinates;

    public BoardManager() {
        this.board = new Piece[8][8];
        coordinates = BoardCoordinatesMapper.getInstance();
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

    public void movePiece(String from, String to) {
        Integer[] pieceXY = Arrays.copyOf(coordinates.getCoord(from), 2);
        if (pieceXY[0] != 0) {
            pieceXY[0] /= TILE_SIZE;
        }
        if (pieceXY[1] != 0) {
            pieceXY[1] /= TILE_SIZE;
        }

        board[pieceXY[1]][pieceXY[0]] = null;

        System.out.println(Arrays.toString(pieceXY));
        System.out.println(board[pieceXY[1]][pieceXY[0]]);
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
