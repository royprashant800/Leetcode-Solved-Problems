class Solution {
    public int triangularSum(int[] nums) {
        List<Integer> li = new ArrayList<>();
        for(int n : nums) li.add(n);
        
        while(li.size() > 1) {
            List<Integer> temp = new ArrayList<>();
            for(int i = 0; i < li.size() - 1; i++) {
                int num = (li.get(i) + li.get(i + 1)) % 10;
                temp.add(num);
            }
            li = temp;
        }
        
        return li.get(0);
    }
}