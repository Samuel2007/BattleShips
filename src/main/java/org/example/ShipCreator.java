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
            Ship ship = new Ship(shipType.getShipLength(),listOfShipsPositions/*TODO: remember this line
            userInput.getShipPositions(listOfAllShipsPositions,shipType.getShipLength())*/);
            playerShips.add(ship);
        }
        return playerShips;
    }
}
