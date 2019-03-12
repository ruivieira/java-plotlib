package org.ruivieira.plotlib.plots;

import org.ruivieira.plotlib.Plot;
import org.ruivieira.plotlib.UnaryAbstractPlot;

import java.util.Collection;

public class Histogram<T> extends UnaryAbstractPlot<T> implements Plot {

    public Histogram(Collection<T> x) {
        super(x);
    }

    @Override
    public String render() {
        script.append("plt.hist(")
                .append(xs.getConvertedList());


        script.append(")\n");
        return script.toString();
    }
}
