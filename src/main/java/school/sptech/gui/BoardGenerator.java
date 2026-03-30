package school.sptech.gui;

import javax.swing.*;
import java.awt.*;
import java.util.Map;

public class BoardGenerator extends JPanel {
    private static final Integer tileSize = 80;
    private final PieceGenerator pieceGenerator = new PieceGenerator();
    private final BoardCoordinatesMapper coordinates = BoardCoordinatesMapper.getInstance();

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

        renderBoardPieceStart(g);
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(640, 640);
    }

    private void renderBoardPieceStart(Graphics g) {
        g.setColor(Color.BLUE);
        pieceGenerator.renderPiece(g, PieceType.ROOK, coordinates.getCoord("a8"));
        pieceGenerator.renderPiece(g, PieceType.HORSE, coordinates.getCoord("b8"));
        pieceGenerator.renderPiece(g, PieceType.BISHOP, coordinates.getCoord("c8"));
        pieceGenerator.renderPiece(g, PieceType.QUEEN, coordinates.getCoord("d8"));
        pieceGenerator.renderPiece(g, PieceType.KING, coordinates.getCoord("e8"));
        pieceGenerator.renderPiece(g, PieceType.BISHOP, coordinates.getCoord("f8"));
        pieceGenerator.renderPiece(g, PieceType.HORSE, coordinates.getCoord("g8"));
        pieceGenerator.renderPiece(g, PieceType.ROOK, coordinates.getCoord("h8"));
    }

    public static Integer getTileSize() {
        return tileSize;
    }
}
