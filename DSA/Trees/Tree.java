package DSA.Trees;
import java.util.*;
@SuppressWarnings("all")
public class Tree {
    static class TreeNode
    {
        int val;
        TreeNode left;
        TreeNode right;
        public TreeNode(){}
        public TreeNode(int value){ this.val = value; this.left=null; this.right = null;}
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
        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(3);
        TreeNode t4 = new TreeNode(4);
        TreeNode t5 = new TreeNode(5);
        TreeNode t7 = new TreeNode(7);
        t2.left = t4;
        t2.right = t5;
        t1.left = t2;
        t1.right = t3;
        t3.right = t7;
        Tree ob = new Tree();
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
        inOrderRecursive(root.left);
        System.out.println(root.val);
        inOrderRecursive(root.right);
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
     void levelOrder(TreeNode root)
     {
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        if( root ==null) return;
        q.offer(root);
        ArrayList<TreeNode> res = new ArrayList<TreeNode>();
        while(!q.isEmpty())
        {
            TreeNode temp = q.poll();
            res.add(temp);
            if( temp.left!=null)
                q.offer(temp.left);
            if( temp.right!=null)
                q.offer(temp.right);  
        }
        for(TreeNode i : res) System.out.print(i.val+ " ");
     }
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    public ArrayList<ArrayList<Integer>> levelOrderTestMode(TreeNode root) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        if (root == null)
            return res;
        // Initialization
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.offer(root);
        q.offer(null);
        ArrayList<Integer> curr = new ArrayList<Integer>();
        while (!q.isEmpty()) {
            TreeNode tmp = q.poll();
            if (tmp != null) {
                curr.add(tmp.val);
            if (tmp.left != null)
                q.offer(tmp.left);
            if (tmp.right != null)
                q.offer(tmp.right);
            } 
            else {
                ArrayList<Integer> c_curr = new ArrayList<Integer>(curr);
                res.add(c_curr);
                curr.clear(); // Java will clear the reference, so have to new an new ArrayList.
                // completion of a level;
                if (!q.isEmpty())
                    q.offer(null);
            }
            }
        return res;
   }
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

   public TreeNode LCA(TreeNode root, TreeNode a, TreeNode b)
    {
        if(root == null) return null;
        if(root ==a || root==b) return root;
        TreeNode left = LCA(root.left, a, b);
        TreeNode right = LCA(root.right, a , b);
        if( left!=null && right!=null) return root;
        if(left ==null && right ==null) return null;
        
        return (left!=null)? left: right;
    }
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
}
