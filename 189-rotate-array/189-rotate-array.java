class Solution {
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        if(k == 0 || k == n)  
            return;
        k = k%n;
        
        int[] res = new int[n];
        for(int i=n-k; i<n; i++)
            res[i-(n-k)] = nums[i];
        for(int j=0; j<n-k; j++)
            res[j+k] = nums[j];
        for(int i=0; i<n; i++)
            nums[i] = res[i];
    }
}