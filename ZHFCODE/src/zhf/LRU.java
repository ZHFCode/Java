package zhf;

import java.util.HashMap;

/**
 * Created by ZHF on 2018/9/16.
 * 手撸LRU，必须会
 */
public class LRU {
    public static class Node<K, V> {
        public K key;
        public V value;
        public Node<K,V> last;
        public Node<K,V> next;

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    public static class NodeDoubleLinkedList<K,V>{
        private Node<K,V> head;
        private Node<K,V> tail;

        public NodeDoubleLinkedList(){
            this.head = null;
            this.tail = null;
        }

        public void addNode(Node<K, V> newNode) {
            if (newNode == null) {
                return;
            }
            if (this.head == null) {
                this.head = newNode;
                this.tail = newNode;
            } else {
                this.tail.next = newNode;
                newNode.last = this.tail;
                this.tail = newNode;
            }
        }

        public void moveNodeToTail(Node<K,V> node){
            if (node == this.tail) {
                return;
            }
            if (head == node) {
                this.head = node.next;
                this.head.last = null;
            } else {
                node.last.next = node.next;
                node.next.last = node.last;
            }
            node.last = this.tail;
            node.next = null;
            this.tail.next = node;
            this.tail = node;
        }

        public Node<K,V> removeHead() {
            if (head == null) {
                return null;
            }
            Node<K, V> res = this.head;
            if (this.head == this.tail) {
                this.head = null;
                this.tail = null;
            } else {
                this.head = res.next;
                this.head.last = null;
                res.next = null;
            }
            return res;
        }

        public static class MyCache<K,V> {
            private HashMap<K, Node<K, V>> nodeMap;
            private NodeDoubleLinkedList<K, V> nodeList;
            private int capacity;

            public MyCache(int capacity) {
                if (capacity < 1) {
                    throw new RuntimeException();
                }
                this.nodeList = new NodeDoubleLinkedList<>();
                this.nodeMap = new HashMap<>();

            }

            public V get(K key) {
                if (this.nodeMap.containsKey(key)) {
                    Node<K, V> res = this.nodeMap.get(key);
                    this.nodeList.moveNodeToTail(res);
                    return res.value;
                }
                return null;
            }

            public void set(K key,V value) {
                if (this.nodeMap.containsKey(key)) {
                    Node<K, V> node = this.nodeMap.get(key);
                    node.value = value;
                    this.nodeList.moveNodeToTail(node);
                } else {
                    Node<K, V> node = new Node<>(key, value);
                    this.nodeMap.put(key, node);
                    this.nodeList.addNode(node);
                    if (this.nodeMap.size() > this.capacity) {
                        removeMostUnusedCache();
                    }
                }
            }

            public void removeMostUnusedCache() {
                Node<K, V> node = this.nodeList.removeHead();
                K removeKey = node.key;
                this.nodeMap.remove(removeKey);
            }

        }
    }
}
