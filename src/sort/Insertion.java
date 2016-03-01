package sort;

public class Insertion {
	
	/*************************************
	 * The helper methods less() and exch() 
	 * Algorithms referenced from the course textbook and course web site
	 *************************************/
	public static boolean less(Comparable v, Comparable w) {
		return v.compareTo(w) < 0;
	}
	
	public static void exch(Comparable[] a, int i, int j) {
		Comparable t = a[i]; a[i] = a[j]; a[j] = t;
	}

	/**
	 * simple insertion sort
	 * @param x - the input array containing scores of words that need to be sorted.
	 * Algorithms referenced from the course textbook and course web site
	 */
	public static void sortInsert ( Word[] x) {
	
	// sort x[] in increasing order
		int N = x.length;
		for (int i = 1; i < N; i++){
			// Insert x[i] among x[i-1], x[i-2], x[i-3]...
			for (int j = i; j >0 && ((x[j]).getScore() < x[j-1].getScore()); j--) 
				exch(x,j,j-1); 
			}
		}
	
	/**
	 * insertion sort using Comparable
	 * @param x - the input array containing scores of words that need to be sorted.
	 */
	public static void sortComparable (Comparable[] x) {
		
		// Sort x[] in increasing order.
		int N = x.length;
		for (int i = 0; i < N; i++) {		//Insert a[i] among a[i-1], a[i-2], a[i-3]...
			for (int j = i; j > 0 && less(x[j], x[j-1]); j--)
				exch(x, j, j-1);		
			}
		}
	
	/**
	 * binary insertion sort
	 * @param x - the input array containing scores of words that need to be sorted.
	 */
		public static void sortBinary ( Comparable[] x) {
			
//Binary search embedded. A binary search is performed first, and then the array is sorted 			
		int N = x.length;
		for (int i = 1; i < N; i++) {
			Comparable temp =  x[i];
			int lo = 0;
			int hi = i - 1;
			
			while (lo <= hi) {
				int mid = (lo + hi) / 2;
				
				if (temp.compareTo(x[mid]) <  0) {
					hi = mid - 1;
				} else {
					lo = mid + 1;
				}
			}
			
			for (int j = i; j >= lo + 1; j--) {
				x[j] =  x[j-1];
			}
			
			x[lo] = temp;
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
