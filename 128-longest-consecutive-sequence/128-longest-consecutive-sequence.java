class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums.length == 0 || nums == null)
			return 0;
		Arrays.sort(nums);
		
		int count = 1, curr = 1;
		for(int i=1; i<nums.length; i++) 
			if(nums[i]==nums[i-1]+1) {
				curr++;
				if(curr > count)
					count = curr;
			}
			else if(nums[i]==nums[i-1]) {
				continue;
			} else {
				curr = 1;
			}
		
		return count;
    }
}