package org.ruivieira.plotlib;

import org.ruivieira.plotlib.converters.ListConverter;

import java.util.Collection;
import java.util.Optional;

public abstract class BinaryAbstractPlot<T, U> extends UnaryAbstractPlot<T> implements Plot {

    protected final ListConverter<U> ys;

    protected Optional<String> colour = Optional.empty();
    protected Optional<Double> alpha = Optional.empty();
    protected Optional<Coordinate> ylim = Optional.empty();

    public BinaryAbstractPlot(Collection<T> x, Collection<U> y) {
        super(x);
        this.ys = new ListConverter<>(y);
    }

    public BinaryAbstractPlot setYLim(Coordinate c) {
        this.ylim = Optional.of(c);
        return this;
    }

    public void renderYLim() {
        ylim.ifPresent(s -> script.append("plt.ylim").append(s.toString()).append("\n"));
    }

    public void renderColour() {
        colour.ifPresent(s -> script.append(", color='").append(s).append("'"));
    }

    public BinaryAbstractPlot setAlpha(Double alpha) {
        this.alpha = Optional.of(alpha);
        return this;
    }

    public void renderAlpha() {
        alpha.ifPresent(s -> script.append(", alpha=").append(s));
    }


}
