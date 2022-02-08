class Solution {
    public int addDigits(int num) {
        int temp1 = num;
        while(temp1 >= 10) {
            temp1 = digitSum(temp1);
        }
        return temp1;
    }
    private static int digitSum(int num) {
        int res = 0;
        while(num > 0) {
            res += (num % 10);
            num /= 10;
        }
        return res;
    }
}