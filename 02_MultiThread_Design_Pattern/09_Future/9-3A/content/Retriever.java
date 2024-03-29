package content;

public class Retriever{
	public static Content retrieve(String urlstr){
		final AsyncContentImpl future = new AsyncContentImpl();

		new Thread(){
			public void run(){
				future.setContent(new SyncContentImpl(urlstr));
			}
		}.start();

		return future;
	}
}