import java.util.concurrent.Semaphore;

class ReaderWriters {
    private static Semaphore mutex = new Semaphore(1);
    private static Semaphore wrt = new Semaphore(1);
    private static int readCount = 0;

    static class Reader implements Runnable {
        public void run() {
            try {
                // Acquiring the mutex to access shared readCount
                mutex.acquire();
                readCount++;

                // If it's the first reader, acquiring write lock
                if (readCount == 1) {
                    wrt.acquire();
                }

                // Release mutex to allow other readers
                mutex.release();

                // Reading section
                System.out.println(Thread.currentThread().getName() + " is reading");

                // Acquiring mutex to modify shared readCount
                mutex.acquire();
                readCount--;

                // If it's the last reader, release write lock
                if (readCount == 0) {
                    wrt.release();
                }

                // Release mutex after modification
                mutex.release();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    static class Writer implements Runnable {
        public void run() {
            try {
                // Acquiring write lock
                wrt.acquire();

                // Writing section
                System.out.println(Thread.currentThread().getName() + " is writing");

                // Release write lock
                wrt.release();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        Reader reader = new Reader();
        Writer writer = new Writer();

        Thread t1 = new Thread(reader);
        Thread t2 = new Thread(reader);
        Thread t3 = new Thread(writer);
        Thread t4 = new Thread(reader);
        Thread t5 = new Thread(writer);

        t1.setName("Reader 1");
        t2.setName("Reader 2");
        t3.setName("Writer 1");
        t4.setName("Reader 3");
        t5.setName("Writer 2");

        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();
    }
}
