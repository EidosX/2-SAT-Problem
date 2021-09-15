import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Tests {
  public static void main(String[] args) throws IOException {
    GraphParser parser = new GraphParser();
    Graph<String> graph1 = parser.parse(new Scanner(new File("assets/formule-2-sat.txt")));
    Graph<String> graph2 = parser.parse(new Scanner(new File("assets/test-1.txt")));
    Graph<String> graph3 = parser.parse(new Scanner(new File("assets/test-2.txt")));

    assert (SAT2.isSatisfiable(graph1) == true);
    assert (SAT2.isSatisfiable(graph2) == false);
    assert (SAT2.isSatisfiable(graph3) == true);
  }
}
