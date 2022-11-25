class Solution {
    public int sumSubarrayMins(int[] arr) {
	int sum = 0;
	int mod = (int) 1e9 + 7;
	int currentStackValue = 0;

	// int[]{value, count}
	Deque<int[]> stack = new ArrayDeque<>();
	for (int i = 0; i < arr.length; i++) {
		int currentCount = 1;
		int currentValue = arr[i];
		
		while (!stack.isEmpty() && stack.peek()[0] >= currentValue) {
			int[] popped = stack.pop();
			currentStackValue -= popped[1] * popped[0];
			currentCount += popped[1]; // assign all previous count to current
		}
		stack.push(new int[]{currentValue, currentCount});
		currentStackValue += currentValue * currentCount;
		sum = (sum + currentStackValue) % mod;
	}
	return sum;
}
}