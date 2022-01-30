class Solution {
    public List<List<Long>> splitPainting(int[][] segments) {
        Map<Integer, Long> map = new TreeMap<>();
        
        for(int[] a : segments) {
            map.put(a[0], map.getOrDefault(a[0], 0L) + a[2]);
            map.put(a[1], map.getOrDefault(a[1], 0L) - a[2]);
        }
            
        List<List<Long>> res = new ArrayList<>();
        long i = 0, sum = 0;
        for(int j : map.keySet()) {
            if(sum > 0)
                res.add(Arrays.asList(i, (long)j, sum));
            sum += map.get(j);
            i = j;
        }
        return res;
    }
}