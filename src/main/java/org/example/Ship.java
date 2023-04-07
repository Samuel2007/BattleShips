package org.example;

import java.util.List;

public class Ship {
    int length;
    boolean drowned = false;
    List<String> position;

    public Ship(int length, List<String> position){
        this.length = length;
        this.position = position;
    }
}
