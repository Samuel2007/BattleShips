package org.example;

public enum ShipTypes {
    SUBMARINE(1),
    BOAT(2),
    DESTROYER(3),
    CARRIER(4),
    CARGO_SHIP(5);
    private final int shipLength;
    public int getShipLength(){
        return shipLength;
    }
    ShipTypes(int shipLength) {
        this.shipLength = shipLength;
    }
}

