package org.example;

import java.util.*;

public class Player {
    String playerName;
    ArrayList<Ship> playerShips;
    public Player(String playerName, ArrayList<Ship> playerShips){
        this.playerName = playerName;
        this.playerShips = playerShips;
    }
    public Player(){}
    public void getShipsPositions(){
        getShipPositionPrinciple(1);
        getShipPositionPrinciple(2);
        //getShipPositionPrinciple(2);
        getShipPositionPrinciple(3);
        /*getShipPositionPrinciple(3);
        getShipPositionPrinciple(3);*/
        getShipPositionPrinciple(4);
        /*getShipPositionPrinciple(4);
        getShipPositionPrinciple(4);
        getShipPositionPrinciple(4);
        getShipPositionPrinciple(4);
        getShipPositionPrinciple(5);
        getShipPositionPrinciple(5);
        getShipPositionPrinciple(5);
        getShipPositionPrinciple(5);*/
        getShipPositionPrinciple(5);
    }
    public void/*List<String>*/ getShipPositionPrinciple(int shipLength){
        UserInput checkShipPositions = new UserInput();
        System.out.println("Place your " + shipLength + " cell ship");
        checkShipPositions.checkShipPositionsCorrection(shipLength);
        //player.playerShips.set(shipPosition,);
        /*switch (shipLength){
            case 1:

            case 2:
        }
        ArrayList<String> shipPositions = new ArrayList<>();
        shipPositions.add(shipPosition);
        //return shipPositions;*/
    }

    /*public static void getPlayerShips() {
        player1Ships.add(Ship.class);
        Scanner playerInput = new Scanner(System.in);
        String[] shipCoordinates = playerInput.nextLine().toLowerCase().trim().split(" ");
        if (shipCoordinates.length == 1) {
            ShipCreator.createSubmarinePlayer(1, shipCoordinates);
        } else if (shipCoordinates.length == 2) {
            ShipCreator.createDestroyerPlayer(2, shipCoordinates);
        } else if (shipCoordinates.length == 3) {
            ShipCreator.createBattleshipPlayer(3, shipCoordinates);
        } else if (shipCoordinates.length == 4) {
            ShipCreator.createCarrierPlayer(4, shipCoordinates);
        }
    }*/
}
