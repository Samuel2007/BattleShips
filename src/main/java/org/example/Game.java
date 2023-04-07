package org.example;

import java.util.*;

public class Game {
    boolean gameOn = true;
    public void startGame(Player player1,Player player2){
        List<Ship> listOfYourShips = player1.playerShips;
        List<Ship> listOfEnemyShips = player2.playerShips;
        List<String> listOfYourShipsHitPositions = new ArrayList<>();
        List<String> listOfEnemyShipsHitPositions = new ArrayList<>();

        List<String> listOfYourShipsPositions = new ArrayList<>(/*Arrays.asList("a1","b1","b2","c1","c2","c3","d1","d2","d3","d4","e1","e2","e3","e4","e5")*/);
        for(Ship ship: listOfYourShips){
            listOfYourShipsPositions.addAll(ship.position);
        }

        List<String> listOfEnemyShipsPositions = new ArrayList<>(/*Arrays.asList("a1","b1","b2","c1","c2","c3","d1","d2","d3","d4","e1","e2","e3","e4","e5")*/);
        for(Ship ship: listOfEnemyShips){
            listOfEnemyShipsPositions.addAll(ship.position);
        }
        UserInput userInput = new UserInput();
        while(gameOn){
            attack(player1,userInput,listOfEnemyShipsPositions,listOfEnemyShipsHitPositions);
            attack(player2,userInput,listOfYourShipsPositions,listOfYourShipsHitPositions);
            if(listOfEnemyShipsHitPositions.equals(listOfEnemyShipsPositions) || listOfYourShipsHitPositions.equals(listOfYourShipsPositions)){
                gameOn = false;
            }
        }
        if(listOfEnemyShipsHitPositions.equals(listOfEnemyShipsPositions)){
            System.out.println(player1.playerName+"Wins!");
        }
        else if (listOfYourShipsHitPositions.equals(listOfYourShipsPositions)){
            System.out.println(player2.playerName+"Wins!");
        }
        else{
            System.out.println("It's a draw");
        }
    }
    private void attack(Player player, UserInput userInput, List<String> listOfShipsPositions, List<String> listOfShipsHitPositions){
        System.out.println("Which tile to attack, "+player.playerName+"?");
        String attackedPosition = userInput.getValidShipPosition();
        if(listOfShipsPositions.contains(attackedPosition)){
            System.out.println("You hit!");
            listOfShipsHitPositions.add(attackedPosition);
        }
        else{
            System.out.println("You missed");
        }
    }
}
