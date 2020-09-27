package thread;

import java.util.Scanner;

public class Command3 {
    public static void main(String args[]){
        Scanner scan = new Scanner(System.in);
        int amount;
        long num,result=0,start=0,end=0;

        long startTime = System.currentTimeMillis();
        System.out.print("Enter the Number (N):");
        num = scan.nextLong();

        System.out.print("Enter the Amount of Thread(s) (M):");
        amount = scan.nextInt();

        ProcessThread[] thread = new ProcessThread[amount];
        for(int i=0;i<amount;i++){
            start = end+1;
            end += num/amount;

        }

    }
    public static class ProcessThread extends Thread(){
    }

}
