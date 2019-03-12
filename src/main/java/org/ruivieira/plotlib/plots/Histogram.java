package org.ruivieira.plotlib.plots;

import org.ruivieira.plotlib.Arguments;
import org.ruivieira.plotlib.Plot;
import org.ruivieira.plotlib.UnaryAbstractPlot;

import java.util.Collection;
import java.util.Optional;

public class Histogram<T> extends UnaryAbstractPlot<T> implements Plot {

    private Optional<Integer> bins = Optional.empty();

    public Histogram(Collection<T> x) {
        super(x);
    }

    @Override
    public String render() {
        script.append("plt.hist(")
                .append(xs.getConvertedList());

        bins.ifPresent(s -> script.append(", ").append(Arguments.build("bins", s)));

        script.append(")\n");
        return script.toString();
    }

    public Histogram<T> setBins(Integer bins) {
        this.bins = Optional.of(bins);
        return this;
    }
}
