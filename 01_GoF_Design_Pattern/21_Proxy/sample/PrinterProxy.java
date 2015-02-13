/**
インスタンスを２つ作ることは重くないの？

*/


public class PrinterProxy implements Printable{
	private String name;
	private Printer real;

	//これ書く必要あるんかい。
	public PrinterProxy(){

	}

	public PrinterProxy(String name){
		this.name = name;
	}

	//なにこれ聞いたことない。synchronized
	public synchronized void setPrinterName(String name){
		if (real != null){
			real.setPrinterName(name);
		}
		this.name = name;
	}

	public String getPrinterName(){
		return name;
	}

	public void print (String string){

		//ここでご本人登場(Printer)
		realize();
		//これが委譲？らしい
		
		real.print(string);

		//正確には、またproxyPrinterさんに働いてもらうために、
		//real = null;（初期化）
		//ってした方がいいんじゃないかなぁ
	}

	private synchronized void realize(){
		if (real == null){
			real = new Printer(name);
		}
	}

}