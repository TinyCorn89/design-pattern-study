class Runner extends Thread {
  private boolean quit = false;
  // private volatile boolean quit = false;
  
  public void run() {
    while (!quit) {
      // ...
    }
    System.out.print("+");
  }

  public void shutdown() {
    quit = true;
  }
}

public class Main {
  public static void main(String[] args) {
    Runner runner = new Runner();
    runner.start();
    runner.shutdown();
  }
}