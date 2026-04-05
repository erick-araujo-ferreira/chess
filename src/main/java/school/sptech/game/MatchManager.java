package school.sptech.game;

import school.sptech.gui.GameWindowManager;
import school.sptech.gui.MouseTracker;

import java.awt.event.MouseEvent;

public class MatchManager {
    BoardManager boardManager = new BoardManager();
    GameWindowManager windowManager = new GameWindowManager(boardManager);
    private Boolean isOver = false;
    public void start() {
        windowManager.startWindow();
    }
}
