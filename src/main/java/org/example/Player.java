package org.example;

import java.util.*;

public class Player {
    String playerName;
    ArrayList<Ship> playerShips;
    public Player(String playerName, ArrayList<Ship> playerShips){
        this.playerName = playerName;
        this.playerShips = playerShips;
    }
}
