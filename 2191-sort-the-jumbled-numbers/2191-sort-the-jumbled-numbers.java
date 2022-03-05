class Solution {
    public int[] sortJumbled(int[] mapping, int[] nums) {
        boolean flag = true;
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i <= 9; i++) {
            if(i != mapping[i]) flag = false;
            map.put(i, mapping[i]);
        }
        if(flag) {
            Arrays.sort(nums);
            return nums;
        }
        int[][] res = new int[nums.length][2];
        for(int i = 0; i < nums.length; i++) {
            String s = Integer.toString(nums[i]);
            char[] arr = s.toCharArray();
            
            for(int j = 0; j < arr.length; j++) {
                int num = arr[j] - '0';
                arr[j] = (char)(map.get(num) + '0');
            }
            int temp = Integer.parseInt(new String(arr));
            
            res[i][0] = nums[i];
            res[i][1] = temp;
        }
        
        Arrays.sort(res, (a, b) -> (a[1] - b[1]));
        int[] ans = new int[nums.length];
        for(int i=0; i<nums.length; i++)
            ans[i] = res[i][0];
        return ans;
    }
}