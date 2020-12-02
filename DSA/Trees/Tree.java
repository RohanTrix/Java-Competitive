package Trees;

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
        sc.close();
    }
////////////////////////////////////////////////////////////////////////////////////////////////////////////
    void preOrderRecursive(TreeNode root)
    {
        if(root ==null)
            return;
        System.out.println(root.val);
        preOrderRecursive(root.left);
        preOrderRecursive(root.right);
    }
///////////////////////////////////////////////////////////////////////////////////////////////////////////
    void preOrderIterative(TreeNode root)
    {
        ArrayList<Integer> res = new ArrayList<Integer>();
        Stack<TreeNode> s = new Stack<TreeNode>();
        if( root == null)
            return;
        s.push(root);
        while(!s.isEmpty())
        {
            TreeNode temp = s.pop();
            res.add(temp.val);
            if(temp.right!=null)
                s.push(temp.right);
            if(temp.left!=null)
                s.push(temp.left);
        }
        for(Integer i: res) System.out.print(i+ " ");
    }
//////////////////////////////////////////////////////////////////////////////////////////////////////////////
    void inOrderRecursive(TreeNode root)
    {
        if(root ==null)
            return;
        preOrderRecursive(root.left);
        System.out.println(root.val);
        preOrderRecursive(root.right);
    }
//////////////////////////////////////////////////////////////////////////////////////////////////////////////
    void inOrderIterative(TreeNode root)
    {

    }
}
