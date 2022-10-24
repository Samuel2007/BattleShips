package org.example;

import java.util.Scanner;

public class GameMenu {
    String gameMode;
    String p1Name;
    String p2Name;
    Scanner getP1Name;
    Scanner getP2Name;
    Player player1;
    Player player2;
    public Player getPlayer1(){
        return player1;
    }
    public Player getPlayer2(){
        return player2;
    }

    public void gameSetup(){
        System.out.println("Choose gamemode");
        System.out.println("1.Singleplayer");
        System.out.println("2.Multiplayer");
        Scanner gameModeScanner = new Scanner(System.in);
        gameMode = gameModeScanner.nextLine();
        ShipCreator shipCreator = new ShipCreator();
        UserInput checkName = new UserInput();
        Game game = new Game();
        if(gameMode.equals("1")){
            System.out.println("Player 1 name");
            p1Name = checkName.checkNameCorrection();
            player1 = new Player(p1Name,shipCreator.createShips());
            player2 = new Player("Bob",shipCreator.createShips());
            game.startGame(player1,player2);
        }
        else if(gameMode.equals("2")){
            System.out.println("Player 1 name");
            getP1Name = new Scanner(System.in);
            p1Name = getP1Name.nextLine();
            Player player1 = new Player(p1Name,shipCreator.createShips());
            System.out.println("Player 2 name");
            getP2Name = new Scanner(System.in);
            p2Name = getP2Name.nextLine();
            Player player2 = new Player(p1Name,shipCreator.createShips());
            game.startGame(player1,player2);
        }
        else{
            System.out.println("That's not a game mode");
            gameSetup();
        }
    }
}
