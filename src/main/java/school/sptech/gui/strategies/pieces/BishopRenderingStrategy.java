package school.sptech.gui.strategies.pieces;

import java.awt.*;

public class BishopRenderingStrategy implements PieceRenderingStrategy {
    @Override
    public void render(Graphics g, Integer x0, Integer y0) {
        int[] x = {x0 + 40, x0 + 60, x0 + 40, x0 + 20};
        int[] y = {y0 + 20, y0 + 40, y0 + 60, y0 + 40};
        g.fillPolygon(x, y, 4);
    }
}
