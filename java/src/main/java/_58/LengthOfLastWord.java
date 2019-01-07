package _58;

public class LengthOfLastWord {
    public int lengthOfLastWord(String s) {
        return solution2(s);
    }
    private int solution1(String s) {
        String[] words = s.split(" ");
        return (words.length == 0) ? 0 : words[words.length - 1].length();
    }
    private int solution2(String s) {
        int length = 0;
        int i = 0;         
        while (i < s.length()) {
            if (s.charAt(i) != ' ') {
                int j = i;
                StringBuilder word = new StringBuilder();
                 while (j < s.length() && s.charAt(j) != ' ') {
                     word.append(s.charAt(j ++));
                 }
                length = word.length();
                i = j;
            }
            i ++;
        }
        return length;
    }
    private int solution3(String s) {
        int length = 0, i = 0;
        while (i < s.length()) {
            int j = i;
            while (j < s.length() && s.charAt(j) != ' ') {
                j ++;
            }
            length = (s.substring(i,j).isEmpty()) ? length : (j - i);
            i = j + 1;
        }
        return length;
    }
}