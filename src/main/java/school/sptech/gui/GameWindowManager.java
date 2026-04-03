package school.sptech.gui;

import school.sptech.game.BoardManager;

import javax.swing.*;

public class GameWindowManager {
    private static final JFrame frame = new JFrame();
    private final WindowGenerator windowGenerator = new WindowGenerator();
    private final BoardManager boardManager = new BoardManager();
    private final BoardGenerator boardGenerator = new BoardGenerator(boardManager.getBoard());

    public void startWindow() {
        windowGenerator.renderWindow(frame);
        frame.add(boardGenerator);
        frame.pack();
        frame.setVisible(true);
    }

    public void updateWindow() {
        boardManager.movePiece("d1", "e4");
        boardGenerator.repaint();
    }
}
