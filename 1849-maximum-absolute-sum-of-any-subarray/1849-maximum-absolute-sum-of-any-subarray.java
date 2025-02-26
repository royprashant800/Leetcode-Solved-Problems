class Solution {
    public int maxAbsoluteSum(int[] arr) {
        int n = arr.length;
        int ans = Integer.MIN_VALUE, box1 = 0, box2 = 0;
		
		for(int i=0; i<n; i++) {
			box1 += arr[i];
			box2 += arr[i];
				ans = Math.max(Math.max(box1, ans), Math.abs(box2));
			if(box1 < 0)
				box1 = 0;
			if(box2 > 0)
				box2 = 0;
		}
		return ans;
    }
}