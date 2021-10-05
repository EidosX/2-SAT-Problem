import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Kosaraju {
  public static List<List<Integer>> getStronglyConnectedComponents(Graph<?> graph) {
    List<Integer> suffixTraversalOrder = getSuffixTraversalOrder(graph);

    List<List<Integer>> scc = new ArrayList<>();
    DFS dfs = new DFS();
    List<Integer> visited = new LinkedList<>();

    Graph<?> transposed = graph.transpose();

    for (int i = suffixTraversalOrder.size() - 1; i >= 0; --i) {
      int node = suffixTraversalOrder.get(i);
      if (visited.contains(node))
        continue;

      LinkedList<Integer> component = new LinkedList<>();
      scc.add(component);
      dfs.setOnExitNode(n -> component.add(n));
      dfs.traverse(transposed, node, visited);
    }
    return scc;
  }

  private static ArrayList<Integer> getSuffixTraversalOrder(Graph<?> graph) {
    ArrayList<Integer> order = new ArrayList<>();
    DFS dfs = new DFS();
    dfs.setOnExitNode(order::add);

    LinkedList<Integer> visited = new LinkedList<>();
    for (int i = 0; i < graph.order(); ++i)
      dfs.traverse(graph, i, visited);
    return order;
  }
}
