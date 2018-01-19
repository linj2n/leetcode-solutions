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