import java.util.ArrayList;
import java.util.List;
import java.util.Stack;


public class BinaryTreePostorderTraversal {
	public class TreeNode {
		     int val;
		     TreeNode left;
		     TreeNode right;
		     TreeNode(int x) { val = x; }
		 }
	List<Integer> list = new ArrayList<Integer>();
	
	//recursive
	public List<Integer> postorderTraversal(TreeNode root) {
		
        if (root == null) return list;
        
        postorderTraversal(root.left);
        list.add(root.val);
        postorderTraversal(root.right);
        
        return list;
    }

	//Iteratively
	public List<Integer> postorderTraversal1(TreeNode root) {
		
		if (root == null) return list;
		
		Stack st = new Stack();
		Stack st2 = new Stack();
		st2.add(root);
		while(!st2.isEmpty())
		{
			root = (TreeNode) st2.pop();
			st.push(root);
			
			if (root.left != null)
				st2.push(root.left);
			if (root.right != null)
				st2.push(root.right);
		}
		
		while (!st.isEmpty())
		{
			root = (TreeNode) st.pop();
			list.add(root.val);
		}
		
		return list;
	}
}
