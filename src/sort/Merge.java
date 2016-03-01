package sort;

public class Merge {	
	
	/***********************************
   * Helper methods less() and exch()
   * Algorithms referenced from the course textbook and course web site
   **********************************/
   
   // is v < w ?
   private static boolean less(Comparable v, Comparable w) {
       return (v.compareTo(w) < 0);
   }

  // exchange a[i] and a[j]
   private static void exch(Object[] a, int i, int j) {
       Object swap = a[i];
       a[i] = a[j];
       a[j] = swap;
   }
   
/**
	 * merge sort using Comparable array as input 
	 * @param x - the input array containing scores of words that need to be sorted.
	 * Algorithms referenced from the course textbook and course web site
	 */ 
   
// The merging part of the algorithm
// stably merge a[lo..mid] with a[mid+1..hi] using aux[lo..hi]
   private static void merge(Comparable[] a, Comparable[] aux, int lo, int mid, int hi) {
  	 // copy to aux[]
     for (int k = lo; k <= hi; k++) {
         aux[k] = a[k]; 
     }
     
     // merge back to a[]
     int i = lo, j = mid+1;
     for (int k = lo; k <= hi; k++) {
         if      (i > mid)              a[k] = aux[j++]; 
         else if (j > hi)               a[k] = aux[i++];
         else if (less(aux[j], aux[i])) a[k] = aux[j++];
         else                           a[k] = aux[i++];
     }
   }
 
//The sorting part of the algorithm
	public static void sortMerge (Comparable[] x ) {
		 int N = x.length;
     Comparable[] aux = new Comparable[N];
     
     for (int n = 1; n < N; n = n+n) { // n: subarray size
       for (int i = 0; i < N-n; i += n+n) {	// i: subarray index
      	 int lo = i;
         int m  = i+n-1;
         int hi = Math.min(i+n+n-1, N-1);
         merge(x, aux, lo, m, hi);
        }
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
