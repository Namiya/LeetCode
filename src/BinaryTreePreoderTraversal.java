import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;


public class BinaryTreePreoderTraversal {
	public class TreeNode {
	     int val;
	     TreeNode left;
	     TreeNode right;
	     TreeNode(int x) { val = x; }
	 }
	List<Integer> list = new ArrayList<Integer>();
	
	//Recursive
	public List<Integer> preorderTraversal(TreeNode root) {
		
		if (root == null) return list;
		
		list.add(root.val);
		
		preorderTraversal(root.left);
		preorderTraversal(root.right);
		
		return list;
    }
	
	//Iteratively
	public List<Integer> preorderTraversal1(TreeNode root) {
		
		if (root == null) return list;
		
		Stack<TreeNode> st = new Stack<TreeNode>();
		Queue<TreeNode> qu = new LinkedList<TreeNode>();
		st.add(root);
		while(!st.isEmpty())
		{
			root = st.pop();
			qu.add(root);
			
			if (root.right != null) st.push(root.right);
			if (root.left != null) st.push(root.left);
		}
		
		while (!qu.isEmpty())
		{
			root = qu.poll();
			list.add(root.val);
		}
		
		return list;	
	}
}
