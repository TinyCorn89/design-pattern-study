/**
VirtualData役。
future役とRealData役を同一視させるためのもの
*/
import java.util.concurrent.ExecutionException;

public interface Data{
	public abstract String getContent() throws ExecutionException;
}