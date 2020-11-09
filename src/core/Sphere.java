package core;

import javax.swing.*;
import java.awt.*;

public class Sphere extends JPanel {
    private Point3D point;
    private int R = 0;
    private int x1, y1, z1;
    public static int subFrameWidth=275, subFrameHight=250, xOBegin=10, yOBegin=25, distance=100, labelSize=25, textSize=75;

    public Sphere(){
        this.point = new Point3D();
        this.R = 0;
    }

    public Sphere(int x1, int y1) {
        this.x1 = x1;
        this.y1 = y1;
    }

    public int getX1() {
        return x1;
    }

    public int getY1() {
        return y1;
    }

    public void setX1(int x1) {
        this.x1 = x1;
    }

    public void setY2(int y1) {
        this.y1 = y1;
    }

    public int getR() {
        return R;
    }

    public void setR(int r) {
        R = r;
    }

    public JFrame createToaDo3D(){
        JFrame frame = new JFrame("SPHERE");
        frame.setSize(subFrameWidth, subFrameHight);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setLayout(null);


        JLabel labelX1,labelY1,labelZ1,labelBanKinhR;

        labelX1=new JLabel("X");
        labelX1.setBounds(10,25,labelSize,25);
        frame.add(labelX1);
        Contants.tfX1=new JTextField();
        Contants.tfX1.setBounds(40,25,textSize,25);
        frame.add(Contants.tfX1);

        labelY1=new JLabel("Y");
        labelY1.setBounds(130,25,labelSize,25);
        frame.add(labelY1);
        Contants.tfY1=new JTextField();
        Contants.tfY1.setBounds(160,25,textSize,25);
        frame.add(Contants.tfY1);

        labelZ1=new JLabel("Z");
        labelZ1.setBounds(10, 75, labelSize, 25);
        frame.add(labelZ1);
        Contants.tfZ1=new JTextField();
        Contants.tfZ1.setBounds(40,75,textSize,25);
        frame.add(Contants.tfZ1);

        labelBanKinhR=new JLabel("R");
        labelBanKinhR.setBounds(10,125,labelSize,25);
        frame.add(labelBanKinhR);
        Contants.tfRadius=new JTextField();
        Contants.tfRadius.setBounds(40,125,textSize,25);
        frame.add(Contants.tfRadius);

        Contants.btnDraw=new JButton("DRAW");
        Contants.btnDraw.setFocusPainted(false);     	// xoa duong vien tren button khi click
        Contants.btnDraw.setBackground(Color.white);	//background cho button
        Contants.btnDraw.setContentAreaFilled(false);
        Contants.btnDraw.setOpaque(true);
        Contants.btnDraw.setBounds(40,175,textSize,30);
        frame.add(Contants.btnDraw);

        Contants.btnClear=new JButton("CLEAR");
        Contants.btnClear.setFocusPainted(false);
        Contants.btnClear.setBackground(Color.white);
        Contants.btnClear.setContentAreaFilled(false);
        Contants.btnClear.setOpaque(true);
        Contants.btnClear.setBounds(160,175,textSize,30);
        frame.add(Contants.btnClear);
        frame.setResizable(false);
        frame.setVisible(true);
        return frame;
    }

//    @Override
//    public void paint(Graphics g) {
//        super.paint(g);
//    }

    public void draw(JPanel panel) {
        Graphics g = panel.getGraphics();
        Graphics2D g2D = (Graphics2D) g.create();

        double b = point.getZ() * Math.sqrt(2.0)/2;

        x1 = (int) (-b + Contants.X_DEVIATION);
        z1 = (int) (b + Contants.Y_DEVIATION + Contants.PANEL_DEVIATION);

        x1 = x1 + point.getX();
        z1 = z1 - point.getY();
        R = getR();

        Bang2D circle = new Bang2D();
        circle.HinhTron(g2D, x1, z1, R);

        Eclip eclip = new Eclip();
        eclip.center.setX(x1);
        eclip.center.setY(z1);
        eclip.setEclipA(R);
        eclip.setEclipB(R/2);

        // draw horizontal eclip
        eclip.drawDashedEclip(g2D);
        eclip.drawSolidEclip(g2D);

        // draw vertical eclip
        int temp = eclip.getEclipA();
        eclip.setEclipA(eclip.getEclipB());
        eclip.setEclipB(temp);
        eclip.drawDashedEclip2(g2D);
        eclip.drawSolidEclip2(g2D);

        Font font = new Font("Verdana", Font.BOLD, 14);
        g.setFont(font);
        g.clearRect(Contants.backgroundWidth + 135, 80, 120, 100);

        g.drawString(".I", x1, z1);
        g.drawString("I", Contants.backgroundWidth + 65, 90);
        g.drawString("( " + point.getX()/5 + ", " + point.getY()/5 + ", " + point.getZ()/5 + " )", Contants.backgroundWidth + 125, 90);
    }

    public void processTextField(){
        String text = Contants.tfX1.getText();

        if (text.equals("")) {
            Contants.tfX1.requestFocus();
        } else {
            point.setX(Integer.parseInt(text) * 5);

            text = Contants.tfY1.getText();
            if(text.equals("")) {
                Contants.tfY1.requestFocus();
            } else {
                point.setY(Integer.parseInt(text) * 5);

                text = Contants.tfZ1.getText();
                if (text.equals("")){
                    Contants.tfZ1.requestFocus();
                } else {
                    point.setZ(Integer.parseInt(text) * 5);

                    text = Contants.tfRadius.getText();
                    if (text.equals("")){
                        Contants.tfRadius.requestFocus();
                    } else {
                        setR(Math.abs(Integer.parseInt(text)) * 5);
                    }
                }
            }
        }
    }

    public void clear(){
        Contants.tfX1.setText("");
        Contants.tfX1.requestFocus();
        Contants.tfY1.setText("");
        Contants.tfZ1.setText("");
        Contants.tfRadius.setText("");
    }
}
