import pagemaker.PageMaker;

public class Main2{
	public static void main (String[] args){

		if(args.length != 1){
			System.out.println("///////エラーだよ！！///////");
			System.out.println("リンクページのファイル名を入力して！");
		}else{
			PageMaker.makeLinkPage(args[0]);
		}
	}
}