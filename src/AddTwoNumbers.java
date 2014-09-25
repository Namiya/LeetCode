public class AddTwoNumbers {
	public class ListNode {
		      int val;
		      ListNode next;
		      ListNode(int x) {
		          val = x;
		          next = null;
		      }
	}
	
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        
		if (l1 == null) return l2;
        if (l2 == null) return l1;
        
        ListNode next1= l1;
        ListNode next2 = l2;
    
        ListNode l = null;
        ListNode next = null;
        
        int carryNum = 0;
        while ((next1 != null) && (next2 != null)){
            int sumNum = next1.val + next2.val + carryNum;
            carryNum = sumNum/10;
            
            ListNode newNode = new ListNode(sumNum%10);
            next1 = next1.next;
            next2 = next2.next;
            if (next == null){
                l = newNode;
                next = newNode;
            }
            else {
                next.next = newNode;
                next = newNode;
            }
        }
        
        if ((next1 == null) && (next2 == null)){
            if (carryNum == 0) return l;
            else {
                next.next = new ListNode(carryNum);
                return l;
            }
        }
        else {
            next1 = (next1 != null) ? next1 : next2;
            while (carryNum != 0){
                int sumNum;
                if (next1 != null){
                    sumNum = carryNum + next1.val;
                    next1 = next1.next;
                }
                else{
                    sumNum = carryNum;
                }
                carryNum = sumNum/10;
                ListNode newNode = new ListNode (sumNum%10);
                next.next = newNode;
                next = newNode;
            }
            next.next = next1;
            return l;
        }
        
    }

}
/*
 		AddTwoNumbers ad = new AddTwoNumbers();
	    AddTwoNumbers.ListNode l1 = ad.new ListNode(0);
	    AddTwoNumbers.ListNode l2 = ad.new ListNode(0);
	    
	    AddTwoNumbers.ListNode l3 = ad.addTwoNumbers(l1, l2);
	    System.out.print("output: ");
	    while (l3 != null){
	    	 System.out.print(l3.val + "->");
	    	 l3 = l3.next;
	    }
*/
