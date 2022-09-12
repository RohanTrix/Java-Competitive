import java.util.List;

// REFER : https://youtu.be/wGXB9OWhPTg

class MorrisTraversal {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        TreeNode current = root;
        while(current != null)
        {
            if(current.left == null)
            {
                list.add(current.val);
                current = current.right;
            }
            else
            {
                // Finding predecessor
                TreeNode pred = current.left;
                while(pred.right!=current && pred.right!=null)
                    pred = pred.right;
                
                if(pred.right == null)
                {
                    pred.right = current;
                    current = current.left;
                }
                else
                {
                    pred.right = null;
                    list.add(current.val);
                    current = current.right;
                }
            }
        }
        return list;
    }
}
