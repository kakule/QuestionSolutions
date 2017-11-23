//Find the kth smallest element in an unsorted array of non-negative integers.

public class Solution {
	// DO NOT MODIFY THE LIST. IT IS READ ONLY
	public int kthsmallest(final List<Integer> a, int k) {
	    if (a == null || a.size() == 0 || k < 1 || k > a.size())
	        return -1;
	    ArrayList<Integer> al = new ArrayList(a);
	    int begin = 0;
	    int end = a.size() - 1;
	    
	    while (begin <= end) {
	        int idx = findIndex(al, begin, end);
	        if (idx == k - 1) {
	            return al.get(idx);
	        } else if (idx < k - 1) {
	            begin = idx + 1;
	        } else {
	            end = idx - 1;
	        }
	    }
	    return 0;
	}
	
        public int findIndex(ArrayList<Integer> a, int start, int end) {    
          int low = start + 1;
          int scan = low;
	    while (scan <= end) {
	        if (a.get(scan) < a.get(start)) {
	            swap(a, low, scan);
	            low++;
	        }
	        scan++;
	    }
	    swap(a, start, low - 1);
	    return low-1;
	}
	
	public void swap(ArrayList<Integer>a, int i, int j) {
	    int tmp = a.get(i);
	    a.set(i, a.get(j));
	    a.set(j, tmp);
	}
}
