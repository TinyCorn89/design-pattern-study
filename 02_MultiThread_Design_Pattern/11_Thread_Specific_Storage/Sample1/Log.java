import java.io.PrintWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Log{
	private static PrintWriter writer = null;

	static{
		try{
			writer = new PrintWriter(new FileWriter("log.txt"));
		}catch(IOException e){
			e.printStackTrace();
		}
	}

	// ログの書き込み
	public static void println(String s){
		writer.println(s);
	}

	public static void close(){
		writer.println("=== End of log ===");
		writer.close();
	}
}