import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.junit.jupiter.api.Test;

public class ReverseLinkedList {

  @Test
  void test() {

    Node node = new Node(1, 2, 3, 4, 5, 6);

    Node result = solve(node);

    System.out.println(result);

  }

  private Node solve(Node input) {

    return reverse(input);
  }

  private Node reverse(Node node) {

    List<Integer> list = new ArrayList<>();
    while (node != null) {
      list.add(node.value);
      node = node.next;
    }

    Collections.reverse(list);

    int[] numbers = list.stream()
        .mapToInt(e -> e).toArray();

    return new Node(numbers);
  }

  static class Node {

    private Integer value;
    private Node next;

    public Node(int... values) {

      for (int value : values) {
        if (this.value == null) {
          this.value = value;
        } else {
          if (this.next == null) {
            this.next = new Node(value);
          } else {
            Node next = this.next;
            while (next.next != null) {
              next = next.next;
            }
            next.next = new Node(value);
          }
        }
      }
    }

    @Override
    public String toString() {
      return "Node{" +
          "value=" + value +
          ", next=" + next +
          '}';
    }
  }
}
