package core;

//import org.omg.PortableServer.POA;

import javax.swing.*;
import java.awt.*;

public class Eclip {
    public Point center;
    private int id;
    private int height, width;
    public int eclipA, eclipB;

    public static int subFrameWidth=275, subFrameHight=250, xOBegin=10, yOBegin=25, distance=100, labelSize=25, textSize=75;

    public Eclip() {
        this.center = new Point();
        this.id = id;
        this.height = 0;
        this.width = 0;
    }

    public Eclip(Point center, int height, int width, int id){
        this.id = id;
        this.center = new Point(center);
        this.height = height;
        this.width = width;
    }

    public Eclip(int x1, int y1, int height, int width, int id){
        this.id = id;
        this.center = new Point(x1, y1);
        this.height = height;
        this.width = width;
    }

    public int getId(){
        return this.id;
    }
    public void setId(int id){
        this.id=id;
    }
    public Point getTamO(){
        return this.center;
    }
    public int getXTamO(){
        return this.center.getX();
    }
    public int getYTamO(){
        return this.center.getY();
    }
    public int getheight(){
        return this.height;
    }
    public int getwidth(){
        return this.width;
    }
    public void setTamO(Point tamO){
        this.center=tamO;
    }
    public void setXTamO(int x){
        this.center.setX(x);
    }
    public void setYTamO(int y){
        this.center.setY(y);
    }
    public void setHeight(int height){
        this.height=height;
    }
    public void setWidth(int width){
        this.width=width;
    }

    public int getEclipA() {
        return eclipA;
    }

    public void setEclipA(int eclipA) {
        this.eclipA = eclipA;
    }

    public int getEclipB() {
        return eclipB;
    }

    public void setEclipB(int eclipB) {
        this.eclipB = eclipB;
    }

//    public JPanel draw() {
//        int x_center = this.center.getX();
//        int y_center = this.center.getY();
//
////        int width = (int) getwidth();
////        int height = (int) getheight();
//
////        int xPanel = x - width;
////        int yPanel = y - height;
//
//        JPanel panelDraw = new JPanel() {
//            private static final long serialVersionUID = 1L;
//
//            @Override
//            protected void paintComponent(Graphics g) {
//                // TODO Auto-generated method stub
//                super.paintComponent(g);
//                Graphics2D g2d = (Graphics2D) g;
//
//                float p, a2, b2;
//                int x = 0, y = eclipB;
//
//                a2 = eclipA*eclipA;
//                b2 = eclipB*eclipB;
//
////                p = (int) Math.round(b2-a2*height+0.25*a2);//p=b2 - a2*b +a2/4
//                p = 2 * ((float) b2/a2) - (2*eclipB) + 1;
//                while(((float) b2/a2) * x <= y) {
//                    put4Pixel(g2d, x_center, y_center, x, y);
//                    if(p < 0) {
//                        p = p+2 * ((float) b2/a2) * (2*x + 3);
//                    } else {
//                        p = p - 4*y + 2*((float) b2/a2) * (2*x + 3);
//                        y--;
//                    }
//                    x++;
//                }
//                p = (int) Math.round(b2 * (x + 0.5) * (x + 0.5) + a2 * (y - 1) * (y - 1) - a2 * b2);
//                //
//                y=0;
//                if(eclipB > eclipA && eclipB/eclipA > 4) x = eclipA + 4;
//                else if(eclipA > eclipB && eclipA/eclipB > 4) x = eclipA + 4;
//                else x = eclipA;
//
//                p = 2 * ((float) a2/b2) - 2*eclipA + 1;
//                while(((float)a2/b2)*y<=x)
//                {
//                    put4Pixel(g2d, x_center, y_center, x, y);
//                    if(p < 0) {
//                        p = p + 2*((float) a2/b2) * (2*y + 3);
//                    } else
//                    {
//                        p = p- 4*x + 2*((float) a2/b2) * (2*y + 3);
//                        x = x - 1;
//                    }
//                    y = y + 1;
//                }
//            }
//
//        };
//        panelDraw.setOpaque(false);
//
////        panelDraw.setBounds(xPanel, yPanel, width*2+1,height*2+1);
//        return panelDraw;
//    }

//    public void drawEclip(Graphics2D g2d) {
//        int x_center = this.center.getX();
//        int y_center = this.center.getY();
//
//        float p, a2, b2;
//        int x = 0, y = eclipB;
//
//        a2 = eclipA*eclipA;
//        b2 = eclipB*eclipB;
//
//        p = 2 * ((float) b2/a2) - (2*eclipB) + 1;
//        while(((float) b2/a2)*x <= y) {
//            put4Pixel(g2d, x_center, y_center, x, y);
//            if(p < 0) {
//                p = p+2 * ((float) b2/a2) * (2*x + 3);
//            } else {
//                p = p - 4*y + 2*((float) b2/a2) * (2*x + 3);
//                y--;
//            }
//            x++;
//        }
//        p = (int) Math.round(b2 * (x + 0.5) * (x + 0.5) + a2 * (y - 1) * (y - 1) - a2 * b2);
//        //
//        y=0;
//        if(eclipB > eclipA && eclipB/eclipA > 4) x = eclipA + 4;
//        else if(eclipA > eclipB && eclipA/eclipB > 4) x = eclipA + 4;
//        else x = eclipA;
//
//        p = 2 * ((float) a2/b2) - (2*eclipA) + 1;
//        while(((float) a2/b2)*y <= x)
//        {
//            put4Pixel(g2d, x_center, y_center, x, y);
//            if(p < 0) {
//                p = p + 2*((float) a2/b2) * (2*y + 3);
//            } else {
//                p = p - 4*x + 2*((float) a2/b2) * (2*y + 3);
//                x = x - 1;
//            }
//            y = y + 1;
//        }
//    }

