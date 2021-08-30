package com.hqyj.hx.response;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

/**
 * @author xfy
 * @create 2021-08-28 11:16
 */
@WebServlet("/checkCodeServlet")
public class CheckCodeServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //创建一张画布
        int width=100;
        int height=50;
            //宽度、长度、色深
        BufferedImage bufferedImage=new BufferedImage(width,height,BufferedImage.TYPE_INT_ARGB);

        //在画布中绘制图形
            //1.绘制背景色
            //获取画笔
        Graphics graphics = bufferedImage.getGraphics();
        //设置背景的颜色
        graphics.setColor(Color.pink);
        //绘制背景色
        graphics.fillRect(0,0,width,height);
        //绘制边框
        graphics.setColor(Color.blue);
        graphics.drawRect(0,0,width-1,height-1);
        //绘制字符串
        graphics.setColor(Color.red);
        //创建随机对象
        Random random = new Random();
        //定义随机的字符的全集
        String string="QWERTYUIOPASDFGHJKLZXCVBNMqwertyuiopasdfghjklzxcvbnm0123456789";
        for (int i=0;i<5;i++) {
            //生成一个随机的数，最大为string的长度
            int randomIndex = random.nextInt(string.length());
            char randomChar = string.charAt(randomIndex);
            graphics.drawString(String.valueOf(randomChar),5+width*i/5,height/2);
        }
        //最后 画10根干扰线
        graphics.setColor(Color.green);
        for (int i=0;i<10;i++) {
            int x1=random.nextInt(width);
            int y1=random.nextInt(height);
            int x2=random.nextInt(width);
            int y2=random.nextInt(height);
            graphics.drawLine(x1,y1,x2,y2);
        }

        //response对象的字节流输出流输出图形数据
        ServletOutputStream outputStream = response.getOutputStream();
        //使用图形图像工具类写数据
        //bufferedImage，图像格式png，输出对象流
        ImageIO.write(bufferedImage,"png",outputStream);
    }
}
