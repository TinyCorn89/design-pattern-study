/**
じゃんけんを行う人を表すクラス
戦略（次の手）に関してはstrategyに委譲してるよ
*/

public class Player{
	private String name;
	//これでインターフェイスのメソッドが使えるの？
	private Strategy strategy;
	private int wincount;
	private int losecount;
	private int gamecount;

	//コンストラクタ。
	public Player(String name, Strategy strategy){
		this.name = name;
		this.strategy = strategy;
	}

	//次の手をstrategyを使って決める！
	public Hand nextHand(){
		return strategy.nextHand();
	}
	//勝ったら・・・・
	public void win(){
		strategy.study(true);
		wincount++;
		gamecount++;
	}
	//負けたら・・・・
	public void lose(){
		strategy.study(false);
		losecount++;
		gamecount++;
	}
	//引き分けならば
	public void even(){
		gamecount++;
	}

	@Override
	public String toString(){
		return "[" + name + "さん:" + gamecount + "games, " + wincount + "win, " + losecount + "lose" + "]";
	}
}