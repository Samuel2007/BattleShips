package org.example;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class UserInput {
    List<String> submarinePositions = new LinkedList<>();
    List<String> boatPositions = new LinkedList<>();
    List<String> destroyerPositions = new LinkedList<>();
    List<String> carrierPositions = new LinkedList<>();
    List<String> cargoShipPositions = new LinkedList<>();
    public String checkNameCorrection(){
        Scanner getP1Name = new Scanner(System.in);
        String playerInput = getP1Name.nextLine();
        if(playerInput.length()<=20){
            return playerInput;
        }
        else{
            System.out.println("The name is too long, try again");
            checkNameCorrection();
            return null;
        }
    }
    public List<String> getSubmarinePositions(){
        return submarinePositions;
    }
    public List<String> getBoatPositions(){
        return boatPositions;
    }
    public List<String> getDestroyerPositions(){
        return destroyerPositions;
    }
    public List<String> getCarrierPositions(){
        return carrierPositions;
    }
    public List<String> getCargoShipPositions(){
        return cargoShipPositions;
    }
    public void checkShipPositionsCorrection (int ship){
        Scanner shipScanner = new Scanner(System.in);
        String[] positionsArray = shipScanner.nextLine().split(" ");
        for(String shipPosition:positionsArray){
            String lowerCaseShipPosition = shipPosition.toLowerCase();
            char[] shipPositionAsCharArray = lowerCaseShipPosition.toCharArray();
            if(shipPosition.length() == 2){
                if(shipPositionAsCharArray[0] >= 'a' && shipPositionAsCharArray[0] <= 'i'){
                    if(shipPositionAsCharArray[1] >= '1' && shipPositionAsCharArray[1] <= '9'){
                        switch(ship){
                            case 1:
                                submarinePositions.add(lowerCaseShipPosition);
                            case 2:
                                boatPositions.add(lowerCaseShipPosition);
                            case 3:
                                destroyerPositions.add(lowerCaseShipPosition);
                            case 4:
                                carrierPositions.add(lowerCaseShipPosition);
                            case 5:
                                cargoShipPositions.add(lowerCaseShipPosition);
                        }
                    }
                    else{
                        System.out.println("False ship coordinate(wrong number), try again");
                        checkShipPositionsCorrection(ship);
                    }
                }
                else{
                    System.out.println("False ship coordinate(wrong letter), try again");
                    checkShipPositionsCorrection(ship);
                }
            }
            else{
                System.out.println("False ship coordinate(wrong length), try again");
                checkShipPositionsCorrection(ship);
            }
        }
    }
}
