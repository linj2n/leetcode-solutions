package _946;

import java.util.Stack;

public class ValidateStackSequences {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        if (pushed == null || popped == null) {
            return false;
        }
        if (pushed.length != popped.length) {
            return false;
        }
        int curr1 = 0, curr2 = 0;
        Stack<Integer> stack = new Stack<>();
        while (curr1 < pushed.length) {
            if (!stack.isEmpty() && stack.peek().equals(popped[curr2])) {
                stack.pop();
                curr2 ++;
            } else {
                stack.push(pushed[curr1 ++]);
            }
        }
        while (!stack.isEmpty()) {
            if (!stack.pop().equals(popped[curr2 ++])) {
                return false;
            }
        }
        return curr2 == popped.length;
    }
}
