public class Log{
	private static final ThreadLocal<TSLog> tsLogCollection = new ThreadLocal<TSLog>();

	public static void println(String s){
		getTSLog().println(s);
	}

	public static void close(){
		getTSLog().close();
	}

	private static TSLog getTSLog(){
		TSLog tsLog = tsLogCollection.get();

		//最初の呼び出し時に初期化	
		if(tsLog == null){
			tsLog = new TSLog(Thread.currentThread().getName() + "-log.txt");
			tsLogCollection.set(tsLog);
			startWatcher(tsLog);
		}

		return tsLog;
	}

	private static void startWatcher(final TSLog tsLog){
		//終了を監視されるスレッド
		final Thread target = Thread.currentThread();

		final Thread watcher = new Thread(){
			public void run(){
				System.out.println("startWatcher for " + target.getName() + " BEGIN");
				try{
					target.join();
				}catch(InterruptedException e){

				}
				tsLog.close();
				System.out.println("startWatcher for " + target.getName() + " END");
			}
		} ;

		watcher.start();
	}


}