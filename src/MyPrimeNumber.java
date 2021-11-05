import java.util.Scanner;

public class MyPrimeNumber {
    static int x,y,z,total;

    public static void main(String[] args){
	Scanner scan=new Scanner(System.in);
    System.out.print("Please input x:");
    x=scan.nextInt();
    Thread t1=new Thread(MyPrimeNumber::thread1);
    Thread t2=new Thread(MyPrimeNumber::thread2);
    t1.start();
    t2.start();
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.print("Total: "+total);
    }

    public static void thread1(){
        y=x+5;
        for(int i=x;i<=y;i++){
            if(isPrime(i)){
                System.out.println(Thread.currentThread().getName()+ ": "+i);
                total+=i;
            }
        }
    }

    public static void thread2(){
        z=x+10;
        for(int i=y;i<=z;i++){
            if(isPrime(i)){
                System.out.println(Thread.currentThread().getName()+ ": "+i);
                total+=i;
            }
        }
    }

    public static boolean isPrime(int checknum){
        if (checknum <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(checknum); i++) {
            if (checknum % i == 0) {
                return false;
            }
        }
        return true;
    }
}
