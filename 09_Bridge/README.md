#Bridge

##補足
###問題9-2
解答例にある reader.mark() と reader.reset() についてです．  

```java
import java.io.*;

public class FileDisplayImpl extends DisplayImpl {
  private String filename;
  private BufferedReader reader;
  private final int MAX_READAHEAD_LIMIT = 4096;
  public FileDisplayImpl(String filename) {
    this.filename = filename;
  }
  public void rawOpen() {
    try {
      reader = new BufferedReader(new FileReader(filename));
      /***
        Java.io.BufferedReader.mark() Method
      ***/
      reader.mark(MAX_READAHEAD_LIMIT);
    } catch (IOException e) {
      e.printStackTrace();
    }
    System.out.println("=-=-=-=-=-=-=-= " + filename + " =-=-=-=-=-=-=-=");
  }
  public void rawPrint() {
    try {
      String line;
      /***
        Java.io.BufferedReader.reset() Method
      ***/
      reader.reset();
      while ((line = reader.readLine()) != null) {
        System.out.println("> " + line);
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
  public void rawClose() {
    System.out.println("=-=-=-=-=-=-=-=");
    try {
      reader.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
```
__mark(int readAheadLimit) ：現在の読み込み位置を保存する．__  
* readAheadLimit：位置を保存している間読み込める文字のバイト数（readAheadLimit >= 0）  
* 8192がデフォルトとなっているため，それ以下を指定しても無視される．c.f. [参考](http://blog.mwsoft.jp/article/45580251.html)  

__reset() ：mark(int readAheadLimit) で保存した読み込み位置に戻る．__  
  
このサンプルでは，この２つのメソッドを用いなくても動作します．  
文字を順番に読み出しているだけで特定の位置に戻る必要がないためです．  
なぜこのコードがあるのでしょうか？  

c.f. [Java.io.BufferedReader.mark() Method](http://www.tutorialspoint.com/java/io/bufferedreader_mark.htm)  
c.f. [Java.io.BufferedReader.reset() Method](http://www.tutorialspoint.com/java/io/bufferedreader_reset.htm)

##議論した点
###例外処理について
__c.f. [Javaの例外（ブログ）](http://www.ne.jp/asahi/hishidama/home/tech/java/exception.html)__