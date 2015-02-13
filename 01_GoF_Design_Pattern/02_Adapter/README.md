#Adaptor
いつもゼロからプログラミングするとは限らず，すでに存在しているクラスを利用することもよくある．特にそのクラスが十分にテストされ，バグが少なく，また実際にこれまで使われてきた実績がある場合は，そのクラスを部品として再利用することが多い．そのときに，アダプターパターンを用いて，既存のクラスに一皮被せて必要とするクラスを作る．  
__cf. デザインパターン p.23__

##議論した点
###java.util.setProperty(key, value)
KEY の Hash 値の順で出力される模様．  
hashCode の求め方を調査すれば順序がわかるのではないか．  
__cf. [Class Hashtable<K,V>](https://docs.oracle.com/javase/7/docs/api/java/util/Hashtable.html)__

###カプセル化
抽象クラスやインターフェイスの利点の１つにカプセル化がある．  
__cf. [カプセル化](http://www.metro-cit.ac.jp/~yamasho/PDF/Java/JavaBasic3.pdf)__