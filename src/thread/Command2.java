package thread;

import java.util.Scanner;

public class Command2 {
    public static void main(String args[]) {

        Scanner input = new Scanner(System.in);
        double balance;
        double[] deposit = new double[2];
        double[] withdraw = new double[2];
        System.out.print("Enter your balance: ");
        balance = input.nextDouble();

        System.out.print("Enter your cash to deposit1: ");
        deposit[0] = input.nextDouble();
        System.out.print("Enter your cash to deposit2: ");
        deposit[1] = input.nextDouble();

        System.out.print("Enter your cash to withdraw1: ");
        withdraw[0] = input.nextDouble();
        System.out.print("Enter your cash to withdraw2: ");
        withdraw[1] = input.nextDouble();

        MyAccount account = new MyAccount(balance);
        ProcessThread a = new ProcessThread(deposit, 1, account);
        ProcessThread b = new ProcessThread(withdraw, 2, account);
        a.start();
        b.start();
    }


    static class MyAccount{
        double balance;
        public MyAccount(double balance) {
            //code;
            this.balance = balance;
        }

        public synchronized void process(double[] amount, int type) {
            for (int i = 0; i < amount.length; i++) {
                //code: type 1 = deposit, type 2 = withdraw;
                try {
                    Thread.sleep(2);
                } catch (InterruptedException ie) {
                }
            }
        }
    }
}
