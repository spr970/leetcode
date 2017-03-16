import java.util.Arrays;

public class Addtwonum {
	/**
	 * Definition for singly-linked list.

	 */
	public class ListNode {
     int val;
     ListNode next;
     ListNode(int x) { val = x; }
	}
	
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0;
        ListNode prev = new ListNode(0);
        ListNode firstNode = prev;
        int tmp;
        while (l1 != null || l2 != null || carry !=0) {
        	ListNode curr = new ListNode(0);
        	tmp = carry + ((l1 == null)?0:l1.val) + ((l2 == null)?0:l2.val);
        	curr.val = tmp % 10;
        	carry = tmp/10;
        	prev.next = curr;
        	prev = curr;
        	
        	if (l1 != null)
        		l1 = l1.next;
        	if (l2 != null)
        		l2 = l2.next;
        }
        return firstNode.next;
    }
    public static void main(String[] args) {
//    	int[] input={150,24,79,50,88,345,3};
////    	System.out.println(Arrays.toString(input));
//    	System.out.print(Arrays.toString(twoSum(input,200)));
    	Addtwonum sample = new Addtwonum();
//    	Addtwonum.ListNode l1= sample.new ListNode(2);
//    	Addtwonum.ListNode l12= sample.new ListNode(4);
//    	Addtwonum.ListNode l13= sample.new ListNode(3);
    	
    	Addtwonum.ListNode l2= sample.new ListNode(5);
//    	Addtwonum.ListNode l22= sample.new ListNode(6);
//    	Addtwonum.ListNode l23= sample.new ListNode(4);
//
//    	l1.next=l12;
//    	l12.next=l13;
//    	
//    	l2.next=l22;
//    	l22.next=l23;

    	ListNode lfinal = sample.addTwoNumbers(l2, l2);
    	
    	while (lfinal != null) {
    		System.out.println(lfinal.val);
    		lfinal = lfinal.next;
    	}
    	
    }
}