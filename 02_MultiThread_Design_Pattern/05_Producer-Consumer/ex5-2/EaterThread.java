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
				eatCake();
			}
		} catch (InterruptedException e){

		}

	}

	//勝手に作ったケーキを食べるメソッド
	private void eatCake(){

		try{

			//テキストでは変数つくってるけど、要らないよね?
			//table.take();
			Thread.sleep(random.nextInt(10000));
		} catch (InterruptedException e){

		}
	}
}