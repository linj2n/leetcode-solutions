package _509;

import java.util.HashMap;
import java.util.Map;

public class FibonacciNumber {

    private Map<Integer, Integer> map = new HashMap<>();

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
        if (map.containsKey(n)) {
            return map.get(n);
        }
        int res = solution2(n - 1) + solution2(n - 2);
        map.put(n, res);
        return res;
    }

    private int solution3(int n) {
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
