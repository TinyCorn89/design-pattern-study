/**
変更なし
*/

import java.util.Random;

public class MakerThread extends Thread{

	private final Random random;
	private final Table table;
	private static int id = 0;

	public MakerThread(String name, Table table, long seed){
		super(name);
		this.table = table;
		this.random = new Random(seed);
	}

	public void run(){
		try{
			while(true){
				String cake = makeCake();
				table.put(cake);
			}

		} catch(InterruptedException e){

		}
	}
	private static synchronized int nextId(){
		return id++;
	}

	//勝手に作ったケーキを作るメソッド
	private String makeCake(){
		String cake = getName() + "が作った" + nextId() + "番目のケーキ！おいしそう！";

		try{
			Thread.sleep(random.nextInt(10000));
		} catch (InterruptedException e){

		}
		
		return cake;
	}
}