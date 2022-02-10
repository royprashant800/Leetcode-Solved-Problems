class Solution {
    public int numberOfWays(String corridor) {
        int mod = 1000000007;
        int n = corridor.length();
        List<Integer> seats = new ArrayList<>();
        for(int i = 0; i < n; i++)
            if(corridor.charAt(i) == 'S')
                seats.add(i);
        
        if(seats.size() == 0 || seats.size() % 2 == 1) return 0; 
        
        int prev = seats.get(1);
        long res = 1;
        for(int i = 2; i < seats.size(); i += 2) {
            res *= (seats.get(i) - prev);
            res %= mod;
            prev = seats.get(i + 1);
        }
        return (int)res;
    }
}