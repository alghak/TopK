package renren.xce.TopK;

import renren.xce.TopK.MinHeap;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class MinHeapTest 
    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public MinHeapTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( MinHeapTest.class );
    }

    /**
     * Rigourous Test :-)
     */
    public void testApp()
    {
        assertTrue( true );
    }
    
    public void testInitAndDump() {
    	long[] array = {34, 23, 64, 43};
    	MinHeap heap = new MinHeap(array);
    	long[] dumpArray = heap.dump();
    	for (long l: dumpArray) {
    	  System.out.print(l + "\t");
    	}
    	System.out.println();
    	assertEquals(array.length, dumpArray.length);
    }
    
    public void testMaintainHeapProperty() {
      long[] array = {34, 23, 43, 64};
      MinHeap heap = new MinHeap(array);
      heap.maintainHeapProperty(3);
      heap.maintainHeapProperty(2);
      heap.maintainHeapProperty(1);
      heap.maintainHeapProperty(0);
      for (long l: heap.dump()) {
        System.out.print(l + "\t");
      }
      System.out.println();
    }
    
    public void testBuildHeap() {
      long[] array = {34, 23, 43, 64};
      MinHeap heap = new MinHeap(array);
      heap.buildHeap();
      for (long l: heap.dump()) {
        System.out.print(l + "\t");
      }
      System.out.println();
    }
    
    public void testSort() {
      long[] array = {34, 23, 43, 64, 432, 878, 4314, 12, 1, 907, 9713, 234, 12, 38};
      MinHeap heap = new MinHeap(array);
      heap.sort();
      for (long l: heap.dump()) {
        System.out.print(l + "\t");
      }
      System.out.println();
    }
}
