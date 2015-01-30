package ks.ai.nuclearpwn.model;

import java.awt.event.InputEvent;
import java.util.Random;

public enum MouseAction {
    FIRE(InputEvent.BUTTON1_MASK), SPECIAL(InputEvent.BUTTON3_MASK);
    private final int buttons;

    MouseAction(int buttons) {
        this.buttons = buttons;
    }

    public int buttons() {
        return buttons;
    }


    public static MouseAction random(Random random) {
        return values()[ random.nextInt(values().length) ];
    }
}