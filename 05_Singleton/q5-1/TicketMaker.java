public class TicketMaker {
  private static TicketMaker ticketMaker = new TicketMaker();
  private int ticket = 1000;
  /***
    解答例ではコンストラクターが実装されているが，
    初期化するフィールド等ないのにも関わらず必要なのか？
  ***/
  private TicketMaker() {
  }
  public static TicketMaker getInstance() {
    return ticketMaker;
  }
  public synchronized int  getNextTicketNumber() {
    return ticket++;
  }
}