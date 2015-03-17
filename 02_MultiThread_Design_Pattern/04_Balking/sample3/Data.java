import java.io.IOException;
import java.io.FileWriter;
import java.io.Writer;

public class Data {
	private final String filename;
	private String content;
	private boolean changed;

	public Data(String filename, String content){
		this.filename = filename;
		this.content  = content;
		this.changed  = true;
	}

	//rewrite data
	public void change(String newContent){
		content = newContent;
		changed = true;
	}

	//save data into a file when changed data
	public void save() throws IOException {
		if(!changed){
			return;
		}
		doSave();
		changed = false;
	}

	//Actually save data into the fil
	private void doSave() throws IOException{
		System.out.println(Thread.currentThread().getName() + "\t calls doSave, content = " + content);
		Writer writer = new FileWriter(filename);
		writer.write(content);
		writer.close();
	}
}