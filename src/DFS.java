import java.util.List;
import java.util.function.Consumer;

public class DFS {
  private Consumer<Integer> onExitNode = null;

  public void setOnExitNode(Consumer<Integer> onExitNode) {
    this.onExitNode = onExitNode;
  }

  public <Label> void traverse(Graph<Label> graph, int source, List<Integer> visited) {
    if (visited.contains(source))
      return;
    visited.add(source);
    graph.destinations(source).forEach(destination -> {
      traverse(graph, destination, visited);
    });
    if (onExitNode != null)
      onExitNode.accept(source);
  }
}
