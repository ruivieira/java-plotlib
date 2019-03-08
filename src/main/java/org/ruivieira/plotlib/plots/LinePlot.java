package org.ruivieira.plotlib.plots;

import org.ruivieira.plotlib.AbstractPlot;
import org.ruivieira.plotlib.Arguments;
import org.ruivieira.plotlib.Plot;

import java.util.Collection;
import java.util.Optional;

public class LinePlot<T, U> extends AbstractPlot<T, U> implements Plot {

    private Optional<String> marker = Optional.empty();
    private Optional<String> linestyle = Optional.empty();

    public LinePlot(Collection x, Collection y) {
        super(x, y);
    }

    public LinePlot setMarker(String marker) {
        this.marker = Optional.of(marker);
        return this;
    }

    public LinePlot setLineStyle(String style) {
        this.linestyle = Optional.of(style);
        return this;
    }

    @Override
    public String render() {
        script.append("plt.plot(")
                .append(xs.getConvertedList())
                .append(",")
                .append(ys.getConvertedList());

        marker.ifPresent(s -> script.append(", ").append(Arguments.build("marker", s)));
        linestyle.ifPresent(s -> script.append(", ").append(Arguments.build("linestyle", s)));

        renderColour();
        renderAlpha();

        script.append(")\n");

        renderYLim();

        return script.toString();

    }
}
