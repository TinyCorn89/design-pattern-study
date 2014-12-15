/**
課題10-1用のつねにランダム適当作戦
*/
import java.util.Random;

public class RandomStrategy implements Strategy{
	private Random random;
	private Hand preHand;
	public RandomStrategy(int seed){
		random = new Random(seed);
	}

	public Hand nextHand(){
		preHand = Hand.getHand(random.nextInt(3));
		return preHand;
	}
	public void study(boolean win){
		//つねにランダムだから勉強しない悪い子
	}
}