public class Service {
  private static GracefulThread thread = null;
  public synchronized static void service() {
    System.out.print("service");
    if (thread != null && thread.isAlive()) {
      System.out.println(" is balked.");
      return;
    }
    thread = new ServiceThread();
    thread.start();
  }
  public synchronized static void cancel() {
    if (thread != null) {
      System.out.println("cancel.");
      thread.shutdownRequest();
    }
  }
}
