package renren.xce.TopK;

import java.util.Arrays;

import renren.xce.TopK.MinHeap.MinHeapException;

public class TopK {
    public static void main(String[] args) {
        long[] array = { 432, 543, 2, 432, 745, 432123, 47542, 8696, 997, 654, 98689, 897986 };
        int K = 3;
        
        long[] firstK = new long[K];
        long[] last = new long[array.length - K];
        for (int i = 0; i < K; ++i) {
            firstK[i] = array[i]; 
        }
        for (int i = K; i < array.length; ++i) {
            last[i - K] = array[i];
        }
        
        MinHeap heap = null;
        try {
            heap = new MinHeap(firstK);
        } catch (MinHeapException e) {
            e.printStackTrace();
            return;
        }
        heap.buildHeap();
        
        for (long l : last) {
            if (l > heap.min()) {
                heap.replaceMin(l);
                heap.maintainHeapProperty(0);
            }
        }
        heap.sort();
        long[] topK = heap.dump();
        System.out.println("top K: " + Arrays.toString(topK));
        // verify result 
        Arrays.sort(array);
        System.out.println("sorted array: " + Arrays.toString(array));
    }
}
