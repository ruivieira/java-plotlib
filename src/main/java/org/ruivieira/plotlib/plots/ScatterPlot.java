package org.ruivieira.plotlib.plots;

import org.ruivieira.plotlib.AbstractPlot;
import org.ruivieira.plotlib.Converter;
import org.ruivieira.plotlib.Plot;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

public class ScatterPlot<T, U> extends AbstractPlot implements Plot {

    final List<String> xs;
    final List<String> ys;

    private Optional<String> marker = Optional.empty();
    private Optional<String> colour = Optional.empty();


    public ScatterPlot(Collection<T> x, Collection<U> y) {
        this.xs = new Converter<>(x).getConverted();
        this.ys = new Converter<>(y).getConverted();

    }

    public ScatterPlot setMarker(String marker) {
        this.marker = Optional.of(marker);
        return this;
    }


    public String render() {
        script.append("plt.scatter([").append(String.join(",", xs));
        script.append("], [");
        script.append(String.join(",", ys));
        script.append("]");
        marker.ifPresent(s -> script.append(", marker='").append(s).append("'"));

        renderColour();
        renderAlpha();

        script.append(")\n");

        renderYLim();

        System.out.println(script.toString());
        return script.toString();
    }

}
