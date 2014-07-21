	
public class SortList {

	static class ListNode {
	      int val;
	      ListNode next;
	      ListNode(int x) {
	          val = x;
	          next = null;
	      }
	  }
	
	ListNode sortHead;
	ListNode sortTail;
	ListNode head;
	
	
	//time limit exceeded
    public ListNode sortList1(ListNode head) {
    	ListNode node;
    	sortHead = head;
        
        if (head == null) return head;
        if (head.next == null) return head;
        else sortTail = head.next;
        if (sortTail.next == null) return head;
        else node = sortTail.next;
        if (sortTail.val < sortHead.val)
        {
            sortTail.next = sortHead;
            sortHead.next = node;
            sortHead = sortTail;
            sortTail = sortHead.next;
        }

        while (node != null)
        {
            sortTail.next = node.next;
            insertNode(node);
            node = sortTail.next;
        }
        return sortHead;
    }

    private void insertNode (ListNode node){
        ListNode pre;
        ListNode next;
        
        if (node.val < sortHead.val)    
        {
            next = node.next;
            node.next = sortHead;
            sortHead = node;
            return;
        }
        
        next = sortHead.next;
        pre = sortHead;
        while (next != sortTail.next)
        {
            if (node.val < next.val)
            {
                node.next = next;
                pre.next = node;
                return;
            }
            
            pre = next;
            next = next.next;
        }
        
        node.next = sortTail.next;
        sortTail.next = node;
        sortTail = node;
        return;
    }
    

    //better than sortList1, but still time limit exceeded!
    public ListNode sortList2(ListNode head) {
 
    	sortHead = head;
    	this.head = head;
        
        if (head == null) return head;
        if (head.next == null) return head;
        
        sortHead = null;
        while (this.head != null)
        {
        	ListNode node = findMinNode();
        	node.next = sortHead;
        	sortHead = node;
        }
        return sortHead;
    }
    
    private ListNode findMinNode()
    {
    	ListNode min;
    	ListNode pre; 
    	ListNode next;
    	ListNode preMin;
    	min = head;
    	preMin = head;
    	pre = head;
    	next = head.next;
    	while (next != null)
    	{
    		if (min.val > next.val)
    		{
    			min = next;
    			preMin = pre;
    		}
    		pre = next;
    		next = next.next;
    	}
    	if ((head != null) && (min == head))
    		head = head.next;
    	else 
    		preMin.next = min.next;
    	return min;
    }

    //Accepted
    public ListNode sortList(ListNode head)
    {
    	if (head == null) return head;
    	if (head.next == null) return head;
    	
    	ListNode listA = head;
    	this.head = head.next;
    	listA.next = null;
    	while (this.head != null)
    	{
        	ListNode listB = scanList();
        	listA = merge(listA, listB);
    	}
    	
    	return listA;
    }
    
    private ListNode scanList()
    {
    	if (head == null) return null;
    	
    	ListNode newHead = head;
    	head = head.next;
    	newHead.next = null;
    	ListNode next = head;
    	ListNode pre = next;
    	while (next != null)
    	{
    		if (next.val <= newHead.val)
    		{
    			
    			if (pre == next) //the first node
    			{
    				head = next.next;
    				next.next = newHead;
    				newHead = next;
    				pre = head;
    				next = head;
    				
    			}
    			else
    			{
    				pre.next = next.next;
    				next.next = newHead;
    				newHead = next;
    				next = pre.next;
    			}
    		}
    		else
    		{
    			pre = next;
    			next = pre.next;
    		}
    	}
    	return newHead;
    }
    
    private ListNode merge(ListNode listA, ListNode listB)
    {
    	if(listA == null) return listB;
    	if(listB == null) return listA;
    	
    	ListNode newHeadA = listA;
    	ListNode nextA, nextB, preA;
    	preA = nextA = listA;
    	nextB = listB;
    	while ((nextA!=null) && (nextB!=null))
    	{
    		if(nextB.val < nextA.val)
    		{
    			if(preA == nextA)//smaller than the first item in listA
    			{
    				newHeadA = nextB;
    				nextB = nextB.next;
    				preA = newHeadA;
    				newHeadA.next = nextA;
    			}
    			else
    			{
    				preA.next = nextB;
    				nextB = nextB.next;
    				preA = preA.next;
    				preA.next = nextA;
    			}
    		}
    		else
    		{
    			preA = nextA;
    			nextA = preA.next;
    		}
    	}
    	
    	if (nextA == null)
    		preA.next = nextB;

    	return newHeadA;
    		
    }
}

/*public static void main (String[] args) throws java.lang.Exception
{
	// your code goes here
    int list[] = {2,4};
    SortList.ListNode node;
    SortList.ListNode head = new SortList.ListNode(3);
    node = head;
    for (int i: list)
    {
    	node.next = new SortList.ListNode(i);
    	node = node.next;
		node.next = null;
    }
	
	SortList sort = new SortList();
	head = sort.sortList(head);
	System.out.print("The sorted list: \n" + head.val);
	node = head.next;
	while (node != null)
	{
		System.out.print(" " + node.val);
		node = node.next;
	}

	
}*/
