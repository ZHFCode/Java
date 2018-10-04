package zhf;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Created by ZHF on 2018/8/5.
 */
public class Test2 {
    public static HashMap<String,String> splitNum(String s){
        HashMap<String,String> pair = new HashMap<String,String>();
        char[] chars = s.toCharArray();
        int len = chars.length;
        int index = 0;
        for (int i=0;i<len;i++){
            if (chars[i]=='0'){
                break;
            }
            index++;
        }
        for (int i=index;i<len && chars[index]!='0';i++){
            int j = index;
            String start = "0.";
            String end = null;
            for (;j <= i;j++){
                start += chars[j];
            }
            for (int l = j; l<len ; l++ ){

                end+=chars[l];
            }
            pair.put(start,end);
        }

        return pair;
    }

    public static void main(String[] args) {
        HashMap<String,String> map = splitNum("09876");
        Iterator<Map.Entry<String,String>> iterator = map.entrySet().iterator();
        while (iterator.hasNext()){
            Map.Entry<String,String> entry = iterator.next();
            String key  = entry.getKey();
            String val  = entry.getValue();
            System.out.println(key+"--"+val);
        }
    }
}
