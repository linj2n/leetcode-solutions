// Approach #1 Presorting
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap <String,ArrayList<String>> h = new HashMap<> ();
        for (String e: strs) {
            char[] charArr = e.toCharArray();
            Arrays.sort(charArr);
            String str = String.valueOf(charArr);
            if ( !h.containsKey(str) ) h.put(str,new ArrayList<String>());
            h.get(str).add(e);
        }
        return new ArrayList(h.values());
    }
}

// Approach #2 
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap <String,List> h = new HashMap<> ();
        int[] counts = new int[26];
        for (String e: strs) {
            System.out.print(e + " ");
            Arrays.fill(counts,0);
            for (char c: e.toCharArray()) {
                counts[c - 'a'] ++;
            }
            StringBuilder sb = new StringBuilder("");
            for (int i: counts) {
                sb.append(i);
            }
            String str = sb.toString();
            if (!h.containsKey(str)) h.put(str,new ArrayList());
            h.get(str).add(e);
        }
        return new ArrayList(h.values());
    }
}
