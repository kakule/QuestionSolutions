//Given an array, find the next greater element G[i] for every element A[i] in the array.
//The Next greater Element for an element A[i] is the first greater element on the right side of A[i] in array. 
//More formally,
//G[i] for an element A[i] = an element A[j] such that 
//    j is minimum possible AND 
//    j > i AND
//    A[j] > A[i]
//Elements for which no greater element exist, consider next greater element as -1.

//Example:
//Input : A : [4, 5, 2, 10]
//Output : [5, 10, 10, -1]
//Example 2:
//Input : A : [3, 2, 1]
//Output : [-1, -1, -1]

public class Solution {
	public ArrayList<Integer> nextGreater(ArrayList<Integer> a) {
	    Stack <Integer> stack = new Stack<>();
	    HashMap<Integer, ArrayList<Integer>> cache = new HashMap<>();
	    ArrayList<Integer> ans = new ArrayList<>();
	    
	    if (a == null || a.size() == 0) return ans;
	    
	    stack.push(a.get(0));
	    
	    for (int i = 1; i < a.size(); i++) {
	        int nexttoconsider = a.get(i);
	        
	        if (!stack.isEmpty()) {
	            int tofind = stack.pop();
	            
	            while (tofind < nexttoconsider) {
	                //found the next greater than
	                ArrayList<Integer> tmp = cache.get(tofind);
	                if (tmp == null) tmp = new ArrayList<Integer>();
	                tmp.add(nexttoconsider);
	                cache.put(tofind, tmp);
	                if (stack.isEmpty()) break;
	                tofind = stack.pop(); // consider next candidate on stack
	            }
	            if (tofind >= nexttoconsider)
	                stack.push(tofind);
	        }
	        
	        stack.push(nexttoconsider);
	    }
	    
	    for (int i = 0; i < a.size(); i++) {
              int val = -1;
	        if (cache.containsKey(a.get(i))) {
	            ArrayList<Integer> tmp = cache.get(a.get(i));
	            for (int j = 0; j < tmp.size(); j++) {
	                if (tmp.get(j) > -1) {
	                    val = tmp.get(j);
	                    tmp.set(j, -2);
	                    break;
	                }
	            }
	        }
	        ans.add(val);
	    }
	    
	    return ans;
	}
}
