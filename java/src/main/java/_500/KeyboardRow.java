// Approach #1 Using extra array.
class Solution {
    public String[] findWords(String[] words) {
        int[] temp = new int[128];
        temp['A'] = 1;temp['a'] = 1;temp['S'] = 1;temp['s'] = 1;temp['D'] = 1;temp['d'] = 1;temp['F'] = 1;temp['f'] = 1;temp['G'] = 1;temp['g'] = 1;temp['H'] = 1;temp['h'] = 1;temp['J'] = 1;temp['j'] = 1;temp['K'] = 1;temp['k'] = 1;temp['L'] = 1;temp['l'] = 1;
        temp['Z'] = 2;temp['z'] = 2;temp['X'] = 2;temp['x'] = 2;temp['C'] = 2;temp['c'] = 2;temp['V'] = 2;temp['v'] = 2;temp['B'] = 2;temp['b'] = 2;temp['N'] = 2;temp['n'] = 2;temp['M'] = 2;temp['m'] = 2;
        
        String[] ans = new String[words.length];
        int i = 0;
        for (String word: words) {
            int cmp = temp[word.charAt[0]];
            boolean tag = true;
            for (char c: word.toCharArray()) {
                if (cmp != temp[c]) {
                    tag = false;
                }
            }
            if (tag) {
                ans[i++] = word;
            }
        }
        return ans;
    }
}
// Approach #2 improve Approach #1
class Solution {
    public String[] findWords(String[] words) {
        int[] temp = new int[128];
        String[] alphArray = {"qwertyuiop","asdfghjkl","zxcvbnm"};
        for (int i = 0; i < alphArray.length; i++) {
            for (char c: alphArray[i].toCharArray()) {
                temp[c] = i; temp[c - 32] = i;
            }
        }

        String[] tempWord = new String[words.length];
        int i = 0;
        for (String word: words) {
            int cmp = temp[word.charAt(0)];
            boolean tag = true;
            for (char c: word.toCharArray()) {
                if (cmp != temp[c]) {
                    tag = false;
                }
            }
            if (tag) {
                tempWord[i++] = word;
            }
        }
        return Arrays.copyOfRange(tempWord,0,i);
    }
}
