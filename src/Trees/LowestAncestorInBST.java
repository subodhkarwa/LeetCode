/*
 *  Given a binary search tree (BST), find the lowest common ancestor (LCA) of two given nodes in the BST.

According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined between two nodes v and w as the lowest node in T that has both v and w as descendants (where we allow a node to be a descendant of itself).”

        _______6______
       /              \
    ___2__          ___8__
   /      \        /      \
   0      _4       7       9
         /  \
         3   5

For example, the lowest common ancestor (LCA) of nodes 2 and 8 is 6. Another example is LCA of nodes 2 and 4 is 2, since a node can be a descendant of itself according to the LCA definition.

 */

package Trees;
public class LowestAncestorInBST {
	
	 class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
		}
	 
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root==null)
            return null;
        
        if(p==null && q==null)    
            return null;
            
        if(p==null) return q;
        if(q==null) return p;
        
        if(root.val==q.val || root.val==p.val)
            return root;
            
        TreeNode left=lowestCommonAncestor(root.left,p,q);
        TreeNode right=lowestCommonAncestor(root.right,p,q);
        
        if(left!=null && right!=null)
            return root;
        
        if(left!=null)
            return left;
            
        if(right!=null)
            return right;
        
          return null;
}
}
