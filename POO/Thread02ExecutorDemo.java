import java.util.concurrent.*;

public class Thread02ExecutorDemo {
    
    public static void main(String[] args){

        ExecutorService executor = Executors.newFixedThreadPool(3);

        executor.execute(new PrintChar('a', 100));
        executor.execute(new PrintChar('b', 100));
        executor.execute(new PrintNume(100));

        executor.shutdown();
    }
}
