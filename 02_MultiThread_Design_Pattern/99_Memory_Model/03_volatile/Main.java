class Something {
  private int x = 0;
  private volatile boolean valid = false;

  public void write() {
    x = 123;
    valid = true;
  }

  public void read() {
    if (valid) {
      System.out.print(x);
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
