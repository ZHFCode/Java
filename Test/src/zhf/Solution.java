package zhf;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by ZHF on 2018/8/5.
 */
public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String inputStr = scanner.nextLine();
        int countOfPerson = Integer.valueOf(inputStr.split(" ")[0]);
        int personList = Integer.valueOf(inputStr.split(" ")[1]);
        Map<Integer,HashSet<Integer>> map = new HashMap<>();
        for (int i=0;i<countOfPerson;i++){
            String temp = scanner.nextLine();
            HashSet<Integer> set = new HashSet<>();
            String[] tempArr = temp.split(" ");
            for (String s:tempArr){
                set.add(Integer.valueOf(s));
            }
            map.put(i,set);
        }
        HashSet<Integer> personSet = map.get(personList);
        Map<Integer,Integer> commonNumMap = new HashMap<>();
        int commonMax = 0;
        for (int index:map.keySet()){
            if (index==personList){
                continue;
            }
            HashSet<Integer> tempSet = map.get(index);
            int commonNum = Deal(personSet,tempSet);
            if (commonMax<commonNum){
                commonMax = commonNum;
            }
            commonNumMap.put(index,commonNum);

            if (commonMax == 0){
                System.out.println(-1);
                return;
            }

            for (int i: commonNumMap.keySet()){
                if (commonNumMap.get(i)==commonMax){
                    System.out.println(i);
                }
            }
        }
    }
    private static int Deal(HashSet<Integer> set, HashSet<Integer> tempSet){
        int r = 0;
        for (int i : set){
            if (tempSet.contains(i)){
                r++;
            }
        }
        return r;
    }
}
