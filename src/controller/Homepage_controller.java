package controller;

import view.Homepage_view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Homepage_controller {
    private Homepage_view homepage_view;

    public Homepage_controller() {
        this.homepage_view = new Homepage_view();
        homepage_view.addListener(new StartListener());
    }

    class StartListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            int player_nb = 0;
            if (homepage_view.getA2PlayersRadioBtn().isSelected()) {player_nb=2;}
            if (homepage_view.getA3PlayersRadioBtn().isSelected()) {player_nb=3;}
            if (homepage_view.getA4PlayersRadioBtn().isSelected()) {player_nb=4;}
            Board_controller board_controller = new Board_controller(player_nb);
        }
    }
}
