package model;

public class Main {
    public static void main(String[] args) {
        get_random_board();
    }

    public static void get_random_board() {
        Game_model game = new Game_model(3);
        //génère une partie de 3 joueurs
        //le plateau est accessible avec game.getBoard()
        //La classe model.Board a pour seul attribut une ArrayList "piece_list" contenant toutes les pièces présentes sur le plateau
        //On peut récupérer la position de ces pièces avec [nom_de_la_piece].getPosition() qui renvoie un array du type {x,y}
        //il ne reste plus qu'à afficher la bonne image au bon endroit
        //ça jsp faire je vous laisse regarder
    }
}
