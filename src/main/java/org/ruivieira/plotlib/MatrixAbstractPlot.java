package org.ruivieira.plotlib;

import org.apache.commons.math3.linear.AbstractRealMatrix;
import org.apache.commons.math3.linear.RealMatrix;
import org.ruivieira.plotlib.converters.MatrixConverter;

public abstract class MatrixAbstractPlot implements Plot {

    protected final MatrixConverter matrix;

    protected final StringBuilder script = new StringBuilder();

    public MatrixAbstractPlot(RealMatrix x) {
        this.matrix = new MatrixConverter(x);
    }
}
