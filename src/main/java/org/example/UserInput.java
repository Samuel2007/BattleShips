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
    public List<String> getSubmarinePositions(){
        Scanner submarine = scanner;
        List<String> listOfShips = new ArrayList<>();
        System.out.println("Place your submarine (1 position)");
        for(int i = 0; i<=0; i++){
            System.out.println("Place position " + (i+1));
            listOfShips.add(getValidShipPosition(submarine));
        }
        return listOfShips;
    }
    public List<String> getBoatPositions(){
        Scanner boat = scanner;
        List<String> listOfShips = new ArrayList<>();
        System.out.println("Place your boat (2 positions)");
        for(int i = 0; i<=1; i++){
            System.out.println("Place position " + (i+1));
            listOfShips.add(getValidShipPosition(boat));
        }
        return listOfShips;
    }
    public List<String> getDestroyerPositions(){
        Scanner destroyer = scanner;
        List<String> listOfShips = new ArrayList<>();
        System.out.println("Place your destroyer (3 positions)");
        for(int i = 0; i<=2; i++){
            System.out.println("Place position " + (i+1));
            listOfShips.add(getValidShipPosition(destroyer));
        }
        return listOfShips;
    }
    public List<String> getCarrierPositions(){
        Scanner carrier = scanner;
        List<String> listOfShips = new ArrayList<>();
        System.out.println("Place your carrier (4 positions)");
        for(int i = 0; i<=3; i++){
            System.out.println("Place position " + (i+1));
            listOfShips.add(getValidShipPosition(carrier));
        }
        return listOfShips;
    }
    public List<String> getCargoShipPositions(){
        Scanner cargoShip = scanner;
        List<String> listOfShips = new ArrayList<>();
        System.out.println("Place your cargo ship (5 positions)");
        for(int i = 0; i<=4; i++){
            System.out.println("Place position " + (i+1));
            listOfShips.add(getValidShipPosition(cargoShip));
        }
        return listOfShips;
    }
    public String getValidShipPosition (Scanner shipScanner){
        String shipPosition = shipScanner.nextLine();
        char letter = shipPosition.toLowerCase().toCharArray()[0];
        char number = shipPosition.toCharArray()[1];
        while(shipPosition.length() != 2){
            System.out.println("Wrong position length");
            shipPosition = shipScanner.nextLine();
        }
        while(letter < 'a' || letter > 'i' && number < '1' || number > '9'){
            System.out.println("Wrong ship coordinate, place ship with correct pattern (A1)");
            shipPosition = shipScanner.nextLine();
            letter = shipPosition.toCharArray()[0];
            number = shipPosition.toCharArray()[1];
        }
        return shipPosition;
    }
}
