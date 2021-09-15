import java.util.List;

public class SAT2 {
  public static boolean isSatisfiable(Graph<?> graph) {
    List<List<Integer>> stronglyConnectedComponents = Kosaraju.getStronglyConnectedComponents(graph);

    for (List<Integer> component : stronglyConnectedComponents)
      for (int i = 0; i < component.size(); ++i)
        component.set(i, GraphParser.unnormalizeVarName(component.get(i), graph.order() / 2));

    return stronglyConnectedComponents.stream().allMatch(c -> c.stream().noneMatch(node -> c.contains(-node)));

  }
}
