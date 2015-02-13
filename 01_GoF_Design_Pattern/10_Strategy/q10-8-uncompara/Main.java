public class Main{
	public static void main(String args[]){
		String[] data = {
			"DODODODODODODO",
			"BoodaSan",
			"Carry-kara",
			"Eminemunemu",
			"Akarin"
		};
		SortAndPrint sap = new SortAndPrint(data, new SelectionSorter());
		sap.execute();
	}
}