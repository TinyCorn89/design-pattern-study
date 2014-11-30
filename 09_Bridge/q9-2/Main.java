public class Main {
  public static void main(String[] args) {
    Display d1 = new Display(new FileDisplayImpl("input.txt"));
    d1.display();
  }
}