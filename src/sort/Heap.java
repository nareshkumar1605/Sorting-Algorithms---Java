package sort;

public class Heap {
		
	/*****************************************
   * Helper methods sink(), less() and exch()
   * Algorithms referenced from the course textbook and course web site
   *****************************************/

   private static void sink(Comparable[] pq, int k, int N) {
       while (2*k <= N) {
           int j = 2*k;
           if (j < N && less(pq, j, j+1)) j++;
           if (!less(pq, k, j)) break;
           exch(pq, k, j);
           k = j;
       }
   }
   
   private static boolean less(Comparable[] pq, int i, int j) {
       return pq[i-1].compareTo(pq[j-1]) < 0;
   }

   private static void exch(Object[] pq, int i, int j) {
       Object swap = pq[i-1];
       pq[i-1] = pq[j-1];
       pq[j-1] = swap;
   }

   // is v < w ?
   private static boolean less(Comparable v, Comparable w) {
       return (v.compareTo(w) < 0);
   }
   
   /**
 	 * heap sort using Comparable
 	 * @param x - the input array containing scores of words that need to be sorted.
 	 * Rearranges the array in ascending order
 	 * Algorithms referenced from the course textbook and course web site
 	 */
	public static void sortHeap ( Comparable[] x) {
		
		int N = x.length;
		for (int k = N/2; k >= 1; k--)
			sink(x, k, N);
		while (N > 1) {
			exch(x, 1, N--);
			sink(x, 1, N);
		}
	}
	
	static boolean isSorted(Comparable[] a) {
    return isSorted(a, 0, a.length - 1);
}
  // is the array sorted from a[lo] to a[hi]
	static boolean isSorted(Comparable[] a, int lo, int hi) {
    for (int i = lo + 1; i <= hi; i++)
        if (less(a[i], a[i-1])) return false;
    return true;
}
}
