package org.ruivieira.plotlib;

import java.util.Optional;

public abstract class AbstractPlot implements Plot {

    protected Optional<String> colour = Optional.empty();
    protected Optional<Double> alpha = Optional.empty();

    protected final StringBuilder script = new StringBuilder();

    public AbstractPlot setColour(String colour) {
        this.colour = Optional.of(colour);
        return this;
    }

    public void renderColour() {
        colour.ifPresent(s -> script.append(", color='").append(s).append("'"));
    }

    public AbstractPlot setAlpha(Double alpha) {
        this.alpha = Optional.of(alpha);
        return this;
    }

    public void renderAlpha() {
        alpha.ifPresent(s -> script.append(", alpha=").append(s));
    }


}
