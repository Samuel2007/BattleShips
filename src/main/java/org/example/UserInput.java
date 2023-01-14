package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UserInput {
    Scanner scanner = new Scanner(System.in);
    public String checkNameCorrection(){
        String playerInput = scanner.nextLine();
        while(playerInput.length() >= 20){
            System.out.println("Name too long");
            playerInput = scanner.nextLine();
        }
        return playerInput;
    }
    public List<String> getValidShipPositionFromPositionRange(List<String> listOfAllShipsPositions, int shipLength) {
        //TODO: test
        String[] shipPositionRange = scanner.nextLine().toLowerCase().split("-");
        return checkShipPosition(shipPositionRange,listOfAllShipsPositions,shipLength);
    }
    public List<String> checkShipPosition(String[] positionsRange,List<String> listOfAllShipsPositions,int shipLength){
        List<String> listOfShipPositions = new ArrayList<>();
        do{
            for (String shipPosition : positionsRange) {
                if(shipLength == 1){
                    while(shipPosition.length() != 2){
                        System.out.println("Change ship position(correct pattern \"A1-A2\")1");
                        shipPosition = scanner.nextLine().toLowerCase();
                    }
                }
                else{
                    while(positionsRange.length != 2) {
                        System.out.println("Change ship position(correct pattern \"A1-A2\")2");
                        positionsRange = scanner.nextLine().toLowerCase().split("-");
                    }
                }
                char letter = shipPosition.toLowerCase().toCharArray()[0];
                char number = shipPosition.toCharArray()[1];
                while ((letter < 'a' || letter > 'i') || (number < '1' || number > '9')
                        || !checkIfPositionAvailable(listOfShipPositions, listOfAllShipsPositions)) {
                    System.out.println("Change ship position(correct pattern \"A1-A2\")3");
                    shipPosition = scanner.nextLine().toLowerCase();
                    /*while(positionsRange.length != 2){
                            System.out.println("Change ship position(correct pattern \"A1-A2\")4");
                            positionsRange = scanner.nextLine().toLowerCase().split("-");
                        }*/
                    letter = shipPosition.toLowerCase().toCharArray()[0];
                    number = shipPosition.toCharArray()[1];
                }
                if(shipLength == 1){
                    listOfShipPositions.add(shipPosition);
                    listOfAllShipsPositions.add(shipPosition);
                }
                else{
                    listOfShipPositions.add(getPositionsFromPositionRange(positionsRange,shipLength,listOfAllShipsPositions).toString());
                    listOfAllShipsPositions.add(getPositionsFromPositionRange(positionsRange,shipLength,listOfAllShipsPositions).toString());
                }
            }
        }while(listOfShipPositions.size() != shipLength);
        return listOfShipPositions;
    }
    public String getValidShipPosition(String input){
        if(input.length() != 2){
            System.out.println("Wrong length");
            input = scanner.nextLine();
        }
        char letter = input.toUpperCase().toCharArray()[0];
        int number = input.toCharArray()[1];
        while((letter < 'a' || letter > 'i') || (number < '1' || number > '9')){
            System.out.println("Change ship position(correct pattern \"A1\")");
            input = scanner.nextLine();
            letter = input.toUpperCase().toCharArray()[0];
            number = input.toCharArray()[1];
        }
        return input;
    }
    private List<String> getPositionsFromPositionRange(String[] shipPositionRange, int shipLength, List<String> listOfAllShipsPositions) {
        List<String> shipPositionsList = new ArrayList<>();
        while(shipPositionRange.length != 2){
            System.out.println("Change ship position(correct pattern \"A1-A2\")5");
            shipPositionRange = scanner.nextLine().toLowerCase().split("-");
        }
        String starPosition = shipPositionRange[0];
        String endPosition = shipPositionRange[1];
        char startPositionLetter = starPosition.charAt(0);
        char startPositionNumber = starPosition.charAt(1);
        char endPositionLetter = endPosition.charAt(0);
        char endPositionNumber = endPosition.charAt(1);
        if(startPositionLetter == endPositionLetter){
            for(char x = startPositionNumber; x <= endPositionNumber; x++){
                shipPositionsList.add("" + startPositionLetter + x);
                /*if(shipLength == 2){
                    return shipPositionsList;
                }
                else if(shipPositionsList.size() != shipLength){
                    System.out.println("Wrong ship length");
                    getValidShipPosition(listOfAllShipsPositions,shipLength);
                }*/
            }
        }
        else{
            for(char x = startPositionLetter; x <= endPositionLetter; x++){
                shipPositionsList.add("" + startPositionNumber + x);
            }
            /*if(shipLength == 2){
                return shipPositionsList;

            }
            else if(shipPositionsList.size() != shipLength){
                System.out.println("Wrong ship length");
                getValidShipPosition(listOfAllShipsPositions,shipLength);
            }*/
        }
        return shipPositionsList;
    }

    public boolean checkIfPositionAvailable(List<String> ListOfShipPositions, List<String> listOfAllShipsPositions){
        for(String shipPosition:ListOfShipPositions){
            for(String allShipPositions:listOfAllShipsPositions){
                if(shipPosition.equals(allShipPositions)){
                    System.out.println("You already placed a ship there");
                    System.out.println("These are your positions " + String.join(",",listOfAllShipsPositions).toUpperCase());
                    return false;
                }
            }
        }
        return true;
    }
    /*public boolean checkShipPlacementCorrection(List<String> listOfShipPositions, String shipPosition){
        /*char listOfShipPositionsLetter = Arrays.toString(listOfShipPositions.toArray()).toLowerCase().toCharArray()[0];
        int listOfShipPositionsNumber = Arrays.toString(listOfShipPositions.toArray()).toCharArray()[1];
        char shipPositionLetter = shipPosition.toLowerCase().toCharArray()[0];
        int shipPositionNumber = shipPosition.toCharArray()[1];
        if(shipPositionNumber == (listOfShipPositionsNumber+1) || shipPositionNumber == (listOfShipPositionsNumber-1)
                || shipPositionLetter == (listOfShipPositionsLetter+1) || shipPositionLetter == (listOfShipPositionsLetter-1)){
            return true;
        }
        return true;
    }*/

    public String getGameMode() {
        String gameMode = scanner.nextLine();
        while(!"1".equals(gameMode) && !"2".equals(gameMode)){
            System.out.println("That's not a game mode");
            gameMode = scanner.nextLine();
        }
        return gameMode;
    }
    /*public List<String> getSubmarinePosition(List<String> listOfAllShipsPositions,int shipLength){

        return
    }*/
}
