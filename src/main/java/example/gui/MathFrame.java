package example.gui;

import example.math.ConvergentSum;

import javax.swing.*;

public class MathFrame extends JFrame {

    private JTabbedPane tab;

    public MathFrame (){
        this.setSize(800, 600);
        this.setTitle("Graphs");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.tab = new JTabbedPane();
        this.add(tab);
        this.setLocationRelativeTo(null);
        PaintPanel draw = new PaintPanel();
        ConvergentSum convergentSum = new ConvergentSum();
        tab.add(convergentSum.getPanel(), convergentSum.getName());
        this.setVisible(true);
    }

    public static void main(String[] args) {
        new MathFrame();
    }
}