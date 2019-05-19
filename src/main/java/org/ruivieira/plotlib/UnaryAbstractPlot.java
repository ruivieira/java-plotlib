package org.ruivieira.plotlib;

import org.ruivieira.plotlib.converters.ListConverter;

import java.util.Collection;

public abstract class UnaryAbstractPlot<A> implements Plot {

    protected final ListConverter<A> xs;

    protected final StringBuilder script = new StringBuilder();

    public UnaryAbstractPlot(Collection<A> x) {
        this.xs = new ListConverter<>(x);
    }
}
