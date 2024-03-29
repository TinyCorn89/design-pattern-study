import java.util.concurrent.TimeoutException;

public class Main {
	public static void main(String[] args){
		Host host = new Host(3000);
		try{
			System.out.println("execute BEGIN");
			host.execute();
			host.setExecutable(true);
		} catch (TimeoutException e){
			e.printStackTrace();
		} catch (InterruptedException e){
			e.printStackTrace();
		}
	}
}