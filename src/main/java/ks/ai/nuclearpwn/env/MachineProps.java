package ks.ai.nuclearpwn.env;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.awt.*;

@Service
public class MachineProps {
    @Autowired
    GraphicsDevice screen;


    private Dimension screenSize;
    private Dimension gameResolution = new Dimension(320, 240);
    private Point windows7BorderOffset = new Point(8, 30);


    @PostConstruct
    void init() {
        DisplayMode displayMode = screen.getDisplayMode();
        screenSize = new Dimension(displayMode.getWidth(), displayMode.getHeight());
    }


    public Dimension gameResolution() {
        return gameResolution;
    }

    public Point windows7BorderOffset() {
        return windows7BorderOffset;
    }

    public Dimension screenSize() {
        return screenSize;
    }
}
