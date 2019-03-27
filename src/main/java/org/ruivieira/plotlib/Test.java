package org.ruivieira.plotlib;

import org.pmw.tinylog.Configurator;
import org.pmw.tinylog.Level;
import org.pmw.tinylog.writers.ConsoleWriter;
import org.ruivieira.plotlib.plots.Histogram;

import java.io.IOException;
import java.util.Arrays;


public class Test {

    public static void main(String[] args) throws IOException {

        Configurator.defaultConfig()
                .writer(new ConsoleWriter())
                .level(Level.DEBUG)
                .activate();

        Figure figure = new Figure();

        Double[] x = new Double[]{1.0, 2.0, 3.0, 4.0};

        figure.add(new Histogram<>(Arrays.asList(x)).setBins(200));

        System.out.println(figure.getBufferedImage());
    }
}
