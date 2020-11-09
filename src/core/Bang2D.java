package core;

import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.Random;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;

public class Bang2D extends JFrame {

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    private JPanel MainPanel;
    private JLabel SunLabel;
	private JLabel CloudLabel;
	private JLabel Vehicle;
	private JLabel Vehicle_Des1;
	private JLabel Vehicle_Des2;
	private JLabel Vehicle_Des3;
	private JLabel Vehicle_Des4;
	private JLabel Vehicle_Des5;
    /**
     * Launch the application.
     */
//    public static void main(String[] args) {
//        EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                try {
//                    Bang2D frame = new Bang2D();
//                    frame.setVisible(true);
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }
//            }
//        });
//    }

    /**
     * Create the frame.
     */
    public Bang2D() {
        initComponents();

    }
    public void DuongThang(Graphics2D g2d, int x1, int y1, int x2, int y2)
    {
        int dx = Math.abs(x2 - x1);
        int dy = Math.abs(y2 - y1);
        int x = x1;
        int y = y1;
        int P = ((2*dy) - dx);
        g2d.setStroke(new BasicStroke(2));
        g2d.drawOval(x, y, 1, 1);
        while (x <= x2) {
            x++;
            if (P < 0) {
                P += 2*dy;
            }
            else if (P >= 0) {
                P += 2*(dy - dx);
                y++;
            }
            g2d.drawOval(x, y, 1, 1);
        }
    }
    void DDA_Line(Graphics2D g2d, int x1, int y1, int x2, int y2, int K)
    {
        int Dx = x2 - x1;
        int Dy = y2 - y1;
        int x = x1;
        int y = y1;
        float m = Dy/Dx;

        g2d.drawOval(x, y, 1, 1);
        int temp = 0;
        while(x <= x2)
        {
            x++;
            y = Math.round(m + y);
            if (K == 1) {
                temp = x % 6;
                if (temp == 1 || temp == 2 || temp == 3 ) g2d.drawOval(x, y, 1, 1);
            }
            else g2d.drawOval(x, y, 1, 1);
        }
    }
    public void HinhCN(Graphics2D g2d, int x, int y, int width, int height) {
        int x2 = x + width;
        int y2 = y + height;
        for (int i = x; i <= x2; i++) {
            g2d.drawOval(i, y, 1, 1);
            g2d.drawOval(i, y2, 1, 1);
        }
        for (int i = y; i <= y2; i++) {
            g2d.drawOval(x, i, 1, 1);
            g2d.drawOval(x2, i, 1, 1);
        }
    }
    public void HinhTron(Graphics2D g, int x, int y, int R) {
        int x1 = 0;
        int y1 = R;
        int P = (5/4) - R;

        put8Pixel(g, x, y, x1, y1);
        while(x1 < y1) {
            if (P < 0) {
                P += 2*x1 + 3;
            } else {
                P += 2*x1 - 2*y1 + 5;
                y1--;
            }
            x1 += 1;
            put8Pixel(g, x, y, x1, y1);
        }
    }

    public void put8Pixel(Graphics2D g2d, int xc, int yc, int a, int b) {
        g2d.drawOval(xc + a, yc + b, 1, 1);
        g2d.drawOval(xc - a, yc + b, 1, 1);
        g2d.drawOval(xc - a, yc - b, 1, 1);
        g2d.drawOval(xc + a, yc - b, 1, 1);

        g2d.drawOval(xc + b, yc + a, 1, 1);
        g2d.drawOval(xc - b, yc + a, 1, 1);
        g2d.drawOval(xc - b, yc - a, 1, 1);
        g2d.drawOval(xc + b, yc - a, 1, 1);
    }
    
    void Ve4diem(Graphics2D g2d, int xc, int yc, int x, int y, int i) {
		g2d.drawOval(xc + x, yc + y, 1, 1);
		g2d.drawOval(xc - x, yc + y, 1, 1);
		g2d.drawOval(xc - x, yc - y, 1, 1);
		g2d.drawOval(xc + x, yc - y, 1, 1);		
	}

	void Elipse(Graphics2D g2d, int x_center, int y_center, int a, int b) {
		float p, a2, b2;
		int x, y;
		a2 = (float) Math.pow(a, 2);
		b2 = (float) Math.pow(b, 2);
		x = 0;
		y = b;

		p = 2 * ((float) b2 / a2) - (2 * b) + 1;

		int i = 1;
		while (((float) b2 / a2) * x <= y) {
			Ve4diem(g2d, x_center, y_center, x, y, i);
			if (p < 0) {
				p = p + 2 * ((float) b2 / a2) * (2 * x + 3);
			} else {
				p = p - 4 * y + 2 * ((float) b2 / a2) * (2 * x + 3);
				y--;
			}
			x++;
			i++;
		}

		i = 1;
		y = 0;
		x = a;
		p = 2 * ((float) a2 / b2) - 2 * a + 1;
		while (((float) a2 / b2) * y <= x) {
			Ve4diem(g2d, x_center, y_center, x, y, i);
			if (p < 0) {
				p = p + 2 * ((float) a2 / b2) * (2 * y + 3);
			} else {
				p = p - 4 * x + 2 * ((float) a2 / b2) * (2 * y + 3);
				x--;
			}
			y++;
			i++;
		}
	}
    //g2d.setColor(new Color(102,51,0));
    public void Tree(Graphics2D g2d, int x, int height, int width, int R, int k) {
        if (k == 0) {
            g2d.setStroke(new BasicStroke(2));
            g2d.setColor(new Color(102,51,0));

            int y= 197-height;
            width = Math.round(width/2);
            for (int i = x-width; i <= x+width;i++) {
                for (int j = 197; j >= y; j--) g2d.drawOval(i, j, 1, 1);
            }
            g2d.setStroke(new BasicStroke(1));
            g2d.setColor(new Color(51,204,51));
            //g2d.setColor(Color.black);
            int locate_y1 = y - Math.round(R/2);
            int locate_y2 = y + Math.round(R/2);
            HinhTron(g2d, x-R,locate_y2,R);
            HinhTron(g2d, x+R,locate_y2,R);


            g2d.setStroke(new BasicStroke(2));
            g2d.setColor(new Color(51,153,0));
            for (int i = 1; i <= R-2; i++) {
                HinhTron(g2d, x,locate_y1,i);
                HinhTron(g2d, x-R,locate_y2,i);
                HinhTron(g2d, x+R,locate_y2,i);
            }

            g2d.setStroke(new BasicStroke(1));
            g2d.setColor(new Color(51,204,51));
            //g2d.setColor(Color.black);
            HinhTron(g2d, x,locate_y1,R);
        }
        else {
            g2d.setStroke(new BasicStroke(2));
            g2d.setColor(new Color(102,51,0));

            int y= 197-height;
            width = Math.round(width/2);
            for (int i = x-width; i <= x+width;i++) {
                for (int j = 197; j >= y; j--) g2d.drawOval(i, j, 1, 1);
            }
            g2d.setStroke(new BasicStroke(1));
            g2d.setColor(new Color(0,102,0));          
            int locate_y1 = y - Math.round(R/2);
            int locate_y2 = y + Math.round(R/2);
            HinhTron(g2d, x-R,locate_y2,R);
            HinhTron(g2d, x+R,locate_y2,R);

            g2d.setStroke(new BasicStroke(2));
            g2d.setColor(new Color(0,51,0));
            for (int i = 1; i <= R-2; i++) {
                HinhTron(g2d, x,locate_y1,i);
                HinhTron(g2d, x-R,locate_y2,i);
                HinhTron(g2d, x+R,locate_y2,i);
            }

            g2d.setStroke(new BasicStroke(1));
            g2d.setColor(new Color(0,102,0));
            //g2d.setColor(Color.black);
            HinhTron(g2d, x,locate_y1,R);
        }
    }
    public void Side(Graphics2D g2d,int k) {


        Tree(g2d,100,70,30,37,k);

        Tree(g2d,500,68,35,34,k);

        Tree(g2d,900,97,37,34,k);
           
        Tree(g2d,1300,68,35,34,k);
    }
    public void CuaSoXe(Graphics2D g2d, int x, int y) {
        x += 10;
        for (int i = x; i < x+100;i++) {
            g2d.drawOval(i, y-10, 1, 1);
        }
        for (int i = y-10; i < y+72;i++) {
            g2d.drawOval(x, i, 1, 1);
        }
        for (int i = x; i < x+140;i++) {
            g2d.drawOval(i, y+72, 1, 1);
        }

        DDA_Line(g2d, x+100, y-10, x + 140, y + 70,0);
    }
    public void DauXe1(Graphics2D g2d, int x, int y) {
        int x1 = x + 450;
        int y1 = y + 300;
        y = y + 70;

        g2d.setStroke(new BasicStroke(2));
        g2d.setColor(new Color(0, 51, 102));
        CuaSoXe(g2d,x1+20,y+30);
        for (int i = x1; i < x1+150;i++) {
            g2d.drawOval(i, y, 1, 1);
        }
        x1 += 150;
        DDA_Line(g2d, x1, y, x1 + 50, y + 100,0);
        x1 += 52;
        y += 103;
        DuongThang(g2d, x1, y, x1 + 78, y + 48);
        x1 +=80;
        y += 50;
        for (int i= y; i<=y1; i++)
            g2d.drawOval(x1, i, 1, 1);
        for (int i= x+450; i<=x1; i++)
            g2d.drawOval(i, y1, 1, 1);
    }
    public void Xe1(Graphics g, int x, int y)
    {
        g = MainPanel.getGraphics();
        Graphics2D g2d = (Graphics2D) g.create();
        g2d.setStroke(new BasicStroke(2));
        g2d.setColor(new Color(0, 204, 102));
        HinhCN(g2d,x,y,450,300);

        DauXe1(g2d,x,y);
        //Tire
        g2d.setColor(Color.white);
        DuongThang(g2d,x+60,y+300,x+180,y+300);

        g2d.setColor(Color.white);
        DuongThang(g2d,x+502,y+300,x+618,y+300);

        g2d.setColor(new Color(0, 0, 51));
        HinhTron(g2d,x+120,y+290,60);
        HinhTron(g2d,x+120,y+290,43);
        HinhTron(g2d,x+560,y+290,60);
        HinhTron(g2d,x+560,y+290,43);

        // Bubble
        Random generator = new Random();
        g2d.setColor(new Color(12, 147, 151));
        HinhCN(g2d,x-17,y+280,17,10);

        g2d.setColor(Color.darkGray);
        for (int i = 1; i <= (generator.nextInt(12)+1); i++)
            HinhTron(g2d,x-30,y+260,i);

        for (int i = 1; i <= (generator.nextInt(12)+1); i++)
            HinhTron(g2d,x-23,y+247,i);

        for (int i = 1; i <= (generator.nextInt(12)+1); i++)
            HinhTron(g2d,x-34,y+278,i);

        for (int i = 1; i <= (generator.nextInt(12)+1); i++)
            HinhTron(g2d,x-37,y+240,i);
    }
    public void Xe2(Graphics g, int x, int y, int k) {
        g = MainPanel.getGraphics();
        Graphics2D g2d = (Graphics2D) g.create();
        g2d.setStroke(new BasicStroke(2));
        g2d.setColor(new Color(102, 255, 102));
        for (int i = x; i <= x + 480; i++)
            g2d.drawOval(i, y+300, 1, 1);
        for (int i = y + 300; i >= y + 220; i--)
            g2d.drawOval(x, i, 1, 1);
        for (int i = x; i <= x + 115; i++)
            g2d.drawOval(i, y+220, 1, 1);
        DDA_Line(g2d, x+115, y+ 220, x+210, y+100,0);
        for (int i = x+213; i <= x + 430; i++)
            g2d.drawOval(i, y+123, 1, 1);
        DDA_Line(g2d, x+430, y+123, x+478, y+250,0);
        HinhCN(g2d,x+480,y+200,50,120);

        //Window Font
        g2d.drawLine(x+145, y+220 ,x+220, y + 140);
        for (int i = x+220; i <= x + 300; i++)
            g2d.drawOval(i, y+140, 1, 1);
        for (int i = x+145; i <= x + 300; i++)
            g2d.drawOval(i, y+220, 1, 1);
        for (int i = y+140; i <= y + 220; i++)
            g2d.drawOval(x+300, i, 1, 1);

        //Window Back
        DDA_Line(g2d, x+415, y+140, x+454, y+220,0);
        for (int i = x+320; i <= x + 415; i++)
            g2d.drawOval(i, y+140, 1, 1);
        for (int i = x+320; i <= x + 453; i++)
            g2d.drawOval(i, y+220, 1, 1);
        for (int i = y+140; i <= y + 220; i++)
            g2d.drawOval(x+320, i, 1, 1);
        for (int i = y+123; i <= y + 300; i++)
            g2d.drawOval(x+310, i, 1, 1);

        //Tire
        g2d.setColor(Color.black);
        DuongThang(g2d,x+60,y+300,x+160,y+300);
        DuongThang(g2d,x+350,y+300,x+450,y+300);

        g2d.setColor(new Color(0, 255, 153));

        HinhTron(g2d,x+110,y+300,50);
        HinhTron(g2d,x+110,y+300,40);

        HinhTron(g2d,x+400,y+300,50);
        HinhTron(g2d,x+400,y+300,40);

        g2d.setColor(new Color(255, 0, 51));
        if (k % 2 == 0) {
            //Font tire
            for (int i = y+260; i <= y+340; i++)
                g2d.drawOval(x+110, i, 1, 1);
            DuongThang(g2d,x+70,y+300,x+149,y+300);
            //Back Tire
            for (int i = y+260; i <= y+340; i++)
                g2d.drawOval(x+400, i, 1, 1);
            DuongThang(g2d,x+360,y+300,x+440,y+300);
        }
        else {
            DDA_Line(g2d,x+82,y+272,x+137,y+327,0);
            DDA_Line(g2d,x+82,y+327,x+137,y+272,0);
            DDA_Line(g2d,x+372,y+272,x+427,y+327,0);
            DDA_Line(g2d,x+372,y+327,x+427,y+272,0);
        }
        // Bubble
        Random generator = new Random();
        g2d.setStroke(new BasicStroke(2));
        for (int i =0; i < 10; i++) {
            g2d.setColor(new Color(generator.nextInt(255),generator.nextInt(255),generator.nextInt(255)));
            HinhTron(g2d,x + 540 + generator.nextInt(120), y+260 - generator.nextInt(150),generator.nextInt(20)+1);
        }
    }
    public void Cloud(Graphics2D g2d) {
    	g2d.setStroke(new BasicStroke(2));
    	//g2d.setColor(new Color(0, 102, 153));
    	g2d.setColor(Color.WHITE);
        for (int i = 0; i< 30; i++) {
        	Elipse(g2d,170,80,50-i,30-i);
        }
        for (int i = 0; i< 30; i++) {
        	Elipse(g2d,250,80,50-i,30-i);        	
        }
        for (int i = 0; i< 30; i++) {
        	Elipse(g2d,330,80,50-i,30-i);       	
        }       
        for (int i = 0; i< 30; i++) {
        	Elipse(g2d,1170,80,50-i,30-i);       	
        }
        for (int i = 0; i< 30; i++) {
        	Elipse(g2d,1250,80,50-i,30-i);        
        }
        for (int i = 0; i< 30; i++) {
        	Elipse(g2d,1330,80,50-i,30-i);
        }
        //CloudLabel.setText("Cloud: (250,80)");
    }
    public void Sky(Graphics2D g2d, int x, int y, int size) {
        g2d.setStroke(new BasicStroke(3));
        
        for (int i = 1; i <= size; i++)
            HinhTron(g2d, x,y,i);
    }
    
    public static final int x= 100;
    public static final int y = 100;
    private void initComponents() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(10, 10, 1500, 800);
        MainPanel = new JPanel();
        MainPanel.setBackground(Color.DARK_GRAY);
        MainPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(MainPanel);
        MainPanel.setSize(1500, 800);
        MainPanel.setLayout(null);
        JPanel XePanel = new JPanel();
        XePanel.setBackground(Color.WHITE);
        XePanel.setBounds(0, 355, 1496, 355);
        
        JPanel SideWalkPanel = new JPanel();
        SideWalkPanel.setBackground(new Color(0, 153, 255));
        SideWalkPanel.setBounds(0, 158, 1496, 197);
        JPanel SkyPanel = new JPanel();
        SkyPanel.setBackground(new Color(153, 255, 255));
        SkyPanel.setBounds(0, 0, 1496, 162);
        JButton Run_Button = new JButton("Run");
        
