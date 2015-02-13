public class Main {
  public static void main(String[] args) {
    RandomCountDisplay d4 = new RandomCountDisplay(new StringDisplayImpl("Hello, Tokyo."));
    d4.randomDisplay(10);
  }
}