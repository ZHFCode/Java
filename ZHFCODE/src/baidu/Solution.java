package baidu;


import java.util.*;

/**
 * Created by ZHF on 2018/9/11.
 */
public class Solution {
    // METHOD SIGNATURE BEGINS, THIS METHOD IS REQUIRED
    List<Integer> findCommonElements(int numCustomer, int numProduct,
                                     List<List<Integer> > productList)
    {
        // WRITE YOUR CODE HERE
        HashSet<Integer> set = new HashSet<>();
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < numCustomer; i++) {
            List<Integer> tmpList = productList.get(i);
            for (int j = 0; j < numProduct; j++) {
                set.add(tmpList.get(j));
            }
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        Iterator<Integer> iterator = set.iterator();
        while (iterator.hasNext()) {
            map.put(iterator.next(), 0);
        }
        long productList_size = productList.size();
        for (long i = 0; i < productList_size; i++) {
            List<Integer> tmp = productList.get((int)i);
            long tmpSize = tmp.size();
            for (int j = 0; j < tmpSize; j++) {
                Integer integer = tmp.get(j);
                if (map.containsKey(integer)) {
                    map.put(integer, map.get(integer) + 1);
                }
            }
        }
        //迭代创建元素
        Iterator<Integer> integerIterator = map.keySet().iterator();
        ArrayList<Node> nodes = new ArrayList<>();
        while (integerIterator.hasNext()) {
            Integer key = integerIterator.next();
            Integer value = map.get(key);
            nodes.add(new Node(key, value));
        }
        Collections.sort(nodes, new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                return o2.num - o1.num;
            }
        });
        for (Node node:nodes) {
            if (node.num == numCustomer) {
                list.add(node.product);
            }
        }
        Collections.sort(list);
        return list;
    }
    static class Node{
        Integer product;
        Integer num;

        public Node(Integer product, Integer num) {
            this.product = product;
            this.num = num;
        }
    }
    // METHOD SIGNATURE ENDS
}

