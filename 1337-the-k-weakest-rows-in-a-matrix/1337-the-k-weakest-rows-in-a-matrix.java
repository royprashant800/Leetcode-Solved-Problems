class Solution {
    public int[] kWeakestRows(int[][] mat, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> (a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]));
        for(int i = 0; i < mat.length; i++) {
            int ones = 0;
            for(int num : mat[i]) 
                if(num == 1) ones++;
            pq.add(new int[]{ones, i});
        }
        
        int[] res = new int[k];
        for(int i = 0; i < k; i++) {
            int[] a = pq.poll();
            res[i] = a[1];
        }
            
        return res;
    }
}