/**
本物とパチもんプリンターを同一視するためのインターフェイス。
同一視ってことは、使用するクラスでは違いがないってこと？


*/

public interface Printable{

	//インターフェイスのメソッドに使う引数は宣言してないけどいいの？
	//あ、要らないや

	public abstract void setPrinterName(String name);
	public abstract String getPrinterName();
	public abstract void print (String string);
}