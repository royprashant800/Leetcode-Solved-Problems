/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return empty list if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
public class NestedIterator implements Iterator<Integer> {
    List<Integer> res;
    int current;
    public NestedIterator(List<NestedInteger> nestedList) {
        res = new ArrayList<>();
        for(NestedInteger integer : nestedList) {
            helper(integer);
        }  
    }

    @Override
    public Integer next() {
        return res.get(current++);
    }

    @Override
    public boolean hasNext() {
        return current < res.size();
    }
    private void helper(NestedInteger val) {
        if(val.isInteger())
            res.add(val.getInteger());
        else {
            for(NestedInteger integer : val.getList()) {
                helper(integer);
            }
        }   
    }
}

/**
 * Your NestedIterator object will be instantiated  andcalled as such:
 * NestedIterator i = new NestedIterator(nestedList);
 * while (i.hasNext()) v[f()] = i.next();
 */