package core;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;

public class Cube {
    public int x, y, z;
    public int length, width, height;
    public static int subFrameWidth=450, subFrameHight=200, labelSize=55, textSize=75;

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getZ() {
        return z;
    }

    public void setZ(int z) {
        this.z = z;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public JFrame createToaDo3D() {
        JFrame frame = new JFrame("CUBE");
        frame.setSize(subFrameWidth, subFrameHight);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setLayout(null);


        JLabel labelX1, labelY1, labelZ1, labelLength, labelWidth, labelHeight;

        labelX1 = new JLabel("X");
        labelX1.setBounds(20,25,labelSize,25);
        frame.add(labelX1);
        Contants.tfX1 = new JTextField();
        Contants.tfX1.setBounds(60,25,textSize,25);
        frame.add(Contants.tfX1);

        labelY1 = new JLabel("Y");
        labelY1.setBounds(165,25,labelSize,25);
        frame.add(labelY1);
        Contants.tfY1 = new JTextField();
        Contants.tfY1.setBounds(195,25,textSize,25);
        frame.add(Contants.tfY1);

        labelZ1 = new JLabel("Z");
        labelZ1.setBounds(303, 25, labelSize, 25);
        frame.add(labelZ1);
        Contants.tfZ1 = new JTextField();
        Contants.tfZ1.setBounds(335,25,textSize,25);
        frame.add(Contants.tfZ1);

        labelLength = new JLabel("Length");
        labelLength.setBounds(10,75,labelSize,25);
        frame.add(labelLength);
        Contants.tfLength = new JTextField();
        Contants.tfLength.setBounds(60,75,textSize,25);
        frame.add(Contants.tfLength);

        labelWidth = new JLabel("Width");
        labelWidth.setBounds(155,75,labelSize,25);
        frame.add(labelWidth);
        Contants.tfWidth = new JTextField();
        Contants.tfWidth.setBounds(195,75,textSize,25);
        frame.add(Contants.tfWidth);

        labelHeight = new JLabel("Height");
        labelHeight.setBounds(295,75,labelSize,25);
        frame.add(labelHeight);
        Contants.tfHeight = new JTextField();
        Contants.tfHeight.setBounds(335,75,textSize,25);
        frame.add(Contants.tfHeight);

        Contants.btnDraw = new JButton("DRAW");
        Contants.btnDraw.setFocusPainted(false);     	// xoa duong vien tren button khi click
        Contants.btnDraw.setBackground(Color.white);	//background cho button
        Contants.btnDraw.setContentAreaFilled(false);
        Contants.btnDraw.setOpaque(true);
        Contants.btnDraw.setBounds(140,130,textSize,30);
        frame.add(Contants.btnDraw);

        Contants.btnClear = new JButton("CLEAR");
        Contants.btnClear.setFocusPainted(false);
        Contants.btnClear.setBackground(Color.white);
        Contants.btnClear.setContentAreaFilled(false);
        Contants.btnClear.setOpaque(true);
        Contants.btnClear.setBounds(230,130,textSize,30);
        frame.add(Contants.btnClear);
        frame.setResizable(false);
        frame.setVisible(true);
        return frame;
    }

    public void draw(JPanel panel) {
        Graphics g = panel.getGraphics();
        Graphics2D g2D = (Graphics2D) g.create();

        int a = (int) (getWidth() * Math.sqrt(2.0)/2);
        int b = (int) (getZ() * Math.sqrt(2.0)/2);
        int x1, z1, x2, z2, x3, z3, x4, z4, x5, z5, x6, z6, x7, z7,  x8, z8;

        x1 = -b + Contants.X_DEVIATION;
        z1 = b + Contants.Y_DEVIATION + Contants.PANEL_DEVIATION;

        x1 = x1 + getX();
        z1 = z1 - getY();

        x2 = x1 + getLength();
        z2 = z1;

        x3 = x2;
        z3 = z2 - getHeight();

        x4 = x1;
        z4 = z1 - getHeight();

        x5 = x1 - a;
        z5 = z1 + a;

        x6 = x5 + getLength();
        z6 = z5;

        x7 = x6;
        z7 = z6 - getHeight();

        x8 = x5;
        z8 = z5 - getHeight();

        midPointLine(g2D, x1, z1, x2, z2, true);
        midPointLine(g2D, x2, z2, x3, z3, false);
        midPointLine(g2D, x3, z3, x4, z4, false);
        midPointLine(g2D, x4, z4, x1, z1, true);

        midPointLine(g2D, x3, z3, x7, z7, false);
        midPointLine(g2D, x4, z4, x8, z8, false);
        midPointLine(g2D, x2, z2, x6, z6, false);
        midPointLine(g2D, x1, z1, x5, z5, true);

        midPointLine(g2D, x8, z8, x7, z7, false);
        midPointLine(g2D, x7, z7, x6, z6, false);
        midPointLine(g2D, x6, z6, x5, z5, false);
        midPointLine(g2D, x5, z5, x8, z8, false);

        Font font = new Font("Verdana", Font.BOLD, 12);
        g.setFont(font);

        g.drawString("A", x1 + 5, z1 - 4);
        g.drawString("B", x2 + 5, z2 - 4);
        g.drawString("C", x6 - 13, z6 - 3);
        g.drawString("D", x5 - 13, z5 - 4);
        g.drawString("E", x4 + 5, z4 - 4);
        g.drawString("F", x3 + 5, z3 - 4);
        g.drawString("G", x7 - 13, z7 - 4);
        g.drawString("H", x8 - 13, z8 - 4);

        String[][] pointsArray = calcCoordinate();
        String[] points = {"A", "B", "C", "D", "E", "F", "G", "H"};

        // remove old point
        g.clearRect(Contants.backgroundWidth + 135, 80, 100, 500);
        for (int i = 0; i <= 7; i++) {
            g.drawString(points[i], Contants.backgroundWidth + 65, 90 + i * 30);
            g.drawString("( ", Contants.backgroundWidth + 138, 90 + i * 30);
            for (int j = 0; j <= 2; j++) {
                if (j == 2) {
                    g.drawString(pointsArray[i][j] + ")", Contants.backgroundWidth + 160 + j*25, 90 + i * 30);
                } else {
                    g.drawString(pointsArray[i][j] + ", ", Contants.backgroundWidth + 145 + j*35, 90 + i * 30);
                }
            }
        }
    }

    public String[][] calcCoordinate() {
        String[][] pointsArray = new String[8][3];
        int x = getX() / 5;
        int y = getY() / 5;
        int z = getZ() / 5;
        int length = getLength() / 5;
        int width = getWidth() / 5;
        int height = getHeight() / 5;

        // A
        pointsArray[0][0] = Integer.toString(x);
        pointsArray[0][1] = Integer.toString(y);
        pointsArray[0][2] = Integer.toString(z);

        pointsArray[1][0] = Integer.toString(x + length);
        pointsArray[1][1] = Integer.toString(y);
        pointsArray[1][2] = Integer.toString(z);

        pointsArray[2][0] = Integer.toString(x + length);
        pointsArray[2][1] = Integer.toString(y);
        pointsArray[2][2] = Integer.toString(z + width);

        pointsArray[3][0] = Integer.toString(x);
        pointsArray[3][1] = Integer.toString(y);
        pointsArray[3][2] = Integer.toString(z + width);

        pointsArray[4][0] = Integer.toString(x);
        pointsArray[4][1] = Integer.toString(y + height);
        pointsArray[4][2] = Integer.toString(z);

        pointsArray[5][0] = Integer.toString(x + length);
        pointsArray[5][1] = Integer.toString(y + height);
        pointsArray[5][2] = Integer.toString(z);

        pointsArray[6][0] = Integer.toString(x + length);
        pointsArray[6][1] = Integer.toString(y + height);
        pointsArray[6][2] = Integer.toString(z + width);

        pointsArray[7][0] = Integer.toString(x);
        pointsArray[7][1] = Integer.toString(y + height);
        pointsArray[7][2] = Integer.toString(z + width);

        return pointsArray;
    }

    public void midPointLine(Graphics2D g, int x1, int y1, int x2, int y2, boolean dashed) {
        int x, y, dX, dY, p1, p2, fabsdX, fabsdY, xE, yE;
        dX = x2 - x1; // denta x
        dY = y2 - y1; // denta y

        fabsdX = Math.abs(dX);
        fabsdY = Math.abs(dY);

        p1 = 2*fabsdY - fabsdX;
        p2 = 2*fabsdX - fabsdY;

        int xUnit, yUnit;
        float m = ((float)dY) / dX;

        if (m < 0) {
            xUnit = yUnit = -1;
        } else {
            xUnit = yUnit = 1;
        }

        if (fabsdY <= fabsdX) {	// ung voi moi gia tri cua x tinh gia tri y
            if (dX >= 0) {	// diem dau(x1,y1) nam ben trai diem cuoi(x2,y2)
                x = x1;		// gan diem dau la diem nam ben trai(x1,y1)
                y = y1;
                xE = x2;	// diem cuoi la diem nam ben phai(x2,y2)
            } else {			// diem dau nam ben phai diem cuoi
                x = x2;		// gan diem dau la diem nam ban phai
                y = y2;
                xE = x1;
            }
            g.drawOval(x, y, 1, 1);
            for (int temp = x; temp < xE; temp++) {
                if (p1 <= 0) p1 += 2*fabsdY;
                else {
                    y += yUnit;
                    p1 += (2*fabsdY - 2*fabsdX);
                }
                if (dashed && temp%15 < 10);
                else g.drawOval(temp, y, 1, 1);
            }
        } else {
            if (dY >= 0) {
                x = x1;
                y = y1;
                yE = y2;
            } else {
                x = x2;
                y = y2;
                yE = y1;
            }
            g.drawOval(x, y, 1, 1);
            for (int temp = y; temp < yE; temp++) {
                if (p2 <= 0) p2 += 2*fabsdX;
                else {
                    x += xUnit;
                    p2 += (2*fabsdX - 2*fabsdY);
                }
                if (dashed && temp%15 < 10);
                else g.drawOval(x, temp, 1, 1);
            }
        }
    }

    public void processTextField(){
        String text = Contants.tfX1.getText();

        if (text.equals("")){
            Contants.tfX1.requestFocus();
        } else {
            setX(Integer.parseInt(text) * 5);
            text = Contants.tfY1.getText();
            if (text.equals("")){
                Contants.tfY1.requestFocus();
            } else {
                setY(Integer.parseInt(text) * 5);
                text = Contants.tfZ1.getText();
                if (text.equals("")){
                    Contants.tfZ1.requestFocus();
                } else {
                    setZ(Integer.parseInt(text) * 5);
                    text = Contants.tfLength.getText();
                    if (text.equals("")){
                        Contants.tfLength.requestFocus();
                    } else {
                        setLength(Math.abs(Integer.parseInt(text)) * 5);
                        text = Contants.tfWidth.getText();
                        if (text.equals("")) {
                            Contants.tfWidth.requestFocus();
                        } else {
                            setWidth(Math.abs(Integer.parseInt(text)) * 5);
                            text = Contants.tfHeight.getText();
                            if (text.equals("")) {
                                Contants.tfHeight.requestFocus();
                            } else {
                                setHeight(Math.abs(Integer.parseInt(text)) * 5);
                            }
                        }
                    }
                }
            }
        }
    }

    public void clear(){
        Contants.tfX1.requestFocus();
        Contants.tfX1.setText("");
        Contants.tfY1.setText("");
        Contants.tfZ1.setText("");
        Contants.tfLength.setText("");
        Contants.tfWidth.setText("");
        Contants.tfHeight.setText("");
    }
}
