public class Main {
  public static void main(String[] args) {
    TicketMaker obj1 = TicketMaker.getInstance();
    TicketMaker obj2 = TicketMaker.getInstance();
    if (obj1 == obj2) {
      System.out.println("obj1 == obj2");
    } else {
      System.out.println("obj1 != obj2");
    }
  }
}