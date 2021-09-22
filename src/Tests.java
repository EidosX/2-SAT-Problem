import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Tests {
  public static void main(String[] args) throws IOException {
    GraphParser parser = new GraphParser();
    Graph<String> graph1 = parser.parse(new Scanner(new File("assets/formule-2-sat.txt")));
    Graph<String> graph2 = parser.parse(new Scanner(new File("assets/test-1.txt")));
    Graph<String> graph3 = parser.parse(new Scanner(new File("assets/test-2.txt")));

    assertEquals(SAT2.isSatisfiable(graph1), true);
    assertEquals(SAT2.isSatisfiable(graph2), false);
    assertEquals(SAT2.isSatisfiable(graph3), true);
  }

  public static <T> void assertEquals(T o1, T o2) {
    if (!o1.equals(o2))
      throw new AssertionError(o1 + " != " + o2);
  }
}
