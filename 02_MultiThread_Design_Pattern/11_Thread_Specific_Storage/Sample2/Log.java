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
		}

		return tsLog;
	}

}