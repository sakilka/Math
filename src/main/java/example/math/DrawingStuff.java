package example.math;

import javax.swing.*;

public class DrawingStuff extends JComponent {

    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setSize(800, 600);
        frame.setTitle("Graphs");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JTabbedPane tabbedPane = new JTabbedPane();
        frame.add(tabbedPane);
        frame.setLocationRelativeTo(null);
        PaintPanel draw = new PaintPanel();
        tabbedPane.add(draw, "Graph1");
        frame.setVisible(true);
    }
}