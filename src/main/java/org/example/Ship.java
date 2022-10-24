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
}
