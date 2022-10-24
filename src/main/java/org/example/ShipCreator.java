package org.example;

import java.util.ArrayList;

public class ShipCreator {
    public ArrayList<Ship> createShips(){
        ArrayList<Ship> playerShips = new ArrayList<>();
        UserInput shipPositions = new UserInput();
        Ship submarine = new Ship(1,false,shipPositions.getSubmarinePositions());
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
