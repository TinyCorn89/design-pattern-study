package ArrayListSample;

import java.util.List;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        try{
        List<Integer> list = new ArrayList<>();
        new WriterThread(list).start();
        new ReaderThread(list).start();
        }
        catch(Exception ex){
            System.out.println(ex.toString());
        }
        
    }
}
