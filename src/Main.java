import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) throws IOException {
    GraphParser parser = new GraphParser();
    Graph<String> graph = parser.parse(new Scanner(new File("assets/formule-2-sat.txt")));

    List<List<Integer>> stronglyConnectedComponents = Kosaraju.getStronglyConnectedComponents(graph);

    for (List<Integer> component : stronglyConnectedComponents)
      for (int i = 0; i < component.size(); ++i)
        component.set(i, GraphParser.unnormalizeVarName(component.get(i), graph.order() / 2));

    boolean result = stronglyConnectedComponents.stream()
        .allMatch(c -> c.stream().noneMatch(node -> c.contains(-node)));

    System.out.println("Formula is " + (result ? "SATISFIABLE" : "UNSATISFIABLE"));
  }
}
