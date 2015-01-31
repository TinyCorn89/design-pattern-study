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

##議論した点
###Static class と Singleton
シングルトンは状態を保持できることがメリットとのことでした．  
用途例は，サンプルのチケットのシリアルナンバーを出力するクラスです．  
  
####Static Class の特徴
```
1. You cannot create the instance of static class.
2. Loaded automatically by the .NET Framework common language runtime (CLR) when the program or namespace containing the class is loaded.
3. Static Class cannot have constructor.
4. We cannot pass the static class to method.
5. We cannot inherit Static class to another Static class in C#.
```
####Singleton の特徴
```
1. You can create one instance of the object and reuse it.
2. Singleton instance is created for the first time when the user requested. 
3. Singleton class can have constructor.
4. You can create the object of singleton class and pass it to method.
5. Singleton class does not say any restriction of Inheritance.
6. We can dispose the objects of a singleton class but not of static class.
```
__c.f. [Difference between Singleton Class and Static Class](http://www.c-sharpcorner.com/Blogs/46541/difference-between-singleton-class-and-static-class.aspx)__