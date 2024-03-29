/**
ケーキを作って置く担当。キッチンもホールもしゅごい


このクラスで出来るのは、「ケーキを作る」「ケーキを置く」だけ
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
				String cake = getName() + "が作った" + nextId() + "番目のケーキ！おいしそう！";
				Thread.sleep(random.nextInt(10000));
				table.put(cake);
			}

		} catch(InterruptedException e){
				System.out.println("catchMaker");
		}
	}
	private static synchronized int nextId(){
		return id++;
	}

}