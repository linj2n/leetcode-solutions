class Solution {
    public int uniqueMorseRepresentations(String[] words) {
        
        List<Character> letters = new ArrayList<Character>(Arrays.asList('a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'));
        
        List<String> code = new ArrayList<String>(Arrays.asList(".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."));
        
        Map<Character,String> MorseMap = new HashMap<>();
        for (int i = 0; i < letters.size(); i++) {
            MorseMap.put(letters.get(i),code.get(i));
        }

        Set<String> transformationsSet = new HashSet<>();
        for (int j =0; j < words.length; j ++) {
            String word = words[j];
            StringBuilder sb = new StringBuilder();
            for (int k = 0 ; k < word.length(); k ++) {
                sb.append(MorseMap.get(word.charAt(k)));
            }
            transformationsSet.add(sb.toString());
        }
        return transformationsSet.size();
    }
}