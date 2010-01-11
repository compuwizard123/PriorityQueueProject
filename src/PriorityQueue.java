import java.util.ArrayList;
import java.util.Iterator;


public class PriorityQueue<T extends Comparable<? super T>> extends ArrayList<T> {
	
	public PriorityQueue() {
		super();
    }
    
    public boolean add(T element) {
    	if(element == null) {
    		throw new NullPointerException();
    	}
    	
    	super.add(element);
    	return true;
    }
    
    public boolean offer(T o) {
        return add(o);
    }
    
    public T peek() {
    	if(super.isEmpty()) {
    		return null;
    	}
    	return super.get(0);
    }
    
    public T poll() {
    	if(super.isEmpty()) {
    		return null;
    	}
    	
    	T temp = super.get(0);
    	remove(temp);
    	return temp;
    }
    
    public boolean remove(T element) {
        Iterator<T> i = super.iterator();
        while(i.hasNext()) {
        	if(i.equals(element)) {
        		i.remove();
        		return true;
        	}
        	i.next();
        }
        return false;
    }
 
}
