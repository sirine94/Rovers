package com.syrine.exercices.models;

public class Plateau {
    final private int x;
    final private int y;

    public Plateau(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) { return true; }
        if (obj == null || obj.getClass() != this.getClass()) { return false; }
        Plateau comparedPlateform = (Plateau) obj;
        return x == comparedPlateform.x && y == comparedPlateform.y;
    }
}
