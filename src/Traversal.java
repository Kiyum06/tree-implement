public class Traversal {
  public static void main(String[] args) {
    TreeNode root = new TreeNode(10);
    // System.out.println(root.data);

    root.left = new TreeNode(9);
    root.right = new TreeNode(15);

    root.left.left = new TreeNode(5);
    root.left.right = new TreeNode(2);

    root.right.left = new TreeNode(-3);
    root.right.right = new TreeNode(5);

    root.right.right.right = new TreeNode(22);

    preorder(root);

  }

  public static void preorder(TreeNode current) {

    if (current == null)
      return;
    System.out.println(current.data);
    preorder(current.left);
    preorder(current.right);
  }

}
