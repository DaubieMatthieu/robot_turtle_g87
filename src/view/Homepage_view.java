package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Homepage_view extends JFrame {
    private JButton start_btn;
    private JButton quit_btn;
    private JRadioButton a2PlayersRadioBtn;
    private JRadioButton a3PlayersRadioBtn;
    private JRadioButton a4PlayersRadioBtn;
    private Background_panel homepage_panel;
    private JFormattedTextField title;

    public Homepage_view() {
        JFrame frame = new JFrame("Homepage");
        homepage_panel.setBackgroundImage("res/images/background.png");
        frame.setContentPane(homepage_panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        double screen_height = Toolkit.getDefaultToolkit().getScreenSize().getHeight();
        double screen_ratio=0.6;
        double image_ratio=(double)620/802;
        frame.setSize((int)(screen_height*screen_ratio*image_ratio),(int)(screen_height*screen_ratio));
        frame.setLocationRelativeTo(null);

        quit_btn.addActionListener((ActionEvent e) -> System.exit(0));
    }

    public void test() {
        System.out.println("test");
    }

    public void addListener(ActionListener listenForStartButton){
        start_btn.addActionListener(listenForStartButton);
    }

    public JRadioButton getA2PlayersRadioBtn() {
        return a2PlayersRadioBtn;
    }

    public JRadioButton getA3PlayersRadioBtn() {
        return a3PlayersRadioBtn;
    }

    public JRadioButton getA4PlayersRadioBtn() {
        return a4PlayersRadioBtn;
    }

}


