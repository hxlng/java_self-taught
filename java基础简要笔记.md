# 一、基本数据类型之间的运算规则

1、自动类型提升

​	结论：当容量小的数据类型的变量与容量大的数据类型的变量做运算时，结果自动提升为容量大的数据类型。

> byte、char、short--->int---->long---->float----->double
>
> 特别的：当byte、char、short三种类型的变量做运算时，结果为int型

2、强制类型转换

​	自动类型提升运算的逆运算。

* 需要使用强转符：（）
* 注意点：强制类型转换，可能导致精度缺失。

==注== 整型常量，默认为int类型      

​		浮点型常量，默认类型为double型

# 二、进制

* 二进制

  > 由0，1组成。以0b开头

* 八进制

  > 由0，....7组成，以0开头

* 16进制

  > 0,...9,a,..f(大小写均可)。以0x开头

## 进制转换

1. 其他进制到十进制

   系数：每位上的数据

   基数：x进制，基数就是x

   权：在右边，从0开始编号，对应位上的编号即为该位的权。

   结果：把系数*基数的权次幂相加即可。

   > 二进制----->十进制
   >
   > 100=1 * 2^2+0 * 2^1+0* 2^0=4

2. 十进制到其他进制

   除基取余，直到商为0，余数反转。

   > 十进制--->二进制
   >
   > 20
   >
   > 20/2=10……0
   >
   > 10/2=5……0
   >
   > 5/2=2……1
   >
   > 2/2=1……0
   >
   > 1/2=0……1
   >
   > =10100

3. 二进制到八进制，到十六进制

   * 先到十进制再到其他进制

   * 分组拆分

     > 二进制--->八进制
     >
     > 0b1011001
     >
     > 从后往前取三位 不足补0
     >
     > | 001  | 011  | 001  |
     > | ---- | ---- | ---- |
     > | 1    | 3    | 1    |
     >
     > 即八进制为   0131

     

     > 二进制到16进制从后往前取4位不足补0

     

     ## 补码

     * 在计算机内，有符号数有3种表示法：原码、反码和补码。==所有数据的运算都是采用补码进行的== 。

     * 原码

       就是二进制定点表示法，即最高位为符号位，“0”表示正，“1”表示负，其余位表示数值的大小

     * 反码

       正数的反码与其原码相同；==负数的反码是其原码逐位取反，但符号位除外== 。

     * 补码

       正数的补码与其原码相同；负数的补码是在其反码的末位

       eg:

       > 原码：
       >符号位 数值位
       >+7 0 0000111
       >-7 1 0000111
       >反码：
       >符号位 数值位
       >+7 0 0000111
       >-7 1 1111000
       >补码：
       >符号位 数值位
       >+7 0 0000111
       >-7  1 1111001

# 三、流程控制

## 分枝结构

**分支结构中的if-else（条件判断结构）**

* 一、三种结构

  第一种：
  if(条件表达式){
  	执行表达式
  }

  第二种：二选一
  if(条件表达式){
  	执行表达式1
  }else{
  	执行表达式2
  }

  第三种：n选一
  if(条件表达式){
  	执行表达式1
  }else if(条件表达式){
  	执行表达式2
  }else if(条件表达式){
  	执行表达式3
  }
  ...
  else{
  	执行表达式n
  }

  说明：
  1. else 结构是可选的。

  2. 针对于条件表达式：
     > * 如果多个条件表达式之间是“互斥”关系(或没有交集的关系),哪个判断和执行语句声明在上面还是下面，无所谓。
     > * 如果多个条件表达式之间有交集的关系，需要根据实际情况，考虑清楚应该将哪个结构声明在上面。
     > * 如果多个条件表达式之间有包含的关系，通常情况下，需要将范围小的声明在范围大的上面。否则，范围小的就没机会执行了

  3.  else没大括号时就近原则

     ```java 
     int x = 4;
     		int y = 1;
     		if (x > 2) 
     			if (y > 2) 
                     System.out.println(x + y);
     				//System.out.println("atguigu");
     			else //就近原则
     				System.out.println("x is " + x);
     ```

     

  ```java 
  class IfTest {
  	public static void main(String[] args) {
  		
  		//举例1
  		int heartBeats = 79;
  		if(heartBeats < 60 || heartBeats > 100){
  			System.out.println("需要做进一步检查");
  		}
  
  		System.out.println("检查结束");
  		
  		//举例2
  		int age = 23;
  		if(age < 18){
  			System.out.println("你还可以看动画片");
  		}else{
  			System.out.println("你可以看成人电影了");
  		}
  
  		//举例3
  		if(age < 0){
  			System.out.println("您输入的数据非法");
  		}else if(age < 18){
  			System.out.println("青少年时期");
  		}else if(age < 35){
  			System.out.println("青壮年时期");
  		}else if(age < 60){
  			System.out.println("中年时期");
  		}else if(age < 120){
  			System.out.println("老年时期");
  		}else{
  			System.out.println("你是要成仙啊~~");
  		}
  	}
  }
  ```

  

