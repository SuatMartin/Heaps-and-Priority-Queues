package structures;

import java.util.Comparator;
import java.util.Iterator;

public class StudentArrayHeap<P, V> extends AbstractArrayHeap<P, V> {
  public StudentArrayHeap(Comparator<P> comparator) {
		super(comparator);
	}
  public int getLeftChildOf(int index) throws IndexOutOfBoundsException{
		if (index < 0){
       throw new IndexOutOfBoundsException();
    }
		return ((2*index) + 1);
	}
  public int getRightChildOf(int index) throws IndexOutOfBoundsException{
		if (index < 0) {
      throw new IndexOutOfBoundsException();
    }
		return ((2*index) + 2);
  }
  public int getParentOf(int index) throws IndexOutOfBoundsException{
		if (index < 0) {
      throw new IndexOutOfBoundsException();
    }
    return ((index - 1) / 2);
  }
  public void bubbleUp(int index) {
		Entry<P, V> upping = heap.get(index);
		int curr = index;
		int parentOfCurr = (curr-1)/2;
    while ((curr > 0) && (getComparator().compare(upping.getPriority(), heap.get(parentOfCurr).getPriority()) > 0)) {
			heap.set(curr, heap.get(parentOfCurr));
			curr = parentOfCurr;
			parentOfCurr = (curr-1)/2;
		}
		heap.set(curr, upping);	
  }
  public void bubbleDown(int index) {
		Entry<P, V> upping = heap.get(index);
    int largerChild;
    int curr = index; 
    int left = (2*index) + 1; 
    int right = (2*index) + 2;
		while (left <= heap.size()-1) {
			if (right <= heap.size()-1 && 
				getComparator().compare(heap.get(left).getPriority(), heap.get(right).getPriority()) < 0)
				largerChild = right; 
			else
				largerChild = left;
			if (getComparator().compare(upping.getPriority(), heap.get(largerChild).getPriority()) >= 0)
				break;
			heap.set(curr, heap.get(largerChild));
			curr = largerChild;
			left = (curr*2)+1;
			right = (curr*2)+2;
		}
		heap.set(curr, upping);
	}
}
