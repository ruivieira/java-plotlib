package org.ruivieira.plotlib.converters;


import org.apache.commons.math3.linear.AbstractRealMatrix;
import org.apache.commons.math3.linear.RealMatrix;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class MatrixConverter<T> {

    public List<String> getConverted() {
        return converted;
    }

    private final List<String> converted;


    public MatrixConverter(RealMatrix data) {
        final double[][] entries = data.getData();
        this.converted = new ArrayList<>();
        for (int rows = 0 ; rows < data.getRowDimension() ; rows++) {
            List<String> rowList = new ArrayList<>();
            final double[] rowEntries = data.getRow(rows);
            for (int i = 0 ; i < rowEntries.length ; i++) {
                rowList.add(String.valueOf(rowEntries[i]));
            }
            this.converted.add("[" + String.join(",", rowList) + "]");
        }
    }

    public String getConvertedList() {
        return "np.array([" + String.join(",", getConverted()) + "])";
    }

}
