class Solution {
    public int chalkReplacer(int[] chalk, int k) {
        int n = chalk.length;
        if(chalk[0] > k) return 0;
        long sum = 0;
        for(int num : chalk) sum += (long)num;
        
        long rem = k % sum;
        
        for(int i = 0; i < n; i++) {
            if(chalk[i] > rem) 
                return i;
            rem -= chalk[i];
        }
        return 0;
    }
}