package org.ruivieira.plotlib;

import org.ruivieira.plotlib.plots.ScatterPlot;

import javax.imageio.ImageIO;
import java.io.IOException;
import java.util.Arrays;


public class Test {

    public static void main(String[] args) throws IOException {

        Figure figure = new Figure();

        Integer[] x = new Integer[]{1, 2, 3, 4};
        Integer[] y = new Integer[]{7, 9, 5, 6};

        figure.add(new ScatterPlot<>(Arrays.asList(x), Arrays.asList(y)));

        System.out.println(figure.getBufferedImage());

        String[] readers = ImageIO.getReaderFormatNames();
        for (String reader : readers)
            System.out.println("reader: " + reader);
        }

}
