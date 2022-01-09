class Solution {
    private static final int[] DELTAS = { 0, -1, -1, 0, 0, 1, 1, 0 };
    
    public boolean isRobotBounded(String instructions) {
        int x = 0, y = 0, facing = 0;  // at origin, facing north
        for (int i = 0; i < instructions.length(); i++) {
            switch (instructions.charAt(i)) {
                case 'G': x += DELTAS[facing]; y += DELTAS[facing + 1]; break;
                case 'L': facing = (facing + 2) % 8; break;
                case 'R': facing = (facing + 6) % 8; break;
            }
        }
        return facing != 0 || (x == 0 && y == 0);
    }
}