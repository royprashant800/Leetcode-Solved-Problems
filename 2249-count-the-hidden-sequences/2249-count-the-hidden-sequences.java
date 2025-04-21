class Solution {
    public int numberOfArrays(int[] differences, int lower, int upper) {
        long min = lower;
        long max = lower;
        long el = lower;
        for(int num : differences) {
            el += num;
            min = Math.min(min, el);
            max = Math.max(max, el);
        }
        long res = (upper - lower) - (max - min) + 1;
        if(res < 0) res = 0;
        return (int)res;
    }
}