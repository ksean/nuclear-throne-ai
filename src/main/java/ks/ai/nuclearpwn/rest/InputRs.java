package ks.ai.nuclearpwn.rest;

import ks.ai.nuclearpwn.Input;
import ks.ai.nuclearpwn.model.KeyboardAction;
import ks.ai.nuclearpwn.model.MouseAction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.awt.*;
import java.io.IOException;
import java.util.Random;

@RestController
@RequestMapping("/rest/input")
public class InputRs {
    @Autowired
    Input input;


    @RequestMapping(value = "/keyboard/{action}")
    public void keyboard(@PathVariable KeyboardAction action) throws AWTException, IOException, InterruptedException {
        Thread.sleep(5 * 1000);
        input.perform(action);
    }


    @RequestMapping(value = "/keyboard/random")
    public void keyboard() throws AWTException, IOException, InterruptedException {
        Thread.sleep(5 * 1000);

        Random random = new Random();
        for (int i = 0; i < 100; i++) {
            KeyboardAction action = KeyboardAction.random(random);
            input.perform(action);
        }
    }

    @RequestMapping(value = "/random")
    public void random() throws AWTException, IOException, InterruptedException {
        Thread.sleep(5 * 1000);

        Random random = new Random();
        for (int i = 0; i < 100; i++) {
            if (random.nextDouble() < 0.8) {
                KeyboardAction action = KeyboardAction.random(random);
                input.perform(action);
            } else {
                MouseAction action = MouseAction.random(random);
                input.perform(action);
            }

        }
    }
}
