package school.sptech.game;

import school.sptech.gui.BoardCoordinatesMapper;
import school.sptech.gui.GameWindowManager;

import java.util.Arrays;

public class GameStarter {
    GameWindowManager windowManager = new GameWindowManager();
    public void start() {
        windowManager.startWindow();
    }
}
