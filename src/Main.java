import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) throws IOException {
    GraphParser parser = new GraphParser();
    Graph<String> graph = parser.parse(new Scanner(new File("assets/formule-2-sat.txt")));

    List<Integer> traversalOrder = new ArrayList<>();
    DFS dfs = new DFS();
    dfs.setOnFinishedVisiting(node -> traversalOrder.add(node));
    dfs.traverse(graph);

    System.out.println(graph);
    System.out.println(traversalOrder);
  }
}
