package core;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class TrucToaDo3D extends JFrame {
    public enum Choose{Sphere, Cube}
    Choose choose = Choose.Sphere;
    JPanel panel3D = new JPanel();

    public JPanel createPanel3D() {
        panel3D.setLayout(null);
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.fill = GridBagConstraints.HORIZONTAL;

        JButton sphere, cube;
        ImageIcon iconSphere, iconCube;

        iconSphere = new ImageIcon("./src/resources/image/sphere.png");
        sphere = new JButton(iconSphere);
        sphere.setFocusPainted(false);
        sphere.setBackground(Color.WHITE);
        sphere.setContentAreaFilled(false);
        sphere.setOpaque(true);
        sphere.setBounds(10, 10, 50, 30);

        iconCube = new ImageIcon("./src/resources/image/cube.png");
        cube = new JButton(iconCube);
        cube.setFocusPainted(false);
        cube.setBackground(Color.WHITE);
        cube.setContentAreaFilled(false);
        cube.setOpaque(true);
        cube.setBounds(70, 10, 50, 30);

        sphere.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent arg0) {
                // TODO Auto-generated method stub
                choose = Choose.Sphere;
                sphere.setBackground(Color.ORANGE);
                cube.setBackground(Color.WHITE);
            }
        });

        cube.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                choose = Choose.Cube;
                sphere.setBackground(Color.WHITE);
                cube.setBackground(Color.ORANGE);
            }
        });

        panel3D.add(sphere);
        panel3D.add(cube);

        JPanel panelBackground3D = createPanelBackground3D();

        // Add lable "show points coordinate"
        JLabel pointLable = new JLabel("Points");
        JLabel coordinateLable = new JLabel("Coordinate");

        pointLable.setBounds(Contants.backgroundWidth + 55, 50, 100, 30);
        coordinateLable.setBounds(Contants.backgroundWidth + 50 + 100, 50, 100, 30);

        panel3D.add(panelBackground3D);
        panel3D.add(pointLable);
        panel3D.add(coordinateLable);

        return panel3D;
    }

    public JPanel createPanelBackground3D() {
        JPanel background3D = new JPanel() {
            private static final long serialVersionUID = 1L;

            @Override
            protected void paintComponent(Graphics arg0) {
                // TODO Auto-generated method stub
                super.paintComponent(arg0);

                // Y
                arg0.drawLine(Contants.backgroundWidth/2 - 50, 0, core.Contants.backgroundWidth/2 - 50, core.Contants.backgroundHeight/2);
                for(int i = core.Contants.backgroundHeight/2; i<= core.Contants.backgroundHeight; i+=6){
                    arg0.drawLine(core.Contants.backgroundWidth/2 - 50, i, core.Contants.backgroundWidth/2 - 50,i+3);
                }

                // X
                arg0.drawLine(core.Contants.backgroundWidth/2 - 50, core.Contants.backgroundHeight/2, core.Contants.backgroundWidth, core.Contants.backgroundHeight/2);
                for(int i = core.Contants.backgroundWidth/2; i>=0; i-=6){
                    arg0.drawLine(i, core.Contants.backgroundHeight/2,i - 3, core.Contants.backgroundHeight/2);
                }

                // Z
                arg0.drawLine(0, core.Contants.backgroundHeight + 175, core.Contants.backgroundWidth/2 - 50, core.Contants.backgroundHeight/2);
                int l = core.Contants.backgroundHeight/2;
                for(int i = core.Contants.backgroundWidth/2; i < core.Contants.backgroundWidth; i+=5){
                    arg0.drawLine(i - 50, l, i - 47,(int) ((int) l-3));
                    l -= 5;
                }
            }
        };
        background3D.setLayout(null);
        JLabel labelX, labelY, labelZ, labelO, labelMaxX, labelMinX, labelMaxY, labelMinY, labelMaxZ, labelMinZ;

        labelY = new JLabel("Y");
        labelY.setBounds(core.Contants.backgroundWidth/2 - 70, 10,10 , 10);
        background3D.add(labelY);

        labelMaxY = new JLabel("325");
        labelMaxY.setBounds(core.Contants.backgroundWidth/2 - 40, 10,30 , 10);
        background3D.add(labelMaxY);

        labelMinY = new JLabel("-325");
        labelMinY.setBounds(core.Contants.backgroundWidth/2 - 40, core.Contants.backgroundHeight-15, 30, 10);
        background3D.add(labelMinY);

        labelX = new JLabel("X");
        labelX.setBounds(core.Contants.backgroundWidth - 15, core.Contants.backgroundHeight/2-15,10 , 10);
        background3D.add(labelX);

        labelMaxX = new JLabel("500");
        labelMaxX.setBounds(core.Contants.backgroundWidth-30, core.Contants.backgroundHeight/2+15,30 , 10);
        background3D.add(labelMaxX);

        labelMinX = new JLabel("-500");
        labelMinX.setBounds(15, core.Contants.backgroundHeight / 2+15, 30, 10);
        background3D.add(labelMinX);

        labelZ = new JLabel("Z");
        labelZ.setBounds(160, core.Contants.backgroundHeight - 15,10 , 10);
        background3D.add(labelZ);

        labelMaxZ = new JLabel("460");
        labelMaxZ.setBounds(195, core.Contants.backgroundHeight - 15,30 , 10);
        background3D.add(labelMaxZ);

        labelMinZ = new JLabel("-460");
        labelMinZ.setBounds(core.Contants.backgroundWidth/2 + 290, 10, 30, 10);
        background3D.add(labelMinZ);

        labelO = new JLabel("0");
        labelO.setBounds(core.Contants.backgroundWidth/2 - 35, core.Contants.backgroundHeight/2+10,10 , 10);
        background3D.add(labelO);


        background3D.setPreferredSize(new Dimension( 750, 600 ));
        Border blueBoder;
        blueBoder = BorderFactory.createLineBorder(Color.BLUE);
        background3D.setBorder(blueBoder);
        background3D.setBackground(Color.WHITE);
        background3D.setBounds(10, 50, core.Contants.backgroundWidth, core.Contants.backgroundHeight);

        background3D.addMouseListener(new MouseListener() {

            @Override
            public void mouseClicked(MouseEvent arg0) {
                // TODO Auto-generated method stub
                Graphics g = panel3D.getGraphics();

                switch(choose) {
                    case Sphere:
                        Sphere s = new Sphere();
                        s.createToaDo3D();

                        Contants.btnDraw.addActionListener(new ActionListener() {

                            @Override
                            public void actionPerformed(ActionEvent e) {
                                // TODO Auto-generated method stub

                                Contants.btnDraw.setBackground(Color.GRAY);
                                Contants.btnClear.setBackground(Color.WHITE);

                                s.processTextField();
                                s.draw(panel3D);
                            }
                        });


                        Contants.btnClear.addActionListener(new ActionListener() {

                            @Override
                            public void actionPerformed(ActionEvent e) {
                                // TODO Auto-generated method stub

                                Contants.btnDraw.setBackground(Color.WHITE);
                                Contants.btnClear.setBackground(Color.GRAY);

                                s.clear();
                                background3D.revalidate();
                                background3D.repaint();
                                g.clearRect(Contants.backgroundWidth + 50, 80, 250, 500);
                            }
                        });
                        break;
                    case Cube:
                        Cube c = new Cube();
                        c.createToaDo3D();

                        Contants.btnDraw.addActionListener(new ActionListener() {

                            @Override
                            public void actionPerformed(ActionEvent e) {
                                // TODO Auto-generated method stub

                                Contants.btnDraw.setBackground(Color.GRAY);
                                Contants.btnClear.setBackground(Color.WHITE);

                                c.processTextField();
                                c.draw(panel3D);
                            }
                        });


                        Contants.btnClear.addActionListener(new ActionListener() {

                            @Override
                            public void actionPerformed(ActionEvent e) {
                                // TODO Auto-generated method stub

                                Contants.btnDraw.setBackground(Color.WHITE);
                                Contants.btnClear.setBackground(Color.GRAY);

                                c.clear();
                                background3D.revalidate();
                                background3D.repaint();
                                g.clearRect(Contants.backgroundWidth + 50, 80, 230, 500);
                            }
                        });
                        break;
                }
            }

            @Override
            public void mouseEntered(MouseEvent arg0) {
                // TODO Auto-generated method stub

            }

            @Override
            public void mouseExited(MouseEvent arg0) {
                // TODO Auto-generated method stub

            }

            @Override
            public void mousePressed(MouseEvent arg0) {
                // TODO Auto-generated method stub

            }

            @Override
            public void mouseReleased(MouseEvent arg0) {
                // TODO Auto-generated method stub

            }

        });
        return background3D;
    }

//    public JTable createPointsTable() {
//        String[][] points = {{"A", "2",}, {"B", "3"}};
//        String collumn[] = {"Point", "Coordinate"};
//
//        JTable pointTable3D = new JTable(points, collumn);
//        pointTable3D.setBounds(1140, 90, 200, 500);
//
//        return pointTable3D;
//    }
}

