package zhf.src.basic_class_03;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Created by ZHF on 2018/8/14.
 */
public class StackAndQueueConvert {
    public static class TwoStacksQueue{
        private Stack<Integer> stackPush;
        private Stack<Integer> stackPop;

        public TwoStacksQueue(){
            this.stackPop = new Stack<>();
            this.stackPush = new Stack<>();
        }

        public boolean isEmpty(){
            return stackPop.isEmpty()&&stackPush.isEmpty();
        }

        public void offer(Integer num){
            stackPush.push(num);
        }
        public Integer poll(){
            if (stackPush.isEmpty() && stackPop.isEmpty()){
                throw new RuntimeException();
            } else if (stackPop.isEmpty()){
                while (!stackPush.isEmpty()){
                    stackPop.push(stackPush.pop());
                }
            }
            return stackPop.pop();
        }
        public Integer peek(){
            if (stackPop.isEmpty() && stackPush.isEmpty()){
                throw new RuntimeException();
            } else if (stackPop.isEmpty()){
                while (!stackPush.isEmpty()){
                    stackPop.push(stackPush.pop());
                }
            }
            return stackPop.peek();
        }
    }

    public static class TwoQueueStack{

        private Queue<Integer> data;
        private Queue<Integer> help;

        public TwoQueueStack(){
            help = new LinkedList<>();
            data = new LinkedList<>();
        }

        public void push(Integer num){
            data.offer(num);
        }
        public Integer pop(){
            if (data.isEmpty()){
                throw new RuntimeException("this stack is empty");
            }
            while (data.size()>1){
                help.offer(data.poll());
            }
            Integer res = data.poll();
            swap();
            return res;
        }

        public Integer peek(){
            if (data.isEmpty()){
                throw new RuntimeException();
            }
            while (data.size() != 1){
                help.offer(data.poll());
            }
            Integer res = data.poll();
            help.offer(res);
            swap();
            return res;
        }

        public boolean isEmpty(){
            return data.isEmpty();
        }

        public void swap(){
            Queue<Integer> tmp = data;
            data = help;
            help = tmp;
        }
    }

    public static void main(String[] args) {
        TwoQueueStack twoQueueStack = new TwoQueueStack();
        twoQueueStack.push(1);
        twoQueueStack.push(2);
        twoQueueStack.push(4);
        twoQueueStack.push(8);
        while (!twoQueueStack.isEmpty()){
            System.out.println(twoQueueStack.pop());
        }

        TwoStacksQueue twoStacksQueue = new TwoStacksQueue();
        twoStacksQueue.offer(1);
        twoStacksQueue.offer(2);
        twoStacksQueue.offer(3);
        twoStacksQueue.offer(5);
        while (!twoStacksQueue.isEmpty()){
            System.out.println(twoStacksQueue.poll());
        }

    }
}
