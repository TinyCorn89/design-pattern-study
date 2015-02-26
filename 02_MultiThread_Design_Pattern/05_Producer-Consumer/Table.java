/**


*/

public class Table{

	private final String[] buffer;
	private int tail;
	private int head;
	private int count;

	public Table(int count){
		//置けるケーキの個数を配列の長さで表します。
		this.buffer = new String[count];
		this.head = 0;	//次にputする場所
		this.head = 0;	//次にtakeする場所
		this.count = 0;	//buffer内のケーキ数
	}

	//ケーキを置く！
											//なんだっけ↓（詳しくは補講でだってさ）
											//このメソッドはキャンセル出来る（謎）
	public synchronized void put (String cake) throws InterruptedException{

		System.out.println(Thread.currentThread().getName() + "が机に置いたのは・・・？");
		System.out.println(cake);
		System.out.println();

				//↓ガード条件！こ、これは！３章！
		while(count >= buffer.length){
			wait();
		}

		buffer[tail] = cake;
		tail = (tail + 1) % buffer.length;
		count++;

		//waitしているスレッドを起こすよ
		notifyAll();
	}

	//ケーキを取る
	public synchronized String take() throws InterruptedException{
		while(count <= 0){
			wait();
		}
		String cake = buffer[head];
		head = (head + 1) % buffer.length;
		count--;
		notifyAll();
		System.out.println(Thread.currentThread().getName() + "が食べる！貪り食う！");
		System.out.println(cake);
		System.out.println();

		return cake;
	}
}