**分支结构之二：switch-case**

1.格式
switch(表达式){
case 常量1:
	执行语句1;
	//break;

case 常量2:
	执行语句2;
	//break;

...

default:
	执行语句n;
	//break;

}

2.说明：
① 根据switch表达式中的值，依次匹配各个case中的常量。一旦匹配成功，则进入相应case结构中，调用其执行语句。
  当调用完执行语句以后，则仍然继续向下执行其他case结构中的执行语句，直到遇到break关键字或此switch-case结构
  末尾结束为止。

② break,可以使用在switch-case结构中，表示一旦执行到此关键字，就跳出switch-case结构

③ switch结构中的表达式，只能是如下的6种数据类型之一：
   byte 、short、char、int、枚举类型(JDK5.0新增)、String类型(JDK7.0新增)

④ case 之后只能声明常量。不能声明范围。

⑤ break关键字是可选的。

⑥  default:相当于if-else结构中的else.  
  default结构是可选的，而且位置是灵活的。

如果switch-case结构中的多个case的执行语句相同，则可以考虑进行合并

## 循环结构

### For循环结构的使用
一、循环结构的4个要素
① 初始化条件
② 循环条件  --->是boolean类型
③ 循环体
④ 迭代条件

二、for循环的结构

for(①;②;④){
	③
}

执行过程：① - ② - ③ - ④ - ② - ③ - ④ - ... - ②

```java 
class ForTest {
	public static void main(String[] args) {

		/*
		System.out.println("Hello World!");
		System.out.println("Hello World!");
		System.out.println("Hello World!");
		System.out.println("Hello World!");
		System.out.println("Hello World!");
		*/

		for(int i = 1;i <= 5;i++){//i:1,2,3,4,5
			System.out.println("Hello World!");
		}
		//i:在for循环内有效。出了for循环就失效了。
		//System.out.println(i);
		
		//练习：
		int num = 1;
		for(System.out.print('a');num <= 3;System.out.print('c'),num++){
			System.out.print('b');
		}
		//输出结果：abcbcbc

		System.out.println();

		//例题：遍历100以内的偶数,输出所有偶数的和,输出偶数的个数
		int sum = 0;//记录所有偶数的和
		int count = 0;//记录偶数的个数
		for(int i = 1;i <= 100;i++){
			
			if(i % 2 == 0){
				System.out.println(i);
				sum += i;
				count++;
			}
			//System.out.println("总和为：" + sum);
		}

		System.out.println("总和为：" + sum);
		System.out.println("个数为：" + count);

	}
}
```

###While 循环的使用

一、循环结构的4个要素
① 初始化条件
② 循环条件  --->是boolean类型
③ 循环体
④ 迭代条件

二、while循环的结构

①
while(②){
	③;
	④;
}

执行过程：① - ② - ③ - ④ - ② - ③ - ④ - ... - ②

说明：
1.写while循环千万小心不要丢了迭代条件。一旦丢了，就可能导致死循环！
2.我们写程序，要避免出现死循环。
3.for循环和while循环是可以相互转换的！ 
  区别：for循环和while循环的初始化条件部分的作用范围不同。

### do-while循环的使用

一、循环结构的4个要素
① 初始化条件
② 循环条件  --->是boolean类型
③ 循环体
④ 迭代条件

二、do-while循环结构：

①
do{
	③;
	④;

}while(②);

执行过程：① - ③ - ④ - ② - ③ - ④ - ... - ②

说明：
1.do-while循环至少会执行一次循环体！
2.开发中，使用for和while更多一些。较少使用do-while

eg: 从键盘读入个数不确定的整数，并判断读入的正数和负数的个数，输入为0时结束程序。

