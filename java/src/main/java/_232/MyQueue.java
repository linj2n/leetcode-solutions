package _232;

import java.util.Stack;

class MyQueue {
    private Stack<Integer> s1 ;
    private Stack<Integer> s2 ;

    private void s2ToS1() {
        while (!s2.isEmpty()) {
            s1.push(s2.pop());
        }
    }
    private void s1ToS2() {
        while (!s1.isEmpty()) {
            s2.push(s1.pop());
        }
    }
    /** Initialize your data structure here. */
    public MyQueue() {
        s1 = new Stack<>();
        s2 = new Stack<>();
    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        s1ToS2();
        s1.push(x);
        s2ToS1();
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        return s1.pop();
    }

    /** Get the front element. */
    public int peek() {
        return s1.peek();
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return s1.isEmpty();
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */
