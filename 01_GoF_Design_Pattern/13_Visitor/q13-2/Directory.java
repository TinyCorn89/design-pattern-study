import java.util.Iterator;
import java.util.ArrayList;

public class Directory extends Entry {
  private String name;
  private ArrayList<Entry> dir = new ArrayList<Entry>();
  public Directory(String name) {
    this.name = name;
  }
  public String getName() {
    return name;
  }
  public int getSize() {
    SizeVisitor v = new SizeVisitor();
    accept(v);
    return v.getSize();
  }
  public Entry add(Entry entry) {
    dir.add(entry);
    return this;
  }
  public Iterator iterator() {
    return dir.iterator();
  }
  public void accept(Visitor v) {
    v.visit(this);
  }
}