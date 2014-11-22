public class Triple {
  private int id;
  private static Triple[] triple = {
    new Triple(0),
    new Triple(1),
    new Triple(2)
  };
  private Triple(int id) {
    System.out.format("Object id %d was generated.%n", id);
    this.id = id;
  }
  public static Triple getInstance(int id) {
    return triple[id];
  }
  public String toString() {
    return "Object id " + this.id;   
  }
}