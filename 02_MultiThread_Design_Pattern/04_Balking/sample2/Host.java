import java.util.concurrent.TimeoutException;

public class Host {
	private final long timeout; //value of timeout
	private boolean ready = false; //true is to be able to execute a method

	public Host(long timeout) {
		this.timeout = timeout;
	}

	//change status
	public synchronized void setExecutable (boolean on){
		ready = on;
		notifyAll();
	}

	//judge status
	public synchronized void execute() throws InterruptedException, TimeoutException {
		long start = System.currentTimeMillis(); //start time
		while(!ready){
			long now  = System.currentTimeMillis(); //current time
			long rest = timeout - ( now - start ); //waitting time
			if( rest <= 0){
				throw new TimeoutException("now - start = " + (now - start) + ",\t timeout = " + timeout);
			}
			wait(rest);
		}
		doExecute();
	} 

	//actually execute
	private void doExecute(){
		System.out.println(Thread.currentThread().getName() + " calls do Execute");
	}
}