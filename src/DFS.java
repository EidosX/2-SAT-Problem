import java.util.LinkedList;
import java.util.List;
import java.util.function.Consumer;

public class DFS {
  // This
  private Consumer<Integer> onFinishedVisiting = null;

  public void setOnFinishedVisiting(Consumer<Integer> onFinishedVisiting) {
    this.onFinishedVisiting = onFinishedVisiting;
  }

  public <Label> void traverse(Graph<Label> graph) {
    LinkedList<Integer> visited = new LinkedList<>();
    for (int i = 0; i < graph.order(); ++i)
      traverse(graph, i, visited);
  }

  private <Label> void traverse(Graph<Label> graph, int source, List<Integer> visited) {

    if (visited.contains(source))
      return;
    visited.add(source);
    graph.destinations(source).forEach(destination -> {
      traverse(graph, destination, visited);
    });
    if (onFinishedVisiting != null)
      onFinishedVisiting.accept(source);
  }
}
