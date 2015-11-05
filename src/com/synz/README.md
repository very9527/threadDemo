1、多线程互斥可以由 sychronized 关键字实现。解决的是类似于银行取款（某个线程写的数据被另外一个覆盖掉）这种问题。

2、内部类的实例化需要加 final 关键字。因为主类没有实例化。

3、锁（关键字里的代码），两个线程要用同一个对象。this 表示这个对象。Outputer.class 表示字节码文件对象。
例子：
```java
	public void output(this) {
		// 省略
	}
	public void output(Outputer.class) {
		// 省略
	}
```
 
4、一段代码有嵌套的 sychronized, 会造成死锁。

5、问题：
下面的代码，改变 synchronized 关键字括号里的内容，使代码可以互斥。
```java
static class Outputer{
		public  void output(String name) {
			int length = name.length();
			synchronized(name) {
				for (int i = 0; i < length; i++) {
					System.out.print(name.charAt(i));
				}
				System.out.println();
			}
		}
		
		public static void output2(String name) {
			int length = name.length();
			synchronized(name) {
				for (int i = 0; i < length; i++) {
					System.out.print(name.charAt(i));
				}
				System.out.println();
			}
		}
}
```