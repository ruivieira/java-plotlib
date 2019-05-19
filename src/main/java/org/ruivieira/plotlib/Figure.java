package org.ruivieira.plotlib;

import org.pmw.tinylog.Logger;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.nio.charset.Charset;
import java.util.Optional;


import static org.apache.commons.io.FileUtils.writeStringToFile;

public class Figure {

    private String python = "/usr/local/bin/python3";

    private Optional<String> title = Optional.empty();

    public StringBuilder script = new StringBuilder();

    public Figure() {
        script.append("import matplotlib\nimport matplotlib.pyplot as plt\nimport numpy as np\n\n");
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
            script.append("\n").append("plt.savefig('").append(imageName).append("', format='png', transparent=False)");
            writeStringToFile(tempFile, script.toString(), Charset.defaultCharset());
            Logger.debug("Saving temporary script to {}", tempFile.getAbsolutePath());
            Logger.debug("Saving temporary image to {}", imageName);
            Process p = runtime.exec(python + " " + tempFile.getAbsolutePath());
            p.waitFor();

        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public BufferedImage getBufferedImage() throws IOException {
        File tempFile = File.createTempFile("tmp", ".png");
        save(tempFile.getAbsolutePath());
        File savedImage = new File(tempFile.getAbsolutePath());
        FileInputStream fis = new FileInputStream(savedImage);
        return ImageIO.read(fis);
    }

    public String getPython() {
        return python;
    }

    public void setPython(String python) {
        this.python = python;
    }

    public void show()  {
        File tempFile = null;
        try {
            tempFile = File.createTempFile("tmp", ".png");
        } catch (IOException e) {
            e.printStackTrace();
        }
        save(tempFile.getAbsolutePath());
        ImageViewer frame = new ImageViewer(tempFile.getAbsolutePath());
        frame.setSize(640, 480);
        frame.setVisible(true);

    }

    private class ImageViewer extends JFrame
    {
        private ImageViewer(String arg){
            JPanel panel = new JPanel();
            panel.setSize(480,640);
            ImageIcon icon = new ImageIcon(arg);
            JLabel label = new JLabel();
            label.setIcon(icon);
            panel.add(label);
            this.getContentPane().add(panel);
        }
    }
}
