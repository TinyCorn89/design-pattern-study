/**
課題
止まれるホスト
*/

public class CancelHost{

	public static void execute(int count)throws InterruptedException{
		for (int i = 0;i< count; i++){
			System.out.println("check1");
			//ここが回答！
			if(Thread.interrupted()){
				throw new InterruptedException();
			}
			System.out.println("check2");
			doHeavyJob();
		}
	}

	private static void doHeavyJob(){

		int c = 0;
		System.out.println("doHeavyJob");
		long start = System.currentTimeMillis();
		while (start + 10000 > System.currentTimeMillis()){
			c++;
			//busy loop
		}
		System.out.println(c);
		System.out.println("doHeavyJob END");
	}
}