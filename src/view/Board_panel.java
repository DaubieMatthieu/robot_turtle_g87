package view;

import java.awt.*;

import javax.swing.*;

public class Board_panel extends JPanel {
    private Background_panel board_grid_panel;
    private JButton box_01;
    private JButton box_02;
    private JButton box_03;
    private JButton box_04;
    private JButton box_05;
    private JButton box_06;
    private JButton box_07;
    private JButton box_08;
    private JButton box_09;
    private JButton box_10;
    private JButton box_11;
    private JButton box_12;
    private JButton box_13;
    private JButton box_14;
    private JButton box_15;
    private JButton box_16;
    private JButton box_17;
    private JButton box_18;
    private JButton box_19;
    private JButton box_20;
    private JButton box_21;
    private JButton box_22;
    private JButton box_23;
    private JButton box_24;
    private JButton box_25;
    private JButton box_26;
    private JButton box_27;
    private JButton box_28;
    private JButton box_29;
    private JButton box_30;
    private JButton box_31;
    private JButton box_32;
    private JButton box_33;
    private JButton box_34;
    private JButton box_35;
    private JButton box_36;
    private JButton box_37;
    private JButton box_38;
    private JButton box_39;
    private JButton box_40;
    private JButton box_41;
    private JButton box_42;
    private JButton box_43;
    private JButton box_44;
    private JButton box_45;
    private JButton box_46;
    private JButton box_47;
    private JButton box_48;
    private JButton box_49;
    private JButton box_50;
    private JButton box_51;
    private JButton box_52;
    private JButton box_53;
    private JButton box_54;
    private JButton box_55;
    private JButton box_56;
    private JButton box_57;
    private JButton box_58;
    private JButton box_59;
    private JButton box_60;
    private JButton box_61;
    private JButton box_62;
    private JButton box_63;
    private JButton box_64;

    Board_panel() {
        this.setLayout(new BorderLayout());
        this.add(board_grid_panel, BorderLayout.CENTER);
        this.board_grid_panel.setBackgroundImage("res/images/board.png");
        board_grid_panel.setOpaque(false);
        board_grid_panel.setEnabled(true);
        Component[] components = board_grid_panel.getComponents();
        for (Component component : components) {
            ((JButton) component).setContentAreaFilled(false);
        }
    }

    public Background_panel getBoard_grid_panel() {
        return board_grid_panel;
    }
}


//box_grid[l][c].addActionListener(new TileListener());