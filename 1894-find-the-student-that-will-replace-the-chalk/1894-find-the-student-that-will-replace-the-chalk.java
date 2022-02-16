class Solution {
    public int chalkReplacer(int[] chalk, int k) {
        int n = chalk.length;
        if(chalk[0] > k) return 0;
        long sum = 0;
        for(int num : chalk) sum += (long)num;
        System.out.println(sum);
        while(sum <= k) {
            k -= sum;
        }
        
        for(int i = 0; i < n; i++) {
            if(chalk[i] > k) 
                return i;
            k -= chalk[i];
        }
        return 0;
    }
}