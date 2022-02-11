class Solution {
    public int maximumGood(int[][] statements) {
        return generate(0, "", statements);     
    }
    private int generate(int ind, String s, int[][] statements) {
        if(ind == statements.length) 
            return check(s, statements);
        
        int bad = generate(ind + 1, s + '0', statements);
        int good = generate(ind + 1, s + '1', statements);
        
        return Math.max(bad, good);
    }
    private int check(String s, int[][] statements) {
        int n = statements.length;
        int count = 0;
        for(int i = 0; i < n; i++) {
            if(s.charAt(i) == '0') continue;
            count++;
            
            for(int j = 0; j < n; j++) {
                if(statements[i][j] == 1 && s.charAt(j) == '0') return 0;
                if(statements[i][j] == 0 && s.charAt(j) == '1') return 0;
            }
        }
        return count;
    }
}