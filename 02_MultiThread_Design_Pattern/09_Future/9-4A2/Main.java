/**
Client役
Hostにリクエストを出して、VirtualDataを受け取る

*/

public class Main{
	public static void main(String[] args){

		try{
			System.out.println("main BEGIN!");
			Host host = new Host();
			Data data = host.request(-1, 'N');
			System.out.println("data = " + data.getContent());
			System.out.println("main END(・８・)b");
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}