/**
Printerを知らなくていいPrinterProxyって意味あんの？
親玉は知っときなさいよ。

*/

public class Main{
	public static void main (String[] arg){
		Printable p = new PrinterProxy("Alice", "Printer");

		System.out.println("名前は現在" + p.getPrinterName() + "です。");

		p.setPrinterName("Bob");
		System.out.println("名前は現在" + p.getPrinterName() + "です。");

		p.print("Hello, world.");
	}

}