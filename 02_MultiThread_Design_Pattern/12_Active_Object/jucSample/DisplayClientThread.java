import activeobject.ActiveObject;

import java.util.concurrent.Future;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.CancellationException;

public class DisplayClientThread extends Thread {
	private final ActiveObject activeObject;
	public DisplayClientThread (String name, ActiveObject activeObject) {
		super(name);
		this.activeObject = activeObject;
	}
	public void run() {
		try {
			for (int i = 0; true; i++) {
				//戻り値のない呼び出し
				String string = Thread.currentThread().getName() + " " + i;
				activeObject.displayString(string);
				Thread.sleep(200);
			}
		} catch (RejectedExecutionException e) {
			System.out.println(Thread.currentThread().getName() + ":" + e);
		} catch (CancellationException e) {
			System.out.println(Thread.currentThread().getName() + ":" + e);
		} catch (InterruptedException e) {
			System.out.println(Thread.currentThread().getName() + ":" + e);
		}
	}
}