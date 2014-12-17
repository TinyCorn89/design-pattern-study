/**
mainで呼ばれてる、ページを作る作業を実際に記述してるクラスだよー
いままではMainクラスに書いていたような内容だよー

*/


package pagemaker;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;

public class PageMaker{
	private PageMaker(){
		//自分、今プライベートなんで
		//インスタンス化させへんで
	}
	public static void makeWelcomePage(String mailaddr, String filename){
		try{
			//なんで突然Databaseクラスのメソッドが使えるんですかねぇ・・・。同じパッケージだから？
			//Database databese;なんて宣言は要らないの？
			//propertiesオブジェクト？を持ってきます。(new Properties をやってる)
			Properties mailprop = Database.getProperties("maildata");

			//プロパティファイルのアドレス（ker）から名前（value）を取得
			String username = mailprop.getProperty(mailaddr);

			//コンストラクタの引数はWriteだけど、FileWriter送ってもいいの？
			//FileWriterがWriterの子クラスだからかな
			HtmlWriter writer = new HtmlWriter(new FileWriter(filename));

			//htmlに書き込みまくるよ！
			writer.title("Welcome to" + username + "'s page!");
			writer.paragraph(username + "のページにようこそ！");
			writer.paragraph("メール待ってるぜ！");
			writer.mailTo(mailaddr, username);
			writer.close();

			//作り終わったら、その旨を報告します。
			System.out.println("///////////作成完了////////////");
			System.out.println("ファイル名" + filename);
			System.out.println("アドレス" + mailaddr);
			System.out.println("ゆーざーねーむ" + username);
			System.out.println("///////////////////////");

		}catch(IOException e){
			e.printStackTrace();
		}
	}
/*	public static void makeLinkPage(String filename){
		try{
			Properties mailprop = Database.getProperties("maildata");
			String username = mailprop.getProperty(mailaddr);
			HtmlWriter writer = new HtmlWriter(new FileWriter(filename));
			writer.title("Welcome to" + username + "'s page!");
			writer.paragraph(username + "のページにようこそ！");

			writer.paragraph("メール待ってるぜ！");
			writer.mailTo(mailaddr, username);
			writer.close();
			System.out.println("///////////作成完了////////////");
			System.out.println("ファイル名" + filename);
			System.out.println("リンクページだよ！");
			System.out.println("///////////////////////");
		}catch(IOException e){
			e.printStackTrace();
		}
	}*/
}