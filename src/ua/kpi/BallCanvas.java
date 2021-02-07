package ua.kpi;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class BallCanvas extends JPanel {

    private List<Ball> balls = new ArrayList<>();

    public void add (Ball b) {
        this.balls.add(b);
    }
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D)g;
        for (int i = 0; i <balls.size() ; i++) {
            Ball b = balls.get(i);
            b.draw(g2);
        }
    }
}
