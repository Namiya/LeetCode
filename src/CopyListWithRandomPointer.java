import java.util.HashMap;
import java.util.Map;


public class CopyListWithRandomPointer {
	class RandomListNode {
		     int label;
		     RandomListNode next, random;
		     RandomListNode(int x) { this.label = x; }
		 }
	 
	public RandomListNode copyRandomList(RandomListNode head) {
	        
		if (head == null) return null;
		
		RandomListNode newHead = new RandomListNode(head.label);
		
		Map<RandomListNode, RandomListNode> nodeMap = new HashMap<RandomListNode, RandomListNode>();
		nodeMap.put(head,  newHead);
		RandomListNode next = head.next;
		while (next != null)
		{
			RandomListNode node = new RandomListNode(next.label);
			nodeMap.put(next, node);
			next = next.next;
		}
		next = head;
		while (next != null)
		{
			RandomListNode node = nodeMap.get(next);
			if (next.next != null) node.next = nodeMap.get(next.next);
			if (next.random != null) node.random = nodeMap.get(next.random);
			next = next.next;
		}
		return newHead;
	}
}
