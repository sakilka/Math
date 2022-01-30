package example.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Path2D;
import java.util.ArrayList;
import java.util.List;

public class PaintPanel extends JComponent {

    private int borderGap = 50;
    private int axisX;
    private int axisY;

    private List<double[]> plot;

    public void paintComponent(Graphics g) {
        axisX = this.getWidth()/2;
        axisY = this.getHeight()/2;

        paintAxis((Graphics2D) g);
        drawGraph((Graphics2D) g);
    }

    private void paintAxis(Graphics2D g) {
        g.setStroke(new BasicStroke(2));
        g.setColor(Color.black);
        g.drawLine(0,axisY,axisX*2,axisY);
        g.drawLine(axisX,0,axisX,axisY*2);

        for (int x = borderGap; x< (this.getWidth()/2); x=x+ borderGap) {
            g.drawLine(axisX + x, axisY + 10, axisX + x, axisY - 10);
            g.drawString(String.valueOf(x/ borderGap), axisX -3 + x, axisY + 25);
        }

        for (int x = borderGap; x< (this.getWidth()/2); x=x+ borderGap) {
            g.drawLine(axisX - x, axisY + 10, axisX - x, axisY - 10);
            g.drawString(String.valueOf(-x/ borderGap), axisX - 8 - x, axisY + 25);
        }

        for (int y = borderGap; y< (this.getHeight()/2); y=y+ borderGap) {
            g.drawLine(axisX +10, axisY + y, axisX -10, axisY +y);
            g.drawString(String.valueOf(-y/ borderGap), axisX + 3 , axisY + 13 +y);
        }

        for (int y = borderGap; y< (this.getHeight()/2); y=y+ borderGap) {
            g.drawLine(axisX +10, axisY - y, axisX -10, axisY -y);
            g.drawString(String.valueOf(y/ borderGap), axisX + 3 , axisY + 13 -y);
        }
    }

    public void setPolygon(List<double[]> plot) {
        this.plot = plot;
    }

    private void drawGraph(Graphics2D g) {
        Path2D translatedPlot = new Path2D.Double();
        boolean first = true;
        for (double[] point : plot) {
            if(first) {
                translatedPlot.moveTo((point[0] * borderGap), (-point[1] * borderGap));
                first = false;
            } else {
                translatedPlot.lineTo((point[0] * borderGap), (-point[1] * borderGap));
            }
        }

        g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g.setStroke(new BasicStroke(5f));
        g.setColor(Color.red);
        g.translate(axisX, axisY);
        g.draw(translatedPlot);
    }
}
