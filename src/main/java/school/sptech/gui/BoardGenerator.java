package school.sptech.gui;

import javax.swing.*;
import java.awt.*;
import java.util.Map;

public class BoardGenerator extends JPanel {
    private static final Integer tileSize = 80;
    private final PieceGenerator pieceGenerator = new PieceGenerator();
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
                pieceGenerator.renderPiece(g, PieceType.PAWN, squareXPosition, squareYPosition);
            }
        }
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(640, 640);
    }

}
