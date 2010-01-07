import java.util.ArrayList;


public class PriorityQueue extends ArrayList {
	private Comparable[] array;
	private int index;
	
	public PriorityQueue() {
        array = new Comparable [16];
        index = 0;
    }

    public boolean empty () {
        return index == 0;
    }
    
    public void insert (Comparable item) {
        if (index == array.length) {
            resize();
        }
        array[index] = item;
        index++;
    }
    
    private void resize() {
    	
    }
    
    public Comparable remove () {
        if (index == 0) return null;

        int maxIndex = 0;

        // find the index of the item with the highest priority
        for (int i=1; i<index; i++) {
            if (array[i].compareTo (array[maxIndex]) > 0) {
                maxIndex = i;
            }
        }
        Comparable result = array[maxIndex];

        // move the last item into the empty slot
        index--;
        array[maxIndex] = array[index];
        return result;
   }
    
 
}
