package _155;

import java.util.Stack;

class MinStack {
    private Stack<Integer> stack ;
    private Stack<Integer> cache ;
    private int min ;
    /** initialize your data structure here. */
    public MinStack() {
        stack = new Stack<>();
        cache = new Stack<>();
        min = Integer.MAX_VALUE;
    }

    public void push(int x) {
        stack.push(x);
        min = Math.min(x, min);
    }

    public void pop() {
        if (min == stack.pop()) {
            min = Integer.MAX_VALUE;
            while (!stack.isEmpty()) {
                min = Math.min(stack.peek(), min);
                cache.push(stack.pop());
            }
            while (!cache.isEmpty()) {
                stack.push(cache.pop());
            }
        }
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return min;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
