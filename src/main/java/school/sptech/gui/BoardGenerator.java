package school.sptech.gui;

import school.sptech.game.Piece;

import javax.swing.*;
import java.awt.*;
import java.util.Arrays;
import java.util.Map;

import static school.sptech.gui.UIConfig.LETTER_ASCII_FIRST_POSITION;
import static school.sptech.gui.UIConfig.TILE_SIZE;

public class BoardGenerator extends JPanel {
    private static final Integer tileSize = TILE_SIZE;
    private final PieceGenerator pieceGenerator = new PieceGenerator();
    private final BoardCoordinatesMapper coordinates = BoardCoordinatesMapper.getInstance();
    private final Piece[][] board;

    public BoardGenerator(Piece[][] board) {
        this.board = board;
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        int squareXPosition;
        int squareYPosition;
        for (int row = 0; row < 8; row ++) {
            squareYPosition = row * tileSize;
            for (int col = 0; col < 8; col ++) {
                squareXPosition = col * tileSize;
                if ((row + col) % 2 == 0) g.setColor(Color.WHITE);
                else g.setColor(Color.BLACK);
                g.fillRect(squareXPosition, squareYPosition, tileSize, tileSize);
            }
        }

        renderBoard(g, board);
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(640, 640);
    }

//    private void renderBoardPieceStart(Graphics g) {
//        PieceType[] ROYAL_ROW = {PieceType.ROOK, PieceType.HORSE, PieceType.BISHOP, PieceType.QUEEN, PieceType.KING, PieceType.BISHOP, PieceType.HORSE, PieceType.ROOK};
//
//        PieceType[] PAWN_ROW = new PieceType[8];
//        Arrays.fill(PAWN_ROW, PieceType.PAWN);
//
//        renderRow(g, ROYAL_ROW, 8);
//        renderRow(g, PAWN_ROW, 7);
//
//        renderRow(g, ROYAL_ROW, 1);
//        renderRow(g, PAWN_ROW, 2);
//    }

    private void renderBoard(Graphics g, Piece[][] board) {

        for(int row = 0; row < 8; row++) {
            for (int col = 0; col < 8; col++) {
                if (board[row][col] != null){
                    // row + 1 pq o tabuleiro começa em a1, não em a0
                    pieceGenerator.renderPiece(g, board[row][col].getPieceType(), coordinates.getCoord(String.format("%c%d", (LETTER_ASCII_FIRST_POSITION + col), row + 1)), board[row][col].isWhite());
                }
            }
        }
    }

}
