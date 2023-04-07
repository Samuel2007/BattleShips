package org.example;

import java.util.*;

public class Game {
    boolean gameOn = true;
    UserInput userInput = new UserInput();
    Random random = new Random();
    public void startGame(Player player1,Player player2,String gameMode){

        List<Ship> yourShips = player1.playerShips;
        List<Ship> enemyShips = player2.playerShips;
        List<String> yourShipsHit = new ArrayList<>();
        List<String> enemyShipsHit = new ArrayList<>();
        List<String> attackedPositionsByBot = new ArrayList<>();

        List<String> yourShipsPositions = new ArrayList<>(Arrays.asList("a1","b1","b2","c1","c2","c3","d1","d2","d3","d4","e1","e2","e3","e4","e5"));
        for(Ship ship: yourShips){
            yourShipsPositions.addAll(ship.position);
        }
        List<String> enemyShipsPositions = new ArrayList<>(/*Arrays.asList("a1","b1","b2","c1","c2","c3","d1","d2","d3","d4","e1","e2","e3","e4","e5")*/);
        for(Ship ship: enemyShips){
            enemyShipsPositions.addAll(ship.position);
        }

        while(gameOn){
            boolean isGameEnded = enemyShipsHit.equals(enemyShipsPositions) || yourShipsHit.equals(yourShipsPositions);
            if(gameMode.equals("1")){
                playerAttack(player1,enemyShipsPositions,enemyShipsHit);
                botAttack(enemyShipsPositions,enemyShipsHit,attackedPositionsByBot);
                if(isGameEnded){
                    gameOn = false;
                }
            }
            else if(gameMode.equals("2")){
                playerAttack(player1,enemyShipsPositions,enemyShipsHit);
                playerAttack(player2,yourShipsPositions,yourShipsHit);
                if(isGameEnded){
                    gameOn = false;
                }
            }
        }
        if(enemyShipsHit.equals(enemyShipsPositions)){
            System.out.println(player1.playerName+"Wins!");
        }
        else if (yourShipsHit.equals(yourShipsPositions)){
            System.out.println(player2.playerName+"Wins!");
        }
        else{
            System.out.println("It's a draw");
        }
    }
    private void playerAttack(Player player, List<String> shipsPositions, List<String> shipsHitPositions){
        System.out.println("Which tile to attack, "+player.playerName+"?");
        String attackedPosition = userInput.getValidShipPosition();
        if(shipsPositions.contains(attackedPosition)){
            System.out.println("You hit!");
            shipsHitPositions.add(attackedPosition);
        }
        else{
            System.out.println("You missed");
        }
    }
    private void botAttack(List<String> shipsPositions, List<String> shipsHitPositions,List<String> attackedPositionsByBot){
        int randomNumber = random.nextInt(9-1+1)+1;
        char randomLetter = (char)(random.nextInt(9)+'a');
        String shipPosition = randomLetter + Integer.toString(randomNumber);
        while(shipPosition.length()>=3){
            randomNumber = random.nextInt(9-1+1)+1;
            randomLetter = (char)(random.nextInt(9)+'a');
            shipPosition = randomLetter + Integer.toString(randomNumber);
        }
        if(shipsPositions.contains(shipPosition)){
            System.out.println("Bob hit!");
            shipsHitPositions.add(shipPosition);
            attackedPositionsByBot.add(shipPosition);
        }
        else{
            System.out.println("Bob missed");
            attackedPositionsByBot.add(shipPosition);
        }
    }
}
