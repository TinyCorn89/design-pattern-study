/**
10秒でケリをつける課題用mainクラス
*/

public class Main{
	public static void main(String[] args){

		Table table = new Table(3);

		Thread[] threads = {

			new MakerThread("コックカワサキ", table, 31415).start();
			new MakerThread("ハンコック", table, 92653).start();
			new MakerThread("佐藤さん", table, 43533).start();
			new EaterThread("星のカービィ", table, 32384).start();
			new EaterThread("はらぺこあおむし", table, 62643).start();	
			new EaterThread("山崎さん", table, 94823).start();
		};



		//スレッドの起動
		for(int i = 0; i< threads.length; i++){
			threads[i].start();
		}

		//10秒休み
		try{
			Thread.sleep(10000);
		} catch (InterruptedException e){

		}

		//ダブルちょん、必要？テキストにない。
		System.out.println("*****interrupt*******");

		//インタラプと
		for(int i =0; i < threads.length; i++){
			threads[i].Interrupt();
		}
	}
}