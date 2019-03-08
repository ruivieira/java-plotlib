package org.ruivieira.plotlib;

public class Arguments {

    public static String build(String key, String value) {
        final StringBuilder builder = new StringBuilder();
        builder.append(key).append("=").append("'").append(value).append("'");
        return builder.toString();
    }
}
