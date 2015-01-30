package ks.ai.nuclearpwn.rest;

import com.google.common.io.Files;
import ks.ai.nuclearpwn.env.MachineProps;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@RestController
@RequestMapping("/rest/screenshot")
public class ScreenshotRs
{
    @Autowired Robot bot;
    @Autowired MachineProps machineProps;

    private File dir;
    private Rectangle screenBounds;

    @PostConstruct
    void init() {
        dir = new File("out");
        screenBounds = new Rectangle(machineProps.windows7BorderOffset(), machineProps.gameResolution());
    }


    @RequestMapping(value = "/save", produces = "image/png")
    public byte[] saveScreenshot() throws AWTException, IOException {
        BufferedImage screenshot = takeScreenshot();

        String screenshotName = screenshotName();

        File saveLocation = new File(dir, screenshotName + ".png");
        Files.createParentDirs(saveLocation);

        ImageIO.write(screenshot, "png", saveLocation);

        return renderImage(screenshot);
    }

    @RequestMapping(value = "/take", produces = "image/png")
    public byte[] viewScreenshot() throws AWTException, IOException {
        return renderImage(takeScreenshot());
    }

    public byte[] renderImage(BufferedImage image) throws AWTException, IOException {

        ByteArrayOutputStream bao = new ByteArrayOutputStream();

        ImageIO.write(image, "png", bao);

        return bao.toByteArray();

    }
    public BufferedImage takeScreenshot() throws AWTException, IOException {
        return bot.createScreenCapture(screenBounds);
    }

    @RequestMapping("/name")
    public String screenshotName() {
        return DateTimeFormatter.ofPattern("yyyy-MM-dd_HH-mm-ss").format(LocalDateTime.now());
    }
}
