package controller;

import model.Game_model;
import view.Board_view;

public class Board_controller {
    private Game_model model;
    private Board_view view;
    private Boolean is_over;

    public Board_controller(int nb_joueur) {
        this.model= new Game_model(nb_joueur);
        this.view=new Board_view(this.model.getBoard().getPiece_list());
        this.is_over=false;
    }
}
