import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Kosaraju {
  public static List<List<Integer>> getStronglyConnectedComponents(Graph<?> graph) {
    ArrayList<Integer> suffixTraversalOrder = getSuffixTraversalOrder(graph);

    ArrayList<List<Integer>> scc = new ArrayList<>();
    DFS dfs = new DFS();
    dfs.setOnExitNode(node -> scc.get(scc.size() - 1).add(node));
    LinkedList<Integer> visited = new LinkedList<>();

    Graph<?> transposed = graph.transpose();

    for (int i = suffixTraversalOrder.size() - 1; i >= 0; --i) {
      int node = suffixTraversalOrder.get(i);
      if (visited.contains(node))
        continue;

      scc.add(new LinkedList<>());
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
