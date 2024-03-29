import java.util.Date;

public class MySystem {
  private static MySystem instance = null;
  private Date date = new Date();
  private MySystem() {
  }
  public Date getDate() {
    return date;
  }
  // Using synchronized comes to low performance
  public static synchronized MySystem getInstance() {
    if (instance == null) {
      instance = new MySystem();
    }
    return instance;
  }
}
