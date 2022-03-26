class Solution {
    public int search(int[] nums, int target) {
        return search(nums, 0, nums.length-1, target);
    }
	static int search(int[] a, int l, int r, int s) {
		while(l <= r) {
			int mid = (l+r)/2;
			
			if(s == a[mid]) 
				return mid;
			
			else if(s > a[mid]) 
				l = mid+1;
			
			else 
				r = mid-1;			
		}
		return -1;
	}
}