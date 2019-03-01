package org.ruivieira.plotlib;

import java.util.ArrayList;
import java.util.List;

public class ScatterPlot implements Plot {

    List<String> xs = new ArrayList<>();
    List<String> ys = new ArrayList<>();


    public ScatterPlot() {

    }

    public String render() {
        return "plt.plot([" + String.join(",", xs) + "], [" + String.join(",", ys) + "])\n";
    }

    public static ScatterPlot create(int[] x, int[] y) {
        List<String> xs = new ArrayList<>();
        for (int _x : x) {
            xs.add(String.valueOf(_x));
        }
        List<String> ys = new ArrayList<>();
        for (int _y : y) {
            ys.add(String.valueOf(_y));
        }
        ScatterPlot plot = new ScatterPlot();
        plot.xs = xs;
        plot.ys = ys;
        return plot;
    }
}
