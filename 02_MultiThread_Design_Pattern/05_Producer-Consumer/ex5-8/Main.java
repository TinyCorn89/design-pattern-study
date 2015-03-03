/**
変更なし
*/

public class Main{
	public static void main(String[] args){

		//ケーキを３個まで置けるテーブル（小さい）を作成
		Table table = new Table(3);

		//ケーキを作ってテーブルに置く、コックを作成
		new MakerThread("コックカワサキ", table, 31415).start();
		new MakerThread("ハンコック", table, 92653).start();
		new MakerThread("佐藤さん", table, 43533).start();
										//↑ケーキを作る時間の乱数用

		//ひたすら食べるお客を作成
		new EaterThread("星のカービィ", table, 32384).start();
		new EaterThread("はらぺこあおむし", table, 62643).start();	
		new EaterThread("山崎さん", table, 94823).start();
										//↑ケーキを食べる時間の乱数用
	}
}