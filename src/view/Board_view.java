package view;

import model.Piece;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class Board_view extends JFrame {
    private ArrayList<Piece> piece_list;
    private JPanel board_panel;
    private JLabel board_image;
    private JFormattedTextField current_player;
    private JButton action3Button;
    private JButton action2Button;
    private JButton action1Button;
    private JPanel player_action_panel;
    private JPanel player_pannel;

    public Board_view(ArrayList<Piece> piece_list) {
        this.piece_list = piece_list;
        JFrame frame = new JFrame("Game Board");
        frame.setContentPane(board_panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        frame.setSize(600,300);
        frame.setLocationRelativeTo(null);
        JFrame.setDefaultLookAndFeelDecorated(true);
        frame.setExtendedState(Frame.MAXIMIZED_BOTH);
    }

    public void setPiece_list(ArrayList<Piece> piece_list) {
        this.piece_list = piece_list;
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }
}
