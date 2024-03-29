
/**
 *
 * @author fx30294
 */
public class Channel {
    private static final int MAX_REQUEST = 100;
    private final Request[] requestQueue;
    private int tail;   //last 
    private int head;   //first
    private int count;
    
    private final WorkerThread[] threadPool;
    
    public Channel(int threads){
        this.requestQueue = new Request[MAX_REQUEST];
        this.head = 0;
        this.tail = 0;
        this.count = 0;
        
        threadPool = new WorkerThread[threads];
        for(int i = 0; i < threadPool.length; i++){
            threadPool[i] = new WorkerThread("Worker-" + i, this);
        }
    }
    public void startWorkers(){
        for(int i = 0; i < threadPool.length; i++){
            threadPool[i].start();
        }
    }
    public void stopAllWorkers(){
        for(int i = 0; i < threadPool.length; i++){
            threadPool[i].stopThread();
        }
    }
    public synchronized void putRequest(Request request) throws InterruptedException{
        while(count >= requestQueue.length){    //100個までしかputできない
            try{
                wait();
            }catch(InterruptedException e){
            }
        }
        requestQueue[tail] = request;
        tail = (tail + 1) % requestQueue.length;
        count++;
        notifyAll();
    }
    public synchronized Request takeRequest() throws InterruptedException{
        while(count <= 0){
            try{
                wait();
            }catch(InterruptedException e){
                
            }
        }
        Request request = requestQueue[head];
        head = (head + 1) % requestQueue.length;
        count--;
        notifyAll();
        return request;
    }
}
