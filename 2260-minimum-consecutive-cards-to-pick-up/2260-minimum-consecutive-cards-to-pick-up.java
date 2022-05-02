class Solution {
    public int minimumCardPickup(int[] cards) {
        int res = Integer.MAX_VALUE;
        Map<Integer, List<Integer>> map = new HashMap<>();
        for(int i = 0; i < cards.length; i++) {
            if(map.get(cards[i]) == null) map.put(cards[i], new ArrayList<>());
            map.get(cards[i]).add(i);
        }
        for(List<Integer> li : map.values()) {
            if(li.size() > 1) {
                for(int i = 1; i < li.size(); i++) {
                    int temp = li.get(i) - li.get(i - 1) + 1;
                    res = Math.min(res, temp);
                }
            }
        }
        return res == Integer.MAX_VALUE ? -1 : res;
    }
}