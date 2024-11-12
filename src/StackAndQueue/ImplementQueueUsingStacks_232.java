package StackAndQueue;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

/**
 * 容易搞错的是pop和peek方法，如果output栈内仍然有元素，就应该先pop和peek
 * output栈为空了之后才再从input里面倒
 */
public class ImplementQueueUsingStacks_232 {
    public static void main(String[] args) {
        MyQueue myQueue = new MyQueue();
        myQueue.push(1);
        myQueue.push(2);
        System.out.println(myQueue.peek());
        System.out.println(myQueue.pop());
        System.out.println(myQueue.empty());

    }
    static class MyQueue {
        Deque<Integer> input;
        Deque<Integer> output;

        public MyQueue() {
            input = new ArrayDeque<>();
            output = new ArrayDeque<>();
        }

        public void push(int x) {
            input.push(x);
        }

        public int pop() {
            if (output.isEmpty()) {
                in2out();
            }
            return output.pop();
        }

        public int peek() {
            if (output.isEmpty()) {
                in2out();
            }
            return output.peek();
        }

        public void in2out(){
            while(!input.isEmpty()){
                output.push(input.pop());
            }
        }

        public boolean empty() {
            return input.isEmpty() && output.isEmpty();
        }
    }
}
