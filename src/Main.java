import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) throws IOException {
    GraphParser parser = new GraphParser();
    Graph<String> graph = parser.parse(new Scanner(new File("assets/formule-2-sat.txt")));

    System.out.println(graph);
  }
}
