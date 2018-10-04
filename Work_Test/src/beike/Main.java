package beike;

/**
 * Created by ZHF on 2018/8/18.
 */
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int n=scanner.nextInt();
        int a[]=new int[n];
        for (int i = 0; i < a.length; i++) {
            a[i]=scanner.nextInt();
        }

        /*从最小的开始修，每个高度，与最小的相比。然后相加
         * 可以ac，时间复杂度为o(n)
         */

        int minindex=0;

        for (int i = 0; i < a.length; i++) {
            if(a[i]<a[minindex]){
                minindex=i;
            }
        }


        int sum=0;

        for (int i = 0; i < a.length; i++) {
            if(i==minindex){
                continue;
            }
            sum=sum+Math.max(a[i], a[minindex]);
        }
        System.out.println(sum);
    }

}