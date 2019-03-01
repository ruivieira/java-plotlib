package org.ruivieira.plotlib;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

public class ScatterPlot<T, U> implements Plot {

    List<String> xs = new ArrayList<>();
    List<String> ys = new ArrayList<>();

    private Optional<String> marker = Optional.empty();


    public ScatterPlot(T[] x, U[] y) {
        for (T _x : x) {
            xs.add(String.valueOf(_x));
        }
        for (U _y : y) {
            ys.add(String.valueOf(_y));
        }
    }

    public ScatterPlot(Collection<T> x, Collection<U> y) {
        for (T _x : x) {
            xs.add(String.valueOf(_x));
        }
        for (U _y : y) {
            ys.add(String.valueOf(_y));
        }
    }

    public ScatterPlot setMarker(String marker) {
        this.marker = Optional.of(marker);
        return this;
    }

    public String render() {
        final StringBuilder rendered = new StringBuilder();
        rendered.append("plt.scatter([").append(String.join(",", xs));
        rendered.append("], [");
        rendered.append(String.join(",", ys));
        rendered.append("]");
        marker.ifPresent(s -> rendered.append(", marker='").append(s).append("'"));

        rendered.append(")\n");
        System.out.println(rendered.toString());
        return rendered.toString();
    }

}
