class Solution {
    public boolean find132pattern(int[] nums) {
        int n = nums.length;
        int[] min = new int[n];
        min[0] = nums[0];
        for(int i=1; i<n; i++) 
            min[i] = Math.min(min[i -1], nums[i]);
        
        Stack<Integer> st = new Stack<>();
        for(int j=n-1; j>=0; j--) {
            if(nums[j] > min[j]) {
                while(!st.isEmpty() && st.peek() <= min[j])
                    st.pop();
                if(!st.isEmpty() && st.peek() < nums[j])
                    return true;
                st.push(nums[j]);
            }
        }
        return false;
    }
}