package org.example;

import java.util.ArrayList;
import java.util.List;

public class ShipCreator {
    UserInput userInput;
    List<String> listOfShipsPositions = new ArrayList<>();
    public ShipCreator(UserInput userInput) {
        this.userInput = userInput;
    }
    /*public static void createSubmarine(int shipLength, String[] position) {
            listOfShips.add(new Ship(shipLength, position));
        }

        public static void createDestroyer(int shipLength, String[] position) {
            Player player1 = new Player();
            player1.player1Ships.add(new Ship(shipLength, position));
        }

        public static void createBattleship(int shipLength, String[] position) {
            Player player1 = new Player();
            player1.player1Ships.add(new Ship(shipLength, position));
        }

        public static void createCarrier(int shipLength, String[] position) {
            Player player1 = new Player();
            player1.player2Ships.add(new Ship(shipLength, position));
        }*/
    public ArrayList<Ship> createShips(){
        ArrayList<Ship> playerShips = new ArrayList<>();
        for(ShipTypes shipType: ShipTypes.values()){
            System.out.println("Place your "+ shipType.name().toLowerCase()+" ("+shipType.getShipLength()+" positions)");
            /*if(shipType == ShipTypes.SUBMARINE){
                userInput.getSubmarinePosition(listOfShipsPositions,shipType.getShipLength());
                playerShips.add(ship);
            }*/
            Ship ship = new Ship(shipType.getShipLength(),userInput.getValidShipPositionFromPositionRange(listOfShipsPositions,shipType.getShipLength()));
                playerShips.add(ship);

        }
        return playerShips;
    }
}
