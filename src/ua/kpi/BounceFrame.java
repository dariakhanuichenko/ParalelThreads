package ua.kpi;

import javax.swing.*;
import javax.swing.plaf.basic.BasicOptionPaneUI;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BounceFrame extends JFrame {
    private BallCanvas canvas;
    public static final int WIDTH=450;
    public static final int HEIGHT=350;
   public  static int  counter = 0;

    JPanel buttonPanel = new JPanel();
    JButton buttonStart=new JButton("Start");
    JButton buttonStop=new JButton("Stop");

    public static  JLabel bottomLabel = new JLabel("Counter: 0");


    public BounceFrame() {
        this.setSize(WIDTH,HEIGHT);
        this.setTitle("Bonce program");

        this.canvas = new BallCanvas();
        System.out.println("In frame thread name ='" +Thread.currentThread().getName() + "'");
        Container content = this.getContentPane();
        content.add(this.canvas, BorderLayout.CENTER);

        buttonPanel.setBackground(Color.lightGray);

        bottomLabel.setVerticalAlignment(JLabel.BOTTOM);
        bottomLabel.setHorizontalAlignment(JLabel.CENTER);

        buttonPanel.add(bottomLabel);

        buttonStart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Ball b = new Ball(canvas);
                canvas.add(b);
                BallThread thread = new BallThread(b, canvas);
                thread.start();
                System.out.println("BUTTON_START: thread name ='" +thread.getName() + "'");
            }
        });

        buttonStop.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        buttonPanel.add(buttonStart);
        buttonPanel.add(buttonStop);

        content.add(buttonPanel, BorderLayout.SOUTH);
    }

   public static void  changeLabelText() {
         counter++;
        bottomLabel.setText("Counter: " +counter);
    }
}
