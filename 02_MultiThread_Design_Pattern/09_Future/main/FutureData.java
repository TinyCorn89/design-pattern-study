/**
ホスト役からクライアント役に渡される引換券
client役から操作された場合、realData役が出来上がるまではwaitで待つ。

*/
public class FutureData implements Data{
	private RealData realData = null;
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
	public synchronized String getContent(){
		while(!ready){
			try{
				wait();
			}catch(InterruptedException e){

			}
		}
		return realData.getContent();
	}
}