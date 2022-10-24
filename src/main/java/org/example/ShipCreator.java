package org.example;

import java.util.ArrayList;

public class ShipCreator {
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
        UserInput shipPositions = new UserInput();
        Ship submarine = new Ship(1,false,shipPositions.getSubmarinePositions());
        //Ship submarine = new Ship(1,false,PlayerInput.getSingleCellPosition());
        Ship boat = new Ship(2,false,shipPositions.getBoatPositions());
        Ship destroyer = new Ship(3,false,shipPositions.getDestroyerPositions());
        Ship carrier = new Ship(4,false,shipPositions.getCarrierPositions());
        Ship cargoShip = new Ship(5,false,shipPositions.getCargoShipPositions());
        playerShips.add(submarine);
        playerShips.add(boat);
        playerShips.add(destroyer);
        playerShips.add(carrier);
        playerShips.add(submarine);
        playerShips.add(cargoShip);
        return playerShips;
    }
}
