import org.junit.jupiter.api.Test;

public class AddTwoNumbers {


  @Test
  void test() {

    ListNode l1 = new ListNode(2, 4, 3, 7, 1);
    ListNode l2 = new ListNode(5, 6, 2, 1, 2);

    Integer result = solve(l1, l2);

    System.out.println("result : " + result);

  }

  private Integer solve(ListNode l1, ListNode l2) {

    ListNode node = new ListNode(0);

    int sum;
    int quotient = 0;

    boolean hasNext = true;

    while (hasNext) {

      ListNode next = node.getNext();

      sum = l1.getVal() + l2.getVal() + quotient;
      quotient = sum / 10;

      if (l1.getNext() == null || l2.getNext() == null) {
        hasNext = false;
      }

      if (next == null) {
        node.setNext(new ListNode(sum % 10));
      } else {
        while (next.getNext() != null) {
          next = next.getNext();
        }

        next.setNext(new ListNode(sum % 10));
      }

      l1 = l1.getNext();
      l2 = l2.getNext();
    }

    if (quotient > 0) {
      ListNode next = node.getNext();
      while (next.getNext() != null) {
        next = next.getNext();
      }
      next.setNext(new ListNode(quotient));
    }

    StringBuilder builder = new StringBuilder();

    while (node.getNext() != null) {
      builder.append(node.getNext().getVal());
      node = node.getNext();
    }

    return Integer.valueOf(builder.toString());
  }


  private static class ListNode {

    public ListNode(int val, Integer... nextVals) {
      this.val = val;

      if (nextVals != null && nextVals.length > 0) {

        ListNode node = null;

        for (Integer nextVal : nextVals) {
          if (node == null) {
            node = new ListNode(nextVal);
          } else {
            if (node.getNext() == null) {
              node.setNext(new ListNode(nextVal));
            } else {
              ListNode next = node.getNext();
              while (next.getNext() != null) {
                next = next.getNext();
              }
              next.setNext(new ListNode(nextVal));
            }
          }
        }

        this.setNext(node);
      }
    }

    private int val;
    private ListNode next = null;

    public int getVal() {
      return val;
    }

    public ListNode getNext() {
      return next;
    }

    public void setNext(ListNode next) {
      this.next = next;
    }

    @Override
    public String toString() {
      return "ListNode{" +
          "val=" + val +
          ", next=" + next +
          '}';
    }
  }

}


