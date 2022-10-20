class Solution {
    public int rotatedDigits(int n) {
        Boolean[] isRotatable = new Boolean[n + 1];
        int ans = 0;
        for(int i = 0; i <= n; i++) {
            if(i < 10) {
                if(i == 2 || i == 5 || i == 6 || i == 9) {
                    ans++;
                    isRotatable[i] = true;
                } else if(i == 0 || i == 1 || i == 8) {
                    isRotatable[i] = false;
                }
            } else {
                Boolean a = isRotatable[i / 10];
                Boolean b = isRotatable[i % 10];
                if(a == null || b == null) continue;
                if(a || b) {
                    isRotatable[i] = true;
                    ans++;
                } else isRotatable[i] = false;
            }
        }
        return ans;
    }
}