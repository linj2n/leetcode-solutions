// Approach #1 Use HashSet
// Runtime: 85 ms
class Solution {
    public int distributeCandies(int[] candies) {
        HashSet <Integer> h = new HashSet<>();
        for (int e: candies)
            h.add(e);
        return h.size() < candies.length/2 ? h.size() : candies.length/2;
    }
}

// Approach #2 
// Runtime: 30 ms
class Solution {
    public int distributeCandies(int[] candies) {
        boolean[] mark = new boolean[200001];
        int kCount = 0, size = candies.length,halfSize = size / 2;
        for (int i = 0; i < size && kCount < halfSize; i++ ) {
            candies[i] += 100000;
            if (!mark[candies[i]]) {
                kCount ++;
                mark[candies[i]] = true;
            }
        }
        return kCount < halfSize ? kCount : halfSize;
    }
}
