package ks.ai.nuclearpwn;

import ks.ai.nuclearpwn.model.KeyboardAction;
import ks.ai.nuclearpwn.model.MouseAction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.awt.*;

@Service
public class Input {
    private static final Logger log = LoggerFactory.getLogger(Input.class);

    int keyboardDelay = 100;
    int mouseDelay = 500;


    @Autowired
    Robot bot;


    public void perform(KeyboardAction keyboardAction) {
        log.info("performing {}", keyboardAction);

        int keyCode = keyboardAction.keyCode();

        bot.keyPress(keyCode);

        try {
            Thread.sleep(keyboardDelay);
        } catch (InterruptedException e) {
            throw new Error(e);
        }

        bot.keyRelease(keyCode);
    }


    public void perform(MouseAction mouseAction) {
        log.info("performing {}", mouseAction);

        int buttons = mouseAction.buttons();

        bot.mousePress(buttons);

        try {
            Thread.sleep(mouseDelay);
        } catch (InterruptedException e) {
            throw new Error(e);
        }

        bot.mouseRelease(buttons);
    }
}