//        Location2D location2D = new Location2D();
//        location2D.setVisible(true);
//        location2D.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
//        
//        SunLabel = new JLabel("Sun:");
//        SunLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
//        SunLabel.setBounds(1000, 165, 150, 14);
//		MainPanel.add(SunLabel);
//		System.out.println(1);
//		CloudLabel = new JLabel("Cloud:");
//		CloudLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
//		CloudLabel.setBounds(1000, 179, 150, 14);
//		MainPanel.add(CloudLabel);
//		
//		Vehicle = new JLabel("Truck:");
//		Vehicle.setFont(new Font("Tahoma", Font.PLAIN, 14));
//		Vehicle.setBounds(1000, 193, 150, 14);
//		MainPanel.add(Vehicle);
//		
//		Vehicle_Des1 = new JLabel("Head:");
//		Vehicle_Des1.setFont(new Font("Tahoma", Font.PLAIN, 14));
//		Vehicle_Des1.setBounds(1050, 207, 150, 14);
//		MainPanel.add(Vehicle_Des1);
//		
//		Vehicle_Des2 = new JLabel("Boot:");
//		Vehicle_Des2.setFont(new Font("Tahoma", Font.PLAIN, 14));
//		Vehicle_Des2.setBounds(1050, 221, 150, 14);
//		MainPanel.add(Vehicle_Des2);	
//		
//		
//		Vehicle_Des3 = new JLabel("Window:");
//		Vehicle_Des3.setFont(new Font("Tahoma", Font.PLAIN, 14));
//		Vehicle_Des3.setBounds(1050, 235, 150, 14);
//		MainPanel.add(Vehicle_Des3);
//		
//		JLabel Vehicle_Des4 = new JLabel("Font Wheel:");
//		Vehicle_Des4.setFont(new Font("Tahoma", Font.PLAIN, 14));
//		Vehicle_Des4.setBounds(1050, 249, 150, 19);
//		MainPanel.add(Vehicle_Des4);
//		
//		JLabel Vehicle_Des5 = new JLabel("Back Wheel:");
//		Vehicle_Des5.setFont(new Font("Tahoma", Font.PLAIN, 14));
//		Vehicle_Des5.setBounds(1050, 263, 150, 19);
//		MainPanel.add(Vehicle_Des5);
//        
        
        Run_Button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Graphics g = SkyPanel.getGraphics();
                Graphics2D g2d = (Graphics2D) g.create();

                Graphics g2 = SideWalkPanel.getGraphics();
                Graphics2D g2d2 = (Graphics2D) g2.create();
                int x1 = -700;
                int y1 = 357;
                Cloud(g2d);
                g2d.setColor(Color.ORANGE);
                Sky(g2d,750,100,100);
                
                Side(g2d2,0);
                //Tree(g2d2,550,50,20,20,0);
                //location2D.conection.Sun(750, 100);
                //location2D.conection.Truck(x1, y1);
                Graphics g1 = XePanel.getGraphics();
                Graphics2D g2d1 = (Graphics2D) g1.create();



                Graphics g3 = MainPanel.getGraphics();
                Graphics2D g2d3 = (Graphics2D) g3.create();
                int count = 0;
                int sizeb1, sizeb2, sizeb3, sizeb4;
                Random generator = new Random();
                
                //Xe1(g2d3,550,357,sizeb1,sizeb2,sizeb3,sizeb4,1);
                //Xe1(g2d3,550,357,sizeb1,sizeb2,sizeb3,sizeb4,2);
                
                while(x1 <= XePanel.getWidth()+67) {

                    try {
                    	//location2D.conection.Truck(x1, y1);
                        XePanel.update(g1);
                        Xe1(g1,x1,y1);
                        
                        x1 += 50;
                        Thread.sleep(450);
                    } catch (InterruptedException e1) {
                        // TODO Auto-generated catch block
                        e1.printStackTrace();
                    }
                }
                int y_sun = 100;
                int size = 100;
                int x_moon = SkyPanel.getWidth() - 50;
                int size_moon = 50;
                for (int i = 0; i <= 6; i++) {
                    try {
                        SkyPanel.update(g);
                        if (i <= 2) {
                            Sky(g2d,750,y_sun,size+10);
                            y_sun += 50;
                        }
                        else if (i > 2 && i < 5) {
                            Sky(g2d,750,y_sun,size+10);
                            y_sun += 50;
                            g2d.setColor(Color.LIGHT_GRAY);
                            Sky(g2d,x_moon,100,size_moon);
                            x_moon -= 200;
                            size_moon += 5;
                            g2d.setColor(Color.ORANGE);
                        }
                        else if (i == 5) {
                            SkyPanel.setBackground(Color.DARK_GRAY);
                            XePanel.setBackground(Color.DARK_GRAY);
                            SideWalkPanel.setBackground(new Color(0, 51, 102));

                            //MainPanel.update(g3);
                            SkyPanel.update(g);
                            XePanel.update(g1);
                            SideWalkPanel.update(g2);
                            //Tree(g2d2,550,50,20,20,1);
                            Side(g2d2,1);
                            g2d.setColor(Color.LIGHT_GRAY);
                            Sky(g2d,x_moon,80,60);

                        }
                        Thread.sleep(450);
                    } catch (InterruptedException e1) {
                        // TODO Auto-generated catch block
                        e1.printStackTrace();
                    }
                }

                int x2 = 1500;
                int y2 = 357;
                g2d.setColor(Color.LIGHT_GRAY);
                SkyPanel.setBackground(Color.BLACK);
                //SideWalkPanel.setBackground(new Color(0, 51, 102));
                XePanel.setBackground(Color.BLACK);

                SkyPanel.update(g);
                XePanel.update(g1);
                //SideWalkPanel.update(g2);
                //Tree(g2d2,550,50,20,20,1);
                Sky(g2d,750,80,60);

                while (x2 >= -660) {
                    try {
                        count++;
                        Xe2(g1,x2,y2,count);
                        x2 -= 50;
                        Thread.sleep(450);
                        XePanel.update(g1);
                    } catch (InterruptedException e1) {
                        // TODO Auto-generated catch block
                        e1.printStackTrace();
                    }
                }
                	
            }
        });
        Run_Button.setBounds(718, 715, 170, 45);
        MainPanel.add(Run_Button);


        MainPanel.add(XePanel);


        MainPanel.add(SideWalkPanel);


        MainPanel.add(SkyPanel);

    }
}
