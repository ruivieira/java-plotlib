package org.ruivieira.plotlib;

import java.util.Collection;
import java.util.List;

public class InterpolationPlot<T, U> extends AbstractPlot implements Plot {

    List<String> xs;
    List<String> ys;
    int steps;

    public InterpolationPlot(Collection<T> x, Collection<U> y, int steps) {
        this.xs = new Converter<>(x).getConverted();
        this.ys = new Converter<>(y).getConverted();
        this.steps = steps;
    }

    @Override
    public String render() {
        script.append("from scipy.interpolate import interp1d\n");
        script.append("import numpy as np\n");
        script.append("_z = interp1d([").append(String.join(",", xs)).append("]");
        script.append(", [").append(String.join(",", ys)).append("], kind='cubic')\n");
        script.append("_x = np.linspace(").append(xs.get(0)).append(", ").append(xs.get(xs.size()-1)).append(", num=").append(this.steps).append(", endpoint=True)\n");
        script.append("plt.plot(_x, _z(_x)");

        renderColour();
        renderAlpha();


        script.append(")\n");
        System.out.println(script.toString());
        return script.toString();
    }
}
