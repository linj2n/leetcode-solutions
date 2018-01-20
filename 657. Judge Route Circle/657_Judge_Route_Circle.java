// Approach #1 Using HashMap
// Runtime: 48ms
class Solution {
    public boolean judgeCircle(String moves) {
        HashMap <Character,Integer> h = new HashMap<>();
        h.put('L',0);h.put('R',0);h.put('U',0);h.put('D',0);
        for (int i = 0; i < moves.length(); i++) {
            char currChar = moves.charAt(i);
            int temp = h.get(currChar) + 1;
            h.put(currChar,temp);
        }
        return h.get('L').equals(h.get('R'))  && h.get('U').equals(h.get('D'));
    }
}

// Approach #2 Convert the String to a new char array.
// Runtime: 15ms
class Solution {
    public boolean judgeCircle(String moves) {
        char [] strArr = moves.toCharArray();   
        int v = 0, h = 0;
        for (int i = 0; i < strArr.length; i++) {
            if (strArr[i] == 'L') {
                h ++;
            }else if (strArr[i] == 'R') {
                h --;
            }else if (strArr[i] == 'U') {
                v ++;
            }else if (strArr[i] == 'D') {
                v --;
            }
        }
        return v == 0 && h == 0;
    }

}
// Approach #3 Use extra array that storing the ocurr times and check if their value are eqaul or not. 
// Runtime: 9ms
class Solution {
    public boolean judgeCircle(String moves) {
        int [] temp = new int[128];
        for (char c: moves.toCharArray()) {
            temp[c] ++;
        }
        return temp['L'] == temp['R'] && temp['U'] == temp['D'];
    }
}

