package school.sptech.gui;

import school.sptech.game.Piece;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import static school.sptech.gui.UIConfig.TILE_SIZE;

public class MouseTracker extends MouseAdapter {
    private static Integer[] clickedPosition = new Integer[2];
    private final Piece[][] board;
    private final GameWindowManager gameWindowManager;

    public MouseTracker(Piece[][] board, GameWindowManager gameWindowManager) {
        this.board = board;
        this.gameWindowManager = gameWindowManager;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
    }

    @Override
    public void mousePressed(MouseEvent e) {
        clickedPosition = new Integer[]{e.getY() / UIConfig.TILE_SIZE, e.getX() / UIConfig.TILE_SIZE};
        System.out.println("clicou em: X:" + clickedPosition[1] + " Y:" + clickedPosition[0]);
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        Integer[] releasedPosition = new Integer[]{e.getY() / TILE_SIZE, e.getX() / TILE_SIZE};
        System.out.println("soltou em: X:" + releasedPosition[1] + " Y:" + releasedPosition[0]);
        board[releasedPosition[0]][releasedPosition[1]] = board[clickedPosition[0]][clickedPosition[1]];
        board[clickedPosition[0]][clickedPosition[1]] = null;
        gameWindowManager.updateWindow();
    }
}
