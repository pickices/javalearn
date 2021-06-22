class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode() {}
     TreeNode(int val) { this.val = val; }
     TreeNode(int val, TreeNode left, TreeNode right) {
         this.val = val;
         this.left = left;
         this.right = right;
     }
}

public class MaxDepth {
    static int max = Integer.MIN_VALUE;
    public static void main(String[] args) {
        TreeNode left = new TreeNode(9);
        TreeNode right = new TreeNode(20,new TreeNode(15),new TreeNode((7)));
        TreeNode root = new TreeNode(3,left,right);
        System.out.println(maxDepth(root));
    }

    public static int maxDepth(TreeNode root){
        if(root==null) return 0;
        max = Math.max(max,maxDepth(root.left)+1);
        max = Math.max(max,maxDepth(root.right)+1);
        return max;
    }
}
