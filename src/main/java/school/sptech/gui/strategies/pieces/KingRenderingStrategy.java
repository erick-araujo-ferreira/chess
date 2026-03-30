package school.sptech.gui.strategies.pieces;

import java.awt.*;

public class KingRenderingStrategy implements PieceRenderingStrategy{
    @Override
    public void render(Graphics g, Integer x0, Integer y0) {
        // body
        g.fillRect(x0 + 30, y0 + 30, 20, 30);

// cross top
        g.fillRect(x0 + 35, y0 + 15, 10, 15);
        g.fillRect(x0 + 30, y0 + 20, 20, 5);
    }
}
