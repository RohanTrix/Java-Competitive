// BST Iterator

public class InorderTree
{
    Deque<TreeNode> stack;
    public InorderTree(TreeNode root)
    {
        stack = new ArrayDeque<>();
        while(root!=null)
        {
            stack.push(root);
            root = root.left;
        }
    }
    public boolean hasNext()
    {
        return !stack.isEmpty();
    }
    public int next()
    {
        TreeNode root = stack.pop();
        int val = root.val;
        root = root.right;
        while(root!=null)
        {
            stack.push(root);
            root = root.left;
        }
        return val;
    }
    public int current()
    {
        return stack.peek().val;
    }
}