/**
テーブルに置かれたケーキをひたすら食べるよ。

このクラスで出来るのは「ケーキを食べる」だけ
*/

import java.util.Random;

public class EaterThread extends Thread{
	private final Random random;
	private final Table table;

	public EaterThread(String name, Table table, long seed){
		super(name);
		this.table = table;
		this.random = new Random(seed);
	}

	public void run(){

		try{
			while(true){
				//eatCakeメソッドに入れられない！なぜ？
				String cake = table.take();
				//eatCake();
				Thread.sleep(random.nextInt(10000));				
			}
		} catch (InterruptedException e){
				System.out.println("catchEater");
		}

	}

	//勝手に作ったケーキを食べるメソッド
	private void eatCake() throws InterruptedException{

		Thread.sleep(random.nextInt(10000));

	}
}