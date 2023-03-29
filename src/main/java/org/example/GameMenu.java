package org.example;

import java.util.Scanner;

public class GameMenu {
    String p1Name;
    String p2Name;
    Scanner getP1Name;
    Scanner getP2Name;
    Player player1;
    Player player2;

    public void gameSetup(){
        System.out.println("Choose gamemode");
        System.out.println("1.Singleplayer");
        System.out.println("2.Multiplayer");
       /* Scanner gameModeScanner = new Scanner(System.in);
        gameMode = gameModeScanner.nextLine();*/
        UserInput userInput = new UserInput();
        String gameMode = userInput.getGameMode();
        ShipCreator shipCreator = new ShipCreator(userInput);
        Game game = new Game();
        if(gameMode.equals("1")){
            /*Random randomNumber = new Random();
            Random randomLetter = new Random();
            Player computer = new Player();*/
            System.out.println("Player 1 name");
            p1Name = userInput.checkNameCorrection();
            System.out.println("Player 1");
            player1 = new Player(p1Name,shipCreator.createShips());
            System.out.println("Player 2");
            player2 = new Player("Bob",shipCreator.createShips());
            game.startGame(player1,player2);
            /*computer.player2Ships.set();
            return new Game(player1,player2);*/
        }
        else if(gameMode.equals("2")){
            System.out.println("Player 1 name");
            getP1Name = new Scanner(System.in);
            p1Name = getP1Name.nextLine();
            p1Name = userInput.checkNameCorrection();
            System.out.println("Player 1");
            Player player1 = new Player(p1Name,shipCreator.createShips());
            System.out.println("Player 2 name");
            getP2Name = new Scanner(System.in);
            p2Name = getP2Name.nextLine();
            p2Name = userInput.checkNameCorrection();
            System.out.println("Player 2");
            Player player2 = new Player(p1Name,shipCreator.createShips());
            game.startGame(player1,player2);
        }
    }
}
