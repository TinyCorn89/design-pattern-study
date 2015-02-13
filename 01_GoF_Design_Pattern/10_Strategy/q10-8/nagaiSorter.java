public class nagaiSorter implements Sorter{
	public void sort(Comparable[] data){

		for (int i = 0; i < data.length; i++){
			if(data[i].length() > data[i+1].length()){
				Comparable tem = data[i+1];
				data[i+1] = data[i];
				data[i] = tem;
			}
		}
	}
}