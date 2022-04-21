class MyHashSet {
    int[] nums;
    public MyHashSet() {
        nums = new int[1000001];
    }
    
    public void add(int key) {
        if(nums[key] == 0)
            nums[key]++;
    }
    
    public void remove(int key) {
        if(nums[key] == 1)
            nums[key]--;
    }
    
    public boolean contains(int key) {
        if(nums[key] == 1) return true;
        return false;
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */