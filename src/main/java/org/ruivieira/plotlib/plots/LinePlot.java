package org.ruivieira.plotlib.plots;

import org.ruivieira.plotlib.BinaryAbstractPlot;
import org.ruivieira.plotlib.Arguments;
import org.ruivieira.plotlib.Plot;
import org.ruivieira.plotlib.interfaces.Colour;
import org.ruivieira.plotlib.interfaces.LineStyle;
import org.ruivieira.plotlib.interfaces.Marker;

import java.util.Collection;
import java.util.Optional;

public class LinePlot<T, U> extends BinaryAbstractPlot<T, U> implements Plot, Marker<LinePlot>, LineStyle<LinePlot>, Colour<LinePlot> {

    private Optional<String> marker = Optional.empty();
    private Optional<String> linestyle = Optional.empty();

    public LinePlot(Collection x, Collection y) {
        super(x, y);
    }

    public LinePlot<T, U> setMarker(String marker) {
        this.marker = Optional.of(marker);
        return this;
    }

    public LinePlot<T, U> setLineStyle(String style) {
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

    @Override
    public LinePlot<T, U> setColour(String colour) {
        this.colour = Optional.of(colour);
        return this;
    }
}
