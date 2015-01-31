import java.util.Random;

public class RandomCountDisplay extends CountDisplay {
  private Random random = new Random();
  public RandomCountDisplay(DisplayImpl impl) {
    super(impl);
  }
  void randomDisplay(int times) {
    multiDisplay(random.nextInt(times));
  }
}