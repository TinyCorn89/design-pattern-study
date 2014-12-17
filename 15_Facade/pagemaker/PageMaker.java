/**
mainで呼ばれてる、ページを作る作業を実際に記述してるクラスだよー
いままではMainクラスに書いていたような内容だよー


テキストで使ってるEnumeration　はIteratorに変更！
java.util.Enumerationは，
Javaのコアパッケージの中ではIteratorより古くからある列挙用のインタフェースです。
現在，このインタフェースを使うメリットはほとんどありません
*/


package pagemaker;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;
import java.util.Enumeration;

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
			finishInfo("ファイル名:" + filename);

		}catch(IOException e){
			e.printStackTrace();
		}
	}
	public static void makeLinkPage(String filename){
		try{
			Properties mailprop = Database.getProperties("maildata");
			
			HtmlWriter writer = new HtmlWriter(new FileWriter(filename));
			writer.title("リンクペィジ");
			writer.paragraph("ひゃっはーここはリンクページだ！！");
			writer.paragraph("Database内の個人情報を晒すぜ！");

			Enumeration ite = mailprop.propertyNames();
			while (ite.hasMoreElements()){
				String mailaddr = (String)ite.nextElement();
			    String username = mailprop.getProperty(mailaddr, "(unknown)");
				writer.mailTo(mailaddr, username);
			}
			writer.close();

			//作り終わったら、その旨を報告します。
			finishInfo("ファイル名:" + filename);

		}catch(IOException e){
			e.printStackTrace();
		}
	}

	public static void finishInfo(String text){
		System.out.println("///////////作成完了////////////");
		System.out.println(text);
		System.out.println("//////////やったー！////////////");
	}
}