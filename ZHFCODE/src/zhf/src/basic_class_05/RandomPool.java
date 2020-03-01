package zhf.src.basic_class_05;

import java.util.HashMap;

/**
 * Created by ZHF on 2018/8/22.
 */
public class RandomPool {
    public HashMap<String,Integer> map1;
    public HashMap<Integer,String> map2;
    public int size;

    public RandomPool() {
        map1 = new HashMap<>();
        map2 = new HashMap<>();
        size = 0;
    }

    public void add(String string) {
        map1.put(string,size);
        map2.put(size,string);
    }

    public String getString() {
        int index = (int) Math.random()*size;
        return map2.get(index);
    }

    public void remove(String string) {
        if (this.map1.containsKey(string)) {
            int deleteIndex = map1.get(string);
            int lastIndex = --size;
            String lastKey = map2.get(lastIndex);
            map1.put(lastKey,deleteIndex);
            map2.put(deleteIndex,lastKey);
            map1.remove(string);
            map2.remove(lastIndex);
        }
    }

    public static void main(String[] args) {
        RandomPool randomPool = new RandomPool();

    }
}
