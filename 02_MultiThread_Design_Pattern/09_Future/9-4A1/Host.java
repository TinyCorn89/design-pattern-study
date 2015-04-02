/**
Host役
新しいスレッドを作って、RealData役を作る。
クライアントにはFuture役をvirtualDataとして返す。
新しいスレッドはrealData役を作ったら、Future役にRealDataをセットする
*/

public class Host{
						//無名インナークラス？に利用されているから？
	public Data request(final int count, final char c){

		System.out.println("request(" + count + "," + c + ")");

		//1.FutureDataのインスタンスを作る
		final FutureData future = new FutureData();

		//2.RealFutureのインスタンスを作るための新しスレッドを起動する
		new Thread(){
			public void run(){
				try{
					RealData realData = new RealData(count, c);
					future.setRealData(realData);
				}catch(Exception e){
					future.setException(e);
				}
			}
		}.start();

		System.out.println("request(" + count + "," + c + ")END");

		//3.FutureDataのインスタンスを戻り値にする！
		return future;
	}
}