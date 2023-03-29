package org.example;

import java.util.*;

public class Game {
    boolean gameOn = true;
    public void startGame(Player player1,Player player2){
        String attackedPosition;
        List<Ship> listOfYourShips = player1.playerShips;
        List<Ship> listOfEnemyShips = player2.playerShips;
        List<String> listOfYourShipsHitPositions = new ArrayList<>();
        List<String> listOfEnemyShipsHitPositions = new ArrayList<>();

        List<String> listOfYourShipsPositions = new ArrayList<>(Arrays.asList("a1","b1","b2","c1","c2","c3","d1","d2","d3","d4","e1","e2","e3","e4","e5"));
        /*TODO: remember this line
        for(Ship ship: listOfYourShips){
            listOfYourShipsPositions.addAll(ship.position);
        }*/

        List<String> listOfEnemyShipsPositions = new ArrayList<>(Arrays.asList("a1","b1","b2","c1","c2","c3","d1","d2","d3","d4","e1","e2","e3","e4","e5"));
        /*TODO: remember this line
        for(Ship ship: listOfEnemyShips){
            listOfEnemyShipsPositions.addAll(ship.position);
        }*/
        UserInput userInput = new UserInput();
        while(listOfEnemyShipsHitPositions!=listOfEnemyShipsPositions || listOfYourShipsHitPositions!=listOfYourShipsPositions){
            System.out.println("Which tile to attack, "+player1.playerName+"?");
            attackedPosition = userInput.getValidShipPosition();
            if(listOfEnemyShipsPositions.contains(attackedPosition)){
                System.out.println("You hit!");
                listOfEnemyShipsHitPositions.add(attackedPosition);
            }
            else{
                System.out.println("You missed");
            }
            System.out.println("Which tile to attack, "+player2.playerName+"?");
            attackedPosition = userInput.getValidShipPosition();
            if(listOfYourShipsPositions.contains(attackedPosition)){
                System.out.println("You hit!");
                listOfYourShipsHitPositions.add(attackedPosition);
            }
            else{
                System.out.println("You missed");
            }
        }
        if(listOfEnemyShipsHitPositions==listOfEnemyShipsPositions){
            System.out.println(player1.playerName+"Wins!");
        }
        else if (listOfYourShipsHitPositions==listOfYourShipsPositions) {
            System.out.println(player2.playerName+"Wins!");
        }
        else{
            System.out.println("It's a draw");
        }
    }
}
