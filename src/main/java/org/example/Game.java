package org.example;

import java.util.*;

public class Game {
    boolean gameOn = true;
    public void startGame(Player player1,Player player2){
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        List<String> listOfYourShipsPositions = new ArrayList<>();
        List<String> listOfEnemyShipsPositions = new ArrayList<>();
        char randomLetter = (char)(random.nextInt('i'-'a')+'a');
        int randomNumber = random.nextInt(9-1)+1;
        String enemyAttackPosition = String.valueOf(randomLetter + randomNumber);

        for(Ship playerShip:player1.playerShips){
            listOfYourShipsPositions.addAll(playerShip.position);
        }
        for(Ship enemyShip:player2.playerShips){
            listOfEnemyShipsPositions.addAll(enemyShip.position);
        }
        while(player1.playerShips.size() > 0 && player2.playerShips.size() > 0 && gameOn) {
            System.out.println("Attack");
            String findShip = scanner.toString();
            if(listOfEnemyShipsPositions.contains(findShip)){
                System.out.println("You Hit");
                listOfEnemyShipsPositions.remove(findShip);
            }
            else{
                System.out.println("You Missed");
            }
            if(listOfYourShipsPositions.contains(enemyAttackPosition)){
                System.out.println("Enemy Hit");
                listOfYourShipsPositions.remove(enemyAttackPosition);
            }
            else{
                System.out.println("Enemy Missed");
            }
        }
        if(player1.playerShips.size() == 0){
            System.out.println("You Lost!");
            System.out.println("Play Again?");
            String playAgain = scanner.toString();
            if(playAgain.equals("yes")){
                GameMenu gameMenu = new GameMenu();
                gameMenu.gameSetup();
            }
            if(playAgain.equals("no")){
                System.exit(0);
            }
        }
        else{
            System.out.println("You Won!");
        }
    }
}
