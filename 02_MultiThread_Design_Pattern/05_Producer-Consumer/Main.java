/**
「コック」と注文は特に多くない「お客」を動かく神のクラス


*/

public class Main{
	public static void main(String[] args){

		//ケーキを３個まで置けるテーブル（小さい）
		Table table = new Table(3);

		new MakerThread("コックカワサキ", table, 31415).start();
		new MakerThread("ハンコック", table, 92653).start();
		new MakerThread("佐藤さん", table, 43533).start();

		new EaterThread("星のカービィ", table, 32384).start();
		new EaterThread("はらぺこあおむし", table, 62643).start();	
		new EaterThread("山崎さん", table, 94823).start();	
	}
}