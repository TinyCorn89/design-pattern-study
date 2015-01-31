public class Singleton {
  private static Singleton singleton = null;
  private Singleton() {
    System.out.println("Generated a new instance.");
    slowdown();
  }
  //public static Singleton getInstance() {
  public static synchronized Singleton getInstance() {
    if (singleton == null) {
      singleton = new Singleton();
    }
    return singleton;
  }
  private void slowdown() {
    try {
      Thread.sleep(500);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }
}