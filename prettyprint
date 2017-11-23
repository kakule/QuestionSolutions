//Print concentric rectangular pattern in a 2d matrix. 
//Let us show you some examples to clarify what we mean
//Example 1:

//Input: A = 4.
//Output:

//4 4 4 4 4 4 4 
//4 3 3 3 3 3 4 
//4 3 2 2 2 3 4 
//4 3 2 1 2 3 4 
//4 3 2 2 2 3 4 
//4 3 3 3 3 3 4 
//4 4 4 4 4 4 4 

//The outermost rectangle is formed by A, then the next outermost is formed by A-1 and so on.
//You will be given A as an argument to the function you need to implement, and you need to return a 2D array.

public class Solution {
	public ArrayList<ArrayList<Integer>> prettyPrint(int a) {
	    
	    ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
	    ArrayList<Integer> tmp = new ArrayList<>();
	    
	    for (int i = 0; i < a; i++) {
	        for (int j = 0; j < a; j++) {
	            if (j == 0) tmp = new ArrayList<>();
	            int val;
	            if (j <= i) val = a - j;
	            else val = a - i;
	            tmp.add(val);
	        }
	        ans.add(tmp);
	    }
	    
	    //copy over to right side
	    for (int i = 0; i < a; i++) {
	        for (int j = 0; j < a; j++) {
	            if (j == 0) {
	                tmp = ans.get(i);
	                continue;
	            }
	            tmp.add(tmp.get(a-1-j));
	        }
	    }
	    
	    //copy top to bottom
	    for (int i = 1; i < a; i++) {
	        ans.add(ans.get(a-1-i));
	    }

	    return ans;
	}
}
