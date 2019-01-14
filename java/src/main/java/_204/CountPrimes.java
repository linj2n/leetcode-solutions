package _204;

public class CountPrimes {
    public int countPrimes(int n) {
        boolean[] notPrimeSet = new boolean[n];
        int count = 0;
        for (int i = 2; i < n; i ++) {
            if (!notPrimeSet[i]) {
                count ++;
                for (int j = 2; i * j < n; j ++) {
                    notPrimeSet[i * j] = true;
                }
            }
        }
        return count;
    }
}
