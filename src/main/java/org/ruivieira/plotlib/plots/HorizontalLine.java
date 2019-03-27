package org.ruivieira.plotlib.plots;

import org.ruivieira.plotlib.Arguments;
import org.ruivieira.plotlib.Plot;
import org.ruivieira.plotlib.interfaces.Colour;
import org.ruivieira.plotlib.interfaces.LineStyle;

import java.util.Optional;

public class HorizontalLine<T> implements Plot,
        LineStyle<HorizontalLine>,
        Colour<HorizontalLine> {

    private final T y;
    private Optional<String> linestyle = Optional.empty();
    private Optional<String> colour = Optional.empty();

    public HorizontalLine(T y) {
        this.y = y;
    }

    @Override
    public String render() {
        StringBuilder script = new StringBuilder();
        script.append("plt.axhline(y=")
                .append(y);
        linestyle.ifPresent(s -> script.append(", ").append(Arguments.build("linestyle", s)));
        colour.ifPresent(s -> script.append(", color='").append(s).append("'"));
        script.append(")\n");
        return script.toString();
    }

    @Override
    public HorizontalLine setLineStyle(String style) {
        this.linestyle = Optional.of(style);
        return this;

    }

    @Override
    public HorizontalLine setColour(String colour) {
        this.colour = Optional.of(colour);
        return this;
    }
}