```java
import java.util.Scanner;

class ForWhileTest {
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		int positiveNumber = 0;//记录正数的个数
		int negativeNumber = 0;//记录负数的个数

		for(;;){//while(true){
			
			int number = scan.nextInt();

			//判断number的正负情况
			if(number > 0){
				positiveNumber++;
			}else if(number < 0){
				negativeNumber++;
			}else{
				//一旦执行break，跳出循环
				break;
			}

		}

		System.out.println("输入的正数个数为：" + positiveNumber);
		System.out.println("输入的负数个数为：" + negativeNumber);
		

	}
}
```

==说明==：

1. 不在循环条件部分限制次数的结构：for(;;) 或 while(true)
2. 结束循环有几种方式？
     方式一：循环条件部分返回false
	 方式二：在循环体中，执行break

## break continue  (加laber)

> break和continue关键字的使用
> 				使用范围			循环中使用的作用(不同点)		相同点
> break:			switch-case			
> 				循环结构中			结束当前循环					关键字后面不能声明执行语句	
>
> continue:		循环结构中			结束当次循环					关键字后面不能声明执行语句
>
> 

eg:

```java
class BreakContinueTest {
	public static void main(String[] args) {

		for(int i = 1;i <= 10;i++){
		
			if(i % 4 == 0){
				break;//123
				//continue;//123567910
				//System.out.println("今晚迪丽热巴要约我！！！");
			}
			System.out.print(i);
		}

		System.out.println("\n");
		//******************************
		
		label:for(int i = 1;i <= 4;i++){
		
			for(int j = 1;j <= 10;j++){
				
				if(j % 4 == 0){
					//break;//默认跳出包裹此关键字最近的一层循环。
					//continue;

					//break label;//结束指定标识的一层循环结构
					continue label;//结束指定标识的一层循环结构当次循环
				}
				
				System.out.print(j);
			}
			
			System.out.println();
		}
	}
}
```

# 四、数组

### 数组的概述

 1.数组的理解：数组(Array)，是多个相同类型数据一定顺序排列的集合，并使用一个名字命名，
 并通过编号的方式对这些数据进行统一管理。

 2.数组相关的概念：
 >数组名
 >元素
 >角标、下标、索引
 >数组的长度：元素的个数

 3.数组的特点：
 * 1数组是序排列的
 * 2数组属于引用数据类型的变量。数组的元素，既可以是基本数据类型，也可以是引用数据类型
 * 3创建数组对象会在内存中开辟一整块连续的空间
 * 4数组的长度一旦确定，就不能修改。
  
 * 4. 数组的分类：
    ① 照维数：一维数组、二维数组、。。。
     ② 照数组元素的类型：基本数据类型元素的数组、引用数据类型元素的数组

### 一维数组

1.一维数组的声明与初始化
正确的方式：
	int num;//声明
		num = 10;//初始化
		int id = 1001;//声明 + 初始化
		
		int[] ids;//声明
		//1.1 静态初始化:数组的初始化和数组元素的赋值操作同时进行
		ids = new int[]{1001,1002,1003,1004};
		//1.2动态初始化:数组的初始化和数组元素的赋值操作分开进行
		String[] names = new String[5];
	
	int[] arr4 = {1,2,3,4,5};//类型推断

错误的方式：
//		int[] arr1 = new int[];
//		int[5] arr2 = new int[5];
//		int[] arr3 = new int[3]{1,2,3};

2.一维数组元素的引用：通过角标的方式调用。
		//数组的角标（或索引从0开始的，到数组的长度-1结束。
		names[0] = "王铭";
		names[1] = "王赫";
		names[2] = "张学良";
		names[3] = "孙居龙";
		names[4] = "王宏志";//charAt(0)

3.数组的属性：length
System.out.println(names.length);//5
System.out.println(ids.length);

说明：
数组一旦初始化，其长度就是确定的。arr.length
数组长度一旦确定，就不可修改。
4.一维数组的遍历
for(int i = 0;i < names.length;i++){
	System.out.println(names[i]);
}

5.一维数组元素的默认初始化值
> 数组元素是整型：0
 > 数组元素是浮点型：0.0
 > 数组元素是char型：0或'\u0000'，而非'0'
 > 数组元素是boolean型：false
 > 数组元素是引用数据类型：null

6.一维数组的内存解析

