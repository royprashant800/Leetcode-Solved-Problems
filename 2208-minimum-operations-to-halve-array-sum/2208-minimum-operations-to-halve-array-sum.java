class Solution {
    public int halveArray(int[] nums) {
        int n = nums.length, res = 0;
        double sum1 = 0;
        
        for(int i = 0; i < n; i++) 
            sum1 += (double)nums[i];
        
        double sum2 = sum1;
            
        PriorityQueue<Double> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int num : nums)
            pq.add((double)num);
        
        while(sum2 > sum1/2) {
            double num = pq.poll();
            num /= 2;
            res++;
            pq.add(num);
            sum2 -= num;
        }
        return res;
    }
}