public class BSTCount {
  class Node {
    int value;
    int numOfLeftNodes;
    Node left;
    Node right;

    Node(int value, int numOfLeftNodes) {
      this.value = value;
      this.numOfLeftNodes = numOfLeftNodes;
    }
  }

  public static Node insert(Node root, int value, int preSum) {
    if (root == null) {
      root = new BSTCount().new Node(value, preSum);
      return root;
    } else if (value < root.value) {
      root.value++;
      root.left = insert(root.left, value, preSum);
    } else {
      root.right = insert(root.right, value, preSum + root.numOfLeftNodes);  
    }
    return root;
  }

  public static void PrintSmallNums(int[] arr) {
    Node root = null;
    for (int i = 0; i < arr.length; i++) {
      root = insert(root, arr[i], 0);
    }
  }

  public static void main(String[] args) {
    int[] vars = {5, 2, 6, 1};
    PrintSmallNums(vars);
  }

}
