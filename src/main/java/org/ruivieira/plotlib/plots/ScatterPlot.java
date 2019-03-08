package org.ruivieira.plotlib.plots;

import org.ruivieira.plotlib.AbstractPlot;
import org.ruivieira.plotlib.Converter;
import org.ruivieira.plotlib.Plot;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

public class ScatterPlot<T, U> extends AbstractPlot<T, U> implements Plot {

    private Optional<String> marker = Optional.empty();
    private Optional<Double> markerSize = Optional.empty();

    public ScatterPlot(Collection<T> x, Collection<U> y) {
        super(x, y);
    }

    public ScatterPlot setMarker(String marker) {
        this.marker = Optional.of(marker);
        return this;
    }

    public ScatterPlot setMarkerSize(double size) {
        this.markerSize = Optional.of(size);
        return this;
    }


    @Override
    public String render() {
        script.append("plt.scatter(").append(xs.getConvertedList())
                .append(",")
                .append(ys.getConvertedList());

        marker.ifPresent(s -> script.append(", marker='").append(s).append("'"));
        markerSize.ifPresent(s -> script.append(", s=").append(s));

        renderColour();
        renderAlpha();

        script.append(")\n");

        renderYLim();

        return script.toString();
    }

}
