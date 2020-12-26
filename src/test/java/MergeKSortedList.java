import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import org.junit.jupiter.api.Test;

public class MergeKSortedList {

  @Test
  void test() {

    Node n1 = new Node(1, 4, 5);
    Node n2 = new Node(1, 3, 4);
    Node n3 = new Node(2, 6);

    Node result = solve(n1, n2, n3);

    System.out.println("result : " + result);

  }

  private Node solve(Node... nodes) {

    Queue<Node> queue = new PriorityQueue<>(Comparator.comparingInt(Node::getVal));

    for (Node node : nodes) {
      queue.offer(new Node(node.getVal()));
      while (node.getNext() != null) {
        queue.offer(new Node(node.getNext().getVal()));
        node = node.getNext();
      }
    }

    Node node = null;
    Node next = null;
    while (!queue.isEmpty()) {
      if (node == null) {
        node = queue.poll();
      } else {
        if (node.getNext() == null) {
          node.setNext(queue.poll());
        } else {
          if (next == null) {
            next = node.getNext();
            next.setNext(queue.poll());
            System.out.println(next);
            next = next.getNext();
          } else {
            if (next.getNext() == null) {
              next.setNext(queue.poll());
              next = next.getNext();
            }
          }
        }
      }
    }

    return node;
  }

  private static class Node {

    public Node(int val, int... nextVals) {
      this.val = val;

      Node node = null;

      for (int nextVal : nextVals) {
        if (node == null) {
          node = new Node(nextVal);
        } else {

          if (node.getNext() == null) {
            node.setNext(new Node(nextVal));
          } else {
            Node next = node.getNext();
            while (next.getNext() != null) {
              next = next.getNext();
            }
            next.setNext(new Node(nextVal));
          }
        }
      }

      this.setNext(node);
    }

    private int val;
    private Node next;

    public int getVal() {
      return val;
    }

    public void setVal(int val) {
      this.val = val;
    }

    public Node getNext() {
      return next;
    }

    public void setNext(Node next) {
      this.next = next;
    }

    @Override
    public String toString() {
      return "Node{" +
          "val=" + val +
          ", next=" + next +
          '}';
    }
  }

}
