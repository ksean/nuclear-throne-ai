package ks.ai.nuclearpwn;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

import java.awt.*;

@EnableAutoConfiguration
@ComponentScan
public class ScreenRecorder {
    public static GraphicsDevice screenBootstrap;

    public static void main(String[] args) throws Exception {
        screenBootstrap = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();

        SpringApplication.run(ScreenRecorder.class, args);
    }
}
