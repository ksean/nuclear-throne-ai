package ks.ai.nuclearpwn.env;

import ks.ai.nuclearpwn.ScreenRecorder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;
import java.awt.*;
import java.io.IOException;

@Configuration
public class MachineConfig {
    private GraphicsDevice screen;
    private Robot bot;

    @PostConstruct
    void init() throws AWTException, IOException {
        screen = ScreenRecorder.screenBootstrap;
        bot = new Robot(screen);
    }

    @Bean GraphicsDevice provideGraphicsDevice() {
        return screen;
    }

    @Bean Robot provideRobot() {
        return bot;
    }
}
