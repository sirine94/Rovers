package com.syrine.exercices.models;

public class RoverPosition {
    private int x;
    private int y;
    private char orientation;

    public RoverPosition(int x, int y, char orientation) {
        this.x = x;
        this.y = y;
        this.orientation = orientation;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public char getOrientation() {
        return orientation;
    }

    public void setOrientation(char orientation) {
        this.orientation = orientation;
    }

    public String toString(){
        return x + " " + y + " " + " " + orientation;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) { return true; }
        if (obj == null || obj.getClass() != this.getClass()) { return false; }
        RoverPosition comparedRoverPosition = (RoverPosition) obj;
        return x == comparedRoverPosition.x && y == comparedRoverPosition.y && orientation == comparedRoverPosition.orientation;
    }
}
