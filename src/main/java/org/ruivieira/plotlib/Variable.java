package org.ruivieira.plotlib;

import java.util.UUID;

public class Variable {

    public static String getTemporary(String baseName) {
        String randomUUIDString = UUID.randomUUID().toString();
        return String.format("_%s_%s", baseName, randomUUIDString.replace("-", "_"));
    }

}
