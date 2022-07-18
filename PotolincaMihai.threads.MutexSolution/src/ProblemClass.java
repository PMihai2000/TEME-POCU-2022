import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ProblemClass {
    private ReentrantLock mutex = new ReentrantLock();
    private int x = 0;
    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void increase() {
        try {
            mutex.lock();
            x = x + 1;
        }finally {
            mutex.unlock();

        }
    }
}