<a href="https://sm.ms/image/sXcUSngHz7eViNw" target="_blank"><img src="https://i.loli.net/2021/04/12/sXcUSngHz7eViNw.png" ></a>

### 二维数组

1.如何理解二维数组？
数组属于引用数据类型
数组的元素也可以是引用数据类型
一个一维数组A的元素如果还是一个一维数组类型的，则，此数组A称为二维数组。


2.二维数组的声明与初始化
正确的方式：

	int[] arr = new int[]{1,2,3};//一维数组
		//静态初始化
		int[][] arr1 = new int[][]{{1,2,3},{4,5},{6,7,8}};
		//动态初始化1
		String[][] arr2 = new String[3][2];
		//动态初始化2
		String[][] arr3 = new String[3][];
	//也是正确的写法：
		int[] arr4[] = new int[][]{{1,2,3},{4,5,9,10},{6,7,8}};
		int[] arr5[] = {{1,2,3},{4,5},{6,7,8}};//类型推断
错误的方式：
//		String[][] arr4 = new String[][4];
//		String[4][3] arr5 = new String[][];
//		int[][] arr6 = new int[4][3]{{1,2,3},{4,5},{6,7,8}};
3.如何调用二维数组元素:
		System.out.println(arr1[0][1]);//2
		System.out.println(arr2[1][1]);//null
		
		arr3[1] = new String[4];
		System.out.println(arr3[1][0]);
	System.out.println(arr3[0]);//
4.二维数组的属性：
	System.out.println(arr4.length);//3
		System.out.println(arr4[0].length);//3
		System.out.println(arr4[1].length);//4
5.遍历二维数组元素
	for(int i = 0;i < arr4.length;i++){
			
			for(int j = 0;j < arr4[i].length;j++){
				System.out.print(arr4[i][j] + "  ");
			}
			System.out.println();
	}
6.二维数组元素的默认初始化值
 * 	规定：二维数组分为外层数组的元素，内层数组的元素
 * 		int[][] arr = new int[4][3];
 * 		外层元素：arr[0],arr[1]等
 * 		内层元素：arr[0][0],arr[1][2]等
 * 
 *   ⑤ 数组元素的默认初始化值 
 *   针对于初始化方式一：比如：int[][] arr = new int[4][3];
 *      外层元素的初始化值为：地址值
 *      内层元素的初始化值为：与一维数组初始化情况相同
 *      
 *   针对于初始化方式二：比如：int[][] arr = new int[4][];
 *   	外层元素的初始化值为：null
 *      内层元素的初始化值为：不能调用，否则报错。

7.二维数组的内存结构

<a href="https://sm.ms/image/6OuJhiAXnleML2g" target="_blank"><img src="https://i.loli.net/2021/04/12/6OuJhiAXnleML2g.png" ></a>

### 数组的常见算法

<a href="https://sm.ms/image/4oMwWDdA5vGJi9Y" target="_blank"><img src="https://i.loli.net/2021/04/13/4oMwWDdA5vGJi9Y.png" ></a>

理解：
1）衡量排序算法的优劣：
时间复杂度、空间复杂度、稳定性

2）排序的分类：内部排序 与 外部排序（需要借助于磁盘）

<a href="https://sm.ms/image/SpGc3U9z8i2WCEY" target="_blank"><img src="https://i.loli.net/2021/04/13/SpGc3U9z8i2WCEY.png" ></a>

4）手写冒泡排序

```java
int[] arr = new int[]{43,32,76,-98,0,64,33,-21,32,99};
		
		//冒泡排序
		for(int i = 0;i < arr.length - 1;i++){
			
			for(int j = 0;j < arr.length - 1 - i;j++){
				
				if(arr[j] > arr[j + 1]){
					int temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
				}
				
			}
			
		}		
```

### Arrays工具类的使用

1.理解：
① 定义在java.util包下。
② Arrays:提供了很多操作数组的方法。

2.使用：

	//1.boolean equals(int[] a,int[] b):判断两个数组是否相等。
		int[] arr1 = new int[]{1,2,3,4};
		int[] arr2 = new int[]{1,3,2,4};
		boolean isEquals = Arrays.equals(arr1, arr2);
		System.out.println(isEquals);
		
		//2.String toString(int[] a):输出数组信息。
		System.out.println(Arrays.toString(arr1));


