public class SortAndPrint{
	String[] data;
	//コンストラクタを使わない場合は、これでそのクラスのメソッドが使えるってこと？newイランの？
	Sorter sorter;

	public SortAndPrint(String[] data, Sorter sorter){
		this.data = data;
		this.sorter = sorter;
	}

	public void execute(){
		System.out.println("１回めのprint()");
		print();
		System.out.println("sortするよ");
		sorter.sort(data);
		System.out.println("２回めのprint()");
		print();
	}

	public void print(){
		for (int i = 0; i < data.length; i++){
			System.out.println(data[i]);
		}
	}
}