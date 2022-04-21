class MyHashSet {
    boolean[] num;
    public MyHashSet() {
        num = new boolean[1000001];
    }
    
    public void add(int key) {
        num[key] = true;
    }
    
    public void remove(int key) {
        num[key] = false;
    }
    
    public boolean contains(int key) {
        return num[key];
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */