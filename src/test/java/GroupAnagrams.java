import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import org.junit.jupiter.api.Test;

public class GroupAnagrams {

  @Test
  void test() {

    String[] input = {"eat", "tea", "tan", "ate", "nat", "bat"};

    List<List<String>> result = solve(input);

    for (List<String> list : result) {
      System.out.println(list);
    }
  }

  private List<List<String>> solve(String[] input) {

    List<List<String>> result = new ArrayList<>();

    Map<String, List<String>> map = new HashMap<>();

    for (int i = 0; i < input.length; i++) {

      String value = input[i];

      char[] chars = value.toCharArray();

      Arrays.sort(chars);

      StringBuilder sb = new StringBuilder();
      for (char ch : chars) {
        sb.append(ch);
      }

      String key = sb.toString();

      if (!map.containsKey(key)) {
        map.put(key, new ArrayList<>());
      }
      map.get(key).add(value);
    }

    Set<String> keySet = map.keySet();

    for (String key : keySet) {
      Collections.sort(map.get(key));
      result.add(map.get(key));
    }

    result = result.stream().sorted(Comparator.comparing(List::size)).collect(Collectors.toList());
    Collections.reverse(result);

    return result;
  }

}
