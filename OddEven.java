public class OddEven{
    public static void main(String args[]){
        Thread oddThread = new Thread(new OddNumberPrinter());
        Thread evenThread = new Thread(new EvenNumberPrinter());
        oddThread.start();
        evenThread.start();
    }
}

class OddNumberPrinter implements Runnable{
    @Override
    public void run(){
        for (int i=1; i<=20 ; i += 2){
            System.out.println(i);
        }
    }
}

class EvenNumberPrinter implements Runnable{
    @Override
    public void run(){
        for (int j=2 ; j<= 20; j+=2){
            System.out.println(j);
        }
    }
}