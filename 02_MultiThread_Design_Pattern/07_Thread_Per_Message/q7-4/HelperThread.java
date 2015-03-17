public class HelperThread extends Thread {
	private final Helper helper;
	private final int count;
	private final char c;

	public Helper Thread(Helper helper, int count, char c) {
		this.helper = helper;
		this.count = count;
		this.c = c;
	}

	public void run() {
		helper.handle(count, c);
	}
}