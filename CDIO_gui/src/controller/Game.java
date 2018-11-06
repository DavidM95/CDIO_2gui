package controller;

import gui_fields.GUI_Player;
import gui_main.GUI;
import model.Board;
import model.Die;
import model.Player;
import ui.Graphic;

/**@author Hold 44
 * Defines Game and all its global variables
 */
public class Game {
    private Player[] players;
    Player currPlayer;
    private Graphic graphic;
    private Die d1, d2;                     //Instances of Die
    private Board board;
    private boolean gameOver = false;
    private boolean extraTurn;

    /**
     * Constructor of Game class
     */
    public Game() {
        // initer spillerne
        this.players = new Player[2];
        this.players[0] = new Player("Spiller 1", 1000);
        this.players[1] = new Player("Spiller 2", 1000);
        // initer terningerne
        this.d1 = new Die(1,6);
        this.d2 = new Die(1,6);
        // Sætter nuværende spiller til den første
        this.currPlayer = this.players[0];
        // initer board
        this.board = new Board(11);
        // initer graphic med felterne fra this.board og de oprettede spillere
        this.graphic = new Graphic(this.board.getSquareList(), this.players);

    }

    /**
     * This method rolls two dices and adds score to player
     */
    public void playRound() {
        // Sørger for hele tiden at skifte til den modsatte spiller
        // Når this.currPlayer bliver sat lig this.players[x] kan vi ændre på this.currPlayer og dette vil også ændre værdierne i arrayet
        if (this.players[1].equals(currPlayer))
            this.currPlayer = this.players[0];
        else
            this.currPlayer = this.players[1];

        // Kaster terningerne og gemmer antal øjne rullet til sammen
        d1.rollDie();
        d2.rollDie();
        int totalEye = getCurrentRollScore();

        // Henter den nuværende balance fra currPlayer og tilføjer det nuværende felts værdi ved at kalde getcashInfluenceByIndex
        this.currPlayer.setBalance(this.currPlayer.getBalance() + this.board.getcashInfluenceByDice(totalEye));
        // Sætter spillet til at være ovre.
        if (this.currPlayer.getBalance() <= 0 || currPlayer.getBalance() > 3000)
            this.setGameOver(true);
        // Viser øjnene i GUI'en
        this.graphic.getGUI().setDice(d1.getEyes(), d2.getEyes());
        // Opbygger en besked der sendes til gui'en vha. showMessage metoden
        StringBuilder message = new StringBuilder("Player: " + this.currPlayer.getName() + " rolled " + totalEye);
        message.append("\nCurrent field: " + this.board.getScenarioByDice(totalEye));
        message.append("\nRound score: " + this.board.getcashInfluenceByDice(totalEye));
        message.append("\nTotal score: " + this.currPlayer.getBalance());
        this.graphic.getGUI().showMessage(message.toString());
    }

    /**
     * Add the eyes of the two dices
     *
     * @return  Sum of the two dices
     */
    public int getCurrentRollScore() {
        return d1.getEyes() + d2.getEyes();
    }

    /**
     * Bliver brugt i main i en while for at tjekke om spillet ikke er afsluttet
     * @return
     */
    public boolean isGameOver() {
        return gameOver;
    }

    /**
     * Sætter spillet til at være færdigt
     * @param gameOver
     */
    public void setGameOver(boolean gameOver) {
        this.gameOver = gameOver;
    }
}



