package _13;
import java.util.*;

public class RomanToInteger {
    public int romanToInt(String s) {
        Map<String,Integer> map = new HashMap<>();
        map.put("I",1);
        map.put("V",5);
        map.put("X",10);
        map.put("L",50);
        map.put("C",100);
        map.put("D",500);
        map.put("M",1000);
        map.put("IV",4);
        map.put("IX",9);
        map.put("XL",40);
        map.put("XC",90);
        map.put("CD",400);
        map.put("CM",900);
        int i = 0,sum = 0;
        while (i < s.length()) {
            String single = s.substring(i,i + 1);
            String doppio = (i != s.length() -1) ? s.substring(i,i + 2) : "";
            int value = 0;
            if (map.containsKey(doppio)) {
                value = map.get(doppio);
                i += 2;
            } else {
                value = map.get(single);
                ++ i;
            }
            sum += value;
        }
        return sum;
    }
}