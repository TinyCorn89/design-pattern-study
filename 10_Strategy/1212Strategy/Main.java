/**
じゃんけんがはじまるよ
数字を二つ入れる仕様
*/

public class Main{
	public static void main (String[] args){

		//数字を２つ入れなかった対策
		if (args.length != 2){
			System.out.println("数字を入れなさい！！");
			System.out.println("Example: java Main 123 45");
			//なにこれ
			System.exit(0);
		}

		//入力した数字を文字列から数値へ！
		int seed1 = Integer.parseInt(args[0]);
		int seed2 = Integer.parseInt(args[1]);

		//選手を作るよ。名前と使用する戦力を入力
		//なにこの書き方！！そんなとこにもnew入るのかよ
		Player player1 = new Player("HIRADE", new WinningStrategy(seed1));
		Player player2 = new Player("MASUNAGA", new ProbStrategy(seed2));

		System.out.println("//////////はっけよい、のこった！！！//////////");
		System.out.println("");

		//それでは試合開始！1000本勝負
		for(int i = 1; i <= 100000; i++){
			//両選手の手を決定
			//これはインスタンス化・・・・じゃない？
			//なぜHandクラス
			Hand nextHand1 = player1.nextHand();
			Hand nextHand2 = player2.nextHand();

			//勝負に対する処理

			if(nextHand1.isStrongerThan(nextHand2)){
				System.out.println("第" + i + "回戦");
				System.out.println(player1 + "は「" + nextHand1 + "」" + player2 + "は「" + nextHand2 + "」");
				System.out.println("winner:" + player1 + "!! <やったー！");
				player1.win();
				player2.lose();
			} else if(nextHand2.isStrongerThan(nextHand1)){
				System.out.println("第" + i + "回戦");
				System.out.println(player1 + "は「" + nextHand1  + "」" + player2 + "は「" + nextHand2 + "」");
				System.out.println("winner:" + player2 + "!! <やったー！");
				player1.lose();
				player2.win();
			} else{
				System.out.println("第" + i + "回戦");	
				System.out.println("Even....(どんまい)");
				player1.even();
				player2.even();
			}
		}

		//試合結果集計表示
		//上記標準出力でやってるけど、toStinrg要らないじゃん！！
		System.out.println("");
		System.out.println("//////////試合終了！結果は〜？//////////");

		System.out.println(player1.toString());
		//System.out.println(player1;
		System.out.println(player2.toString());
		//System.out.println(player2);
	}
}