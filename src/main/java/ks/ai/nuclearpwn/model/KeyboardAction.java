package ks.ai.nuclearpwn.model;

import java.awt.event.KeyEvent;
import java.util.Random;

public enum KeyboardAction {
    UP(KeyEvent.VK_W),
    DOWN(KeyEvent.VK_S),
    LEFT(KeyEvent.VK_A),
    RIGHT(KeyEvent.VK_D),
    SWAP(KeyEvent.VK_Q),
    PICKUP(KeyEvent.VK_E);

    private final int keyCode;

    KeyboardAction(int keyCode) {
        this.keyCode = keyCode;
    }

    public int keyCode() {
        return keyCode;
    }

    public static KeyboardAction random(Random random) {
        return values()[ random.nextInt(values().length) ];
    }
}
