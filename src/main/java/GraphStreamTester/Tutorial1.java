package GraphStreamTester;

import org.yaml.snakeyaml.Yaml;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;

public class Tutorial1 {
  public static void buildNodes(Node parent, Map map){
    map.entrySet().forEach((entry)->{
      Map.Entry mapEntry = (Map.Entry)entry;
      Node node = new Node(mapEntry.toString());
      parent.addChild(node);
      if(mapEntry.getValue() instanceof Map){
        buildNodes(node, (Map)mapEntry.getValue());
      }
    });
  }

  private static String readfile() throws IOException {
    StringBuffer sb = new StringBuffer();
    String line;
    BufferedReader br = new BufferedReader(new InputStreamReader(Tutorial1.class.getClassLoader().getResourceAsStream("mindmap.yaml")));
    while((line = br.readLine()) != null){
      sb.append(line);
      sb.append("\n");
    }
    br.close();
    return sb.toString();
  }

  public static void main(String args[]) throws IOException {
    Yaml yaml = new Yaml();
    Map map = (Map)yaml.load(readfile());

    Node rootNode = new Node("root");
    buildNodes(rootNode, map);
    System.out.println(map);
    System.out.println(rootNode);

//    graph.display();
  }
}