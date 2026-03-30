package school.sptech.gui.strategies.pieces;

import java.awt.*;

public class QueenRenderingStrategy implements PieceRenderingStrategy {
    @Override
    public void render(Graphics g, Integer x0, Integer y0) {
        int[] x = {
                x0 + 20, x0 + 30, x0 + 40, x0 + 50, x0 + 60,
                x0 + 55, x0 + 25
        };
        int[] y = {
                y0 + 60, y0 + 30, y0 + 50, y0 + 30, y0 + 60,
                y0 + 60, y0 + 60
        };
        g.fillPolygon(x, y, 7);
    }
}
