/**
ホスト役からクライアント役に渡される引換券
client役から操作された場合、realData役が出来上がるまではwaitで待つ。

*/

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;
import java.util.concurrent.ExecutionException;

public class FutureData extends FutureTask<RealData> implements Data{

	public FutureData(Callable<RealData> callable){
		super(callable);
	}

	public String getContent(){
		String string = null;

		try{
			string = get().getContent();
		}catch(InterruptedException e){
			e.printStackTrace();
		}catch(ExecutionException e){
			e.printStackTrace();
		}
		return string;
	}
}