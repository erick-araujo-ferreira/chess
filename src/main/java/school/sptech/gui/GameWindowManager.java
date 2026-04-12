package school.sptech.gui;

import school.sptech.game.BoardManager;
import school.sptech.game.MatchManager;

import javax.swing.*;

public class GameWindowManager {
    private static final JFrame frame = new JFrame();
    private final WindowGenerator windowGenerator = new WindowGenerator();
    private final BoardManager boardManager;
    private final BoardGenerator boardGenerator;
    private final MouseTracker tracker;
    private final MatchManager currentMatch;

    public GameWindowManager(BoardManager boardManager, MatchManager matchManager) {
        this.boardManager = boardManager;
        boardGenerator = new BoardGenerator(this.boardManager);
        tracker = new MouseTracker();
        currentMatch = matchManager;
    }

    public void startWindow() {
        tracker.addObserver(currentMatch);
        windowGenerator.renderWindow(frame);
        boardGenerator.addMouseListener(tracker);
        frame.add(boardGenerator);
        frame.pack();
        frame.setVisible(true);
        System.out.println(frame.getInsets());
    }

    public void updateWindow() {
        boardGenerator.repaint();
    }
}
