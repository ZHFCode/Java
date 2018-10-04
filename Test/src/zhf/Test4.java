package zhf;


import java.util.ArrayList;

/**
 * Created by ZHF on 2018/8/5.
 */
public class Test4 {
    public static int test4(int n,int[] list){
        ArrayList<Integer> arr = new ArrayList<Integer>();
        ArrayList<Integer> res = new ArrayList<Integer>();
        for (int i=0;i<n;i++){
            arr.add(list[i]);
        }
        int count_up = 0;
        int count_down = 0;
        return minNum(arr);
    }
    public static int minNum(ArrayList<Integer> arrayList){
        int start = arrayList.get(0);
        int start_final = start;
        int count = 0;
        int count_up = 0;
        int count_down = 0;
        if (arrayList.isEmpty()){
            return count;
        }
        for (Integer integer:arrayList){
            if (integer>=start){
                count_up++;
                start = integer;
            } else {
                count_down++;
                start = integer;
            }

        }
        start = start_final;
        if (count_down>count_up){
            for (Integer integer: arrayList){
                if (integer>start){
                    int index = arrayList.indexOf(integer);
                    arrayList.remove(index);
                    start = integer;
                }
            }
            count++;
        } else {
            for (Integer integer: arrayList){
                if (integer<start){
                    int index = arrayList.indexOf(integer);
                    arrayList.remove(index);
                    start = integer;
                }
            }
            count++;
        }
        return minNum(arrayList);
    }
}
