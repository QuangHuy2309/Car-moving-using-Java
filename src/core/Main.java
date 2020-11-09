package core;

import core.TrucToaDo3D;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main extends JFrame {
    private JPanel contentPane;
    static Main frame = new Main();

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    frame.setSize(400, 300);
                    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    frame.setResizable(false);

                    frame.setLocationRelativeTo(null);
                    frame.setLayout(null);
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public Main(){
        contentPane = new JPanel();
        contentPane.setBounds(0, 0, 400, 300);
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        
        JButton btn2D = new JButton("2D");
        btn2D.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
//                frame.setVisible(false);
                Bang2D program2D = new Bang2D();
                program2D.setVisible(true);
                program2D.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
                
            }
        });
        //btn2D.setForeground(Color.black);
        //btn2D.setForeground(new Color(135, 120, 235));
        btn2D.setBorderPainted(false);
		btn2D.setForeground(new Color(255, 204, 0));
		btn2D.setBackground(new Color(255, 102, 102));
        btn2D.setFont(new Font("Tahoma", Font.BOLD, 14));
        btn2D.setBounds(160, 80, 96, 21);
        contentPane.add(btn2D);

        JButton btn3D = new JButton("3D");
        btn3D.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
//                frame.setVisible(false);
                TrucToaDo3D trucToaDo3D = new TrucToaDo3D();
                trucToaDo3D.setSize(1370, 750);
//                trucToaDo3D.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                trucToaDo3D.setResizable(false);
                trucToaDo3D.add(trucToaDo3D.createPanel3D());
                trucToaDo3D.setVisible(true);
            }
        });
        //btn3D.setForeground(Color.black);
        //btn3D.setForeground(new Color(135, 120, 235));
        btn3D.setBorderPainted(false);
		btn3D.setForeground(new Color(0, 204, 0));
		btn3D.setBackground(new Color(204, 255, 0));
        btn3D.setFont(new Font("Tahoma", Font.BOLD, 14));
        btn3D.setBounds(160, 120, 96, 21);
        contentPane.add(btn3D);
        
        JLabel Groupname = new JLabel("Nhóm 4");
        Groupname.setFont(new Font("Tahoma", Font.BOLD, 25));
        Groupname.setForeground(new Color(255, 102, 0));
        Groupname.setBounds(5, 10, 100, 21);
        contentPane.add(Groupname);
        
        JLabel Name1 = new JLabel("Lê Phước Anh Đạt    -     N17DCCN033");
        Name1.setBounds(30, 170, 250, 21);
        contentPane.add(Name1);
        JLabel Name2 = new JLabel("Ngô Quang Hòa        -     N17DCCN051");
        Name2.setBounds(30, 190, 250, 21);
        contentPane.add(Name2);
        JLabel Name3 = new JLabel("Lương Quang Huy   -     N17DCCN057");
        Name3.setBounds(30, 210, 250, 21);
        contentPane.add(Name3);
        JLabel Name4 = new JLabel("Đỗ Vạn Thành           -     N15DCCN185");
        Name4.setBounds(30, 230, 250, 21);
        contentPane.add(Name4);
        
        
        /*JLabel Id1 = new JLabel("-   N17DCCN033");
        Name1.setBounds(200, 120, 150, 21);
        contentPane.add(Id1);
        JLabel Id2 = new JLabel("-   N17DCCN051");
        Name2.setBounds(200, 190, 150, 21);
        contentPane.add(Id2);
        JLabel Id3 = new JLabel("-   N17DCCN057");
        Name3.setBounds(200, 210, 150, 21);
        contentPane.add(Id3);
        JLabel Id4 = new JLabel("-   N15DCCN185");
        Name4.setBounds(200, 230, 150, 21);
        contentPane.add(Id4);*/
    }
}
