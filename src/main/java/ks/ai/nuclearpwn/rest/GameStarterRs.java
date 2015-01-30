package ks.ai.nuclearpwn.rest;

import ks.ai.nuclearpwn.setup.GameStarter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.awt.*;
import java.io.IOException;

@RestController
@RequestMapping("/rest/game-starter")
public class GameStarterRs {
    @Autowired
    GameStarter gameStarter;


    @RequestMapping(value = "/start")
    public void start() throws AWTException, IOException, InterruptedException {
        gameStarter.start();
    }

    @RequestMapping(value = "/start-and-position")
    public void startAndPosition() throws AWTException, IOException, InterruptedException {
        gameStarter.start();
        gameStarter.positionWindow();
    }
}
