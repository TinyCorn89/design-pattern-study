/**
notifyAllをnotifyに変えます。
*/

public class Table{

	private final String[] buffer;
	private int tail;
	private int head;
	private int count;

	public Table(int count){
		//置けるケーキの個数を配列の長さで表します。
		this.buffer = new String[count];
		this.tail = 0;	//次にputする机のスペース番号
		this.head = 0;	//次にtakeする机のスペース番号
		this.count = 0;	//buffer内(机上？)のケーキ数
	}

	//ケーキを置く！
											//なんだっけ↓（詳しくは補講でだってさ）
											//このメソッドはキャンセル出来る（謎）っていうのは、waitを終了させられるてこと？
	public synchronized void put (String cake) throws InterruptedException{

		System.out.println(Thread.currentThread().getName() + "が机に置いたのは・・・？");
		System.out.println(cake);
		System.out.println();

		//ケーキを置くスペースがないので待機
				//↓ガード条件！こ、これは！３章！
		while(count >= buffer.length){
			wait();
		}

		//"tail"番のスペースにケーキを置く
		buffer[tail] = cake;
		//ケーキを置いたので、次にケーキを置くスペース番号をtailに代入
		tail = (tail + 1) % buffer.length;
		//ケーキを置いたので机上のケーキの数が＋1
		count++;

		//変更点
		notify();
	}

	//ケーキを取る
	public synchronized String take() throws InterruptedException{

		//パンもケーキもないので、待機
		while(count <= 0){
			wait();
		}

		//次に消費するケーキの決める
		String cake = buffer[head];

		//ケーキを消費するので、次の消費するスペース番号を変更
		head = (head + 1) % buffer.length;

		//ケーキを消費するので、机上のケーキの数を-1
		count--;

		//waitしているスレッドを起こすよ。
		notify();

		System.out.println(Thread.currentThread().getName() + "が食べる！貪り食う！");
		System.out.println(cake);
		System.out.println();

		//これは何のためだろう・・・。
		return cake;
	}
}