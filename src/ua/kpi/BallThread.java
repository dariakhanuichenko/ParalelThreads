package ua.kpi;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BallThread extends Thread {
    private Ball b;
    private ActionListener actionListener;


    public BallThread(Ball ball, BallCanvas canvas) {
        b = ball;
        actionListener = new Listener(canvas);
    }

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()) {
                for (int i = 0; i < 1000; i++) {
                    b.move();
                    System.out.println("RUN_THREAD:thread name = '" + Thread.currentThread().getName() + "'");
                    Thread.sleep(5);
                }
                actionListener.actionPerformed(new ActionEvent(b, 0, ""));
                Thread.currentThread().interrupt();
            }
        } catch (InterruptedException e) {
            System.out.println("EXXXXXXXXXXXXX");
        }
    }
}