    public void drawSolidEclip(Graphics2D g2d) {
        int x_center = this.center.getX();
        int y_center = this.center.getY();

        float p, a2, b2;
        int x = 0, y = eclipB;

        a2 = eclipA*eclipA;
        b2 = eclipB*eclipB;

        p = 2 * ((float) b2/a2) - (2*eclipB) + 1;
        while(((float) b2/a2)*x <= y) {
            drawTop(g2d, x_center, y_center, x, y);
            if (p < 0) {
                p = p+2 * ((float) b2/a2) * (2*x + 3);
            } else {
                p = p - 4*y + 2*((float) b2/a2) * (2*x + 3);
                y--;
            }
            x++;
        }

        y = 0; x = eclipA;
        p = 2 * ((float) a2/b2) - (2*eclipA) + 1;
        while(((float) a2/b2)*y <= x)
        {
            drawTop(g2d, x_center, y_center, x, y);
            if (p < 0) {
                p = p + 2*((float) a2/b2) * (2*y + 3);
            } else {
                p = p - 4*x + 2*((float) a2/b2) * (2*y + 3);
                x = x - 1;
            }
            y = y + 1;
        }
    }

    public void drawDashedEclip(Graphics2D g2d) {
        int x_center = this.center.getX();
        int y_center = this.center.getY();

        float p, a2, b2;
        int x = 0, y = eclipB, count = 0;

        a2 = eclipA*eclipA;
        b2 = eclipB*eclipB;

        p = 2 * ((float) b2/a2) - (2*eclipB) + 1;
        while(((float) b2/a2)*x <= y) {
            if (p < 0) {
                p = p+2 * ((float) b2/a2) * (2*x + 3);
            } else {
                p = p - 4*y + 2*((float) b2/a2) * (2*x + 3);
                y--;
            }
            if (x % 10 == 0) {
                count = 0;
            }
            if (count < 5) {
                drawBottom(g2d, x_center, y_center, x, y);
                count++;
            }
            x++;
        }

        y = 0; x = eclipA;
        p = 2 * ((float) a2/b2) - (2*eclipA) + 1;
        while(((float) a2/b2)*y <= x)
        {
            if (p < 0) {
                p = p + 2*((float) a2/b2) * (2*y + 3);
            } else {
                p = p - 4*x + 2*((float) a2/b2) * (2*y + 3);
                x = x - 1;
            }
            if (y % 10 == 0) {
                count = 0;
            }
            if (count < 5) {
                drawBottom(g2d, x_center, y_center, x, y);
                count++;
            }
            y = y + 1;
        }
    }

