import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;

public class MissingRanges {

  @Test
  void test() {

    int[] input = {2, 3, 5, 50, 52, 75, 80, 82, 95};

    int lower = 0;
    int upper = 99;
    List<String> result = solve(input, lower, upper);

    System.out.printf("result : %s\n", result);
  }

  private List<String> solve(int[] input, int lower, int upper) {

    List<String> result = new ArrayList<>();

    int rangeFirst = lower;
    int rangeLast;

    for (int i : input) {
      // 배열의 수가 크거나 같은 경우
      if (i - rangeFirst >= 1) {
        // 연속되는 경우
        if (i - rangeFirst == 1) {
          result.add(String.valueOf(i - 1));
        } else {
          // 연속되지 않는 경우
          rangeLast = i - 1;
          result.add(rangeFirst + "->" + rangeLast);
        }
        rangeFirst = i + 1;
      } else {
        rangeFirst++;
      }
    }

    if (rangeFirst < upper) {
      result.add(rangeFirst + "->" + upper);
    }

    return result;
  }

}
