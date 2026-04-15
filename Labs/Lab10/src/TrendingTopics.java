import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class TrendingTopics {

  /**
   * Counts how many times each topic appears in the input list.
   *
   * @param topics the list of topic strings
   * @return a map where the key is a distinct topic and the value is its count
   */
  public Map<String, Long> countTopics(List<String> topics) {
    return topics.stream()
        .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
  }
}
