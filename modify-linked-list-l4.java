//Given a singly linked list, modify the value of first half nodes such that :

//1st node’s new value = the last node’s value - first node’s current value
//2nd node’s new value = the second last node’s value - 2nd node’s current value,
//and so on …

/**
 * Definition for singly-linked list.
 * class ListNode {
 *     public int val;
 *     public ListNode next;
 *     ListNode(int x) { val = x; next = null; }
 * }
 */
public class Solution {
	public ListNode subtract(ListNode a) {
	    
	    if (a == null)
	        return null;
	        
	   ListNode first = a;
	   ListNode second = a;
	   Stack <ListNode> nodeStack = new Stack<ListNode>();
	   
	   while (first.next != null && first.next.next != null) {
	       first = first.next.next;
	       second = second.next;
	   }
	   
	   //increment by one for start position
	   second = second.next;
	   
	   while (second != null) {
	       nodeStack.push(second);
	       second = second.next;
	   }
	   
	   //reset first pointer
	   first = a;
	   while(!nodeStack.isEmpty()) {
	       second = nodeStack.pop();
	       first.val = second.val - first.val;
	       first = first.next;
	   }
	   
	   return a;
	}
}
