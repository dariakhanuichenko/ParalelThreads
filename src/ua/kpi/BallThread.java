package ua.kpi;

public class BallThread extends Thread {
    private Ball b;

    public BallThread(Ball ball) {
        b=ball;
    }

    @Override
    public void run() {
        try{
            for (int i = 0; i < 1000; i++) {
                b.move();
                System.out.println("RUN_THREAD:thread name = '"+Thread.currentThread().getName()+"'");
            Thread.sleep(5);
            }
        } catch (InterruptedException e) {
        }
    }
}
