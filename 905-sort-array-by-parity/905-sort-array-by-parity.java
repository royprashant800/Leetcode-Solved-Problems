class Solution {
    public int[] sortArrayByParity(int[] nums) {
        int n = nums.length;
        int[] res = nums;
        int i=0, j = 1;
        while(i < n && j < n) {
            if(res[i]%2 == 1 && res[j]%2 == 0) {
                swap(res, i, j);
                i++; j++;   
            } else if(res[i]%2 == 0 && res[j]%2 == 1) {
                i++;
            } else {
                j++;
            }
        }
        return res;
    }
    private void swap(int[] res, int i, int j) {
        int temp = res[i];
        res[i] = res[j];
        res[j] = temp;
    }
}