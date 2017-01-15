// Find the kth smallest element in an unsorted array of non-negative integers.

public class Solution {
	// DO NOT MODIFY THE LIST. IT IS READ ONLY
	public int kthsmallest(final List<Integer> a, int k) {
	    if (a.size() == 0)
	        return -1;
	    if (a.size() == 1)
	        return a.get(0);
	    int pividx = 0;
	    int low = 0;
	    int high = a.size() - 1;
	    ArrayList<Integer> b = new ArrayList (a);
	    while (low <= high) {
	        pividx = pivot(b, low, high);
	        if (pividx == (k-1)) {
	            return b.get(pividx);
	        } else if (pividx < (k-1)) {
	            low = pividx + 1;
	        } else {
	            high = pividx - 1;
	        }
	    }

	    return -1;
	}
	
	public int pivot(ArrayList<Integer> a, int low, int high) {
	    
	    int pivot = a.get(low);
	    int j = high;
	    int i = low;
	    int scanner = low;
	    while (scanner <= j) {
	       if (a.get(scanner) < pivot) {
	           swap(a, i, scanner);
	           scanner++;
	           i++;
	       } else if (a.get(scanner) == pivot) {
	           scanner++;
	       } else {
	           swap(a, scanner, j);
	           j--;
	       }
	   }
	   
	   return scanner - 1;
	}
	
	public void swap(ArrayList<Integer> a, int i, int j) {
	    int temp = a.get(i);
	    a.set(i, a.get(j));
	    a.set(j, temp);

	}
}
