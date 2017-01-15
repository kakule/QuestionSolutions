//Given a collection of numbers that might contain duplicates, return all possible unique permutations.

public class Solution {
    boolean [] inuse;
    Set<ArrayList<Integer>> uPs = new HashSet<ArrayList<Integer>>();
    ArrayList <Integer> cur = new ArrayList<Integer>();
    ArrayList<ArrayList<Integer>> uniquePerms = new ArrayList<ArrayList<Integer>> ();
	public ArrayList<ArrayList<Integer>> permute(ArrayList<Integer> a) {
		
	    inuse = new boolean [a.size()];
	    permuteHelper(a);
	    uPs.addAll(uniquePerms);
	    uniquePerms.clear();
	    uniquePerms.addAll(uPs);

	    return uniquePerms;
	}
	
	public void permuteHelper(ArrayList<Integer> a) {
	    
	    for (int i = 0; i < a.size(); i++) {
	        if (cur.size() == a.size()) {
	            uniquePerms.add((ArrayList)cur.clone());
	            return;
	        }
	        if (inuse[i])
	            continue;
	        cur.add(a.get(i));
	        inuse[i] = true;
	        permuteHelper(a);
	        cur.remove(cur.size() - 1);
	        inuse[i] = false;
	    }
	}
}