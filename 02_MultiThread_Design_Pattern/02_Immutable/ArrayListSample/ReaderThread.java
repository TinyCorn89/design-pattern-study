import java.util.ConcurrentModificationException;
import java.util.List;

public class ReaderThread extends Thread {
    private final List<Integer> list;
    public ReaderThread(List<Integer> list) {
        super("ReaderThread");
        this.list = list;
    }
    public void run() {
        try{
        while (true) {
            for (int n : list) {
                System.out.println(n);
            }
        }
        }
        catch(ConcurrentModificationException ex){
            System.out.println(ex.getMessage());
        }
    }
}
