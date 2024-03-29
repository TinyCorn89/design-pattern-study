package pagemaker;

import java.io.FileWriter;
import java.io.IOException;

public class HtmlWriter{
	private FileWriter writer;
	public HtmlWriter(FileWriter writer){
		this.writer = writer;
	}

	public void title(String title) throws IOException{
		writer.write("<html>");
		writer.write("<head>");
		writer.write("<title>" + title + "</title>");
		writer.write("</head>");

		writer.write("<body>");
		writer.write("<h1>" + title + "</h1>");
	}
	public void paragraph (String msg) throws IOException{
		writer.write("<p>" + msg + "</p>");
	}

	public void link(String href, String caption) throws IOException{
		paragraph("<a href=&quot;" + href + "&quot;>" + caption + "</a>");
	}

	public void mailTo (String username, String mailaddr) throws IOException{
		link("mailTo:" + mailaddr, username);
	}

	public void close() throws IOException{
		writer.write("</body>");
		writer.write("</html>");
		writer.close();
	}
}