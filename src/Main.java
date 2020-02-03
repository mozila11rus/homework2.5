public class Main {

  static final int size = 10000000;
  static final int h = size / 2;
  float[] arr = new float[size];

    public static void main(String[] args) {
        Main main = new Main();
        main.calculate_1();
        main.calculate_2();
    }

    private void calculate_1 () {
    for (int i = 0; i < arr.length; i++) { arr[i] = 1; }
    long a = System.currentTimeMillis();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (float)(arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }
        System.currentTimeMillis();
        System.out.println("Время рассчета первого метода: " + (System.currentTimeMillis() - a) + " милисекунды.");
    }

    private void calculate_2 () {
        for (int i = 0; i < arr.length; i++) { arr[i] = 1; }

        long a = System.currentTimeMillis();
        float [] a1 = new float[h];
        float [] a2 = new float[h];
        System.arraycopy(arr, 0, a1, 0, h);
        System.arraycopy(arr, 0, a2, 0, h);
        MyThread t1 = new MyThread();
        t1.run(a1);
        MyThread t2 = new MyThread();
        t2.run(a2);
//        Runnable r1 = new Runnable() {
//            @Override
//            public void run() {
//                for (int i = 0; i < h; i++) {
//                    a1[i] = (float) (a1[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
//                }
//            }
//        };
//        Runnable r2 = new Runnable() {
//            @Override
//            public void run() {
//                for (int i = 0; i < h; i++) {
//                    a2[i] = (float) (a2[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
//                }
//            }
//        };
//        Thread t1 = new Thread(r1);
//        t1.start();
//        Thread t2 = new Thread(r2);
//        t2.start();

        System.arraycopy(a1, 0, arr, 0, h);
        System.arraycopy(a2, 0, arr, h, h);

        System.currentTimeMillis();

        System.out.println("Время рассчета второго метода: " + (System.currentTimeMillis() - a) + " милисекунды.");

    }

}
