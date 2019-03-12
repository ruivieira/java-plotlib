package org.ruivieira.plotlib;

import java.util.Collection;

public abstract class UnaryAbstractPlot<A> implements Plot {

    protected final Converter<A> xs;

    protected final StringBuilder script = new StringBuilder();

    public UnaryAbstractPlot(Collection<A> x) {
        this.xs = new Converter<>(x);
    }
}
