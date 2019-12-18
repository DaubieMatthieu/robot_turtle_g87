package view;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Homepage_view extends JFrame {
    private JButton start_btn;
    private JButton quit_btn;
    private JRadioButton a2PlayersRadioBtn;
    private JRadioButton a3PlayersRadioBtn;
    private JRadioButton a4PlayersRadioBtn;
    private JPanel homepage_panel;
    private JFormattedTextField title;

    public Homepage_view() {
        JFrame frame = new JFrame("Homepage");
        frame.setContentPane(homepage_panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        frame.setSize(600,300);
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
