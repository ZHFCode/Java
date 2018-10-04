package basic_class_01;
/*
固定长度的数组实现Stack和Queue
 */
/**
 * Created by ZHF on 2018/8/14.
 */
public class ArrayToStackQueue {
    public static class ArrayStack{
        private Integer[] arr;
        private Integer index;  //index表示如果我要压入一个数，我该压入到哪个位置

        public ArrayStack(int initalSize){
            if (initalSize<0){
                throw new IllegalArgumentException("allegal arguments");
            }
            arr = new Integer[initalSize];
            index = 0;
        }
        public Integer peek(){
            if (index == 0){
                return null;
            }
            return arr[index];
        }
        public void push(Integer num){
            if (index == arr.length){
                throw new ArrayIndexOutOfBoundsException("this stack is full!");
            }
            arr[index++] = num;
        }
        public Integer pop(){
            if (index == 0){
                throw new ArrayIndexOutOfBoundsException("this stack is empty!");
            }
            return arr[--index];
        }
        public boolean isEmpty(){
            return index == 0;
        }
    }

    public static class ArrayQueue{
        private Integer[] arr;
        private Integer start;  //代表如果我要拿取一个数，我还拿取那个位置上的数
        private Integer end;  //代表如果我要放入一个数，我该放到哪个位置上
        private Integer size;

        public ArrayQueue(int initialSize){
            if (initialSize<0){
                throw new IllegalArgumentException("Illegal Argument!");
            }
            arr = new Integer[initialSize];
            size = 0;
            start = 0;
            end = 0;
        }
        public void push(int obj){
            if (size == arr.length){
                throw new ArrayIndexOutOfBoundsException("this queue is full!");
            }
            size++;
            arr[end] = obj;
            end = end == arr.length-1 ? 0 : end+1;
        }
        public Integer poll(){
            if (size == 0){
                throw new ArrayIndexOutOfBoundsException("this queue is empty");
            }
            size--;
            int tmp = start;
            start = start == arr.length-1 ? 0 : start+1;
            return arr[tmp];
        }
        public boolean isEmpty(){
            return size == 0;
        }
    }

    public static void main(String[] args) {
        ArrayQueue arrayQueue = new ArrayQueue(3);
        arrayQueue.push(1);
        arrayQueue.push(2);
        arrayQueue.push(4);
        while (!arrayQueue.isEmpty()){
            System.out.println(arrayQueue.poll()+" ");
        }
    }
}