​			
​		//3.void fill(int[] a,int val):将指定值填充到数组之中。
​		Arrays.fill(arr1,10);
​		System.out.println(Arrays.toString(arr1));


		//4.void sort(int[] a):对数组进行排序。
		Arrays.sort(arr2);
		System.out.println(Arrays.toString(arr2));
		
		//5.int binarySearch(int[] a,int key)
		int[] arr3 = new int[]{-98,-34,2,34,54,66,79,105,210,333};
		int index = Arrays.binarySearch(arr3, 210);
		if(index >= 0){
			System.out.println(index);
		}else{
			System.out.println("未找到");
		}
### 数组的常见异常

```java
1.数组角标越界异常：ArrayIndexOutOfBoundsException

		int[] arr = new int[]{1,2,3,4,5};
		
//		for(int i = 0;i <= arr.length;i++){
//			System.out.println(arr[i]);
//		}
		
//		System.out.println(arr[-2]);
		
//		System.out.println("hello");
2.空指针异常：NullPointerException
	//情况一：
//		int[] arr1 = new int[]{1,2,3};
//		arr1 = null;
//		System.out.println(arr1[0]);
		
		//情况二：
//		int[][] arr2 = new int[4][];
//		System.out.println(arr2[0][0]);
		
		//情况：
		String[] arr3 = new String[]{"AA","BB","CC"};
		arr3[0] = null;
		System.out.println(arr3[0].toString());

小知识：一旦程序出现异常，未处理时，就终止执行。
```

# 五、面向对象

## 类与对象

1. 面向对象学习的三条主线：

   * Java类及类的成员：属性、方法、构造器、代码块、内部类
   * 面向对象的三大特征：封装性、继承性、多态性、（抽象性）
   * 其它关键字：this、super、static、final、abstract、interface、package、import等

2. 面向对象与面向过程（理解）

   * 面向过程：强调的是功能行为，以函数为最小单位，考虑怎么做
   * 面向对象：强调具备了功能的对象，以类/对象为最小单位，考虑谁来做。

3. 面向对象中两个重要的概念：

   * 类：对一类事物的描述，是抽象的，概念上的定义
   * 对象：是实际存在的该类事物的每个个体，因而也称为实例（instance）
     * 面向对象程序设计的重点是类的设计
     * 设计类，就是设计类的成员

   二者关系：

   对象，是由类new出来的，派生出来的。

4. 面向对象思想落地实现的规则一

   * 创建类，设计类的成员
   
   * 创建类的对象
   
* 通过“对象.属性”或“对象.方法”调用对象的结构
  
   * 补充：几个概念的使用说明
   
      属性 = 成员变量 = field = 域、字段
      方法 = 成员方法 = 函数 = method
      创建类的对象 = 类的实例化 = 实例化类
   
5. 对象的创建与对象的内存解析

   典型代码：
   Person p1 = new Person();
   Person p2 = new Person();
   Person p3 = p1;//没有新创建一个对象，共用一个堆空间中的对象实体。

   说明：
   如果创建了一个类的多个对象，则每个对象都独立的拥有一套类的属性。（非static的）
   意味着：如果我们修改一个对象的属性a，则不影响另外一个对象属性a的值。

   内存解析

   <a href="https://sm.ms/image/d6ApmFg4aXqcPCJ" target="_blank"><img src="https://i.loli.net/2021/04/17/d6ApmFg4aXqcPCJ.png" ></a>

<a href="https://sm.ms/image/4XgUHCdDJo2FM3R" target="_blank"><img src="https://i.loli.net/2021/04/17/4XgUHCdDJo2FM3R.png" ></a>

6. 匿名对象:我们创建的对象，没显式的赋给一个变量名。即为匿名对象

   特点：匿名对象只能调用一次。

   ```java
   举例：
   	new Phone().sendEmail();
   		new Phone().playGame();
   		
   		new Phone().price = 1999;
   		new Phone().showPrice();//0.0
   应用场景：
   PhoneMall mall = new PhoneMall();
   
   //匿名对象的使用
   mall.show(new Phone());
   其中，
   class PhoneMall{
   	public void show(Phone phone){
   		phone.sendEmail();
   		phone.playGame();
   	}
   	
   }
   ```

7. 理解"万事万物皆对象"

   * 在Java语言范畴中，我们都将功能、结构等封装到类中，通过类的实例化，来调用具体的功能结构

     >Scanner,String等
     >
     >文件：File
     >
     >网络资源：URL

## JVM内存结构

