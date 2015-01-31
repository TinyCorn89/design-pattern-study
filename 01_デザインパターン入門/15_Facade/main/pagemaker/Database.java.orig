/**
データベース管理用クラス
Database.txtを読み込むよ！

ファイル操作だから異常系対策も大事！
オブジェクトを作らない、newしなくてもメソッドは使えるんだ？pageMakerにて
*/

package pagemaker;
//パッケージってなんだよ。フォルダでまとめればいいのか？

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.Iterator;

public class Database{
	private Database(){
	}

	//これはオーバーライド？
	public static Properties getProperties(String dbname){
	//Propertiesはいきなりどこから湧いて出てきたんだよ！
	//あ、インポートしたのか		

		String filename = dbname + ".txt";
		Properties prop = new Properties();
		try{
			prop.load(new FileInputStream(filename));
		}catch(IOException e){
			System.out.println("Warning:" + filename + " is not found.");
		}
		return prop;
	}
}