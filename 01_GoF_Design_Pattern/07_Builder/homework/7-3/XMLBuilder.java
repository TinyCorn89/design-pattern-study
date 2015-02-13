import java.io.*;

public class XMLBuilder extends Builder{
	private String filename;
	private PrintWriter writer;
	protected void buildTitle(String title) {
		filename = title + ".xml";
		try {
			writer = new PrintWriter(new FileWriter(filename));
		} catch (IOException e) {
			e.printStackTrace();
		}

		writer.println("<info>\n\t<title>" + title + "</title>");
	}

	protected void buildString(String str){
		writer.println("\t<string>" + str + "</string>");
	}

	protected void buildItems(String[] items) {
		for (int i = 0 ; i <items.length; i++) {
			writer.println("\t \t<item>" + items[i] + "</item>");
		}
	}

	protected void buildDone(){
		writer.println("</info>");
		writer.close();
	}

	public String getResult(){
		return filename;
	}
}
