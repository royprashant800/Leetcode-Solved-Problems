class Solution {
    public String kthLargestNumber(String[] nums, int k) {
        Arrays.sort(nums, (a, b) -> {
           if(a.length() > b.length())
               return -1;
            else if(a.length() < b.length())
                return 1;
            else
                return b.compareTo(a);
        });
        return nums[k - 1];
    }
}