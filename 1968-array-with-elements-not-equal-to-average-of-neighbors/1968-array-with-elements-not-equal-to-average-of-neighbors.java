class Solution {
    public int[] rearrangeArray(int[] arr) {
        int n = arr.length;
        
        for(int i = 1; i < n - 1; i++) {
            double num = (double)(arr[i - 1] + arr[i + 1]) / 2;
            if(arr[i] == num) {
                int temp = arr[i];
                arr[i] = arr[i + 1];
                arr[i + 1] = temp;
            }
        }
        for(int i = n - 2; i >= 1; i--) {
            double num = (double)(arr[i - 1] + arr[i + 1]) / 2;
            if(arr[i] == num) {
                int temp = arr[i - 1];
                arr[i - 1] = arr[i];
                arr[i] = temp;
            }
        }
        return arr;
    }
}