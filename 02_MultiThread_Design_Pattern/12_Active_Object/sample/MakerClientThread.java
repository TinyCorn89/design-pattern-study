import activeobject.ActiveObject;
import activeobject.Result;

public class MakerClientThread extends Thread {
	private final ActiveObject activeObject;
	private final char fillchar;
	public MakerClientThread (String name, ActiveObject activeObject) {
		super(name);
		this.activeObject = activeObject;
		this.fillchar = name.charAt(0);
	}
	public void run() {
		try {
			for (int i = 0; true; i++) {
				//戻り値のある呼び出し
				Result<String> result = activeObject.makeString(i, fillchar);
				Thread.sleep(10);
				String value = result.getResultValue();
				System.out.println(Thread.currentThread().getName() + ": value = " + value);
			}
		} catch (InterruptedException e) {

		}
	}
}