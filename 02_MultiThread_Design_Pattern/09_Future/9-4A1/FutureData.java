/**
ホスト役からクライアント役に渡される引換券
client役から操作された場合、realData役が出来上がるまではwaitで待つ。

*/
import java.util.concurrent.ExecutionException;

public class FutureData implements Data{
	private RealData realData = null;
	private ExecutionException exception = null;
	private boolean ready = false;

	public synchronized void setRealData(RealData realData){
		if(ready){
			//なにこれ？
			return;
		}
		this.realData = realData;
		this.ready = true;
		notifyAll();

	}
	public synchronized void setException(Throwable throwable){
		if(ready){
			return;
		}
		this.exception = new ExecutionException(throwable);
		this.ready = true;
		notifyAll();
	}

	public synchronized String getContent() throws ExecutionException{
		while(!ready){
			try{
				wait();
			}catch(InterruptedException e){

			}
		}
		if(exception != null){
			throw exception;
		}
		return realData.getContent();
	}
}