package zhf.src.basic_class_03;

import java.util.Stack;

/**
 * Created by ZHF on 2018/8/14.
 */
public class GetMinStack {
    public static class MyStack{
        private Stack<Integer> stackData = new Stack<>();
        private Stack<Integer> stackMin = new Stack<>();

        public void push(int num){
            if (stackMin.isEmpty()){
                stackMin.push(num);
            } else {
                if (stackMin.peek()>num){
                    stackMin.push(num);
                } else {
                    stackMin.push(stackMin.peek());
                }
            }
            stackData.push(num);
        }

        public int pop(){
            if (stackData.isEmpty() || stackMin.isEmpty()){
                throw new RuntimeException("this stack is empty!");
            }
            stackMin.pop();
            return stackData.pop();
        }

        public int peek(){
            if (stackData.isEmpty()){
                throw new RuntimeException("this stack is empty!");
            }
            return stackData.peek();
        }
    }
}
