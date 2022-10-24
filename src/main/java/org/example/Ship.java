package org.example;

import java.util.List;

public class Ship {
    int length;
    boolean drowned;
    List<String> position;

    public Ship(int length, boolean drowned, List<String> position){
        this.drowned = drowned;
        this.length = length;
        this.position = position;
    }
    /*public submarine(int length, String[] position,boolean drowned) {
        this.position = position;
        this.length = 1;

    }
    public boat(int length, String[] position,boolean drowned) {
        this.position = position;
        this.length = 2;

    }
    public destroyer(int length, String[] position,boolean drowned) {
        this.position = position;
        this.length = 3;

    }
    public carrier( String[] position,boolean drowned) {
        this.position = position;
        this.length = 4;

    }
    public cargoShip(int length, String[] position,boolean drowned) {
        this.position = position;
        this.length = 5;

    }
    //static Scanner shipLocation;
    /*public static void getPlayerShips(){
        String[] shipCoordinates = shipLocation.nextLine().trim().split(" ");
        if(shipCoordinates.length == 1){
            ShipCreator.createSubmarine(1,shipCoordinates);
        }
        else if(shipCoordinates.length == 2){
            ShipCreator.createDestroyer(2,shipCoordinates);
        }
        else if(shipCoordinates.length == 3){
            ShipCreator.createBattleship(3,shipCoordinates);
        }
        else if(shipCoordinates.length == 4){
            ShipCreator.createCarrier(4,shipCoordinates);
        }
    }*/
}
