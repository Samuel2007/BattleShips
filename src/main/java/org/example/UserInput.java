package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class UserInput {
    Scanner scanner = new Scanner(System.in);

    public String checkNameCorrection() {
        String playerInput = scanner.nextLine();
        while (playerInput.length() >= 20) {
            System.out.println("Name too long");
            playerInput = scanner.nextLine();
        }
        return playerInput;
    }

    public List<String> getShipPositions(List<String> listOfAllShipsPositions, int shipLength) {
        //TODO: discus double input asking problem, create main game
        List<String> listOfShipPositions;
        int repeat = 0;
        if(shipLength == 1){
            String shipPosition = getValidShipPosition();
            List<String> shipPositionAsList = new ArrayList<>(Arrays.asList(shipPosition.split(",")));
            listOfAllShipsPositions.add(shipPosition);
            return shipPositionAsList;
        }
        do{
            if(repeat != 0){
                System.out.println("Wrong length");
            }
            listOfShipPositions = getValidListOfShipPositions(getValidPositionRange(), listOfAllShipsPositions);
            repeat = repeat+1;
        } while (listOfShipPositions.size() != shipLength);
        listOfAllShipsPositions.addAll(listOfShipPositions);
        return listOfShipPositions;
    }
    public String getValidShipPosition() {
        char[] input = scanner.nextLine().toLowerCase().toCharArray();
        while(  input.length != 2 ||
                (input[0] < 'a' || input[0] > 'i') ||
                (input[1] < '1' || input[1] > '9')){
            System.out.println("Wrong coordinates,correct pattern \"A1\"(a-i and from 1-9)");
            input = scanner.nextLine().toLowerCase().toCharArray();
        }
        /*String inputWithNoSpaces = input.strip();
        while (inputWithNoSpaces.length() != 2) {
            System.out.println("Wrong length(correct pattern \"A1\")");
            inputWithNoSpaces = scanner.nextLine();
        }
        char letter = inputWithNoSpaces.toLowerCase().toCharArray()[0];
        char number = inputWithNoSpaces.toCharArray()[1];
        while ((letter < 'a' || letter > 'i') || (number < '1' || number > '9') || inputWithNoSpaces.length() != 2) {
            System.out.println("Change ship position(correct pattern \"A1\")");
            inputWithNoSpaces = scanner.nextLine();
            letter = inputWithNoSpaces.toUpperCase().toCharArray()[0];
            number = inputWithNoSpaces.toCharArray()[1];
        }*/
        return String.valueOf(input);
    }

    private String[] getValidPositionRange(){
        String[] shipPositionRange;
        char[] shipPositionRangeAsCharArray = scanner.nextLine().toLowerCase().replaceAll("\\s","").toCharArray();
        while(( shipPositionRangeAsCharArray.length != 5 ||
                shipPositionRangeAsCharArray[0] < 'a' || shipPositionRangeAsCharArray[0] > 'i') ||
                (shipPositionRangeAsCharArray[1] < '1' || shipPositionRangeAsCharArray[1] > '9') ||
                shipPositionRangeAsCharArray[2] != '-' ||
                (shipPositionRangeAsCharArray[3] < 'a' || shipPositionRangeAsCharArray[3] > 'i') ||
                (shipPositionRangeAsCharArray[4] < '1' || shipPositionRangeAsCharArray[4] > '9') ){
            System.out.println("Change ship position,correct pattern \"A1-A2\"(a-i and 1-9)");
            shipPositionRangeAsCharArray = scanner.nextLine().toLowerCase().replaceAll("\\s","").toCharArray();
        }
        shipPositionRange = String.valueOf(shipPositionRangeAsCharArray).split("-");
        return shipPositionRange;
    }
    private List<String> getValidListOfShipPositions(String[] shipPositionRange, List<String> listOfAllShipsPositions){
        List<String> listOfShipPositions = getPositionsFromPositionRange(shipPositionRange);
        while (!checkIfPositionsAvailable(listOfShipPositions, listOfAllShipsPositions)) {
            System.out.println("You've already placed a ship there");
            shipPositionRange = getValidPositionRange();
            listOfShipPositions = getPositionsFromPositionRange(shipPositionRange);
        }
        return listOfShipPositions;
    }

    private List<String> getPositionsFromPositionRange(String[] shipPositionRange) {
        List<String> shipPositionsList = new ArrayList<>();
        while (shipPositionRange.length != 2) {
            System.out.println("Change ship position,correct pattern \"A1-A2\"(a-i and 1-9)");
            shipPositionRange = scanner.nextLine().toLowerCase().split("-");
        }
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

    public boolean checkIfPositionsAvailable(List<String> listOfShipPositions, List<String> listOfAllShipsPositions) {
        boolean isAvailable = false;
        for(String shipPositionInAllShipsPositions: listOfAllShipsPositions){
            if (!listOfShipPositions.contains(shipPositionInAllShipsPositions)) {
                isAvailable = true;
                break;
            }
        }
        return isAvailable;
    }
    /*public boolean isShipPositionRangeValid(String[] input) {
        for(String shipPosition: input){
            while(shipPosition.length() != 2) {
                System.out.println("Wrong length");
                shipPosition = scanner.nextLine();
            }
            char letter = shipPosition.toLowerCase().toCharArray()[0];
            char number = shipPosition.toCharArray()[1];
            while ((letter < 'a' || letter > 'i') || (number < '1' || number > '9')) {
                System.out.println("Change ship position(correct pattern \"A1\")");
                shipPosition = scanner.nextLine();
                while (shipPosition.length() != 2) {
                    System.out.println("Wrong length");
                    shipPosition = scanner.nextLine();
                }
                letter = shipPosition.toUpperCase().toCharArray()[0];
                number = shipPosition.toCharArray()[1];
            }
            return false;
        }
        return true;
    }
    public boolean checkShipPlacementCorrection(List<String> listOfShipPositions, String shipPosition){
        char listOfShipPositionsLetter = Arrays.toString(listOfShipPositions.toArray()).toLowerCase().toCharArray()[0];
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
        while (!"1".equals(gameMode) && !"2".equals(gameMode)) {
            System.out.println("That's not a game mode");
            gameMode = scanner.nextLine();
        }
        return gameMode;
    }
}
