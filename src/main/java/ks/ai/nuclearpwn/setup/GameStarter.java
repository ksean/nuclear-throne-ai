package ks.ai.nuclearpwn.setup;

import ks.ai.nuclearpwn.env.MachineProps;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.awt.*;
import java.awt.event.InputEvent;
import java.io.IOException;

@Service
public class GameStarter {
    private String path = "H:/Games/steamapps/common/Nuclear Throne/nuclearthrone.exe";

    @Autowired
    Robot bot;

    @Autowired
    MachineProps machineProps;

    Process process;


    public void start() throws IOException, InterruptedException {
        process = Runtime.getRuntime().exec(path);

        Thread.sleep(3000);
    }

    public void stop() {
        if (process != null) {
            process.destroyForcibly();
            process = null;
        }
    }

    public void positionWindow() throws InterruptedException {
        Dimension gameResolution = machineProps.gameResolution();
        System.out.println(gameResolution);
        Dimension screenResolution = machineProps.screenSize();
        System.out.println(screenResolution);
        Point borderOffset = machineProps.windows7BorderOffset();

        Point start = new Point(screenResolution.width / 2, (screenResolution.height / 2) - (gameResolution.height / 2) - borderOffset.y / 2 + 40);
        Point end = new Point( gameResolution.width / 2, borderOffset.y / 2); // borderOffset.x +

        bot.mouseMove(start.x, start.y);
        Thread.sleep(1000);
        bot.mousePress(InputEvent.BUTTON1_MASK);
        Thread.sleep(1000);
        bot.mouseMove(end.x, end.y);
        Thread.sleep(1000);
        bot.mouseRelease(InputEvent.BUTTON1_MASK);
    }
}
