package _509;

public class FibonacciNumber {
    public int fib(int N) {
        return solution1(N);
    }

    private int solution1(int n) {
        if (n == 0 || n == 1) {
            return n;
        }
        return solution1(n - 1) + solution1(n - 2);
    }

    private int solution2(int n) {
        if (n == 0 || n == 1) {
            return n;
        }
        int a = 0, b = 1, result = 0;
        while (n > 1) {
            result = a + b;
            int temp = b;
            b = result;
            a = temp;
            n --;
        }
        return result;
    }
}
