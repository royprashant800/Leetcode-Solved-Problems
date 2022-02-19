class Solution {
    public int minimumDeviation(int[] nums) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> (b - a));
        int min = Integer.MAX_VALUE;
        for(int i : nums) {
            if(i % 2 != 0) i *= 2;
            min = Math.min(min, i);
            pq.add(i);
        }
        
        int res = Integer.MAX_VALUE;
        while(pq.peek() % 2 == 0) {
            int max = pq.poll();
            res = Math.min(res, max - min);
            max /= 2;
            min = Math.min(min, max);
            pq.add(max);
        }
        return Math.min(res, pq.peek() - min);
    }
}