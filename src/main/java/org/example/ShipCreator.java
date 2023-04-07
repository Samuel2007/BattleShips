package org.example;

import java.util.*;

public class ShipCreator {
    UserInput userInput;
    List<String> listOfAllShipsPositions = new ArrayList<>();
    List<String> listOfShipsPositions = new ArrayList<>();
    public ShipCreator(UserInput userInput) {
        this.userInput = userInput;
    }
    public ArrayList<Ship> createShips(){
        ArrayList<Ship> playerShips = new ArrayList<>();
        for(ShipTypes shipType: ShipTypes.values()){
            System.out.println("Place your "+ shipType.name().toLowerCase().replace("_"," ")+" ("+shipType.getShipLength()+" positions)");
            Ship ship = new Ship(shipType.getShipLength(), listOfShipsPositions/*userInput.getShipPositions(listOfAllShipsPositions,shipType.getShipLength())*/);
            playerShips.add(ship);
        }
        return playerShips;
    }
    public ArrayList<Ship> createShipsForBot(){
        ArrayList<Ship> botShips = new ArrayList<>();
        for(ShipTypes shipType: ShipTypes.values()){
            Ship ship = new Ship(shipType.getShipLength(),getListOfBotShipPositions(shipType, listOfAllShipsPositions));
            botShips.add(ship);
        }
        return botShips;
    }
    private List<String> getListOfBotShipPositions(ShipTypes shipType, List<String> listOfAllShipsPositions){
        List<String> listOfBotShipPositions = new ArrayList<>();
        String shipPosition;
        Random random = new Random();
        int randomNumber = random.nextInt(9-1+1)+1;
        char randomLetter = (char)(random.nextInt(9)+'a');
        if(shipType.getShipLength() == 1){
            shipPosition = randomLetter + Integer.toString(randomNumber);
            listOfBotShipPositions.add(shipPosition);
        }
        else{
            shipPosition = randomLetter + Integer.toString(randomNumber);
            String endingPosition = randomLetter + Integer.toString(randomNumber+shipType.getShipLength()-1);
            String[] shipPositionRange = new String[]{shipPosition,endingPosition};
            listOfBotShipPositions = getPositionsFromPositionRange(shipPositionRange);
            while(userInput.checkIfPositionsAvailable(listOfBotShipPositions,listOfAllShipsPositions)||endingPosition.length()>=3){
                randomNumber = random.nextInt(9-1+1)+1;
                randomLetter = (char)(random.nextInt(9)+'a');
                shipPosition = randomLetter + Integer.toString(randomNumber);
                endingPosition = randomLetter + Integer.toString(randomNumber+shipType.getShipLength()-1);
                shipPositionRange = new String[]{shipPosition,endingPosition};
                listOfBotShipPositions = getPositionsFromPositionRange(shipPositionRange);
            }
        }
        return listOfBotShipPositions;
    }
    private List<String> getPositionsFromPositionRange(String[] shipPositionRange) {
        List<String> shipPositionsList = new ArrayList<>();
        String starPosition = shipPositionRange[0];
        String endPosition = shipPositionRange[1];
        char startPositionLetter = starPosition.charAt(0);
        char startPositionNumber = starPosition.charAt(1);
        char endPositionLetter = endPosition.charAt(0);
        char endPositionNumber = endPosition.charAt(1);
        if (startPositionLetter == endPositionLetter) {
            for (char x = startPositionNumber; x <= endPositionNumber; x++) {
                shipPositionsList.add("" + startPositionLetter + x);
            }
        } else {
            for (char x = startPositionLetter; x <= endPositionLetter; x++) {
                shipPositionsList.add("" + startPositionNumber + x);
            }
        }
        return shipPositionsList;
    }
}
