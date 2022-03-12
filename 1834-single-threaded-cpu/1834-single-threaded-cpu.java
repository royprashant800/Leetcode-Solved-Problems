class Solution {
    public int[] getOrder(int[][] tasks) {
        int n = tasks.length;
        int[] res = new int[n];
        int[][] nums = new int[n][3];
        
        for(int i = 0; i < n; i++) 
            nums[i] = new int[] {tasks[i][0], tasks[i][1], i};
        
        Arrays.sort(nums, (a, b) -> (a[0] - b[0]));
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] == b[1] ? a[2] - b[2] : a[1] - b[1]);
        
        int i = 0, k = 0, time = 0;
        while(!pq.isEmpty() || i < n) {
            if(pq.isEmpty()) time = Math.max(time, nums[i][0]);
            while(i < n && time >= nums[i][0]) {
                pq.offer(nums[i++]);
            }
            
            int[] curr = pq.poll();
            time += curr[1];
            res[k++] = curr[2];
        }
        return res; 
    }
}