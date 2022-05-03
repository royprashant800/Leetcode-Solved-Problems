class Solution {
    public int findUnsortedSubarray(int[] nums) {
        int n = nums.length;
        int[] arr = new int[n];
        
        for(int i = 0; i < n; i++) arr[i] = nums[i];
        Arrays.sort(arr);
        
        int start, end;
        for(start = 0; start < n; start++)
            if(nums[start] != arr[start]) break;
        
        if(start >= n - 1) return 0;
        for(end = n - 1; end >= 0; end--) 
            if(nums[end] != arr[end]) break;
        
        return end - start + 1;
    }
}