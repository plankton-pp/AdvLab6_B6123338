package thread;

import java.util.Scanner;

public class Command3 {
    public static void main(String args[]){
        Scanner scan = new Scanner(System.in);
        int amount;
        long num,result=0;
        int start=0,end=0;


        System.out.print("Enter the Number (N):");
        num = scan.nextLong();

        System.out.print("Enter the Amount of Thread(s) (M):");
        amount = scan.nextInt();
        //Array for ProcessThread
        printRes[] thread = new printRes[amount];
        //Start Time
        long startTime = System.currentTimeMillis();
        //Loop for create new to ProcessTread Array
        for(int i=0;i<amount;i++){
            start = end+1;
            end += num/amount;
            //Last Thread
            if(i==amount-1){
                end += num%amount;
            }
            thread[i] = new printRes(start,end);
        }
        for(int j=0;j<amount;j++){
            thread[j].start();
        }
        for(int k=0;k<amount;k++){
            try{
                thread[k].join();
            }catch(InterruptedException ie){
                ie.printStackTrace();
            }
        }
        long endTime = System.currentTimeMillis();
        for(int l=0;l<amount;l++){
            result += thread[l].count;
            System.out.printf("Result of Thread%d =%d\n",l+1,result);
        }

        System.out.printf("Result: %d\n",result);
        System.out.printf("Time: %d Millisec\n",endTime-startTime);

    }
    static class printRes extends Thread{
        int start, end, count=0;
        public printRes(int start,int end){
            this.start = start;
            this.end = end;
        }
        public void run(){
            for(long m=start;m<=end;m++){
                count+= m;
            }
        }
    }

}
