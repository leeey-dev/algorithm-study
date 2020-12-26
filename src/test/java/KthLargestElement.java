import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import org.junit.jupiter.api.Test;

public class KthLargestElement {

  @Test
  void test() {

    int[] input = {3, 2, 1, 5, 6, 4};
    int k = 2;

    Integer result = solve2(input, k);

    System.out.printf("result : %s\n", result);

  }

  private Integer solve(int[] input, int k) {

    int length = input.length;

    if (k == 0 || length < k) {
      return null;
    }

    Arrays.sort(input);

    return input[length - k];
  }

  private Integer solve2(int[] input, int k) {

    PriorityQueue<Integer> queue = new PriorityQueue<>((a, b) -> b - a);

    for (int i = 0; i < input.length; i++) {
      queue.offer(input[i]);
    }

    Integer result = null;
    for (int i = 0; i < k; i++) {
      result = queue.poll();
    }

    return result;
  }

}
