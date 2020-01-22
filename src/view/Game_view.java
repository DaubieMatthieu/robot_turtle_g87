package view;

import model.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Game_view extends JFrame {
    private JPanel game_panel;
    private Board_panel board_panel;

    private JPanel player_action_panel;
    private JFormattedTextField current_player;
    private JPanel actions_panel;
    private JButton complete_program_btn;
    private JButton construct_wall_btn;
    private JButton execute_program_btn;
    private JButton discard_cards_btn;
    private JButton end_turn_btn;

    private JPanel card_hand_panel;
    private JFormattedTextField card_title;
    private JPanel cards_panel;
    private JButton card_1_btn;
    private JButton card_2_btn;
    private JButton card_3_btn;
    private JButton card_4_btn;
    private JButton card_5_btn;

    private JPanel wall_hand_pannel;
    private JFormattedTextField walls_title;
    private JPanel walls_panel;
    private JButton wall_1_btn;
    private JButton wall_2_btn;
    private JButton wall_3_btn;
    private JButton wall_4_btn;
    private JButton wall_5_btn;

    public Game_view(ArrayList<Piece> piece_list) {
        JFrame main_frame = new JFrame("Game Board");
        main_frame.setContentPane(this.game_panel);
        main_frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        main_frame.pack();
        main_frame.setVisible(true);
        main_frame.setExtendedState(Frame.MAXIMIZED_BOTH);
        board_panel.setPreferredSize(new Dimension(main_frame.getHeight(),main_frame.getHeight()));
        board_panel.setLayout(new BorderLayout());
        board_panel.add(board_panel.getBoard_grid_panel(), BorderLayout.CENTER);
        repaint();
    }


    public void addListener(Component btn, String actionCommand, ActionListener actionListener) {
        ((JButton)btn).addActionListener(actionListener);
        ((JButton)btn).setActionCommand(actionCommand);
    }

    public void setMain_frame() {
    }

    public void display_piece(Piece piece) {
        Position position = piece.getPosition();
        Character orientation = piece.getOrientation();
        int c = position.getX();
        int l = position.getY();
        JButton button = getButtons(board_panel.getBoard_grid_panel()).get(8*l+c);
        String filepath = "res/images/pieces/";
        String sub_class = "";
        String attribute = "";
        if (piece instanceof Turtle_piece)  {
            sub_class = "turtle";
            attribute = ((Turtle_piece) piece).getColor();
        }
        if (piece instanceof Jewel_piece) {
            sub_class = "jewel";
            attribute = ((Jewel_piece) piece).getColor();
        }
        if (piece instanceof Wall_piece) {
            sub_class = "wall";
            attribute = ((Wall_piece) piece).getWall_type();
        }
        filepath+=sub_class+"s/"+attribute+"_"+sub_class+"_"+orientation+".png";
        Icon icon = new StretchIcon(filepath);
        button.setIcon(icon);
        button.setDisabledIcon(icon);
    }

    public void hide_piece(Piece piece) {
        Position position = piece.getPosition();
        int c = position.getX();
        int l = position.getY();
        JButton button = getButtons(board_panel.getBoard_grid_panel()).get(8*l+c);
        button.setIcon(null);
        button.setDisabledIcon(null);
    }

    public void display_color_cards(ArrayList<Color_card> color_card_list) {
        ArrayList<JButton> buttons = getButtons(cards_panel);
        for (int i=0; i<5; i++) {
            display_color_card(color_card_list.get(i), buttons.get(i));
        }
    }

    public void display_color_card(Color_card color_card, JButton button) {
        String color=color_card.getColor();
        String filepath = "res/images/error_icon.png";
        switch (color) {
            case "blue":
                filepath = "res/images/cards/blue_card.png";
                break;
            case "yellow":
                filepath = "res/images/cards/yellow_card.png";
                break;
            case "purple":
                filepath = "res/images/cards/purple_card.png";
                break;
            case "laser":
                filepath = "res/images/cards/laser_card.png";
                break;
        }
        Icon icon = new ImageIcon(filepath);
        button.setIcon(icon);
        button.setDisabledIcon(icon);
    }

    public void display_wall_cards(ArrayList<Wall_card> wall_card_list) {
        ArrayList<JButton> buttons = getButtons(walls_panel);
        int wall_card_nb = wall_card_list.size();
        for (int i=0; i<5; i++) {
            if (i<wall_card_nb) {display_wall_card(wall_card_list.get(i), buttons.get(i));} else {buttons.get(i).setIcon(null);}
        }
    }

    public void display_wall_card(Wall_card wall_card, JButton button) {
        String wall_type=wall_card.getWall_type();
        String filepath = "res/images/error_icon.png";
        switch (wall_type) {
            case "stone":
                filepath = "res/images/pieces/walls/stone_wall_N.png";
                break;
            case "ice":
                filepath = "res/images/pieces/walls/ice_wall_N.png";
                break;
        }
        Icon icon = new ImageIcon(filepath);
        button.setIcon(icon);
        button.setDisabledIcon(icon);
    }

    public ArrayList<JButton> getButtons(JPanel jpanel) {
        Component[] components = jpanel.getComponents();
        ArrayList<JButton> buttons = new ArrayList<>();
        for (Component component:components) {
            if (component instanceof JButton) {buttons.add((JButton) component);}
        }
        return buttons;
    }

    public JButton getBoard_button(Position position) {
        ArrayList<JButton> buttons = getButtons(board_panel.getBoard_grid_panel());
        return buttons.get(8*position.getY()+position.getX());
    }

    public void disable_buttons_panel(JPanel jPanel) {
        ArrayList<JButton> buttons = getButtons(jPanel);
        for (JButton jButton:buttons) {
            jButton.setEnabled(false);
        }
    }

    public void enable_buttons_panel(JPanel jPanel) {
        ArrayList<JButton> buttons = getButtons(jPanel);
        for (JButton jButton:buttons) {
            if (jButton.getIcon()!=null) jButton.setEnabled(true);
        }
    }

    public void enable_free_board_buttons(Board board) {
        ArrayList<Piece> pieces_list = board.getPieces_list();
        for (int l=0; l<8; l++) {
            for (int c=0; c<8; c++) {
                Position position = new Position(c,l);
                if (board.position_is_free(position)) {
                    getBoard_button(position).setEnabled(true);
                }
            }
        }
    }

    public void hide_board_button() {
        for (Component component:getBoard_panel().getBoard_grid_panel().getComponents()) {
            ((JButton)component).setIcon(null);
        }
    }

    public JPanel getCards_panel() {
        return cards_panel;
    }

    public JPanel getWalls_panel() {
        return walls_panel;
    }

    public JPanel getCard_hand_panel() {
        return card_hand_panel;
    }

    public JPanel getWall_hand_pannel() {
        return wall_hand_pannel;
    }

    public JPanel getActions_panel() {
        return actions_panel;
    }

    public JButton getExecute_program_btn() {
        return execute_program_btn;
    }

    public JButton getConstruct_wall_btn() {
        return construct_wall_btn;
    }

    public JButton getComplete_program_btn() {
        return complete_program_btn;
    }

    public JButton getDiscard_cards_btn() {
        return discard_cards_btn;
    }

    public JButton getEnd_turn_btn() {
        return end_turn_btn;
    }

    public Board_panel getBoard_panel() {
        return board_panel;
    }

    public JFormattedTextField getCurrent_player() {
        return current_player;
    }

    public void close() {
        this.dispose();
    }
}
