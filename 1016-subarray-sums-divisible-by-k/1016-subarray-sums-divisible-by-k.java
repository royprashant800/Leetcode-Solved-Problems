class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        int n = nums.length, res = 0, prefSum = 0;
        Map<Integer, Integer> prevOccCnt = new HashMap<>();
        prevOccCnt.put(0, 1);

        for(int i = 0; i < n; i++) {
            prefSum = (prefSum + nums[i]%k + k)%k;
            if(prevOccCnt.containsKey(prefSum)) res += prevOccCnt.get(prefSum);
            prevOccCnt.put(prefSum, prevOccCnt.getOrDefault(prefSum, 0) + 1);
        }
        return res;
    }
}