/**
テーブルに置かれたケーキをひたすら食べるよ。

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
				String cake = table.take();
				eatCake();
			}
		} catch (InterruptedException e){

		}

	}

	//勝手に作ったケーキを作るメソッド
	private void eatCake(){
		try{
			Thread.sleep(random.nextInt(10000));
		} catch (InterruptedException e){

		}
	}
}