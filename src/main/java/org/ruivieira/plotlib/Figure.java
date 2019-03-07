package org.ruivieira.plotlib;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.Optional;

import static org.apache.commons.io.FileUtils.writeStringToFile;

public class Figure {

    private String python = "/usr/local/bin/python3";

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
        save(imageName, Runtime.getRuntime());
    }

    public void save(String imageName, Runtime runtime) {
        try {
            File tempFile = File.createTempFile("java-plotlib-", ".py");
            title.ifPresent(s -> script.append("plt.title('").append(s).append("')\n"));
            script.append("\n").append("plt.savefig('").append(imageName).append("')");
            writeStringToFile(tempFile, script.toString(), Charset.defaultCharset());
//            System.out.println(script.toString());
            runtime.exec(python + " " + tempFile.getAbsolutePath());
            System.out.println(tempFile.getAbsolutePath());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public BufferedImage getBufferedImage() {
        BufferedImage img = null;
        try {
            File tempFile = File.createTempFile("java-plotlib-", ".png");
            save(tempFile.getAbsolutePath());
             img = ImageIO.read(new File(tempFile.getAbsolutePath()));

        } catch (IOException e) {
            e.printStackTrace();
        }
        return img;
    }

    public String getPython() {
        return python;
    }

    public void setPython(String python) {
        this.python = python;
    }
}
