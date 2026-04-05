package school.sptech.gui;

import school.sptech.game.BoardManager;
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
    private final Piece[][] board;
    private final BoardManager boardManager;

    public BoardGenerator(BoardManager boardManager) {
        this.boardManager = boardManager;
        this.board = this.boardManager.getBoard();
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


    private void renderBoard(Graphics g, Piece[][] board) {
        char coordLetter;
        Piece pieceToRender;
        for (int row = 0; row < 8; row++) {
            for (int col = 0; col < 8; col++) {
                pieceToRender = board[row][col];
                Integer[] pieceXY = {col * tileSize, row * tileSize};
                if (pieceToRender != null)
                    pieceGenerator.renderPiece(g, pieceToRender.getPieceType(), pieceXY, pieceToRender.isWhite());
            }
        }
        boardManager.printBoard();

    }

}
