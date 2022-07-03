package com.example.lab4_20960400_villarroelgonzalez;

import javax.swing.*;

public class DobbleUI {
    private JPanel DobbleUiPanel;
    private JTextField Texto1;

    public static void main(String[] args) {
        JFrame frame = new JFrame("DobbleUI");
        frame.setContentPane(new DobbleUI().DobbleUiPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
