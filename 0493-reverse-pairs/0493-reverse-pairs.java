class Solution {
    public int reversePairs(int[] nums) {
        return mergeSort(nums, 0, nums.length - 1);
    }
    private static int mergeSort(int[] nums, int l, int r) {
        int count = 0;
		if(l < r) {
			int mid = l + (r - l)/2;
			count += mergeSort(nums, l, mid);
			count += mergeSort(nums, mid + 1, r);
			count += merge(nums, l, mid, r);
		}
        return count;
	}
	private static int merge(int[] nums, int l, int mid, int r) {
        int count = 0, j = mid + 1;
        for(int i = l; i <= mid; i++) {
            while(j <= r && nums[i] > ((long)2 * nums[j])) j++;
            count += (j - (mid + 1));
        }

		List<Integer> temp = new ArrayList<>();
		int low = l, high = mid + 1;
		while(low <= mid && high <= r) {
			if(nums[low] <= nums[high]) temp.add(nums[low++]);
			else temp.add(nums[high++]);
		}
		while(low <= mid) temp.add(nums[low++]);
		while(high <= r) temp.add(nums[high++]);
		
		for(int i = l; i <= r; i++) {
			nums[i] = temp.get(i - l);
		}
        return count;
	}
}