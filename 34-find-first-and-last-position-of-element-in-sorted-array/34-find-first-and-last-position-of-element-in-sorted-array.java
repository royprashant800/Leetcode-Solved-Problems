class Solution {
    public int[] searchRange(int[] nums, int target) {
        int n = nums.length;
        int[] res = new int[2];
        res[0] = first(nums, target, 0, n-1);
        res[1] = last(nums, target, 0, n-1);
        
        return res;
    }
    static int first(int[] a, int x, int l, int r) {
		int res = -1;
		while(l <= r) {
			int mid = (l+r)/2;
			if(x == a[mid]) {
				res = mid;
				r = mid-1;
			}
			else if(x > a[mid])
				l = mid+1;
			else
				r = mid-1;
		}
		return res;
	}
	static int last(int[] a, int x, int l, int r) {
		int res = -1;
		while(l <= r) {
			int mid = (l+r)/2;
			
			if(x == a[mid]) {
				res = mid; 
				l = mid+1;
			}	 
			else if(x > a[mid])  
				l = mid+1;
			else
				r = mid-1;
		}
		return res;
	}
}