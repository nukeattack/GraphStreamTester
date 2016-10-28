package GraphStreamTester;

import java.util.LinkedList;
import java.util.List;

/**
 *
 */
public class Node {
  static int id = 0;
  private int nodeId;
  private Node parent;
  private String text;
  private List<Node> children = new LinkedList<>();

  public Node(String text) {
    this.text = text;
    nodeId = id++;
  }

  public Node getParent() {
    return parent;
  }

  public void setParent(Node parent) {
    this.parent = parent;
  }

  public String getText() {
    return text;
  }

  public void setText(String text) {
    this.text = text;
  }

  public void addChild(Node node){
    node.setParent(this);
    children.add(node);
  }

  public List<Node> getChildren() {
    return children;
  }

  public void setChildren(List<Node> children) {
    this.children = children;
    children.forEach(c->c.setParent(this));
  }

  @Override
  public String toString() {
    return "Node{" +
           "nodeId=" + nodeId +
           ", text='" + text + '\'' +
           ", children=" + children +
           '}';
  }
}
