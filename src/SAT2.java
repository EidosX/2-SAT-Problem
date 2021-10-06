import java.util.stream.Collectors;

public class SAT2 {
  public static boolean isSatisfiable(Graph<?> graph) {
    int n = graph.order() / 2;
    return Kosaraju.getStronglyConnectedComponents(graph).stream()
        .map(c -> c.stream().map(node -> GraphParser.unnormalizeVarName(node, n)).collect(Collectors.toList()))
        .noneMatch(c -> c.stream().anyMatch(node -> c.contains(-node)));
  }
}
