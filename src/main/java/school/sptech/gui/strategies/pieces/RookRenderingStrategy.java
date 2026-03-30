package school.sptech.gui.strategies.pieces;

import java.awt.*;

public class RookRenderingStrategy implements PieceRenderingStrategy {
    @Override
    public void render(Graphics g, Integer x0, Integer y0) {
        int[] x = {x0 + 20, x0 + 60, x0 + 60, x0 + 20};
        int[] y = {y0 + 30, y0 + 30, y0 + 60, y0 + 60};
        g.fillPolygon(x, y, 4);

// top towers
        g.fillRect(x0 + 20, y0 + 20, 10, 10);
        g.fillRect(x0 + 35, y0 + 20, 10, 10);
        g.fillRect(x0 + 50, y0 + 20, 10, 10);
    }
}
