package com.ishan;

import javax.swing.*;

public class Main {

    public static void main(String[] args) {
        notMSPaint();
    }

    public static void notMSPaint(){
        JFrame frame = new JFrame("This is not MS Paint");
        frame.setSize(600, 512);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(new PaintPanel());
        frame.setVisible(true);
    }
}
