class Solution {

	/*
	 *
	 * Time Complexity: O(N*100 + M*100) = O(N+M), N = the length of the nums array,
	 * M = the length of the queries array
	 *
	 * Space Complexity: O(N*101) = O(N)
	 *
	 */
	public int[] minDifference(int[] nums, int[][] queries) {

		int[][] preNumberCnt = new int[nums.length][101];
		int[] digCnt = new int[101];
		// count how many times a number existed between 0th ~ ith elements of the nums
		// array.
		for (int i = 0; i < nums.length; i++) {
			digCnt[nums[i]]++;
			for (int j = 1; j < 101; j++)
				preNumberCnt[i][j] = digCnt[j];
		}
		int[] ans = new int[queries.length];
		for (int i = 0; i < queries.length; i++) {
			// we can know how many times a number existed in the query interval
			// by counting preNumberCnt[end]- preNumberCnt[start-1]
			int pre = -1;
			int min = Integer.MAX_VALUE;
			if (queries[i][0] != 0) {
				for (int j = 1; j < 101; j++) {
					// If we know which numbers existed in the query interval and the numbers are
					// ordered,
					// we can check the gap between each existing number to get the Minimum Absolute
					// Difference
					if (preNumberCnt[queries[i][1]][j] - preNumberCnt[queries[i][0] - 1][j] != 0) {
						if (pre != -1) {
							min = Math.min(min, j - pre);
						}
						pre = j;

					}
				}

			} else {
				for (int j = 1; j < 101; j++) {
					if (preNumberCnt[queries[i][1]][j] != 0) {
						if (pre != -1) {
							min = Math.min(min, j - pre);
						}
						pre = j;
					}
				}
			}

			ans[i] = min == Integer.MAX_VALUE ? -1 : min;
		}
		return ans;
	}
}