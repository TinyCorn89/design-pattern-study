public class Main{
	public static void main (String[]args){
		System.out.println("おきました。");

		try{
			Something.method(3000);
			Something.method(3000);
		}catch(InterruptedException e){

		}

		System.out.println("おやすみなさい");
		System.out.println("Something end ...");		
	}
}