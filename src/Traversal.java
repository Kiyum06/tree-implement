import java.util.Stack;
import java.util.Queue;
import java.util.LinkedList;

public class Traversal {
  public static void main(String[] args) {
    TreeNode<Integer> root = new TreeNode<>(10);
    // System.out.println(root.data);

    root.left = new TreeNode<>(9);
    root.left.left = new TreeNode<>(5);
    root.left.right = new TreeNode<>(2);

    root.right = new TreeNode<>(15,
                                new TreeNode<>(-3),
                                new TreeNode<>(5,
                                null,
                                new TreeNode<>(22) 
                              )
                            );

    

    TreeNode<String> stringRoot = new TreeNode<> ("hello");

    stringRoot.left = new TreeNode<>("hi");
    stringRoot.left.left = new TreeNode<>("shdk");
    stringRoot.left.right = new TreeNode<>("sndj");

    stringRoot.right = new TreeNode<>("dfgdfg",
                                new TreeNode<>("fji"),
                                new TreeNode<>("ka", 
                                      null,
                                      new TreeNode<>("ey") 
                                )
                            );
    
                            
    TreeNode <Integer> megaRoot = new TreeNode<Integer>(1); 
    
    TreeNode<Integer> current = megaRoot;
    for (int i = 1; i < 100_001; i++) {
      current.right = new TreeNode<Integer>(i);
      current = current.right;
    }

    levelOrder(root);
    //preorderIterative(root);
    // preorder(megaRoot);
    // preorder(stringRoot);
    // postorder(root);
    // // inorder(root);
    // printGreaterThan(root, 1);
    // System.out.println(countNodes(root));
  }

  public static int countNodes(TreeNode<?> current){
    if (current == null) return 0; 
  
    int leftCount = countNodes(current.left);
    int rightCount = countNodes(current.right); 

    int totalCount = 1 + leftCount + rightCount;

    return totalCount;

    // one line code for whole method 
    //return current == null ? 0 : 1 + countNodes(current.left) + countNodes(current.right);

  }

 

  // Do a preorder traversal
  // but only print the nodes that are gtreater than our treshold
  public static void printGreaterThan (TreeNode<Integer> current, int threshold) {
    if (current == null) return;
    if (current.value > threshold) {
      System.out.println(current.value);
    }
    printGreaterThan(current.left, threshold);
    printGreaterThan(current.right, threshold);

  }


  public static void preorderIterative (TreeNode<?> root) {
    Stack<TreeNode<?>> stack = new Stack<>();

    stack.push(root);

    while(!stack.isEmpty()) {
      TreeNode<?> current = stack.pop();
      if(current == null) continue;
      System.out.println(current.value);
      stack.push(current.right);
      stack.push(current.left);
    }
  } 

  public static void levelOrder(TreeNode<?> root){
    Queue<TreeNode<?>> queue = new LinkedList<>();

    queue.offer(root);

    while(!queue.isEmpty()) {
      TreeNode<?> current = queue.remove();
      if(current == null) continue;
      System.out.println(current.value);
      queue.offer(current.left);
      queue.offer(current.right);
    }
  }


  public static void preorder(TreeNode<?> current) {
    if (current == null) return;
    System.out.println(current.value);
    preorder(current.left);
    preorder(current.right);
  }

  public static <E> void postorder(TreeNode<E> current) {
    if (current == null) return;
    preorder(current.left);
    preorder(current.right);
    E myValue = current.value;
    System.out.println(myValue);
  }

  public static void inorder(TreeNode<?> current) {
    if (current == null) return;
    inorder(current.left);
    System.out.println(current.value);
    inorder(current.right);
    
    
  }

}
