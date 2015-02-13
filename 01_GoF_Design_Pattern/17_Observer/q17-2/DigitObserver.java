public class DigitObserver implements Observer {
	public void update(NumberGenerator generator){
		System.out.println("DigitObserver:" + generator.getNumber());
		try{
			Thread.sleep(10);
		} catch (InterruptedException e){
			//nothing to do
		}
	}
}