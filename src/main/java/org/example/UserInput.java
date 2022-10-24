package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UserInput {
    Scanner scanner;
    public String checkNameCorrection(){
        Scanner getP1Name = scanner;
        String playerInput = getP1Name.nextLine();
        while(playerInput.length() >= 20){
            System.out.println("Name too long");
            playerInput = getP1Name.nextLine();
        }
        return playerInput;
    }
    public List<String> getSubmarinePositions(){
        Scanner submarine = scanner;
        List<String> listOfShips = new ArrayList<>();
        for(int i = 0; i<=1; i++){
            System.out.println("Place position " + i);
            listOfShips.add(getValidShipPosition(submarine));
        }
        return listOfShips;
    }
    public List<String> getBoatPositions(){
        Scanner boat = scanner;
        List<String> listOfShips = new ArrayList<>();
        for(int i = 0; i<=2; i++){
            System.out.println("Place position " + i);
            listOfShips.add(getValidShipPosition(boat));
        }
        return listOfShips;
    }
    public List<String> getDestroyerPositions(){
        Scanner destroyer = scanner;
        List<String> listOfShips = new ArrayList<>();
        for(int i = 0; i<=3; i++){
            System.out.println("Place position " + i);
            listOfShips.add(getValidShipPosition(destroyer));
        }
        return listOfShips;
    }
    public List<String> getCarrierPositions(){
        Scanner carrier = scanner;
        List<String> listOfShips = new ArrayList<>();
        for(int i = 0; i<=4; i++){
            System.out.println("Place position " + i);
            listOfShips.add(getValidShipPosition(carrier));
        }
        return listOfShips;
    }
    public List<String> getCargoShipPositions(){
        Scanner cargoShipPosition = scanner;
        List<String> listOfShips = new ArrayList<>();
        for(int i = 0; i<=5; i++){
            System.out.println("Place position " + i);
            listOfShips.add(getValidShipPosition(cargoShipPosition));
        }
        return listOfShips;
    }
    public String getValidShipPosition (Scanner shipScanner){
        String shipPosition = shipScanner.nextLine();
        char letter = shipPosition.toCharArray()[0];
        char number = shipPosition.toCharArray()[1];
        while(shipPosition.length() == 2){
            System.out.println("Wrong position length");
            shipPosition = shipScanner.nextLine();
        }
        while(letter <= 'a' || letter >= 'i'||number <= '1' || number >= '9'){
            System.out.println("Wrong ship coordinate, place ship with correct pattern (A1)");
            shipPosition = shipScanner.nextLine();
            letter = shipPosition.toCharArray()[0];
            number = shipPosition.toCharArray()[1];

        }
        return shipPosition;
    }
}
