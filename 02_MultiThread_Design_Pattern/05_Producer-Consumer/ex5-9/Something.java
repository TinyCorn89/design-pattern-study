public class Something{
	public static void method(long x) throws InterruptedException{
		if (x != 0){
			Object object = new Object();
			System.out.println(object);
			//synchronized (object){
				object.wait(x);
			//}
		}
	}
}