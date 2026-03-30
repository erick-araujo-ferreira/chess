package school.sptech.gui;

import javax.swing.*;

public class GameWindowManager {
    private static final JFrame frame = new JFrame();
    private final WindowGenerator windowGenerator = new WindowGenerator();
    private final BoardGenerator boardGenerator = new BoardGenerator();

    public void startWindow() {
        windowGenerator.renderWindow(frame);
        frame.add(boardGenerator);
        frame.pack();
        frame.setVisible(true);
    }
}
