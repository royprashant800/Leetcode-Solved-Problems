class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int low = 1, high = 1000000000;
        while(low < high) {
            int mid = low + (high - low)/2;
            
            if(isPossible(piles, mid, h))
                high = mid;
            else
                low = mid + 1;
        }
        return low;
    }
    private boolean isPossible(int[] piles, int k, int h) {
        int time = 0;
        for(int x : piles) {
            time += (x - 1)/k + 1;
            if(time > h) 
                break;
        }
        return time <= h;
    }
}