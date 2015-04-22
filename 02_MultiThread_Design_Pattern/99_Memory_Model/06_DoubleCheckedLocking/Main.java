public class Main {
  private static Object first;
  private static Object second;
  
  public static void main(String[] args) {
    new Thread() {
      public void run() {
        first = MySystem.getInstance().getDate();
      }
    }.start();
    new Thread() {
      public void run() {
        second = MySystem.getInstance().getDate();
      }
    }.start();
    try {
      Thread.sleep(10);  
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    System.out.print(first == second ? "o" : "+");
  }
}