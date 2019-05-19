package org.ruivieira.plotlib;

import org.apache.commons.math3.linear.RealMatrix;
import org.pmw.tinylog.Configurator;
import org.pmw.tinylog.Level;
import org.pmw.tinylog.writers.ConsoleWriter;
import org.ruivieira.plotlib.plots.Histogram;
import org.ruivieira.plotlib.plots.HorizontalLine;
import org.ruivieira.plotlib.plots.MatShow;
import org.ruivieira.plotlib.plots.ScatterPlot;

import java.io.IOException;
import java.util.Arrays;

import static org.apache.commons.math3.linear.MatrixUtils.createRealIdentityMatrix;


public class Test {

    public static void main(String[] args) throws IOException {

        Configurator.defaultConfig()
                .writer(new ConsoleWriter())
                .level(Level.DEBUG)
                .activate();

        Integer[] x = new Integer[1000];

        for (int i=0 ; i < 1000 ; i++) {
            x[i] = i;
        }

        Figure figure = new Figure();
        figure.add(new ScatterPlot<>(Arrays.asList(x), Arrays.asList(x)));
        figure.add(new HorizontalLine<>(10.0).setColour("black").setLineStyle("--"));
        figure.show();

        RealMatrix m = createRealIdentityMatrix(10);
        Figure f = new Figure();
        f.add(new MatShow(m));
        f.show();
    }
}