编译完源程序以后，生成一个或多个字节码文件。

我们使用JVM中的类的加载器和解释器对生成的字节码文件进行解释运行。意味着，需要将字节码文件对应的类加载到内存中，涉及到内存解析。

<a href="https://sm.ms/image/A1BaRYk4gbx6oPW" target="_blank"><img src="https://i.loli.net/2021/04/17/A1BaRYk4gbx6oPW.png" ></a>

《JVM规范》

虚拟机栈，即为平时提到的栈结构。我们将局部变量存储在栈结构中
堆，我们将new出来的结构（比如：数组、对象）加载在对空间中。补充：对象的属性（非static的）加载在堆空间中。
方法区：类的加载信息、常量池、静态域

## 类的结构之一：属性

对比：属性  vs  局部变量

1.相同点：
 * 		1.1  定义变量的格式：数据类型  变量名 = 变量值
 * 		1.2 先声明，后使用
 * 		1.3 变量都其对应的作用域 

2.不同点：



2.1 在类中声明的位置的不同

属性：直接定义在类的一对{}内

局部变量：声明在方法内、方法形参、代码块内、构造器形参、构造器内部的变量

2.2 关于权限修饰符的不同

属性：可以在声明属性时，指明其权限，使用权限修饰符。

常用的权限修饰符：private、public、缺省、protected  --->封装性



局部变量：不可以使用权限修饰符。



2.3 默认初始化值的情况：

属性：类的属性，根据其类型，都默认初始化值。

整型（byte、short、int、long：0）

浮点型（float、double：0.0）

字符型（char：0  （或'\u0000'））

布尔型（boolean：false）



引用数据类型（类、数组、接口：null）

局部变量：没默认初始化值。

意味着，我们在调用局部变量之前，一定要显式赋值。

特别地：形参在调用时，我们赋值即可。



2.4 在内存中加载的位置：

属性：加载到堆空间中   （非static）

局部变量：加载到栈空间

<a href="https://sm.ms/image/faHuGNS4YtI7vzC" target="_blank"><img src="https://i.loli.net/2021/04/17/faHuGNS4YtI7vzC.png" ></a>

## 类的结构之二：方法

1. 方法的声明

   方法的声明：权限修饰符  返回值类型  方法名(形参列表){

   方法体

   }

   注意：static、final、abstract 来修饰的方法，后面再讲。

2. 关于权限修饰符：默认方法的权限修饰符先都使用public

   Java规定的4种权限修饰符：private、public、缺省、protected  -->封装性再细说

3. 返回值类型： 返回值  vs 没返回值

   如果方法返回值，则必须在方法声明时，指定返回值的类型。同时，方法中，需要使用return关键字来返回指定类型的变量或常量：“return 数据”。

   如果方法没返回值，则方法声明时，使用void来表示。通常，没返回值的方法中，就不需要使用return.但是，如果使用的话，只能“return;”表示结束此方法的意思。

4. 方法的使用中，可以调用当前类的属性或方法

   特殊的：方法A中又调用了方法A:递归方法。

   方法中，不可以定义方法。

### return关键字

1.使用范围：使用在方法体中
2.作用：

① 结束方法

② 针对于返回值类型的方法，使用"return 数据"方法返回所要的数据。
3.注意点：return关键字后面不可以声明执行语句。

### 方法的重载

1. 方法的重载的概念

   定义：在同一个类中，允许存在一个以上的同名方法，只要它们的参数个数或者参数类型不同即可。

   总结："两同一不同":同一个类、相同方法名
                参数列表不同：参数个数不同，参数类型不同

### 可变个数形参的方法

1. 使用说明
    * 1.jdk 5.0新增的内容
    * 2.具体使用：
    *   2.1 可变个数形参的格式：数据类型 ... 变量名
    *   2.2 当调用可变个数形参的方法时，传入的参数个数可以是：0个，1个,2个，。。。
    *   2.3 可变个数形参的方法与本类中方法名相同，形参不同的方法之间构成重载
    *   2.4 可变个数形参的方法与本类中方法名相同，形参类型也相同的数组之间不构成重载。换句话说，二者不能共存。
    *   2.5 可变个数形参在方法的形参中，必须声明在末尾
    * 	 2.6  可变个数形参在方法的形参中,最多只能声明一个可变形参。

2.举例说明

