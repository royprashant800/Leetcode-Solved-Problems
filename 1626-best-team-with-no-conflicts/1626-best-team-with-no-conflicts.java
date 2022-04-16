class Solution {
    public int bestTeamScore(int[] s, int[] a) {
        int n = s.length;
        List<Pair> lp = new ArrayList<>();
        for(int i = 0; i < n; i++)
            lp.add(new Pair(a[i], s[i]));
        
        Collections.sort(lp, new Comparator<Pair>() {
            public int compare(Pair a, Pair b) {
                if(a.age == b.age) return a.score - b.score;
                return a.age - b.age;
            }
        });
        
        int[] dp = new int[n];
        dp[0] = lp.get(0).score;
        int res = dp[0];
        for(int i = 1; i < n; i++) {
            int max = lp.get(i).score;
            for(int j = 0; j < i; j++) {
                if(lp.get(i).score >= lp.get(j).score)
                    max = Math.max(max, dp[j] + lp.get(i).score);
            }
            dp[i] = max;
            res = Math.max(res, dp[i]);
        }
        return res;
    }
}

class Pair {
    int age;
    int score;
    public Pair(int age, int score) {
        this.age = age;
        this.score = score;
    }
}