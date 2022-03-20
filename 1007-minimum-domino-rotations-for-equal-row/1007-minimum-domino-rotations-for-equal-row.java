class Solution {
    public int minDominoRotations(int[] tops, int[] bottoms) {
        int res = Integer.MAX_VALUE;
        
        for(int i = 1; i <= 6; i++) {
            int topRot = 0;
            int bottomRot = 0;
            boolean flag = true;
            for(int j = 0; j < tops.length; j++) {
                if(tops[j] == i || bottoms[j] == i) {
                    if(tops[j] != i) topRot++;
                    if(bottoms[j] != i) bottomRot++;
                } else {
                    flag = false;
                    break;
                }
            }
            if(flag) res = Math.min(topRot, bottomRot);
        }
        return res == Integer.MAX_VALUE ? -1 : res;
    }
}