```java
public void show(int i){
		
	}
	
	public void show(String s){
		System.out.println("show(String)");
	}
	
	public void show(String ... strs){
		System.out.println("show(String ... strs)");
		
		for(int i = 0;i < strs.length;i++){
			System.out.println(strs[i]);
		}
	}
	//不能与上一个方法同时存在
//	public void show(String[] strs){
//		
//	}
调用时：
		test.show("hello");
		test.show("hello","world");
		test.show();
		
		test.show(new String[]{"AA","BB","CC"});
```

## 面向对象的特征一 ：封装性

面向对象的特征一：封装与隐藏

1. 为什么要引入封装性？

   我们程序设计追求“高内聚，低耦合”。
   高内聚 ：类的内部数据操作细节自己完成，不允许外部干涉；
   低耦合 ：仅对外暴露少量的方法用于使用。

   隐藏对象内部的复杂性，只对外公开简单的接口。便于外界调用，从而提高系统的可扩展性、可维护性。通俗的说，把该隐藏的隐藏起来，该暴露的暴露出来。这就是封装性的设计思想。

2. 封装性思想具体的代码体现：

   体现一：将类的属性xxx私化(private),同时，提供公共的(public)方法来获取(getXxx)和设置(setXxx)此属性的值

   ```java 
   private double radius;
   public void setRadius(double radius){
   	this.radius = radius;
   }
   public double getRadius(){
   	return radius;
   }
   ```

   体现二：不对外暴露的私有的方法

   体现三：单例模式（将构造器私有化）

   体现四：如果不希望类在外包被调用，可以将类设置为缺省

3. Java规定的四种权限修饰符

   权限从小到大顺序为：private<缺省<protected<public

   <a href="https://sm.ms/image/O5urBLbPpZhFJlA" target="_blank"><img src="https://i.loli.net/2021/04/18/O5urBLbPpZhFJlA.png" ></a>

   ==说明== 4种权限都可以用来修饰类的内部结构：属性、方法、构造器、内部类
   修饰类的话，只能使用：缺省、public

## 类的结构之三：构造器

1. 构造器（或构造方法）：Constructor

   * 创建对象
   * 初始化对象的信息

2. 使用说明

   * 如果没显式的定义类的构造器的话，则系统默认提供一个空参的构造器
   * 定义构造器的格式：权限修饰符  类名(形参列表){}
   * 一个类中定义的多个构造器，彼此构成重载
   * 一旦我们显式的定义了类的构造器之后，系统就不再提供默认的空参构造器
   * 一个类中，至少会有一个构造器。

   ```java 
   //构造器
   	public Person(){
   		System.out.println("Person().....");
   	}
   	
   	public Person(String n){
   		name = n;
   		
   	}
   	
   	public Person(String n,int a){
   		name = n;
   		age = a;
   	}
   ```

   

## 关键字 this

1. 可以调用的结构：属性、方法；构造器

2. this调用属性、方法

   this理解为：当前对象  或 当前正在创建的对象

   * 在类的方法中，我们可以使用"this.属性"或"this.方法"的方式，调用当前对象属性或方法。但是，通常情况下，我们都择省略"this."。特殊情况下，如果方法的形参和类的属性同名时，我们**必须显式**
   * 在类的构造器中，我们可以使用"this.属性"或"this.方法"的方式，调用当前正在创建的对象属性或方法。但是，通常情况下，我们都择省略"this."。特殊情况下，如果构造器的形参和类的属性同名时，我们必须显式的使用"this.变量"的方式，表明此变量是属性，而非形参。

3. this 调用构造器：

   ① 我们在类的构造器中，可以显式的使用"this(形参列表)"方式，调用本类中指定的其他构造器
   ② 构造器中不能通过"this(形参列表)"方式调用自己
   ③ 如果一个类中有n个构造器，则最多有 n - 1构造器中使用了"this(形参列表)"
   ④ **规定："this(形参列表)"必须声明在当前构造器的首行**
   ⑤ 构造器内部，**最多只能声明一个"this(形参列表)"**，用来调用其他的构造器

   

## 关键字 package/import

1. package的使用

   * 为了更好的实现项目中类的管理，提供包的概念
   * 使用package声明类或接口所属的包，声明在源文件的首行
   * 包，属于标识符，遵循标识符的命名规则、规范(xxxyyyzzz)、“见名知意”
   * 每"."一次，就代表一层文件目录。

