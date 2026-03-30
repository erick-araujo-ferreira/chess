package school.sptech.gui.strategies.pieces;

import java.awt.*;

public class HorseRenderingStrategy implements PieceRenderingStrategy {
    @Override
    public void render(Graphics g, Integer x0, Integer y0) {
        int[] x = {
                x0 + 20, x0 + 50, x0 + 60, x0 + 45, x0 + 30
        };
        int[] y = {
                y0 + 60, y0 + 60, y0 + 40, y0 + 20, y0 + 30
        };
        g.fillPolygon(x, y, 5);
    }
}
