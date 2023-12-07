public class Thread01TaskThreadDemo {

    public static void main(String[] args){

        Runnable printA = new PrintChar('a',100);
        Runnable printB = new PrintChar('b',100);
        Runnable print100 = new PrintNume(100);

        Thread thread1 = new Thread(printA);
        Thread thread2 = new Thread(printB);
        Thread thread3 = new Thread(print100);

        thread1.start();
        thread2.start();
        thread3.start();
    }
}


class PrintChar implements Runnable {
    private char charToPrint;
    private int times;

    public PrintChar(char c, int t){
        charToPrint=c;
        times=t;
    }

    @Override

    public void run(){
        for(int i=0;i<times;i++){
            System.out.print(" "+charToPrint);
        }
    }
}

class PrintNume implements Runnable {
    private int lastNum;

    public PrintNume( int t){
        lastNum=t;
    }

    @Override

    public void run(){
        for(int i=0;i<=lastNum;i++){
            System.out.print(" "+i);
        }
    }
}