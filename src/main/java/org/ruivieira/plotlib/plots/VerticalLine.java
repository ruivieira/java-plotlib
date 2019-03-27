package org.ruivieira.plotlib.plots;

import org.ruivieira.plotlib.Arguments;
import org.ruivieira.plotlib.Plot;
import org.ruivieira.plotlib.interfaces.Colour;
import org.ruivieira.plotlib.interfaces.LineStyle;

import java.util.Optional;

public class VerticalLine<T> implements Plot,
        LineStyle<VerticalLine>,
        Colour<VerticalLine> {

    private final T x;
    private Optional<String> linestyle = Optional.empty();
    private Optional<String> colour = Optional.empty();


    public VerticalLine(T x) {
        this.x = x;
    }

    @Override
    public String render() {
        StringBuilder script = new StringBuilder();
        script.append("plt.axvline(x=")
                .append(x);
        linestyle.ifPresent(s -> script.append(", ").append(Arguments.build("linestyle", s)));
        colour.ifPresent(s -> script.append(", color='").append(s).append("'"));
        script.append(")\n");
        return script.toString();
    }

    @Override
    public VerticalLine setLineStyle(String style) {
        this.linestyle = Optional.of(style);
        return this;

    }

    @Override
    public VerticalLine setColour(String colour) {
        this.colour = Optional.of(colour);
        return this;
    }

}
