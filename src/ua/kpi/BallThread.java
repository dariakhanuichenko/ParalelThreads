package ua.kpi;

public class BallThread extends Thread {
    private Ball b;

    public BallThread(Ball ball, BallCanvas canvas) {
        b = ball;
        b.setActionListener(canvas);
    }

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()) {
                try {
                    for (int i = 0; i < 1000; i++) {
                        b.move();
                        System.out.println("RUN_THREAD:thread name = '" + Thread.currentThread().getName() + "'");
                        Thread.sleep(5);
                    }
                    Thread.currentThread().interrupt();
                } catch (RuntimeException e) {
                    System.out.println("IN_POCKET: thread name = '" + Thread.currentThread().getName() + "'");
                    Thread.currentThread().interrupt();
                }
            }
        } catch (InterruptedException e) {
        }
    }
}
