class Solution {
    public int longestPalindrome(String[] words) {
        Map<String, Integer> map = new HashMap<>();
        for(String word : words) 
            map.put(word, map.getOrDefault(word, 0) + 1);
        
        boolean middle = false;
        int res = 0;
        
        HashSet<String> used = new HashSet<>();
        for(String key : map.keySet()) {
            if(used.contains(key))
                continue;
            int count = map.get(key);
            if(key.charAt(0) == key.charAt(1)) {
                res += count;
                if(count%2 == 1) {
                    middle = true;
                    res -= 1;
                }
            } else {
                String opp = new StringBuilder(key).reverse().toString();
                res += 2 * Math.min(count, map.getOrDefault(opp, 0));
                used.add(opp);
            }
        }
        if(middle) res++;
        return 2 * res;
    }
}