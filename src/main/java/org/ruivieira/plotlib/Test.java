package org.ruivieira.plotlib;

public class Test {

    public static void main(String[] args) {

        Figure figure = new Figure();

        int[] x = new int[]{1, 2, 3, 4};
        int[] y = new int[]{7, 9, 5, 6};

        figure.add(ScatterPlot.create(x, y));

        figure.save();

    }
}
