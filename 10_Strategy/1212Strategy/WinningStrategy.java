/**
Strategyインターフェイスのメソッドを実装していくぞ！
作戦１
勝ったら同じ手、負けたら乱数
*/

import java.util.Random;

public class WinningStrategy implements Strategy {
	private Random randomJob;
	private boolean won = false;
	//Handのインスタンス化しないのかーい！
	private Hand preHand;

	//コンストラクタを作るZ
	public WinningStrategy(int seed){
		randomJob = new Random(seed);
	}

	//以下メソッドの実装！

	//次の手は
	public Hand nextHand(){
		//負けたら乱数
		if(!won){
			preHand = Hand.getHand(randomJob.nextInt(3));
		}
		//それ以外は前と同じ手・・・・というか何も代入しないの？
		return preHand;
	}
	//勝ったかどうかを保存しとくよ
	public void study(boolean win){
		won = win;
	}
}