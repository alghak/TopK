package renren.xce.TopK;

import java.util.Arrays;

import renren.xce.TopK.MinHeap.MinHeapException;

public class TopK {
    /**
     * Get the top K elements from array.
     * @param array
     * @param K
     * @return the top K elements. return null if failed.
     */
    public static long[] getTopK(long[] array, int K) {
        if (array == null ||
                array.length < K) {
            return null;
        }
        if (array.length == K) {
            return array;
        }
        long[] firstK = new long[K];
        long[] last = new long[array.length - K];
        // get first K elements, array[0:K). use them to initialize heap & build heap.
        for (int i = 0; i < K; ++i) {
            firstK[i] = array[i]; 
        }
        // array[K:end)
        for (int i = K; i < array.length; ++i) {
            last[i - K] = array[i];
        }
        // build head using first K elements.
        MinHeap heap = null;
        try {
            heap = new MinHeap(firstK);
        } catch (MinHeapException e) {
            e.printStackTrace();
            return null;
        }
        heap.buildHeap();
        // using MinHeap to maintain the top K elements. 
        for (long l : last) {
            if (l > heap.min()) {
                heap.replaceMin(l);
                heap.maintainHeapProperty(0);
            }
        }
        heap.sort();
        return heap.dump();
    }
    
    public static void main(String[] args) {
        long[] array = { 432, 543, 2, 432, 745, 432123, 47542, 8696, 997, 654, 98689, 897986 };
        int K = 3;
        
        if (args.length > 0) {
            K = Integer.parseInt(args[0]);
        }
        
        long[] topK = getTopK(array, K);
        if (topK == null) {
            return;
        }
        System.out.println("top K: " + Arrays.toString(topK));
        // verify result 
        Arrays.sort(array);
        System.out.println("sorted array: " + Arrays.toString(array));
    }
}