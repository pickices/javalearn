package com.liuxinchi.servlet;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

public class Image extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setHeader("refresh","3");
        BufferedImage img = new BufferedImage(80, 30, BufferedImage.TYPE_INT_RGB);
        Graphics2D graphics2D = (Graphics2D) img.getGraphics();
        graphics2D.setColor(Color.WHITE);
        graphics2D.fillRect(0,0,80,30);
        graphics2D.setColor(Color.BLUE);
        graphics2D.setFont(new Font(null,Font.BOLD,20));
        graphics2D.drawString(makeNum(),0,20);
        ImageIO.write(img,"jpg",resp.getOutputStream());



    }

    private String makeNum(){
        Random random = new Random();
        String num = random.nextInt(999999) + "";
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < 6-num.length(); i++) {
            sb.append("0");
        }
        return sb+num;
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
}
