public class Main {
  public static void main(String[] args) {
    Thread t = new Thread() {
      public void run() {
        while (true) {
          try {
            if (Thread.currentThread().isInterrupted()) {
            // if (Thread.interrupted()) {
              throw new InterruptedException();
            }
            System.out.print(".");
          } catch (InterruptedException e) {
            System.out.print("*");
          }
        }
      }
    };
    t.start();
    try {
      Thread.sleep(5000);
    } catch (InterruptedException e) {
    }
    t.interrupt();
  }
}
