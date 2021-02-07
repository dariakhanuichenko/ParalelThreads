package ua.kpi;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Listener implements ActionListener {

    private BallCanvas canvas;

    public Listener(BallCanvas canvas) {
        this.canvas = canvas;
    }

    public void actionPerformed(ActionEvent e) {
        Ball b = (Ball) e.getSource();
       canvas.remove(b, (Graphics2D) canvas.getGraphics());
    }
}

