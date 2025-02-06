class RandomizedSet {
    List<Integer> list;
    public RandomizedSet() {
        list = new ArrayList<>();
    }
    
    public boolean insert(int val) {
        if(!list.contains(val)) {
            list.add(val);
            return true;
        }
        return false;
    }
    
    public boolean remove(int val) {
        for(int i = 0; i < list.size(); i++) {
            if(list.get(i) == val) {
                list.remove(i);
                return true;
            }
        }
        return false;
    }
    
    public int getRandom() {
        double random = Math.random();
        int size = list.size();
        return list.get((int)(random * size));
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */