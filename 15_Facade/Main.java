import pagemaker.PageMaker;

public class Main{

	public static void main (String[] args){
		int actCount;

		if (args.length != 2){
			System.out.println("///////エラーだよ！！/////");
			System.out.println("作成する人のメールアドレスとhtmlファイル名を入れなさいよ！");
		}else{
			PageMaker.makeWelcomePage(args[0], args[1]);
		}
	}
}