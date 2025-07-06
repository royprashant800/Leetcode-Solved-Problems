class FindSumPairs {
    int[] nums1;
    int[] nums2;
    Map<Integer, Integer> hm = new HashMap<>();
    public FindSumPairs(int[] nums1, int[] nums2) {
        this.nums1 = nums1;
        this.nums2 = nums2;
        for(int x : nums2) {
            IncreaseFreq(x, 1);
        }
    }
    private void IncreaseFreq(int key, int inc) {
        hm.put(key, hm.getOrDefault(key, 0) + inc);
    }
    public void add(int index, int val) {
        IncreaseFreq(nums2[index], -1);
        nums2[index] += val;
        IncreaseFreq(nums2[index], 1);
    }
    
    public int count(int tot) {
        int ct = 0;
        for(int a : nums1) {
            ct += hm.getOrDefault(tot - a, 0);
        }
        return ct;
    }
}
