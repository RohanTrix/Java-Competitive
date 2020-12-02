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
        /* ALGORITHM
            1) Keep a flag variable to determine if traversal of tree is over or not
            2) While the done!=true, PUSH the currNode to stack and SET currNode = currNode.left
            3) When leftest node is reached, pop the element out of stack and store it in the ArrayList and SET
            currNode = currNode.right;
        */
        ArrayList<TreeNode> res = new ArrayList<TreeNode>();
        Stack<TreeNode> s = new Stack<TreeNode>();
        TreeNode currNode = root;
        boolean done = false;
        while(!done)
        {
            if(currNode != null)
            {
                s.push(currNode);
                currNode = currNode.left;
            }
            else
            {
                if(s.isEmpty())
                    done = true;
                else
                {
                    currNode = s.pop();
                    res.add(currNode);
                    currNode = currNode.right;
                }
            }
        }
    }
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    void postOrderRecursive(TreeNode root)
    {
        if(root ==null)
            return;
        preOrderRecursive(root.left);
        preOrderRecursive(root.right);
        System.out.println(root.val);
    }
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////
     void levelOrderRecursive(TreeNode root)
     {
        Stack<TreeNode> s = new Stack<TreeNode>();
        if( root ==null)
            return;
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.offer(root);
        q.offer(null);
        while(!q.isEmpty())
        {
            TreeNode temp = q.poll();
            
        }
     }
}
