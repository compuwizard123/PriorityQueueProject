import java.util.ArrayList;
import java.util.Iterator;

import javax.lang.model.element.Element;


public class PriorityQueue<T extends Comparable<? super T>> extends ArrayList<T> {
	
	public PriorityQueue() {
		super();
    }
    
    public boolean add(T element) {
    	if(element == null) {
    		throw new NullPointerException();
    	}
    	super.add(element);
    	int index = super.size() - 1;
    	while(element.compareTo(super.get((index-1)/2)) < 0) {
    		T temp = super.get((index-1)/2);
    		super.set((index-1)/2, element);
    		super.set(index, temp);
    		index /= 2;
    	}
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
    	
    	T element = super.get(0);
    	T temp = super.remove(super.size()-1);
    	if(super.size() > 0) {
    		super.set(0, temp);
    		percolateDown(0);
    	}
    	return element;
    }
 
    public void percolateDown(int index) {
    	T element = super.get(index);
    	T left = null, right = null;
    	int index2 = -1;
    	int size = super.size();
    	if(2*index + 1 < size) {
    		left = super.get(2*index + 1);
    		if(2*index + 2 >= size) {
    			//left child
        		if(element.compareTo(left) > 0) {
        			index2 = 2*index + 1;
        			super.set(index, left);
        		}
    		} else {
    			//both children
    			right = super.get(2*index + 2);
    			if(right.compareTo(left) < 0) {
        			if(element.compareTo(right) > 0) { 
        				index2 = 2*index + 2;
        				super.set(index, right);
        			}
    			} else {
    				if(element.compareTo(left) > 0) {
    					index2 = 2*index + 1;
    					super.set(index, left);
    				}
    			}
    			
    		}
    		if(index2 != -1) {
    			super.set(index2, element);
    			percolateDown(index2);
    		}
    	}
    }
}
