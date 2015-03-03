/**
10秒でケリをつける課題用mainクラス
*/

public class Main{
	public static void main(String[] args){

		Table table = new Table(3);

		Thread[] threads = {
			new MakerThread("コックカワサキ", table, 31415),
			new MakerThread("ハンコック", table, 92653),
			new MakerThread("佐藤さん", table, 43533),
			new EaterThread("星のカービィ", table, 32384),
			new EaterThread("はらぺこあおむし", table, 62643),	
			new EaterThread("山崎さん", table, 94823)
		};

		//スレッドの起動
		for(int i = 0; i < threads.length; i++){
			threads[i].start();
			System.out.println("START!!!");
		}

		//10秒休み
		try{
			Thread.sleep(5000);
		} catch (InterruptedException e){

		}

		System.out.println("*****interrupt*******");

		//インタラプと
		for(int i = 0; i < threads.length; i++){
			threads[i].interrupt();
			System.out.println("STOP!!!!");
		}
	}
}