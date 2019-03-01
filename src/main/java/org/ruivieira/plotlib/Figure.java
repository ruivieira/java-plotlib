package org.ruivieira.plotlib;

public class Figure {

    public StringBuilder script = new StringBuilder();

    public Figure() {
        script.append("import matplotlib\nimport matplotlib.pyplot as plt\n\n");
    }

    public void add(Plot plot) {
        script.append(plot.render());
    }

    public void save() {
        System.out.println(script.toString());
    }
}
