/**
課題
*/

public class Host{
	public static void execute(int count){
		for (int i = 0;i< count; i++){
			//ここが回答！
			if(Thread.interrupted()){
				throw new InterruptedException();
			}

			doHeavyJob;
		}
	}

	private static void doHeavyJob(){
		System.out.println("doHeavyJob");
		long start = System.currentTimeMillis();
		while (start + 10000 > System.currentTimeMillis()){
			//busy loop
		}
		System.out.println("doHeavyJob END");
	}
}