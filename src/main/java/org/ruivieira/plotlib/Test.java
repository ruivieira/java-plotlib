package org.ruivieira.plotlib;

import org.ruivieira.plotlib.plots.ScatterPlot;

import java.util.Arrays;


public class Test {

    public static void main(String[] args) {

        Figure figure = new Figure();

        Integer[] x = new Integer[]{1, 2, 3, 4};
        Integer[] y = new Integer[]{7, 9, 5, 6};

        figure.add(new ScatterPlot<>(Arrays.asList(x), Arrays.asList(y)));

        figure.getBufferedImage();

    }
}
