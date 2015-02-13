#Factory Method
どんなときに有効なデザインパターンなのでしょうか．

##議論した点
###クラスフィールドへの代入
```java
package idcard;
import framework.*;

public class IDCard extends Product {
  private String owner;
  IDCard(String owner) {
    System.out.println(owner + "のカードを作ります。");
    /**
      this.owner = owner; について
        左辺（this.owner）：IDCard クラスのプライベートフィールドである owner を指す．
        右辺（owner）     ：このコンストラクタの引数である owner を指す．
    **/
    this.owner = owner;
  }
  public void use() {
    System.out.println(owner + "のカードを使います。");
  }
  public String getOwner() {
    return owner;
  }
}
```
###クラスフィールド（メンバ変数）の接頭辞
Java -> 接頭辞をつける慣習はあまりない．  
C/C++, PHP, JavaScript etc... -> アンダースコア（_）をつける慣習がある（？）
###HashMap
キーと値を１セットとした要素の集まり．  
__c.f. [コレクション(HashMap) - javadrive](http://www.javadrive.jp/start/hashmap/)__  
__c.f. [Class HashMap<K,V> - Oracle Docs](https://docs.oracle.com/javase/7/docs/api/java/util/HashMap.html)__