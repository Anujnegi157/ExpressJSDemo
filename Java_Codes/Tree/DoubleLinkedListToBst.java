public class DoubleLinkedListToBst {
  import java.util.*;

class Main {
  public static Scanner scn = new Scanner(System.in);

  public static class Node {
    int val = 0;
    Node left = null;
    Node right = null;

    Node(int val) {
      this.val = val;
    }
  }
  public static Node middleNode(Node head) {

     Node slow = head;
     Node fast = head;
      while(fast.right != null && fast.right.right != null){
      slow = slow.right;
      fast= fast.right.right;
      }
    return slow;
    }
  // left : prev, right : next
  public static Node SortedDLLToBST(Node head) {
    return MakeTree(head);
  }
  public static Node MakeTree(Node head){
      
      if(head==null || head.right==null){
          return head;
          
      }
      
      Node mid = middleNode(head);
      Node lt = mid.left;
      Node rt = mid.right;
      if(lt!=null){
      lt.right = null;
      mid.left=null;
      }
      
      mid.right = null;
      rt.left=null;
      
      
      mid.left=MakeTree(lt != null ? head : null);
      mid.right= MakeTree(rt);
      return mid;
  }

  // Input_code===================================================

  public static void display(Node node) {
    if (node == null)
      return;

    StringBuilder sb = new StringBuilder();
    sb.append((node.left != null ? node.left.val : "."));
    sb.append(" -> " + node.val + " <- ");
    sb.append((node.right != null ? node.right.val : "."));

    System.out.println(sb.toString());

    display(node.left);
    display(node.right);

  }

  public static Node makeList(int n) {
    Node dummy = new Node(-1);
    Node prev = dummy;
    while (n-- > 0) {
      Node node = new Node(scn.nextInt());
      prev.right = node;
      node.left = prev;
      prev = prev.right;
    }

    Node head = dummy.right;
    head.left = dummy.right = null;

    return head;
  }

  public static void main(String[] args) {
    Node head = makeList(scn.nextInt());

    head = SortedDLLToBST(head);
    display(head);
  }

}
}
