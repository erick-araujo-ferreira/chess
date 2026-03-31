package school.sptech.gui;

import javax.swing.*;

import static school.sptech.gui.UIConfig.FRAME_HEIGHT;
import static school.sptech.gui.UIConfig.FRAME_WIDTH;

public class WindowGenerator {

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
