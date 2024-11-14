import java.util.concurrent.Semaphore;

public class ReaderWriter {
    private static Semaphore mutex = new Semaphore(1);
    private Semaphore rw_mutex = new Semaphore(1);
    private static int count = 0;

    public static void main(String[] args) {
        ReaderWriter readerWriter = new ReaderWriter();
        
        
        Thread reader1 = new Thread(() -> {
            while (true) {
                try {
                    readerWriter.ReaderEntry();
                    Thread.sleep(1000);
                    readerWriter.ReaderExit();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        });

        Thread writer1 = new Thread(() -> {
            while (true) {
                try {
                    readerWriter.WriterEntry();
                    Thread.sleep(1000);
                    readerWriter.WriterExit();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        });
        reader1.start();
        writer1.start();
    }


        void ReaderEntry() throws InterruptedException{
            mutex.acquire();
            count++;
            if(count==1){
                rw_mutex.acquire();
            }
            mutex.release();
            
            System.out.println("Reader entered the critical section");
            ReaderExit();   
        }

        void ReaderExit() throws InterruptedException{
            count--;
            if(count==0){
                rw_mutex.release();
            }
            mutex.release();
        }

        void WriterEntry() throws InterruptedException{
            rw_mutex.acquire();
            System.out.println("Writer entered the critical section");
            WriterExit();
        }

        void WriterExit() throws InterruptedException{
            rw_mutex.release();

        }

}
