class Solution {
    public boolean wordPattern(String pattern, String s) {
        Map<Character, String> map = new HashMap<>();
        Set<Character> patternSet = new HashSet<>();
        Set<String> wordSet = new HashSet<>();
        String[] words = s.split(" ");
        
        for(Character c : pattern.toCharArray())
            patternSet.add(c);
        
        for(String str : words)
            wordSet.add(str);
        
        if(pattern.length() != words.length || patternSet.size() != wordSet.size()) 
            return false;
        
        for(int i=0; i<words.length; i++) {
            if(map.containsKey(pattern.charAt(i))) {
                if(!map.get(pattern.charAt(i)).equals(words[i]))
                    return false;
            } else {
                map.put(pattern.charAt(i), words[i]);
            }
        }
        return true;            
    }
}