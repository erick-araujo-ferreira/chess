package school.sptech.gui;

import school.sptech.game.Piece;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

import static school.sptech.gui.UIConfig.TILE_SIZE;

public class MouseTracker extends MouseAdapter {
    private static Integer[] clickedPosition = new Integer[2];
    List<MouseTrackerObserver> observers = new ArrayList<>();

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
        notifyObservers(clickedPosition, releasedPosition);
    }

    public void addObserver(MouseTrackerObserver observer) {
        this.observers.add(observer);
    }

    public void notifyObservers(Integer[] clickedSquare, Integer[] releasedSquare) {
        for (MouseTrackerObserver observer : observers) {
            observer.pieceMoved(clickedSquare, releasedSquare);
        }
    }
}
