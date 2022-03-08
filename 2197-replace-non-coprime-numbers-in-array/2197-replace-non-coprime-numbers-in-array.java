class Solution {  public List<Integer> replaceNonCoprimes(int[] nums) {
        int n = nums.length;
        int i, j;
        boolean b = true;
        for(i = 1, j = 0; i < n; i++){
            int g = gcd(nums[j], nums[i]);
            if (g == 1){
                nums[++j] = nums[i];
            } else {
                nums[j] *= nums[i] / g;
                b = true;
                while(j > 0 && b){
                    g = gcd(nums[j], nums[j-1]);
                    b = g > 1;
                    if(b) {
                        nums[j-1] *= nums[j] / g;
                        j--;
                    }
                }
            }
        }
        var res = new ArrayList<Integer>();
        for(i = 0; i <= j; i++)
            res.add(nums[i]);
        
        return res;
    }
    
    private int gcd(int a, int b) {
        return b > 0 ? gcd(b, a % b) : a;
    }
}