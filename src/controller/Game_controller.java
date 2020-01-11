package controller;

import model.*;
import view.*;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;

public class Game_controller {
    private Game_model game_model;
    private Game_view game_view;
    private Boolean is_over;
    private int player_nb;
    private int current_player_num;
    private Player current_player;
    private StartListener startListener = new StartListener();

    public Game_controller(int player_nb) {
        this.game_model = new Game_model(player_nb);
        this.game_view =new Game_view(this.game_model.getBoard().getPieces_list());
        this.is_over=false;
        this.player_nb=player_nb;
        this.current_player_num=player_nb-1;
        setListeners();
        display_pieces();
        new_turn();
        game_view.disable_buttons_panel(game_view.getBoard_panel().getBoard_grid_panel());
    }

    public void setListeners() {
        ArrayList<JButton> controls_buttons = new ArrayList<>();
        controls_buttons.addAll(game_view.getButtons(game_view.getActions_panel()));
        controls_buttons.addAll(game_view.getButtons(game_view.getCards_panel()));
        controls_buttons.addAll(game_view.getButtons(game_view.getWalls_panel()));
        int button_nb = controls_buttons.size();
        for (int i=0; i<button_nb; i++) {
            game_view.addListener(controls_buttons.get(i), Integer.toString(i+1) , startListener);
        }
        ArrayList<JButton> board_buttons = game_view.getButtons(game_view.getBoard_panel().getBoard_grid_panel());
        for (int i=0; i<8; i++) {
            for (int j=0; j<8; j++) {
                game_view.addListener(board_buttons.get(i+8*j), i+","+j , startListener);
            }
        }
    }

    public void display_pieces() {
        ArrayList<Piece> pieces_list = game_model.getBoard().getPieces_list();
        for (Piece piece: pieces_list) {game_view.display_piece(piece);}
    }

    class StartListener implements ActionListener {
        private ArrayList<Integer> used_color_cards = new ArrayList<>();
        private Wall_card used_wall_card = null;
        private String color_card_button_action;
        public void actionPerformed(ActionEvent e) {
            int sub=0;
            switch (e.getActionCommand()) {
                case "1":
                    complete_program();
                    break;
                case "2":
                    construct_wall();
                    break;
                case "3":
                    execute_program();
                    break;
                case "4":
                    discard_card();
                    break;
                case "5":
                    end_turn();
                    break;
                case "6":
                case "7":
                case "8":
                case "9":
                case "10":
                    ((JButton)e.getSource()).setIcon(null);
                    ((JButton)e.getSource()).setEnabled(false);
                    int card_nb = Integer.parseInt(e.getActionCommand())-6;
                    used_color_cards.add(card_nb);
                    for (Integer num: used_color_cards) {if (num<card_nb) {sub+=1;}}
                    card_nb-=sub;
                    if (color_card_button_action.equals("complete_program")) {
                        current_player.getProgram().add(current_player.getCard_hand().get(card_nb));
                        if (used_color_cards.size()==1) {
                            game_view.getDiscard_cards_btn().setEnabled(true);
                            game_view.getEnd_turn_btn().setEnabled(true);
                        }
                    }
                    current_player.getCard_hand().remove(card_nb);
                    break;
                case "11":
                case "12":
                case "13":
                case "14":
                case "15":
                    ((JButton)e.getSource()).setIcon(null);
                    ((JButton)e.getSource()).setEnabled(false);
                    int wall_nb = Integer.parseInt(e.getActionCommand())-11;
                    used_wall_card =current_player.getWall_hand().get(wall_nb);
                    current_player.getWall_hand().remove(wall_nb);
                    game_view.getDiscard_cards_btn().setEnabled(true);
                    game_view.disable_buttons_panel(game_view.getWalls_panel());
                    game_view.enable_free_board_buttons(game_model.getBoard());
                    game_view.getEnd_turn_btn().setEnabled(true);
            break;
            default: //c'est un bouton du plateau
                ArrayList<String> position_str = new ArrayList<>(Arrays.asList(e.getActionCommand().split(",")));
                Position position = new Position(Integer.parseInt(position_str.get(0)),Integer.parseInt(position_str.get(1)));
                current_player.play_wall_card(used_wall_card, game_model.getBoard(), position);
                game_view.display_piece(game_model.getBoard().getPiece(position));
                game_view.disable_buttons_panel(game_view.getBoard_panel().getBoard_grid_panel());
                game_view.getConstruct_wall_btn().setEnabled(false);
                game_view.getDiscard_cards_btn().setEnabled(true);
                game_view.getEnd_turn_btn().setEnabled(true);
            }
        }

        public void setUsed_color_cards(ArrayList<Integer> used_color_cards) {
            this.used_color_cards = used_color_cards;
        }

        public void setUsed_wall_card(Wall_card wall_card) {
            this.used_wall_card = wall_card;
        }
    }

    //TODO peut etre laisser la possibilité au joueur de ne rien faire donc activer les boutons de fin de tour dès ceux de début de tout ont été activés

    public void complete_program() {
        game_view.getComplete_program_btn().setEnabled(false);
        game_view.getConstruct_wall_btn().setEnabled(false);
        game_view.getExecute_program_btn().setEnabled(false);
        startListener.color_card_button_action = "complete_program";
        game_view.enable_buttons_panel(game_view.getCards_panel());
    }

    public void construct_wall() {
        game_view.getComplete_program_btn().setEnabled(false);
        game_view.getConstruct_wall_btn().setEnabled(false);
        game_view.getExecute_program_btn().setEnabled(false);
        game_view.enable_buttons_panel(game_view.getWalls_panel());
        //TODO vérifier que le joueur n'entoure pas un joyau/joueur : vérifier règle
    }

    public void execute_program() {
        game_view.getComplete_program_btn().setEnabled(false);
        game_view.getConstruct_wall_btn().setEnabled(false);
        game_view.getExecute_program_btn().setEnabled(false);
        game_view.hide_piece(current_player.getPiece());
        current_player.execute_program(game_model.getBoard());
        game_view.display_piece(current_player.getPiece());
        game_view.getDiscard_cards_btn().setEnabled(true);
        game_view.getEnd_turn_btn().setEnabled(true);
    }

    public void discard_card() {
        game_view.getDiscard_cards_btn().setEnabled(false);
        game_view.enable_buttons_panel(game_view.getCards_panel());
        startListener.color_card_button_action = "discard_card";
    }

    public void end_turn() {
        current_player.refill_hand();
        new_turn();
    }

    public void new_turn() {
        this.current_player_num=(this.current_player_num+1)%this.player_nb;
        this.current_player= game_model.getPlayer_list().get(current_player_num);
        String color=current_player.getColor();
        game_view.getCurrent_player().setText("Joueur "+color);
        game_view.display_color_cards(current_player.getCard_hand());
        game_view.display_wall_cards(current_player.getWall_hand());
        game_view.disable_buttons_panel(game_view.getCards_panel());
        game_view.disable_buttons_panel(game_view.getWalls_panel());
        game_view.getComplete_program_btn().setEnabled(true);
        game_view.getConstruct_wall_btn().setEnabled(true);
        game_view.getExecute_program_btn().setEnabled(true);
        game_view.getDiscard_cards_btn().setEnabled(false);
        game_view.getEnd_turn_btn().setEnabled(false);
        startListener.setUsed_color_cards(new ArrayList<>());
        startListener.setUsed_wall_card(null);
    }
}
