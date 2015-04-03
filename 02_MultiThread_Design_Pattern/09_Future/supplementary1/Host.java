/**
Host役
新しいスレッドを作って、RealData役を作る。
クライアントにはFuture役をvirtualDataとして返す。
新しいスレッドはrealData役を作ったら、Future役にRealDataをセットする
*/

import java.util.concurrent.Callable;

public class Host{
						//無名インナークラス？に利用されているから？
	public Data request(final int count, final char c){

		System.out.println("request(" + count + "," + c + ")");

		//1.FutureDataのインスタンスを作る
		FutureData future = new FutureData(
			new Callable<RealData>(){
				public RealData call(){
					return new RealData(count, c);
				}
			}
		);

		//2.RealFutureのインスタンスを作るための新しスレッドを起動する
		new Thread(future).start();

		System.out.println("request(" + count + "," + c + ")END");

		//3.FutureDataのインスタンスを戻り値にする！
		return future;
	}
}