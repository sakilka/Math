package example.math;

import example.gui.PaintPanel;

import java.util.ArrayList;
import java.util.List;

public class ConvergentSum extends AbstractFunction {

    private static final String SUM_NAME = "CONVERGENT SUM";

    private final PaintPanel panel;
    private double previousValue = 0;

    public ConvergentSum() {
        this.panel = new PaintPanel();
        panel.setPolygon(getPolygon());
    }

    @Override
    public String getName() {
        return SUM_NAME;
    }

    @Override
    public List<double[]> getPolygon() {
        List<double[]> plot = new ArrayList<>();
        for(int x = 0; x< 10; x++){
            double[] point = {x, calculate(x)};
            plot.add(point);
        }
        return plot;
    }

    public PaintPanel getPanel() {
        return this.panel;
    }

    private double calculate(double x){
        previousValue += 1/Math.pow(2.0, x);
        return previousValue;
    }
}
