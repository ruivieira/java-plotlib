package org.ruivieira.plotlib;


import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class Converter<T> {

    public List<String> getConverted() {
        return converted;
    }

    private final List<String> converted;


    public Converter(Collection<T> data) {
        this.converted = data.stream().map(String::valueOf).collect(Collectors.toList());
    }

    public String getConvertedList() {
        final StringBuilder builder = new StringBuilder();
        builder.append("[").append(String.join(",", getConverted())).append("]");
        return builder.toString();
    }

}