    // backside
    public void drawDashedEclip2(Graphics2D g2d) {
        int x_center = this.center.getX();
        int y_center = this.center.getY();

        float p, a2, b2;
        int x = 0, y = eclipB, count = 0;

        a2 = eclipA*eclipA;
        b2 = eclipB*eclipB;

        p = 2 * ((float) b2/a2) - (2*eclipB) + 1;
        while(((float) b2/a2)*x <= y) {
            if (p < 0) {
                p = p+2 * ((float) b2/a2) * (2*x + 3);
            } else {
                p = p - 4*y + 2*((float) b2/a2) * (2*x + 3);
                y--;
            }
            if (x % 10 == 0) {
                count = 0;
            }
            if (count < 5) {
                drawBackside(g2d, x_center, y_center, x, y);
                count++;
            }
            x++;
        }

        y = 0; x = eclipA;
        p = 2 * ((float) a2/b2) - (2*eclipA) + 1;
        while(((float) a2/b2)*y <= x)
        {
            if (p < 0) {
                p = p + 2*((float) a2/b2) * (2*y + 3);
            } else {
                p = p - 4*x + 2*((float) a2/b2) * (2*y + 3);
                x = x - 1;
            }
            if (y % 10 == 0) {
                count = 0;
            }
            if (count < 5) {
                drawBackside(g2d, x_center, y_center, x, y);
                count++;
            }
            y = y + 1;
        }
    }

    public void drawSolidEclip2(Graphics2D g2d) {
        int x_center = this.center.getX();
        int y_center = this.center.getY();

        float p, a2, b2;
        int x = 0, y = eclipB;

        a2 = eclipA*eclipA;
        b2 = eclipB*eclipB;

        p = 2 * ((float) b2/a2) - (2*eclipB) + 1;
        while(((float) b2/a2)*x <= y) {
            drawFront(g2d, x_center, y_center, x, y);
            if (p < 0) {
                p = p+2 * ((float) b2/a2) * (2*x + 3);
            } else {
                p = p - 4*y + 2*((float) b2/a2) * (2*x + 3);
                y--;
            }
            x++;
        }

        y = 0; x = eclipA;
        p = 2 * ((float) a2/b2) - (2*eclipA) + 1;
        while(((float) a2/b2)*y <= x)
        {
            drawFront(g2d, x_center, y_center, x, y);
            if (p < 0) {
                p = p + 2*((float) a2/b2) * (2*y + 3);
            } else {
                p = p - 4*x + 2*((float) a2/b2) * (2*y + 3);
                x = x - 1;
            }
            y = y + 1;
        }
    }

//    public void put4Pixel(Graphics2D g, int xc, int yc, int x, int y) {
//        g.drawOval(xc + x, yc + y, 1, 1);
//        g.drawOval(xc - x, yc + y, 1, 1);
//        g.drawOval(xc - x, yc - y, 1, 1);
//        g.drawOval(xc + x, yc - y, 1, 1);
//    }

    public void drawBottom(Graphics2D g, int xc, int yc, int x, int y) {
        g.drawOval(xc - x, yc - y, 1, 1);
        g.drawOval(xc + x, yc - y, 1, 1);
    }

    public void drawTop(Graphics2D g, int xc, int yc, int x, int y) {
        g.drawOval(xc + x, yc + y, 1, 1);
        g.drawOval(xc - x, yc + y, 1, 1);
    }

    public void drawBackside(Graphics2D g, int xc, int yc, int x, int y) {
        g.drawOval(xc + x, yc + y, 1, 1);
        g.drawOval(xc + x, yc - y, 1, 1);
    }

    public void drawFront(Graphics2D g, int xc, int yc, int x, int y) {
        g.drawOval(xc - x, yc + y, 1, 1);
        g.drawOval(xc - x, yc - y, 1, 1);
    }
}
