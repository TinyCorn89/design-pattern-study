/**
javac Main.javaって打っても、これが再コンパイルされないのはなんでだろう？

*/

public class Printer implements Printable{
	private String name;

	//これはなんで作ってるんだろう？
	//引数なしのコンストラクタは作るのがマナー？
	public Printer (){
		heavyJob("Printerクラスのインスタンスを生成中！");
	}
	public Printer (String name){
		this.name = name;
		heavyJob("Printerクラスのインスタンス("+name+")を作成中");
	}

	public void setPrinterName(String name){
		this.name = name;
	}

	public String getPrinterName(){
		return name;
	}

	public void print(String string){
		System.out.println("===" + name + "===");
		System.out.println();
		System.out.println("┈┈┈┈▅┈┈▕■┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈"); 
		System.out.println("┈┈┈▕┈┈┈╱╲▕■┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈");
		System.out.println("┈┈┈╱╲┈┈▏▕╱╲┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈");
		System.out.println("┈┈┈▏▕╱╲▏▎▏▕╱╲┈▃┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈");
		System.out.println("┈╱╲▏▎▅▂▅▂▏▎▏▎▏▏ ┈┈" + string);
		System.out.println("▂▏▎▏▕╭┳┳╮▏┊▏▕╱╲ ┈┈┈┈┈┈┈┈┈┈┈┈┈┈");
		System.out.println("▏▏▏▎( ˘ω˘ )▏ ▏▎▏┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈");
		System.out.println("▇▆▅▃▂┻┻┻┻▂▃▅▆▇▉ ");
	}

	//HJ(仮)
	private void heavyJob(String msg){
		System.out.println(msg);

		for (int i = 0; i < 5; i++){
			System.out.println(".");
			if(i == 4){
				System.out.println("Compleat!");
			}
			try{
				Thread.sleep(1000);
			}catch (InterruptedException e){

			}
		}
	}
}