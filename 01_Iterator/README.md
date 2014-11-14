#Iterator
##練習問題（補足）
###問題1-1
巻末にある解答例の通りにコンパイルを行うと以下のように警告が出ます．

```bash
$ javac Main.java
Note: ./BookShelf.java uses unchecked or unsafe operations.
Note: Recompile with -Xlint:unchecked for details.
```

これは，フィールドのbooksの宣言時にArrayListの型を指定していないためです．  
ＳＥ５以降では型を指定するように推奨されているため，以下のように変更しました．
```java
import java.util.ArrayList;

public class BookShelf implements Aggregate {
  // private ArrayList books; =>
  private ArrayList<Book> books;
  public BookShelf() {
    // this.books = new ArrayList(); =>
    this.books = new ArrayList<Book>();
  }
  public Book getBookAt(int index) {
    // return (Book)books.get(index); =>
    return books.get(index);
  }
  public void appendBook(Book book) {
    this.books.add(book);
  }
  public int getLength() {
    return this.books.size();
  }
  public Iterator iterator() {
    return new BookShelfIterator(this);
  }
}
```

[（参考）Class ArrayList<E>](https://docs.oracle.com/javase/7/docs/api/java/util/ArrayList.html)  
[（参考）JavaDrive](http://www.javadrive.jp/start/arraylist/index1.html)