2. JDK中的主要包介绍：

   <a href="https://sm.ms/image/GDhO4JtZ9dfpe7Y" target="_blank"><img src="https://i.loli.net/2021/04/18/GDhO4JtZ9dfpe7Y.png" ></a>

3. import的使用
   * 在源文件中显式的使用import结构导入指定包下的类、接口
   * 声明在包的声明和类的声明之间
   * 如果需要导入多个结构，则并列写出即可
   * 可以使用"xxx.*"的方式，表示可以导入xxx包下的所结构
   * 如果使用的类或接口是java.lang包下定义的，则可以省略import结构
   * 如果使用的类或接口是本包下定义的，则可以省略import结构
   * 如果在源文件中，使用了不同包下的同名的类，则**必须至少一个类需要以全类名的方式显示。**
   * import static:导入指定类或接口中的静态结构:属性或方法。 

## 面向对象的特征二：继承性

1. 为什么要有类的继承性？（好处）

   * 减少了代码的冗余，提高了代码的复用性

   * 便于功能的扩展

   * 为之后多态性的使用，提供了前提

     <a href="https://sm.ms/image/3qcuCNx5wdlLIF7" target="_blank"><img src="https://i.loli.net/2021/04/21/3qcuCNx5wdlLIF7.png" ></a>

2. 继承性的格式

```java 
//A:子类、派生类、subclass
//B:父类、超类、基类、superclass
class A extends B{}
```

3. 子类继承父类以后有哪些不同？

   3.1. 体现：一旦子类A继承父类B以后，子类A中就获取了父类B中声明的所有的属性和方法

   ​		==特别的== 特别的，父类中声明为private的属性或方法，子类继承父类以后，仍然认为获取了父类中私的结构。只因为封装性的影响，使得子类不能直接调用父类的结构而已。

   3.2子类继承父类以后，还可以声明自己特有的属性或方法：实现功能的拓展。

   ​			子类和父类的关系，不同于子集和集合的关系。

   ​             extends：延展、扩展

4. Java中继承性的说明

   * 一个类可以被多个子类继承

   * Java中==类的单继承性== ：一个类只能有一个父类

   * 子父类是相对概念

   * 子类直接继承的父类，成为：直接父类。间接继承的父类成为：间接父类

   * 子类继承父类以后，就获取了直接父类以及所间接父类中声明的属性和方法

     <a href="https://sm.ms/image/7GwA68WfLe4Yu5J" target="_blank"><img src="https://i.loli.net/2021/04/21/7GwA68WfLe4Yu5J.png" ></a>

5. java.lang.Object类的理解

   * 如果我们没显示的声明一个类的父类的话，则此类继承于java.lang.Object

   * 所有的java类（除java.lang.Object类之外都直接或间接的继承于java.lang.Object类）

   * 意味着，所有的java类具有java.lang.Object类声明的功能

     

例子

Creature.java

```java
public class Creature {
	
	public void breath(){
		System.out.println("呼吸");
	}
	
}
```

Person.java

```java
public class Person extends Creature{
	
	String name;
	private int age;
	
	public Person(){
		
	}
	
	public Person(String name,int age){
		this.name = name;
		this.age = age;
	}
	
	public void eat(){
		System.out.println("吃饭");
		sleep();
	}
	
	private void sleep(){
		System.out.println("睡觉");
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
	
	
}
```

Student.java

```java
public class Student extends Person{
	
//	String name;
//	int age;
	String major;
	
	public Student(){
		
	}
	public Student(String name,int age,String major){
		this.name = name;
//		this.age = age;
		setAge(age);
		this.major = major;
	}
//	public void eat(){
//		System.out.println("吃饭");
//	}
//	
//	public void sleep(){
//		System.out.println("睡觉");
//	}
	
	public void study(){
		System.out.println("学习");
	}
	
	public void show(){
		System.out.println("name:" + name + ",age:" + getAge());
	}
	
}

```

ExtendsTest.java

```java
public class ExtendsTest {
	public static void main(String[] args) {
		
		Person p1 = new Person();
//		p1.age = 1;
		p1.eat();
		System.out.println("*****************");
		
		Student s1 = new Student();
		s1.eat();
//		s1.sleep();
		s1.name = "Tom";
		s1.setAge(10);
		System.out.println(s1.getAge());
		
		s1.breath();
		
		
		Creature c = new Creature();
		System.out.println(c.toString());
	}
}

```

aST `	