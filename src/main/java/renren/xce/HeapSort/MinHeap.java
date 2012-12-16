package renren.xce.HeapSort;

import java.util.ArrayList;

/**
 * Min-Heap implementation.
 *
 */

public class MinHeap 
{
	private long[] array_;
	/**
	 * Before sort, heapSize = array.length
	 * When doing sort, heapSize minus 1 each time as the minimum element is put back.
	 */
	private int heapSize_;
	
	public MinHeap(long[] array) {
	  init(array);
	}
	/**
	 * Initialize minHeap. Put elements into its array; Set heapSize.
	 * @param array  using array to initialize internal array_(deep copy).
	 */
	public void init(long[] array) {
	  this.array_ = new long[array.length];
		// deep copy array.
		for (int i = 0; i < array.length; ++i) {
		  this.array_[i] = array[i];
		}
	  this.heapSize_ = this.array_.length;
	}
	/**
	 * Dump elements stored in MinHeap.
	 * @return elements in heap.
	 */
	public long[] dump() {
	  int length = this.array_.length;
		long[] array = new long[length];
		for (int i = 0; i < length; ++i) {
		  array[i] = this.array_[i];
		}
		return array;
	}
	/**
	 * Maintains the min-heap property of heap rooted at index.
	 * Assumption: sub-heap rooted at left and right child of index
	 * is all min-heap, but not the heap rooted at index.
	 * @param index
	 */
	public void maintainHeapProperty(int index) {
	  if (index >= this.heapSize_) {
	    return;
	  }
		int left = leftChildIndex(index);
		int right = rightChildIndex(index);
		int least = index;
		if (left < this.heapSize_ &&
		    this.array_[left] < array_[index]) {
		  least = left;
		}
		if (right < this.heapSize_ &&
		    array_[right] < array_[least]) {
		  least = right;
		}
		if (least != index) {
		  long temp = array_[index];
		  array_[index] = array_[least];
		  array_[least] = temp;
		  maintainHeapProperty(least);
		}
	}
	
	public void buildHeap() {
		for (int i = heapSize_ / 2; i >= 0; --i) {
		  maintainHeapProperty(i);
		}
	}
	
  public void sort() {
    buildHeap();
    for (int i = array_.length -1; i >= 1; --i) {
      long temp = array_[0];
      array_[0] = array_[i];
      array_[i] = temp;
      --heapSize_;
      maintainHeapProperty(0);      
    }
  }
    
    public long min() {
      // if array_ is null
      // or array_ is empty
      // what should i do?
    	return array_[0];
    }
    
    public void replaceMin(long l) {
    	array_[0] = l;
    }
    
    static int parentIndex(int i) {
      return (i - 1) / 2;
    }
    
    static int leftChildIndex(int i) {
      return i * 2 + 1;
    }
    
    static int rightChildIndex(int i) {
      return (i + 1) * 2;
    }
    
}
/**
public class MinHeap<T> 
{
	public void init(ArrayList<T> array) {
		
	}
	
	public ArrayList<T> dump() {
		ArrayList<T> array = new ArrayList<T>();
		return array;
	}
	
	public void makeHeapify(int parent) {
		
	}
	
	public void buildHeap() {
		
	}
	
    public void sort() {
    	
    }
    
    public void min() {
    	
    }
    
    public void replaceMin(T t) {
    	
    }
    
}
**/