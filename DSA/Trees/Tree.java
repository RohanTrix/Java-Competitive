import java.util.*;
public class Tree {
    class TreeNode
    {
        int val;
        TreeNode left;
        TreeNode right;
        public TreeNode(){}
        public TreeNode(int value){ this.val = value; }
        public TreeNode(int val, TreeNode left, TreeNode right)
        {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
    }
    void preOrderRecursive(TreeNode root)
    {
        System.out.println(root.val);
        preOrderRecursive(root.left);
        preOrderRecursive(root.right);
    }
    void preOrderIterative(TreeNode root)
    {
        ArrayList<Integer> res = new ArrayList<Integer>();
        if( root == null)
            return;
        Stack<TreeNode> s = new Stack<TreeNode>();
        
        
    }
}
