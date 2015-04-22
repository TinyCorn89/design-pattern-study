class Something {
  private int x = 0;
  private int y = 0;
  // private volatile int x = 0;
  // private volatile int y = 0;

  public void write() {
  // public synchronized void write() {
    x = 100;
    y = 50;
  }

  public void read() {
  // public synchronized void read() {
    if (x < y) {
      System.out.println("\nReordered!");
      System.out.println("x = " + x + ", y = " + y);
    } else {
      System.out.print("+");
    }
  }
}

public class Main {
  public static void main(String[] args) {
    final Something something = new Something();

    new Thread() {
      public void run() {
        something.write();
      }
    }.start();

    new Thread() {
      public void run() {
        something.read();
      }
    }.start();
  }
}
