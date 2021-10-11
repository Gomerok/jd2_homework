package by.academy.it.controller;

import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.http.HttpServletResponse;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class ImageCreator {
    public static void createImage(HttpServletResponse response) throws IOException {
        BufferedImage image = new BufferedImage(200,200, BufferedImage.TYPE_INT_RGB);
        Graphics2D graphics2D = image.createGraphics();
        graphics2D.setFont(new Font("Serif", Font.ITALIC, 48));
        graphics2D.setColor(Color.green);
        graphics2D.drawString(String.valueOf(Counter.getCount()), 100, 100);
        ServletOutputStream out = response.getOutputStream();
        ImageIO.write(image, "jpeg", out);
    }


}
