/**
このクラスはplayerと二つのstrategyに使われるよ。
HandというよりJankenクラスって感じ
*/

public class Hand{
	//３手の値をつくるよ！
	public static final int HANDVALUE_GUU = 0;
	public static final int HANDVALUE_CHO = 1;
	public static final int HANDVALUE_PAA = 2;

	//手を表すインスタンス！インスタンスも配列でかけるんだね。
	//自分のクラスの名前でnewってできんのかよ！まじか
	public static final Hand[] hand = {
		new Hand(HANDVALUE_GUU),
		new Hand(HANDVALUE_CHO),
		new Hand(HANDVALUE_PAA)
	};

	//三手の名前を文字列で保存！
	private static final String[] name = {
		"ぐー！",
		"ちょき！",
		"ぱぁ！"
	};

	//手の値すぺーす
	private int handvalue;

	//コンストラクタ
	private Hand(int handvalue){
		this.handvalue = handvalue;
	}

	//以下メソッド祭り

	//引数の値からインスタンスを取るよ
	//え？このメソッドいる？直接newしろや。前なんかパターンやったっけ。
	public static Hand getHand (int handvalue){
		return hand[handvalue];
	};
	//強いかどうかの判定
	public boolean isStrongerThan(Hand h){
		return fight(h) == 1;
	};
	//弱いかどうかの判定・・・・これ要る？
	public boolean isWeakerThan(Hand h){
		return fight(h) == 1;
	};

	//値を使って強さを判定！
	private int fight(Hand h){
		//このthisはナニ。インスタンス？
		//引き分けのとき
		if (this == h){
			return 0;
		//かったとき！
		}else if((this.handvalue + 1) % 3 == h.handvalue){
			return 1;
		//負けたとき・・・。
		}else {
			return -1;
		}
	}
	//文字列表現に変換
	public String toString(){
		return name[handvalue];
	}
}