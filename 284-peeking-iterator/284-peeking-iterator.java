// Java Iterator interface reference:
// https://docs.oracle.com/javase/8/docs/api/java/util/Iterator.html

class PeekingIterator implements Iterator<Integer> {
    int i, n;
    List<Integer> li;
	public PeekingIterator(Iterator<Integer> it) {
	    // initialize any member here.
        i = 0;
        li = new ArrayList<>();
        while(it.hasNext()) 
            li.add(it.next());
        n = li.size();
	}
	
    // Returns the next element in the iteration without advancing the iterator.
	public Integer peek() {
        return li.get(i);        
	}
	
	// hasNext() and next() should behave the same as in the Iterator interface.
	// Override them if needed.
	@Override
	public Integer next() {
	    return li.get(i++);
	}
	
	@Override
	public boolean hasNext() {
        System.out.println(i);
	    return i < n;
	}
}