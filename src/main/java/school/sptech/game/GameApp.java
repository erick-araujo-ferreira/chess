package school.sptech.game;

import school.sptech.gui.GameWindowManager;

public class GameApp {
    GameWindowManager windowManager = new GameWindowManager();
    public void start() {
        windowManager.startWindow();
    }
}
