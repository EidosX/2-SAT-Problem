import java.util.ArrayList;
import java.util.LinkedList;

public class Graph<Label> {
  private class Edge {
    public int source;
    public int destination;
    public Label label;

    public Edge(int from, int to, Label label) {
      this.source = from;
      this.destination = to;
      this.label = label;
    }
  }

  private final int cardinal;
  private final ArrayList<LinkedList<Edge>> incidency;

  public Graph(int size) {
    cardinal = size;
    incidency = new ArrayList<LinkedList<Edge>>(size + 1);
    for (int i = 0; i < cardinal; i++) {
      incidency.add(i, new LinkedList<Edge>());
    }
  }

  public int order() {
    return cardinal;
  }

  public void addArc(int source, int dest, Label label) {
    incidency.get(source).addLast(new Edge(source, dest, label));
  }

  public Graph<Label> transpose() {
    Graph<Label> graph = new Graph<>(cardinal);
    incidency.stream().flatMap(l -> l.stream()).forEach(e -> {
      graph.addArc(e.destination, e.source, e.label);
    });
    return graph;
  }

  @Override
  public String toString() {
    StringBuilder result = new StringBuilder();
    result.append(cardinal + "\n");
    for (int i = 0; i < cardinal; i++) {
      for (Edge e : incidency.get(i)) {
        result.append(e.source + " " + e.destination + " (" + e.label.toString() + ")\n");
        // result.append(e.label + "\n");
      }
    }
    return result.toString();
  }
}
