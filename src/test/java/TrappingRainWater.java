import java.util.Arrays;
import org.junit.jupiter.api.Test;

public class TrappingRainWater {

  @Test
  void test() {

    int[] input = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};

    int[] result = solve(input);

    System.out.printf("result, %s\n", Arrays.toString(result));


  }

  private int[] solve(int[] input) {

    int length = input.length;

    // set Left wall
    int[] left = new int[length];
    int leftMax = input[0];
    left[0] = leftMax;

    for (int i = 1; i < length; i++) {
      if (input[i] > leftMax) {
        leftMax = input[i];
      }
      left[i] = leftMax;
    }

    // set Right wall
    int[] right = new int[length];
    int rightMax = input[length - 1];
    right[length - 1] = rightMax;

    for (int i = length - 1; i >= 0; i--) {
      if (input[i] > rightMax) {
        rightMax = input[i];
      }
      right[i] = rightMax;
    }

    System.out.printf("left, %s\n", Arrays.toString(left));

    System.out.printf("right, %s\n", Arrays.toString(right));

    // left, right 최소값, 결과 구하기
    int[] minArr = new int[length];

    int[] result = new int[length];
    for (int i = 0; i < length; i++) {

      /**
       *       if (left[i] < right[i]) {
       *         minArr[i] = left[i];
       *       } else {
       *         minArr[i] = right[i];
       *       }
       */
      minArr[i] = Math.min(left[i], right[i]);
      result[i] = minArr[i] - input[i];
    }

    System.out.printf("minArr, %s\n", Arrays.toString(minArr));

    return result;
  }
}
