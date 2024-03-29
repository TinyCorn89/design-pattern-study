/**
Strategyインターフェイスのメソッドを実装していくぞ！
作戦2
過去の勝ち負け履歴から、確率を計算！（賢い！
*/

import java.util.Random;

public class ProbStrategy implements Strategy{
	private Random random;
	private int preHandValue = 0;
	private int currentHandValue = 0;

	private int[][] history = {
		{1, 1, 1},
		{1, 1, 1},
		{1, 1, 1}
	};

	public ProbStrategy (int seed){
		random = new Random(seed);
	};

	public Hand nextHand(){
		int bet = random.nextInt(getSum(currentHandValue));
		int handvalue = 0;
		if(bet < history[currentHandValue][0]){
			handvalue = 0;
		}else if (bet < history[currentHandValue][0] + history[currentHandValue][1]){
			handvalue = 1;
		}else{
			currentHandValue = 2;
		}
		preHandValue = currentHandValue;
		currentHandValue = handvalue;
		return Hand.getHand(handvalue);
	};

	public void study(boolean win){
		if(win){
			history[preHandValue][currentHandValue]++;
		}else{
			history[preHandValue][(currentHandValue + 1) % 3]++;
			history[preHandValue][(currentHandValue + 2) % 3]++;
		}
	};

	private int getSum(int hv){
		int sum = 0;
		for (int i = 0; i < 3; i++){
			sum += history[hv][i];
		}
		return sum;
	}

}