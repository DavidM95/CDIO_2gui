package ui;

import gui_fields.GUI_Field;
import gui_fields.GUI_Player;
import gui_fields.GUI_Street;
import gui_main.GUI;
import model.Die;
import model.Square;

import java.awt.*;

public class Graphic {

    private GUI gui;
    private GUI_Field[] fields;
    private GUI_Player[] players;

    public Graphic(Square[] squares, GUI_Player[] players) {
        this.setPlayers(players);
        this.setFields(squares);
        this.gui = new GUI(this.fields);
    }

    public void setFields(Square[] squares)
    {
        this.fields = new GUI_Field[squares.length];
        for (int i = 0; i < squares.length; i++)
        {
            Square square = squares[i];
            this.fields[i] = new GUI_Street();
            this.fields[i].setTitle(square.getScenario());
            this.fields[i].setSubText(String.valueOf(square.getCashInfluence()));
            this.fields[i].setBackGroundColor(Color.pink);
        }
    }

    public GUI_Player[] getPlayers() {
        return this.players;
    }

    public void setPlayers(GUI_Player[] inputPlayers)
    {
        this.players = new GUI_Player[inputPlayers.length];
        for (int i = 0; i < inputPlayers.length; i++)
        {
            this.players[i] = inputPlayers[i];
        }
    }

    public void movePlayer(GUI_Player player, int oldPosition, int newPosition)
    {
        this.fields[oldPosition].setCar(player, false);
        this.fields[newPosition].setCar(player, true);
    }
    public GUI getGUI() { return this.gui; }


}
