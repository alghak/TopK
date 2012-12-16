package renren.xce.TopK;

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

    /**
     * Construct MinHeap.
     * @param array
     * @throws MinHeapException 
     */
    public MinHeap(long[] array) throws MinHeapException {
        init(array);
    }
    /**
     * Initialize minHeap. Put elements into its array; Set heapSize.
     * @param array  using array to initialize internal array_(deep copy).
     * @throws MinHeapException 
     */
    public void init(long[] array) throws MinHeapException {                
        if (array == null ||
                array.length == 0) {
            throw new MinHeapException("Invalid MinHeap");
        }
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
     * @param index the root of heap that need to maintain heap property.
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
//            long temp = array_[index];
//            array_[index] = array_[least];
//            array_[least] = temp;
            exchange(index, least);
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
//            long temp = array_[0];
//            array_[0] = array_[i];
//            array_[i] = temp;
            exchange(0, i);
            --heapSize_;
            maintainHeapProperty(0);
        }
    }

    public long min() {
        return array_[0];
    }

    public void replaceMin(long l) {
        array_[0] = l;
    }

    void exchange(int i, int j) {
        if (i >= array_.length ||
                j >= array_.length) {
            return;
        }
        long temp = array_[i];
        array_[i] = array_[j];
        array_[j] = temp;
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
    
    public class MinHeapException extends Exception {
        private static final long serialVersionUID = 1L;

        public MinHeapException(String msg) {
            super(msg);
        }
    }
}