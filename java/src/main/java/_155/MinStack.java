package _155;

import java.util.Stack;

class MinStack {

    private Stack<Integer> stack = new Stack<>();
    private Stack<Integer> monotStack = new Stack<>();
    /** initialize your data structure here. */
    public MinStack() {

    }

    public void push(int x) {
        if (stack.isEmpty() || monotStack.peek() >= x) {
            monotStack.push(x);
        }
        stack.push(x);
    }

    public void pop() {
        // 判断条件写成 monotStack.peek() == stack.pop() 会出错
        if (monotStack.peek().equals(stack.pop())) {
            monotStack.pop();
        }
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return monotStack.peek();
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