package core;

import javax.swing.*;

public class Contants {
    public static int backgroundWidth = 1100;
    public static int backgroundHeight = 650;

    public static JTextField tfX1, tfY1, tfZ1, tfLength, tfWidth, tfHeight, tfRadius;
    public static JButton btnDraw, btnClear;

    // This deviation is calculated from the coordinates 0 of the Panel (not the coordinates 0 of the console screen)
    public final static int X_DEVIATION = 500;
    public final static int Y_DEVIATION = 325;

    // the deviation of the console
    public final static int PANEL_DEVIATION = 50;
}
