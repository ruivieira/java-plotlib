package org.ruivieira.plotlib.plots;

import org.ruivieira.plotlib.Plot;

public class YLim implements Plot {

    private final double min;
    private final double max;

    public YLim(double min, double max) {
        this.min = min;
        this.max = max;
    }

    @Override
    public String render() {
        StringBuilder script = new StringBuilder();
        script.append("plt.ylim(").append(min).append(", ").append(max).append(")\n");
        return script.toString();
    }
}
