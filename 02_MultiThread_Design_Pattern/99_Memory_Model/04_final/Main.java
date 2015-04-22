class Something {
  private final int x;
  private static Something last = null;
  public Something() {
  // private Something() {
    x = 7;
    last = this;
  }
  public static void print() {
    if (last != null) {
      System.out.print(last.x);
    } else {
      System.out.print("o");
    }
  }
  /*
  public static Something create() {
    last = new Something();
    return last;
  }
  */
}

public class Main {
  public static void main(String[] args) {
    new Thread() {
      public void run() {
        new Something();
        // Something.create();
      }
    }.start();
    new Thread() {
      public void run() {
        Something.print();
      }
    }.start();
  }
}
