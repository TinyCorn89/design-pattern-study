public class PrinterProxy implements Printable{
	private String name;
	//変更点１
	private Printable real;
	private String className;

	//変更点２　合わせて変えなきゃ
	public PrinterProxy(String name, String className){
		this.className= className;
		this.name = name;
	}

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
		realize();
		real.print(string);
	}

		//変更点３なんだこのメソッド。
	private synchronized void realize(){
		if (real == null){
			try{
				real =  (Printable)Class.forName(className).newInstance();
				real.setPrinterName(name);
			} catch (ClassNotFoundException e) {
				System.out.println("クラス" + className + "が見つかりません。");
			} 
			//これは何対策？上野があるのに。
			catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

}