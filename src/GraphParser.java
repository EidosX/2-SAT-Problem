import java.io.IOException;
import java.util.Scanner;

public class GraphParser {
  public Graph<String> parse(Scanner scanner) throws IOException {
    String[] fstLine = scanner.nextLine().split(" ");
    String[] sndLine = scanner.nextLine().split(" ");

    @SuppressWarnings("unused")
    String commentary = fstLine[1];
    int varCount = Integer.parseInt(sndLine[2]);
    int clausesCount = Integer.parseInt(sndLine[3]);

    Graph<String> graph = new Graph<>(varCount * 2);

    for (int i = 0; i < clausesCount; ++i) {
      String[] line = scanner.nextLine().split(" ");
      int x = Integer.parseInt(line[0]);
      int y = Integer.parseInt(line[1]);

      graph.addArc(normalizeVarName(-x, varCount), normalizeVarName(y, varCount), formatImplication(-x, y));
      graph.addArc(normalizeVarName(-y, varCount), normalizeVarName(x, varCount), formatImplication(-y, x));
    }
    scanner.close();
    return graph;
  }

  /**
   * Maps a value x from [-n; 0[ U ]0; n] to [0; 2n[.
   */
  public static int normalizeVarName(int x, int n) {
    assert x != 0;
    return x > 0 ? x - 1 : n * 2 + x;
  }

  /**
   * Inverse of normalizeVarName
   */
  public static int unnormalizeVarName(int x, int n) {
    return x <= 0 ? x + 1 : x - n * 2;
  }

  /**
   * Formats x => y, taking negations into account
   */
  private static String formatImplication(int x, int y) {
    String xString = x >= 0 ? " " + x : "¬" + -x;
    String yString = y >= 0 ? " " + y : "¬" + -y;
    return xString + " ⇒ " + yString;
  }
}
