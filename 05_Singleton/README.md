#Singleton
インスタンスが複数存在すると不都合な場合に，シングルトンパターンを利用する．

##補足
###クラスの初期化
The Java Language Specification で以下のように決められているようです．  
サンプルプログラムの初期化のタイミングは，２番目が当てはまりそうです．

```
A class or interface type T will be initialized immediately before the first occurrence of any one of the following:  
1. T is a class and an instance of T is created.  
2. T is a class and a static method declared by T is invoked.
3. A static field declared by T is assigned.  
4. A static field declared by T is used and the field is not a constant variable.  
5. T is a top-level class, and an assert statement lexically nested within T is executed.
```
__cf. [The Java Language Specification - Chapter 12](https://docs.oracle.com/javase/specs/jls/se5.0/html/execution.html)__