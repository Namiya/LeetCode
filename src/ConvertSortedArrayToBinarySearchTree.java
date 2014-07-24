
public class ConvertSortedArrayToBinarySearchTree {

	public class TreeNode {
	     int val;
	     TreeNode left;
	     TreeNode right;
	     TreeNode(int x) { val = x; }
	 }

	public TreeNode sortedArrayToBST(int[] num) {
        if (num == null) return null;
        if (num.length == 0) return null;
     
       	return generateTree(num, 0, num.length-1);
    }
	
	private TreeNode generateTree(int[] num, int start, int end)
	{
		if(start > end) return null;
	
		int index = start + (end-start)/2;
        
		TreeNode root = new TreeNode(num[index]);
        root.left = generateTree(num, start, index-1);
        root.right = generateTree(num, index+1, end);
        
        return root;
	}

	/*
	 * Convert Sorted List to Binary Search Tree
	 * Given a singly linked list where elements are sorted in ascending order, convert it to a height balanced BST.
	 */

	public class ListNode {
	     int val;
	     ListNode next;
	     ListNode(int x) { val = x; next = null; }
	 }

	public TreeNode sortedListToBST(ListNode head) {
		if (head == null) return null;
		
		int length = 1;
		ListNode next = head.next;
		while (next != null)
		{
			length ++;
			next = next.next;
		}
		
		listHead = head;
		return generateTree2(0, length-1);
    }
	
	ListNode listHead = null;
	TreeNode generateTree2(int start, int end)
	{
		if (start > end) return null;
		
		TreeNode root = new TreeNode(0);
		int index = start + (end - start)/2;
		
		root.left = generateTree2(start, index-1);
		root.val = listHead.val;
		listHead = listHead.next;
		root.right = generateTree2(index+1, end);	
		
		return root;
	}
}