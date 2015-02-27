/**
「コック」と注文は特に多くない「お客」を動かく神のクラス


*/

public class Main{
	public static void main(String[] args){

		new MakerThread("コックカワサキ", new Table(3), 31415).start();

		new EaterThread("星のカービィ", new Table(3), 32384).start();

	}
}