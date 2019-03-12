package org.ruivieira.plotlib.plots;

import org.ruivieira.plotlib.BinaryAbstractPlot;
import org.ruivieira.plotlib.Arguments;
import org.ruivieira.plotlib.Plot;

import java.util.Collection;
import java.util.Optional;

public class InterpolationPlot<T, U> extends BinaryAbstractPlot<T, U> implements Plot {

    int steps;

    private Optional<String> linestyle = Optional.empty();

    public InterpolationPlot(Collection<T> x, Collection<U> y, int steps) {
        super(x, y);
        this.steps = steps;
    }

    public InterpolationPlot setLineStyle(String style) {
        this.linestyle = Optional.of(style);
        return this;
    }

    @Override
    public String render() {
        script.append("from scipy.interpolate import interp1d\n");
        script.append("import numpy as np\n");

        script.append(String.format("_z = interp1d(%s, %s, %s)\n",
                xs.getConvertedList(),
                ys.getConvertedList(),
                Arguments.build("kind", "cubic")));

        script.append("_x = np.linspace(").append(xs.getConverted().get(0)).append(", ").append(xs.getConverted().get(xs.getConverted().size()-1)).append(", num=").append(this.steps).append(", endpoint=True)\n");
        script.append("plt.plot(_x, _z(_x)");

        renderColour();
        renderAlpha();
        linestyle.ifPresent(s -> script.append(", linestyle='").append(s).append("'"));

        script.append(")\n");

        renderYLim();

        return script.toString();
    }
}
