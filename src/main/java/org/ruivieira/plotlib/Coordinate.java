package org.ruivieira.plotlib;

public class Coordinate {

    public double getMin() {
        return min;
    }

    public double getMax() {
        return max;
    }

    private final double min;
    private final double max;

    @Override
    public String toString() {
        return "(" + min + ", " + max + ")";
    }

    public Coordinate(double min, double max) {
        this.min = min;
        this.max = max;
    }

}
