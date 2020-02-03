public class MyThread  extends Thread {

    MyThread() {
        start();
    }

    @Override
    public void run() {
    }

    public void run (float [] a) {
        for (int i = 0; i < a.length; i++) {
            a[i] = (float) (a[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }
    }

}
