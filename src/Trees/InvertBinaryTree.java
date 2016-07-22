/*
 * Invert a binary tree.

     4
   /   \
  2     7
 / \   / \
1   3 6   9

to

     4
   /   \
  7     2
 / \   / \
9   6 3   1

 */

package Trees;
public class InvertBinaryTree {
	
	 class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
		}

	public TreeNode invertTree(TreeNode root) {
		if(root==null)
			return null;

		TreeNode temp=root.left;
		root.left=root.right;
		root.right=temp;

		invertTree(root.left);
		invertTree(root.right);

		return root;
	}
}
