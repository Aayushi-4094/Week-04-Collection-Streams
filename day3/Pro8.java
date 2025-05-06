import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;

class WriterThread extends Thread {
    private PipedOutputStream pos;

    public WriterThread(PipedOutputStream pos) {
        this.pos = pos;
    }

    @Override
    public void run() {
        try {
            pos.write("Hello, World!".getBytes());
            pos.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}

class ReaderThread extends Thread {
    private PipedInputStream pis;

    public ReaderThread(PipedInputStream pis) {
        this.pis = pis;
    }

    @Override
    public void run() {
        try {
            byte[] buffer = new byte[1024];
            int bytesRead = pis.read(buffer);
            System.out.println(new String(buffer, 0, bytesRead));
            pis.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}

public class Pro8 {
    public static void main(String[] args) {
        try {
            PipedOutputStream pos = new PipedOutputStream();
            PipedInputStream pis = new PipedInputStream(pos);

            WriterThread writerThread = new WriterThread(pos);
            ReaderThread readerThread = new ReaderThread(pis);

            writerThread.start();
            readerThread.start();

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
