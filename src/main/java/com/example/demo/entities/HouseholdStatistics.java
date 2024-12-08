package com.example.demo.entities;

public class HouseholdStatistics {
    private int emptyHouses;
    private int fullHouses;

    // Default constructor
    public HouseholdStatistics() {
    }

    // Getter and setter for emptyHouses
    public int getEmptyHouses() {
        return emptyHouses;
    }

    public void setEmptyHouses(int emptyHouses) {
        this.emptyHouses = emptyHouses;
    }

    // Getter and setter for fullHouses
    public int getFullHouses() {
        return fullHouses;
    }

    public void setFullHouses(int fullHouses) {
        this.fullHouses = fullHouses;
    }
}