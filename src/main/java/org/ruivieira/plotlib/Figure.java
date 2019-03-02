package org.ruivieira.plotlib;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.Optional;

import static org.apache.commons.io.FileUtils.writeStringToFile;

public class Figure {

    private Optional<String> title = Optional.empty();

    public StringBuilder script = new StringBuilder();

    public Figure() {
        script.append("import matplotlib\nimport matplotlib.pyplot as plt\n\n");
    }

    public void setTitle(String title) {
        this.title = Optional.of(title);
    }

    public void add(Plot plot) {
        script.append(plot.render());
    }

    public void save(String imageName) {
        try {
            File tempFile = File.createTempFile("java-plotlib-", ".py");
            System.out.println(tempFile.getAbsolutePath());
            System.out.println(tempFile.getName());
            title.ifPresent(s -> script.append("plt.title('").append(s).append("')\n"));
            script.append("\n").append("plt.savefig('").append(imageName).append("')");
            writeStringToFile(tempFile, script.toString(), Charset.defaultCharset());
            Process p = Runtime.getRuntime().exec("/usr/local/bin/python3 " + tempFile.getAbsolutePath());
            System.out.println(p.getOutputStream().toString());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}