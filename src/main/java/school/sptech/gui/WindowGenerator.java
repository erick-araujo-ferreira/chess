package school.sptech.gui;

import javax.swing.*;

public class WindowGenerator {

    private final Integer FRAME_WIDTH = 640;
    private final Integer FRAME_HEIGHT = 640;

    public void renderWindow(JFrame frame) {
        frame.setSize(FRAME_WIDTH, FRAME_HEIGHT);
    }

    public Integer getFRAME_WIDTH() {
        return FRAME_WIDTH;
    }

    public Integer getFRAME_HEIGHT() {
        return FRAME_HEIGHT;
    }
}
