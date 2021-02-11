package ua.kpi;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.geom.Ellipse2D;
import java.util.Random;

public class Ball {
    private Component canvas;
    private Color ballColor = Color.darkGray;
    private static final int X_SIZE = 20;
    private static final int Y_SIZE = 20;
    private Listener actionListener;
    private int x = 0,
            y = 0,
            dx = 2,
            dy = 2;

    public Ball(Component canvas) {
        this.canvas = canvas;
        if (Math.random() < 0.5) {
            x = new Random().nextInt(this.canvas.getWidth());
            y = 0;
        } else {
            x = 0;
            y = new Random().nextInt(this.canvas.getHeight());
        }
    }

    public Ball(Component canvas, Color color, int x, int y) {
        this.canvas = canvas;
        this.ballColor = color;
        this.x = x;
        this.y = y;
    }

    public void setActionListener(BallCanvas canvas) {
        this.actionListener = new Listener(canvas);
    }

    public void draw(Graphics2D g2) {
        g2.setColor(this.ballColor);
        g2.fill(new Ellipse2D.Double(x, y, X_SIZE, Y_SIZE));
    }

    public void move() {
        x += dx;
        y += dy;
        if (x < 0) {
            x = 0;
            dx = -dx;
        }
        if (x + X_SIZE >= this.canvas.getWidth()) {
            x = this.canvas.getWidth() - X_SIZE;
            dx = -dx;
        }
        if (y < 0) {
            y = 0;
            dy = -dy;
        }
        if (y + Y_SIZE >= this.canvas.getHeight()) {
            y = this.canvas.getHeight() - Y_SIZE;
            dy = -dy;
        }
        if (x >= 0 && x <= 30 && y >= 0 && y <= 30 & ballColor.equals(Color.darkGray) & actionListener != null) { //попал в лузу
            actionListener.actionPerformed(new ActionEvent(this, 0, ""));
            throw new RuntimeException(); // кидаем исключение чтобы  остановить поток
        }
        this.canvas.repaint();
    }

    public void hide(Graphics2D g2) {
        System.out.println("HIDE: '" + Thread.currentThread().getName() + "' ball");
        g2.clearRect(x, y, X_SIZE, Y_SIZE);
    }
}
