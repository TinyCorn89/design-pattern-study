/**
プロデューサーさん！からのデータを受け取り、保管する
消費者の要求に応じてテータを渡す、Channel役

排他制御！
データの同時更新を防ぐために、
あるスレッド（役？）が利用している間は、他のスレッド（役？）が利用できないようにする	

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
			System.out.println(Thread.currentThread().getName() + "ケーキがいっぱい！");
			wait();
			System.out.println(Thread.currentThread().getName() + "スペースが空いた！");
		}

		//"tail"番のスペースにケーキを置く
		buffer[tail] = cake;
		//ケーキを置いたので、次にケーキを置くスペース番号をtailに代入
		tail = (tail + 1) % buffer.length;
		//ケーキを置いたので机上のケーキの数が＋1
		count++;

		//waitしているスレッドを起こすよ
		//これは最後に書くものなの？waitのループの直後じゃないの？
		notifyAll();
	}

	//ケーキを取る
	public synchronized String take() throws InterruptedException{

		//パンもケーキもないので、待機
		while(count <= 0){
			System.out.println(Thread.currentThread().getName() + "ケーキがない（'Å`）");
			wait();
			System.out.println(Thread.currentThread().getName() + "ケーキがきた！（・８・）");		}

		//次に消費するケーキの決める
		String cake = buffer[head];

		//ケーキを消費するので、次の消費するスペース番号を変更
		head = (head + 1) % buffer.length;

		//ケーキを消費するので、机上のケーキの数を-1
		count--;

		//waitしているスレッドを起こすよ。
		notifyAll();

		System.out.println(Thread.currentThread().getName() + "が食べる！貪り食う！");
		System.out.println(cake);
		System.out.println();

		//これは何のためだろう・・・。
		return cake;
	}
}