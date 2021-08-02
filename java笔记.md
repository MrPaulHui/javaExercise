# java note

## 最基础

### 编译和运行

https://www.liaoxuefeng.com/wiki/1252599548343744/1255878730977024

1. 编写好源码，保存为Hello.java

2. javac Hello.java

   生成Hello.class

   注：若有中文注释或字符，则用javac -encoding UTF-8 Hello.java

3. java Hello

   执行Hello.class

## eclipse使用

最基础的：https://blog.csdn.net/qq_36798713/article/details/79530056

先新建java project，然后在src里新建一个package（包，对应到文件系统里就是一个文件夹），再新建class（在包下面），其中一个class作为主入口

## 点

### 传参

参考：https://blog.csdn.net/weixin_35756522/article/details/81020812

（注：以下所说的方法就是函数啦）

1. java方法基本数据类型是传值（拷贝），对象类型（定义的类对象）传引用

2. 当参数为对象类型时，在方法内部进行=赋值操作，实际上是将形参这个局部变量指向了另外一个对象地址，不再指向传进来的实参，所以实参不会发生变化

   e.g.

   ```java
   public class TestFun2 {  
   public static void testStr(String str){  
   str="hello";//型参指向字符串 “hello”  
   }  
   public static void main(String[] args) {  
   String s="1" ;  
   TestFun2.testStr(s);  
   System.out.println("s="+s); //实参s引用没变，值也不变  
   }  
   }  
   ```

   输出结果为s=1

3. 当参数为对象类型时，通过形参对对象的属性内容进行修改，那么实参对象也会相应发生改变

以上均可参见Hero.java以及MethodParam.java中的代码示例

### java中public、private、protected、不写的区别

参考：https://blog.csdn.net/LiJianbo_Jon/article/details/80043995

public：
①具有最大的访问权限，可以访问任何一个在classpath下的类、接口、异常等。它往往用于对外的情况，也就是对象或类对外的一种接口的形式。（我们可以通过get方法访问，也可以对象.属性名来访问）
private：
①类的创建者和内部方法使用（注意只能是本类，不是本对象）,内部类也无法使用

protected:
①子类可以访问protected修饰的变量和方法。（只要是子类，即使不同包）。②同包中可以访问protected。

不写：
①声明时没有加修饰符，认为是friendly修饰，包（package）内部访问。（而不是默认为public）

### 静态方法

静态方法属于`class`而不属于实例，因此，静态方法内部，无法访问`this`变量，也无法访问实例字段，它只能访问静态字段。

### 对象属性初始化顺序

在Java中，创建对象实例的时候，按照如下顺序进行初始化：

1. 先初始化字段，例如，`int age = 10;`表示字段初始化为`10`，`double salary;`表示字段默认初始化为`0`，`String name;`表示引用类型字段默认初始化为`null`；
2. 执行构造方法的代码进行初始化。

因此，如果先做了字段的初始化，再进行构造，以构造函数的赋值为最终结果。

### == 和 equals 的区别

### 单例模式



### 多态

多态就是在**运行期**自动调用其实际指向的类的方法，而非声明的类型，涉及到upcasting

可参照ModernClass.java

