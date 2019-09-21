package org.ruivieira.plotlib.plots;

import org.apache.commons.math3.linear.RealMatrix;
import org.ruivieira.plotlib.MatrixAbstractPlot;

public class MatShow extends MatrixAbstractPlot {

    public MatShow(RealMatrix x) {
        super(x);
    }

    @Override
    public String render() {
        script.append("plt.matshow(").append(matrix.getConvertedList()).append(")");

        return script.toString();
    }
}
