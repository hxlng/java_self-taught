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

# 五、面向对象上

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



## 方法的重写

1. 什么是方法的重写（override或overwrite）?

   子类继承父类以后，可以对父类中同名同参数的方法，进行覆盖。

2. 应用：

   重写以后，当创建子类对象以后，通过子类对象调用子父类中的同名同参数的方法时，实际执行的是子类重写父类的方法。

3. 举例

   ```java 
   class Circle{
   public double findArea(){}//求面积
   }
   class Cylinder extends Circle{
   public double findArea(){}//求表面积
   }
   ***************
   class Account{
   public boolean withdraw(double amt){}
   }
   class CheckAccount extends Account{
   public boolean withdraw(double amt){}
   }
   ```

4. 重写的规则：

   方法的声明：权限修饰符 返回值类型 方法名(形参列表) throws 异常的类型{

   //方法体

   }

   约定俗成：子类中的叫重写的方法，父类中的叫被重写的方法

   * 子类重写的方法的方法名和形参列表与父类被重写的方法的方法名和形参列表相同

   * 子类重写的方法的权限修饰符不小于父类被重写的方法的权限修饰符

     > 特殊情况：子类不能重写父类中声明的private权限的方法

   * 返回值类型

     > * 父类被重写的方法的返回值类型是void，则子类重写的方法的返回值类型只能是void
     > * 父类被重写的方法的返回值类型是A类型，则子类重写的方法的返回值类型可以是A类或A类的子类
     > * 父类被重写的方法的返回值类型是基本数据类型(比如：double)，则子类重新写的方法的返回值类型必须是相同的基本数据类型(必须也是double)

   * 子类重写的方法抛出的异常类型不大于父类被重写的方法抛出的异常类型(具体放到异常处理的时候详说)

   * 考虑重写的时候子类和父类要么为非static的(要么都声明为static（不是重写）)

5. 面试题

   区分方法的重写和重载？

   > 答：
   > ① 二者的概念：
   > ② 重载和重写的具体规则
   > ③ 重载：不表现为多态性。
   >   重写：表现为多态性。

   重载，是指允许存在多个同名方法，而这些方法的参数不同。编译器根据方法不同的参数表，对同名方法的名称做修饰。对于编译器而言，这些同名方法就成了不同的方法。它们的调用地址在编译期就绑定了。Java的重载是可以包括父类和子类的，即子类可以重载父类的同名不同参数的方法。
   所以：对于重载而言，在方法调用之前，编译器就已经确定了所要调用的方法，这称为“早绑定”或“静态绑定”；

   而对于多态，只等到方法调用的那一刻，解释运行器才会确定所要调用的具体方法，这称为“晚绑定”或“动态绑定”。 

   引用一句Bruce Eckel的话：“不要犯傻，如果它不是晚绑定，它就不是多态。”

## 关键字：super

1. super关键字可以理解为： 父类的

2. 可以用来调用的结构：

   属性、方法、构造器

3. super 调用属性、方法：

   * 可以再子类的方法或构造器中。通过使用“super.属性”或‘’super.方法‘’的方式，显示的调用父类中声明的属性或方法。但是，通常情况下，我们习惯省略‘’super.‘’
   * 特殊情况：当==子类和父类中定义了同名的属== 时我们要想在子类中调用父类中声明的属性，则==必须==显式的使用"super.属性"的方式，表明调用的是父类中声明的属性。
   * 特殊情况：当==子类重写了父类中的方法==以后，我们想在子类的方法中调用父类中被重写的方法时，则必须显式的使用"super.方法"的方式，表明调用的是父类中被重写的方法。

4. super调用构造器：

   * 我们可以在子类的构造器中显式的使用"super(形参列表)"的方式，调用父类中声明的指定的构造器
   * "super(形参列表)"的使用，必须声明在子类构造器的首行！
   * 我们在类的构造器中，针对于"this(形参列表)"或"super(形参列表)"只能二一，不能同时出现
   * 在构造器的首行，没显式的声明"this(形参列表)"或"super(形参列表)"，则默认调用的是父类中空参的构造器：super()
   * 在类的多个构造器中，至少一个类的构造器中使用了"super(形参列表)"，调用父类中的构造器

## 子类对象实例化全过程

1. 从结果上看：继承性

   > 子类继承父类以后，就获取了父类中声明的属性或方法。
   >
   > 创建子类的对象，在堆空间中，就会加载所有父类中声明的属性。

2. 从过程上看

   > 当我们通过子类的构造器创建子类对象时，我们一定会直接或间接的调用其父类的构造器，进而调用父类的父类的构造器，...直到调用了java.lang.Object类中空参的构造器为止。正因为加载过所的父类的结构，所以才可以看到内存中父类中的结构，子类对象才可以考虑进行调用。

   <a href="https://sm.ms/image/lcXE7WDJsj5n9dq" target="_blank"><img src="https://i.loli.net/2021/04/22/lcXE7WDJsj5n9dq.png" ></a>

3. 强调说明：

   ​		虽然创建子类对象时，调用了父类的构造器，但是自始至终就创建过一个对象，即为new的子类对象。

   <a href="https://sm.ms/image/3TWnwE4ze9RcKxy" target="_blank"><img src="https://i.loli.net/2021/04/22/3TWnwE4ze9RcKxy.png" alt="image.png"></a>

## 面向对象的特征三：多态性

1. 多态性的理解：可以理解为一个事物的多种形态。

2. 何为多态性：

    对象的多态性(对象的上转型对象)：父类的引用指向子类的对象（或子类的对象赋给父类的引用）

   > Person p=new Man();
   >
   > Object obj =new Date();

3. 多态性的使用：虚拟方法调用

   > 有了对象的多态性以后，我们在编译期，只能调用父类中声明的方法，但在运行期，我们实际执行的是子类重写父类的方法。

   ==总结== ：编译，看左边；运行，看右边。

4. 多态性的使用前提：

   * 类的继承关系
   * 方法的重写

5. 多态性的应用举例：

   ``` java
   举例一：
   	public void func(Animal animal){//Animal animal = new Dog();
   		animal.eat();
   		animal.shout();a
   	}
   举例二：
   public void method(Object obj){
   		
   	}
   举例三：
   class Driver{
   	
   	public void doData(Connection conn){//conn = new MySQlConnection(); / conn = new OracleConnection();
   		//规范的步骤去操作数据
   //		conn.method1();
   //		conn.method2();
   //		conn.method3();
   		
   	}
   	
   }
   ```

6. 多态性使用的注意点：

   对象的多态性，只适用于方法，不适用于属性（编译和运行都看左边）

7. 关于向上转型与向下转型：

   向上转型：多态

   向下转型：

   * 为什么使用向下转型：

     > 有了对象的多态性以后，内存中实际上是加载了子类特有的属性和方法的，但是由于变量声明为父类类型，导致编译时，只能调用父类中声明的属性和方法。子类特有的属性和方法不能调用。如何才能调用子类特的属性和方法？使用向下转型。

   * 如何实现向下转型：使用强制类型转换符：()

   * 使用时的注意点：

     > ① 使用强转时，可能出现ClassCastException的异常。
     >
     > ② 为了避免在向下转型时出现ClassCastException的异常，我们在向下转型之前，先进行instanceof的判断，一旦返回true，就进行向下转型。如果返回false，不进行向下转型。

   * instanceof的使用：

     > ① a instanceof A:判断对象a是否是类A的实例。如果是，返回true；如果不是，返回false。
     >
     > ② 如果 a instanceof A返回true,则 a instanceof B也返回true.其中，类B是类A的父类。
     >
     > ③ 要求a所属的类与类A必须是子类和父类的关系，否则编译错误。

     图示：

     <a href="https://sm.ms/image/Zn42gHTLxihzOqk" target="_blank"><img src="https://i.loli.net/2021/04/22/Zn42gHTLxihzOqk.png" ></a>

8. 面试题

   谈谈你对多态性的理解？

   > ① 实现代码的通用性。
   > ② Object类中定义的public boolean equals(Object obj){  }
   >   JDBC:使用java程序操作(获取数据库连接、CRUD)数据库(MySQL、Oracle、DB2、SQL Server)
   > ③ 抽象类、接口的使用肯定体现了多态性。（抽象类、接口不能实例化）

   多态是编译时行为还是运行时行为？

   ```java
   import java.util.Random;
   
   //面试题：多态是编译时行为还是运行时行为？
   //证明如下：
   class Animal  {
    
   	protected void eat() {
   		System.out.println("animal eat food");
   	}
   }
   
   class Cat  extends Animal  {
    
   	protected void eat() {
   		System.out.println("cat eat fish");
   	}
   }
   
   class Dog  extends Animal  {
    
   	public void eat() {
   		System.out.println("Dog eat bone");
   
   	}
   
   }
   
   class Sheep  extends Animal  {
    
   
   	public void eat() {
   		System.out.println("Sheep eat grass");
   
   	}
   
    
   }
   
   public class InterviewTest {
   
   	public static Animal  getInstance(int key) {
   		switch (key) {
   		case 0:
   			return new Cat ();
   		case 1:
   			return new Dog ();
   		default:
   			return new Sheep ();
   		}
   
   	}
   
   	public static void main(String[] args) {
   		int key = new Random().nextInt(3);
   
   		System.out.println(key);
   
   		Animal  animal = getInstance(key);
   		
   		animal.eat();
   		 
   	}
   
   }
   
   ```



## Object类的使用

1. java.lang.Object类的说明：

   * Object类是所Java类的根父类

   * 如果在类的声明中未使用extends关键字指明其父类，则默认父类为java.lang.Object类

   * Object类中的功能(属性、方法)就具通用性。

     > 属性：无
     >
     > 方法：equals() / toString() / getClass() /hashCode() / clone() / finalize()
     >
     > wait() 、 notify()、notifyAll()

   * Object类只声明了一个空参的构造器

   ###  equals方法

   1. equals()的使用：

      > 是一个方法，而非运算符
      >
      > 只能适用于引用数据类型
      >
      > Object类中equals()的定义：
      >
      > ```java 
      > public boolean equals(Object obj) {
      > 	        return (this == obj);
      > 	  }
      > ```
      >
      > 说明：==Object类中定义的equals()和\==的作用是相同的==：比较两个对象的地址值是否相同.即两个引用是否指向同一个对象实体

   2. 像String、Date、File、包装类等都重写了Object类中的equals()方法。重写以后，比较的不是两个引用的地址是否相同，==而是比较两个对象的"实体内容"是否相同==。

   3. 通常情况下，我们自定义的类如果使用equals()的话，也通常是比较两个对象的"实体内容"是否相同。那么，我们就需要对Object类中的equals()进行重写。

      ==重写的原则：比较两个对象的实体内容是否相同==
      
   4. 重写equals()
   
      * 手动重写  举例
   
        ```java
        class User{
            String name;
            int age;
            //重写其equals()方法
            public boolean equals(Object obj){
                if(obj==this){
                    return true;
                }
                if(obj instanceof User){
                    User u=(User)obj;
                    return this.age==u.age&&this.name.equals(u.name);
                }
                return false;
            }
        }
        ```
   
      * 开发中如何实现：自动生成的
   
        ```java
        public class User {
        	String name;
            int age;
        	
        	@Override
        	public boolean equals(Object obj) {
        		if (this == obj)
        			return true;
        		if (obj == null)
        			return false;
        		if (getClass() != obj.getClass())
        			return false;
        		User other = (User) obj;
        		if (age != other.age)
        			return false;
        		if (name == null) {
        			if (other.name != null)
        				return false;
        		} else if (!name.equals(other.name))
        			return false;
        		return true;
        	}
            
        }
        ```
   
   5. 回顾==运算符的使用：
   
      > == ：运算符
      >
      > 1. 可以使用在基本数据类型变量和引用数据类型变量中
      > 2. 如果比较的是基本数据类型变量：比较两个变量保存的数据是否相等。（不一定类型要相同）
      > 3. 如果比较的是引用数据类型变量：比较两个对象的地址值是否相同.即两个引用是否指向同一个对象实体
      > 4. == 符号使用时，必须保证符号左右两边的变量类型一致。
   
      

### 重写toString()方法

1. toString（）的使用：

  * 当我们输出一个对象的引用时，实际上就是调用当前对象的toString（）
  
  * Object类中toString()的定义：
  
    ```java
    public String toString(){
        return getClass().getName()+"@"+Integer.toHexString(hashCode());
    }
    ```
    
  * 像String、Date、File、包装类等都重写了Object类中的toString()方法。使得在调用对象的toString()时，返回"实体内容"信息
  
  * 自定义类也可以重写toString()方法，当调用此方法时，返回对象的"实体内容"
  
    > //自动实现
    > 	@Override
    > 	public String toString() {
    > 		return "Customer [name=" + name + ", age=" + age + "]";
    > 	}
  
2. 面试题：

   ① final、finally、finalize的区别？
   ②  == 和 equals() 区别

   后面补此题

## 单元测试方法

步骤

1. 中当前工程 - 右键择：build path - add libraries - JUnit 4 - 下一步

2. 创建Java类，进行单元测试。

   此时的Java类要求：==① 此类是public的  ②此类提供公共的无参的构造器==

3. 此类中声明单元测试方法。

   此时的单元测试方法：==方法的权限是public,没返回值，没形参==

4. 此单元测试方法上需要声明注解：@Test,并在单元测试类中导入：import org.junit.Test;

5. 声明好单元测试方法以后，就可以在方法体内测试相关的代码。

6. 写完代码以后，左键双击单元测试方法名选中，右键：run as - JUnit Test

   说明

   1.如果执行结果没任何异常：绿条

   2.如果执行结果出现异常：红条

   ```java
   import org.junit.Test;
   public class Junit {
   	@Test
   	public void testToString(){
   		String s2 = "MM";
   		System.out.println(s2.toString());
   	}
   }
   ```

   

## 包装类的使用

1. 为什么要有包装类(或封装类）

   为了使基本数据类型的变量具有类的特征，引入包装类。

2. 基本数据类型与对应的包装类：
   <a href="https://sm.ms/image/xoKQNE2h4Lt9i3r" target="_blank"><img src="https://i.loli.net/2021/04/23/xoKQNE2h4Lt9i3r.png" ></a>

3. 需要掌握的类型间的转换：（基本数据类型、包装类、String）

   <a href="https://sm.ms/image/PpzTaUG81wIifrF" target="_blank"><img src="https://i.loli.net/2021/04/23/PpzTaUG81wIifrF.png" ></a>

4. 简易版

   基本数据类型<--->包装类：JDK 5.0 新特性：自动装箱 与自动拆箱

   基本数据类型、包装类--->String:调用String重载的valueOf(Xxx xxx)

   String--->基本数据类型、包装类:调用包装类的parseXxx(String s)

   ​	注意：转换时，可能会报NumberFormatException

   应用场景举例：

   ① Vector类中关于添加元素，只定义了形参为Object类型的方法：

   v.addElement(Object obj);   //基本数据类型 --->包装类 --->使用多态

   ```java
   import org.junit.Test;
   
   /*
    * 包装类的使用:
    * 1.java提供了8种基本数据类型对应的包装类，使得基本数据类型的变量具有类的特征
    * 
    * 2.掌握的：基本数据类型、包装类、String三者之间的相互转换
    * 
    * 
    * 
    */
   public class WrapperTest {
   	
   	//String类型 --->基本数据类型、包装类：调用包装类的parseXxx(String s)
   	@Test
   	public void test5(){
   		String str1 = "123";
   		//错误的情况：
   //		int num1 = (int)str1;
   //		Integer in1 = (Integer)str1;
   		//可能会报NumberFormatException
   		int num2 = Integer.parseInt(str1);
   		System.out.println(num2 + 1);
   		
   		String str2 = "true1";
   		boolean b1 = Boolean.parseBoolean(str2);
   		System.out.println(b1);
   	}
   	
   	//基本数据类型、包装类--->String类型：调用String重载的valueOf(Xxx xxx)
   	@Test
   	public void test4(){
   		
   		int num1 = 10;
   		//方式1：连接运算
   		String str1 = num1 + "";
   		//方式2：调用String的valueOf(Xxx xxx)
   		float f1 = 12.3f;
   		String str2 = String.valueOf(f1);//"12.3"
   		
   		Double d1 = new Double(12.4);
   		String str3 = String.valueOf(d1);
   		System.out.println(str2);
   		System.out.println(str3);//"12.4"
   		
   	}
   	
   	/*
   	 * JDK 5.0 新特性：自动装箱 与自动拆箱
   	 */
   	@Test
   	public void test3(){
   //		int num1 = 10;
   //		//基本数据类型-->包装类的对象
   //		method(num1);
   		
   		//自动装箱：基本数据类型 --->包装类
   		int num2 = 10;
   		Integer in1 = num2;//自动装箱
   		
   		boolean b1 = true;
   		Boolean b2 = b1;//自动装箱
   		
   		//自动拆箱：包装类--->基本数据类型
   		System.out.println(in1.toString());
   		
   		int num3 = in1;//自动拆箱
   		
   	}
   	
   	public void method(Object obj){
   		System.out.println(obj);
   	}
   	
   	//包装类--->基本数据类型:调用包装类Xxx的xxxValue()
   	@Test
   	public void test2(){
   		Integer in1 = new Integer(12);
   		
   		int i1 = in1.intValue();
   		System.out.println(i1 + 1);
   		
   		
   		Float f1 = new Float(12.3);
   		float f2 = f1.floatValue();
   		System.out.println(f2 + 1);
   	}
   	
   	//基本数据类型 --->包装类：调用包装类的构造器
   	@Test
   	public void test1(){
   		
   		int num1 = 10;
   	//	System.out.println(num1.toString());
   		Integer in1 = new Integer(num1);
   		System.out.println(in1.toString());
   		
   		Integer in2 = new Integer("123");
   		System.out.println(in2.toString());
   		
   		//报异常
   //		Integer in3 = new Integer("123abc");
   //		System.out.println(in3.toString());
   		
   		Float f1 = new Float(12.3f);
   		Float f2 = new Float("12.3");
   		System.out.println(f1);
   		System.out.println(f2);
   		
   		Boolean b1 = new Boolean(true);
   		Boolean b2 = new Boolean("TrUe");
   		System.out.println(b2);
   		Boolean b3 = new Boolean("true123");
   		System.out.println(b3);//false
   		
   		
   		Order order = new Order();
   		System.out.println(order.isMale);//false
   		System.out.println(order.isFemale);//null
   	}
   	
   }
   
   class Order{
   	
   	boolean isMale;
   	Boolean isFemale;
   }
   ```

   举例

   ```java
   import java.util.Scanner;
   import java.util.Vector;
   
   /*
    *  利用Vector代替数组处理：从键盘读入学生成绩（以负数代表输入结束），找出最高分，并输出学生成绩等级。
   	提示：数组一旦创建，长度就固定不变，所以在创建数组前就需要知道它的长度。
   	而向量类java.util.Vector可以根据需要动态伸缩。
   	
   	创建Vector对象：Vector v=new Vector();
   	给向量添加元素：v.addElement(Object obj);   //obj必须是对象
   	取出向量中的元素：Object  obj=v.elementAt(0);
   	注意第一个元素的下标是0，返回值是Object类型的。
   	计算向量的长度：v.size();
   	若与最高分相差10分内：A等；20分内：B等；
   	      30分内：C等；其它：D等
   
    * 
    * 
    * 
    * 
    */
   public class ScoreTest {
   	public static void main(String[] args) {
   		//1.实例化Scanner，用于从键盘获取学生成绩
   		Scanner scan = new Scanner(System.in);
   		
   		//2.创建Vector对象：Vector v=new Vector();相当于原来的数组
   		Vector v = new Vector();
   		
   		//3.通过for(;;)或while(true)方式，给Vector中添加数组
   		int maxScore = 0;
   		for(;;){
   			System.out.println("请输入学生成绩（以负数代表输入结束）");
   			int score = scan.nextInt();
   			//3.2 当输入是负数时，跳出循环
   			if(score < 0){
   				break;
   			}
   			if(score > 100){
   				System.out.println("输入的数据非法，请重新输入");
   				continue;
   			}
   			//3.1 添加操作：：v.addElement(Object obj)
   			//jdk5.0之前：
   //			Integer inScore = new Integer(score);
   //			v.addElement(inScore);//多态
   			//jdk5.0之后：
   			v.addElement(score);//自动装箱
   			//4.获取学生成绩的最大值
   			if(maxScore < score){
   				maxScore = score;
   			}
   		}
   		
   		//5.遍历Vector，得到每个学生的成绩，并与最大成绩比较，得到每个学生的等级。
   		char level;
   		for(int i = 0;i < v.size();i++){
   			Object obj = v.elementAt(i);
   			//jdk 5.0之前：
   //			Integer inScore = (Integer)obj;
   //			int score = inScore.intValue();
   			//jdk 5.0之后：
   			int score = (int)obj;
   			
   			if(maxScore - score <= 10){
   				level = 'A';
   			}else if(maxScore - score <= 20){
   				level = 'B';
   			}else if(maxScore - score <= 30){
   				level = 'C';
   			}else{
   				level = 'D';
   			}
   			
   			System.out.println("student-" + i + " score is " + score + ",level is " + level);
   			
   		}
   		
   		
   		
   		
   	}
   }
   ```

   

# 六、面向对象下

## 关键字：static

1. 可以用来修饰的结构：主要用来修饰类的内部结构

   属性、方法、代码块、内部类

2. static修饰属性：静态变量（或类变量）

   * 属性，是否使用static修饰，又分为：静态属性  vs 非静态属性(实例变量)

     实例变量：我们创建了类的多个对象，每个对象都独立的拥一套类中的非静态属性。当修改其中一个对象中的非静态属性时，不会导致其他对象中同样的属性值的修改。

     静态变量：我们创建了类的多个对象，多个对象共享同一个静态变量。当通过某一个对象修改静态变量时，会导致其他对象调用此静态变量时，是修改过了的。

   * static修饰属性的其他说明：

     ① 静态变量随着类的加载而加载。可以通过"类.静态变量"的方式进行调用

     ② 静态变量的加载要早于对象的创建。

     ③ 由于类只会加载一次，则静态变量在内存中也只会存在一份：存在方法区的静态域中。

     > ​		类变量	实例变量
     >
     > 类		yes		no
     >
     > 对象	yes		yes

   * 静态属性举例：System.out; Math.PI;

3. 静态变量内存解析：

   <a href="https://sm.ms/image/cjeO1Msq9NaF8I3" target="_blank"><img src="https://i.loli.net/2021/04/23/cjeO1Msq9NaF8I3.png" ></a>

4. static修饰方法：静态方法(类方法)

   * 随着类的加载而加载，可以通过"类.静态方法"的方式进行调用

     > ​			静态方法	非静态方法
     >
     > 类		    yes		  no
     >
     > 对象		yes		  yes

   * ==静态方法中，只能调用静态的方法或属性==

   * ==非静态方法中，既可以调用非静态的方法或属性，也可以调用静态的方法或属性==

5. static的注意点：

   * 在静态的方法内，不能使用this关键字、super关键字
   * 关于静态属性和静态方法的使用，从生命周期的角度去理解。

6. 如何判定属性和方法应该使用static关键字：

   * 关于属性
     * 属性是可以被多个对象所共享的，不会随着对象的不同而不同的。
     * 类中的常量也常常声明为static
   * 关于方法
     * 操作静态属性的方法，通常设置为static的
     * 工具类中的方法，习惯上声明为static的。 比如：Math、Arrays、Collections

   举例

   ```java
   //static关键字的应用
   public class CircleTest {
   	public static void main(String[] args) {
   		
   		Circle c1 = new Circle();
   		
   		Circle c2 = new Circle();
   		
   		Circle c3 = new Circle(3.4);
   		System.out.println("c1的id：" + c1.getId() );
   		System.out.println("c2的id：" + c2.getId() );
   		System.out.println("c3的id：" + c3.getId() );
   		
   		System.out.println("创建的圆的个数为：" + Circle.getTotal());
   		
   	}
   }
   
   
   class Circle{
   	
   	private double radius;
   	private int id;//自动赋值
   	
   	public Circle(){
   		id = init++;
   		total++;
   	}
   	
   	public Circle(double radius){
   		this();
   //		id = init++;
   //		total++;
   		this.radius = radius;
   		
   	}
   	
   	private static int total;//记录创建的圆的个数
   	private static int init = 1001;//static声明的属性被所有对象所共享
   	
   	public double findArea(){
   		return 3.14 * radius * radius;
   	}
   
   	public double getRadius() {
   		return radius;
   	}
   
   	public void setRadius(double radius) {
   		this.radius = radius;
   	}
   
   	public int getId() {
   		return id;
   	}
   
   	public static int getTotal() {
   		return total;
   	}
   
   }
   ```



## 单例模式

1. 设计模式的说明

   设计模式是在大量的实践中总结和理论化之后优的代码结构、编程风格、以及解决问题的思考方式。

2. 常用设计模式   --- 23种经典的设计模式  GOF

   创建型模式，共5种：工厂方法模式、抽象工厂模式、单例模式、建造者模式、原型模式。 
   结构型模式，共7种：适配器模式、装饰器模式、代理模式、外观模式、桥接模式、组合模式、享元模式。 
   行为型模式，共11种：策略模式、模板方法模式、观察者模式、迭代器模式、责任链模式、命令模式、备忘录模式、状态模式、访问者模式、中介者模式、解释器模式。 

3. 单例模式

   * 要解决的问题：

     ==所谓类的单例设计模式，就是采取一定的方法保证在整个的软件系统中，对某个类只能存在一个对象实例。==

   * 具体代码的实现

     饿汉式1：

     ```java
     class Bank(){
         //1、私化类的构造器
         private Bank(){
             
         }
         //2、内部创建类的对象
         //4、要求此对象也必须声明为静态的
         private static Bank instance= new Bank();
         //3、提供公共的静态方法，返回类的对象
         public static Bank getInstance(){
             return instance;
         }
     }
     ```

     饿汉式2：使用了静态代码块

     ```java 
     class Order{
         //1.私化类的构造器
     	private Order(){
     		
     	}
         //2.声明当前类对象，没初始化
     	//4.此对象也必须声明为static的
     	private static Order instance = null;
         static{
     		instance = new Order();
      }
         //3.声明public、static的返回当前类对象的方法
     	public static Order getInstance(){
     		return instance;
     	}
     }
     ```

     懒汉式：

     ```java
     class Order{
         //1.私化类的构造器
     	private Order(){
     		
     	}
         //2.声明当前类对象，没初始化
     	//4.此对象也必须声明为static的
     	private static Order instance = null;
         //3.声明public、static的返回当前类对象的方法
     	public static Order getInstance(){
     		
     		if(instance == null){
     			
     			instance = new Order();
     			
     		}
     		return instance;
     	}
     }
     ```

4. 两种方式的对比

   饿汉式：

   * 坏处：对象加载时间过长
   * 好处：饿汉式是线程安全的

   懒汉式：

   * 好处：延迟对象的创建。

   * 坏处：目前的写法线程不安全。--->到多线程内容时，在修改

     

## main()的使用说明

* main()方法作为程序的入口

* main()方法也是一个普通的静态方法

* main()方法可以作为我们与控制台交互的方式。（之前：使用Scanner）

  > 如何将控制台获取的数据传给形参：String[] args?
  >   运行时：java 类名 "Tom" "Jerry" "123" "true"
  >
  > sysout(args[0]);//"Tom"
  > sysout(args[3]);//"true"  -->Boolean.parseBoolean(args[3]);
  > sysout(args[4]);//报异常



小结：

> public static void main(String[] args){//方法体}
>
> 权限修饰符：private 缺省 protected pubilc ---->封装性
> 修饰符：static \ final \ abstract \native 可以用来修饰方法
> 返回值类型： 无返回值 / 有返回值 -->return
> 方法名：需要满足标识符命名的规则、规范；"见名知意"
> 形参列表：重载 vs 重写；参数的值传递机制；体现对象的多态性
> 方法体：来体现方法的功能

## 类的结构之四：代码块

代码块(初始化块)（重要性较属性、方法、构造器差一些）

1. 代码块的作用：用来初始化类、对象的信息

2. 分类：代码块要是使用修饰符，只能使用static     静态代码块  vs 非静态代码块

3. 静态代码块：

   >内部可以输出语句
   >随着类的加载而执行,而且只执行一次
   >作用：初始化类的信息
   >如果一个类中定义了多个静态代码块，则按照声明的先后顺序执行
   >静态代码块的执行要优先于非静态代码块的执行
   >静态代码块内只能调用静态的属性、静态的方法，不能调用非静态的结构

4. 非静态代码块：

   >内部可以输出语句
   >随着对象的创建而执行
   >每创建一个对象，就执行一次非静态代码块
   >作用：可以在创建对象时，对对象的属性等进行初始化
   >如果一个类中定义了多个非静态代码块，则按照声明的先后顺序执行
   >非静态代码块内可以调用静态的属性、静态的方法，或非静态的属性、非静态的方法

5. 举例

   LeafTest.java

   ```java
   //总结：由父及子，静态先行
   class Root{
   	static{
   		System.out.println("Root的静态初始化块");
   	}
   	{
   		System.out.println("Root的普通初始化块");
   	}
   	public Root(){
   		super();
   		System.out.println("Root的无参数的构造器");
   	}
   }
   class Mid extends Root{
   	static{
   		System.out.println("Mid的静态初始化块");
   	}
   	{
   		System.out.println("Mid的普通初始化块");
   	}
   	public Mid(){
   		super();
   		System.out.println("Mid的无参数的构造器");
   	}
   	public Mid(String msg){
   		//通过this调用同一类中重载的构造器
   		this();
   		System.out.println("Mid的带参数构造器，其参数值："
   			+ msg);
   	}
   }
   class Leaf extends Mid{
   	static{
   		System.out.println("Leaf的静态初始化块");
   	}
   	{
   		System.out.println("Leaf的普通初始化块");
   	}	
   	public Leaf(){
   		//通过super调用父类中有一个字符串参数的构造器
   		super("atguigu");
   		System.out.println("Leaf的构造器");
   	}
   }
   public class LeafTest{
   	public static void main(String[] args){
   		new Leaf(); 
   		System.out.println();
   		new Leaf();
   	}
   }
   ```

   Son.java

   ```java
   class Father {
   	static {
   		System.out.println("11111111111");
   	}
   	{
   		System.out.println("22222222222");
   	}
   
   	public Father() {
   		System.out.println("33333333333");
   
   	}
   
   }
   
   public class Son extends Father {
   	static {
   		System.out.println("44444444444");
   	}
   	{
   		System.out.println("55555555555");
   	}
   	public Son() {
   		System.out.println("66666666666");
   	}
   
   
   	public static void main(String[] args) { // 由父及子 静态先行
   		System.out.println("77777777777");
   		System.out.println("************************");
   		new Son();
   		System.out.println("************************");
   		new Son();
   		System.out.println("************************");
   		new Father();
   	}
   
   }
   ```



## 属性的赋值顺序

 * ①默认初始化
 * ②显式初始化/⑤在代码块中赋值
 * ③构造器中初始化
 * ④有了对象以后，可以通过"对象.属性"或"对象.方法"的方式，进行赋值
 * 执行的先后顺序：① - ② / ⑤ - ③ - ④

## 关键字： final

final：最终的

1. 可以用来修饰：类、方法、变量

2. final 用来修饰一个类:此类不能被其他类所继承。

   比如：String类、System类、StringBuffer类

3. final 用来修饰方法：表明此方法不可以被重写

   比如：Object类中getClass();

4. final 用来修饰变量：此时的"变量"就称为是一个常量

   * final修饰属性：可以考虑赋值的位置：显式初始化、代码块中初始化、构造器中初始化

   * final修饰局部变量：

     > 尤其是使用final修饰形参时，表明此形参是一个常量。当我们调用此方法时，给常量形参赋一个实参。一旦赋值以后，就只能在方法体内使用此形参，但不能进行重新赋值。

5. static final 用来修饰属性：全局常量

6. 举例

   ```java
   public class FinalTest {
   	
   	final int WIDTH = 0;
   	final int LEFT;
   	final int RIGHT;
   //	final int DOWN;
   	
   	{
   		LEFT = 1;
   	}
   	
   	public FinalTest(){
   		RIGHT = 2;
   	}
   	
   	public FinalTest(int n){
   		RIGHT = n;
   	}
   	
   //	public void setDown(int down){
   //		this.DOWN = down;
   //	}
   	
   	
   	public void doWidth(){
   //		width = 20;
   	}
   	
   	
   	public void show(){
   		final int NUM = 10;//常量
   //		NUM += 20;
   	}
   	
   	public void show(final int num){
   //		num = 20;//编译不通过
   		System.out.println(num);
   	}
   	
   	
   	public static void main(String[] args) {
   		
   		int num = 10;
   		
   		num = num + 5;
   		
   		FinalTest test = new FinalTest();
   //		test.setDown(3);
   		
   		test.show(10);
   	}
   }
   
   
   final class FinalA{
   	
   }
   
   //class B extends FinalA{
   //	
   //}
   
   //class C extends String{
   //	
   //}
   
   class AA{
   	public final void show(){
   		
   	}
   }
   
   class BB extends AA{
   	
   //	public void show(){
   //		
   //	}
   }
   ```


## 关键字:abstract

1. 可以用来修饰：类、方法

2. 具体的：

   * abstract修饰类：抽象类

     > ==此类不能实例化==
     >
     > ==抽象类中一定有构造器==，便于子类实例化时调用（涉及：子类对象实例化的全过程）
     >
     > 开发中，都会提供抽象类的子类，让子类对象实例化，完成相关的操作 --->抽象的使用前提：继承性

   * abstract修饰方法：抽象方法

     > 抽象方法只方法的声明，没方法体
     >
     > 包含抽象方法的类，一定是一个抽象类。反之，抽象类中可以没有抽象方法的。
     >
     > 若子类重写了父类中的所的抽象方法后，此子类方可实例化
     >
     > 若子类没重写父类中的所的抽象方法，则此子类也是一个抽象类，需要使用abstract修饰

3. 注意点：

   1. abstract不能用来修饰：属性、构造器等结构
   2. abstract不能用来修饰私方法、静态方法、final的方法、final的类

4. abstract的应用举例

   举例一：

   ```java
   public abstract class Vehicle{
       public abstract double calcFuelEfficiency();//计算燃料效率的抽象方法
       public abstract double calcTripDistance();//计算行驶距离的抽象方法
   }
   public class Truck extends Vehicle{
   	public double calcFuelEfficiency( ){//写出计算卡车的燃料效率的具体方法}
   	public double calcTripDistance() { //写出计算卡车行驶距离的具体方法}
   }
   public class RiverBarge extends vehicle{
   	public double calcFuelEfficiency(){//写出计算驳船的燃料效率的具体方法}
       public double calcTripDistance( ) {//写出计算驳船行驶距离的具体方法}
       
   }
   ```

   举例二：

   ```java
   abstract class GeometricObject{
   public abstract double findArea();
   }
   class Circle extends GeometricObject{
   private double radius;
   public double findArea(){
   		return 3.14 * radius * radius;
   }
   }
   ```

   举例三：

   > IO流中设计到的抽象类：InputStream/OutputStream / Reader /Writer。在其内部
   > 定义了抽象的read()、write()方法。



### 模板方法的设计模式

1. 解决的问题

   在软件开发中实现一个算法时，整体步骤很固定、通用，这些步骤已经在父类中写好了。但是些部分易变，易变部分可以抽象出来，供不同子类实现。这就是一种模板模式。

2. 应用场景

   > 模板方法设计模式是编程中经常用得到的模式。各个框架、类库中都有他的影子，比如常见的有:
   > 数据库访问的封装Junit单元测试
   > JavaWeb的Servlet中关于doGetldoPost方法调用
   >
   > Hibernate中模板程序
   > Spring中JDBCTemlate、HibernateTemplate等

3. 举例

   ```java 
   /*
    * 抽象类的应用：模板方法的设计模式
    * 
    */
   public class TemplateTest {
       public static void main(String[] args) {
   
           SubTemplate t = new SubTemplate();
   
           t.spendTime();
       }
   }
   
   abstract class Template{
   
       //计算某段代码执行所需要花费的时间
       public void spendTime(){
   
           long start = System.currentTimeMillis();
   
           this.code();//不确定的部分、易变的部分
   
           long end = System.currentTimeMillis();
   
           System.out.println("花费的时间为：" + (end - start));
   
       }
   
       public abstract void code();
   
   
   }
   
   class SubTemplate extends Template{
   
       @Override
       public void code() {
   
           for(int i = 2;i <= 1000;i++){
               boolean isFlag = true;
               for(int j = 2;j <= Math.sqrt(i);j++){
   
                   if(i % j == 0){
                       isFlag = false;
                       break;
                   }
               }
               if(isFlag){
                   System.out.println(i);
               }
           }
   
       }
   
   }
   ```

   ```java
   //抽象类的应用：模板方法的设计模式
   public class TemplateMethodTest {
   
   	public static void main(String[] args) {
   		BankTemplateMethod btm = new DrawMoney();
   		btm.process();
   
   		BankTemplateMethod btm2 = new ManageMoney();
   		btm2.process();
   	}
   }
   abstract class BankTemplateMethod {
   	// 具体方法
   	public void takeNumber() {
   		System.out.println("取号排队");
   	}
   
   	public abstract void transact(); // 办理具体的业务 //钩子方法
   
   	public void evaluate() {
   		System.out.println("反馈评分");
   	}
   
   	// 模板方法，把基本操作组合到一起，子类一般不能重写
   	public final void process() {
   		this.takeNumber();
   
   		this.transact();// 像个钩子，具体执行时，挂哪个子类，就执行哪个子类的实现代码
   
   		this.evaluate();
   	}
   }
   
   class DrawMoney extends BankTemplateMethod {
   	public void transact() {
   		System.out.println("我要取款！！！");
   	}
   }
   
   class ManageMoney extends BankTemplateMethod {
   	public void transact() {
   		System.out.println("我要理财！我这里有2000万美元!!");
   	}
   }
   ```

## 关键字:interface

1. 使用说明：

* 接口使用interface来定义
* Java中，接口和类是并列的两个结构

2. 如何定义接口：定义接口中的成员

   * JDK7及以前：只能定义全局常量和抽象方法

     > 全局常量：public static final的.但是书写时，可以省略不写
     >
     > 抽象方法：public abstract的

   * JDK8：除了定义全局常量和抽象方法之外，还可以定义静态方法、默认方法（略

3. 接口中不能定义构造器的！意味着接口不可以实例化

4. Java开发中，接口通过让类去实现(implements)的方式来使用.

   1. 如果实现类覆盖了接口中的所抽象方法，则此实现类就可以实例化
   2. 如果实现类没覆盖接口中所的抽象方法，则此实现类仍为一个抽象类

5. Java类可以实现多个接口   --->弥补了Java单继承性的局限性

   1. 格式：class AA extends BB implements CC,DD,EE

6. 接口与接口之间可以继承，而且可以多继承

7. 接口的具体使用，体现多态性

8. 接口，实际上可以看做是一种规范

9. 举例

   ```java 
   /*
    * 接口的使用
    * 1.接口使用上也满足多态性
    * 2.接口，实际上就是定义了一种规范
    * 3.开发中，体会面向接口编程！
    * 
    */
   public class USBTest {
   	public static void main(String[] args) {
   		
   		Computer com = new Computer();
   		//1.创建了接口的非匿名实现类的非匿名对象
   		Flash flash = new Flash();
   		com.transferData(flash);
   		
   		//2. 创建了接口的非匿名实现类的匿名对象
   		com.transferData(new Printer());
   		
   		//3. 创建了接口的匿名实现类的非匿名对象
   		USB phone = new USB(){
   
   			@Override
   			public void start() {
   				System.out.println("手机开始工作");
   			}
   
   			@Override
   			public void stop() {
   				System.out.println("手机结束工作");
   			}
   			
   		};
   		com.transferData(phone);
   		
   		
   		//4. 创建了接口的匿名实现类的匿名对象
   		
   		com.transferData(new USB(){
   			@Override
   			public void start() {
   				System.out.println("mp3开始工作");
   			}
   
   			@Override
   			public void stop() {
   				System.out.println("mp3结束工作");
   			}
   		});
   	}
   }
   
   class Computer{
   	
   	public void transferData(USB usb){//USB usb = new Flash();
   		usb.start();
   		
   		System.out.println("具体传输数据的细节");
   		
   		usb.stop();
   	}
   	
   	
   }
   
   interface USB{
   	//常量：定义了长、宽、最大最小的传输速度等
   	
   	void start();
   	
   	void stop();
   	
   }
   
   class Flash implements USB{
   
   	@Override
   	public void start() {
   		System.out.println("U盘开启工作");
   	}
   
   	@Override
   	public void stop() {
   		System.out.println("U盘结束工作");
   	}
   	
   }
   
   class Printer implements USB{
   	@Override
   	public void start() {
   		System.out.println("打印机开启工作");
   	}
   
   	@Override
   	public void stop() {
   		System.out.println("打印机结束工作");
   	}
   	
   }
   ```

10. 体会面向接口编程的

    <a href="https://sm.ms/image/FRasN36prtUjbzZ" target="_blank"><img src="https://i.loli.net/2021/04/24/FRasN36prtUjbzZ.png" ></a>

    面向接口编程：我们在应用程序中，调用的结构都是JDBC中定义的接口，不会出现具体某一个
    数据库厂商的API。

11. Java8中关于接口的新规范

    1. 接口中定义的静态方法，只能通过接口来调用。

    2. 通过实现类的对象，可以调用接口中的默认方法。

       如果实现类重写了接口中的默认方法，调用时，仍然调用的是重写以后的方法

    3. 如果子类(或实现类)继承的父类和实现的接口中声明了同名同参数的默认方法，那么子类在没重写此方法的情况下，默认调用的是父类中的同名同参数的方法。-->==类优先原则==

    4. 如果实现类实现了多个接口，而这多个接口中定义了同名同参数的默认方法，那么在实现类没重写此方法的情况下，报错。-->接口冲突。这就需要我们必须在实现类中重写此方法

    5. 如何在子类(或实现类)的方法中调用父类、接口中被重写的方法

       举例：
       
       SubClassTest.java
       
       ```java
       public class SubClassTest {
       	
       	public static void main(String[] args) {
       		SubClass s = new SubClass();
       		
       //		s.method1();
       //		SubClass.method1();
       		//知识点1：接口中定义的静态方法，只能通过接口来调用。
       		CompareA.method1();
       		//知识点2：通过实现类的对象，可以调用接口中的默认方法。
       		//如果实现类重写了接口中的默认方法，调用时，仍然调用的是重写以后的方法
       		s.method2();
       		//知识点3：如果子类(或实现类)继承的父类和实现的接口中声明了同名同参数的默认方法，
       		//那么子类在没有重写此方法的情况下，默认调用的是父类中的同名同参数的方法。-->类优先原则
       		//知识点4：如果实现类实现了多个接口，而这多个接口中定义了同名同参数的默认方法，
       		//那么在实现类没有重写此方法的情况下，报错。-->接口冲突。
       		//这就需要我们必须在实现类中重写此方法
       		s.method3();
       		
       	}
       	
       }
       
       class SubClass extends SuperClass implements CompareA,CompareB{
       	
       	public void method2(){
       		System.out.println("SubClass：上海");
       	}
       	
       	public void method3(){
       		System.out.println("SubClass：深圳");
       	}
       	
       	//知识点5：如何在子类(或实现类)的方法中调用父类、接口中被重写的方法
       	public void myMethod(){
       		method3();//调用自己定义的重写的方法
       		super.method3();//调用的是父类中声明的
       		//调用接口中的默认方法
       		CompareA.super.method3();
       		CompareB.super.method3();
       	}
       }
       ```
       
       SuperClass.java
       
       ```java 
       public class SuperClass {
       	
       	public void method3(){
       		System.out.println("SuperClass:北京");
       	}
       	
       }
       ```
       
       CompareA.java
       
       ```java 
       /*
        * 
        * JDK8：除了定义全局常量和抽象方法之外，还可以定义静态方法、默认方法
        * 
        */
       public interface CompareA {
       	
       	//静态方法
       	public static void method1(){
       		System.out.println("CompareA:北京");
       	}
       	//默认方法
       	public default void method2(){
       		System.out.println("CompareA：上海");
       	}
       	
       	default void method3(){
       		System.out.println("CompareA：上海");
       	}
       }
       ```
       
       CompareB.java
       
       ```java
       public interface CompareB {
       	
       	default void method3(){
       		System.out.println("CompareB：上海");
       	}
       	
       }
       ```
       
       
       
       

12. 面试题：

    抽象类和接口的异同？

    相同点：不能实例化；都可以包含抽象方法的。

    不同点：

    ​	把抽象类和接口(java7,java8,java9)的定义、内部结构解释说明

    ​	类：单继承性    接口：多继承

    ​	类与接口：多实现



### 代理模式

1. 解决的问题

   代理模式是Java开发中使用较多的一种设计模式。代理设计就是为其他对象提供一种代理以控制对这个对象的访问。 

2. 举例

   ```java 
   /*
    * 接口的应用：代理模式
    * 
    */
   public class NetWorkTest {
   	public static void main(String[] args) {
   		Server server = new Server();
   //		server.browse();
   		ProxyServer proxyServer = new ProxyServer(server);
   		
   		proxyServer.browse();
   		 
   	}
   }
   
   interface NetWork{
   	
   	public void browse();
   	
   }
   
   //被代理类
   class Server implements NetWork{
   
   	@Override
   	public void browse() {
   		System.out.println("真实的服务器访问网络");
   	}
   
   }
   //代理类
   class ProxyServer implements NetWork{
   	
   	private NetWork work;
   	
   	public ProxyServer(NetWork work){
   		this.work = work;
   	}
   	
   
   	public void check(){
   		System.out.println("联网之前的检查工作");
   	}
   	
   	@Override
   	public void browse() {
   		check();
   		
   		work.browse();
   		
   	}
   	
   }
   ```

3. 应用场景

   <a href="https://sm.ms/image/EvGu6F238mrWcbp" target="_blank"><img src="https://i.loli.net/2021/04/25/EvGu6F238mrWcbp.png" ></a>



### 工厂的设计模式

1. 实现了创建者与调用者的分离，即将创建对象的具体过程屏蔽隔离起来，达到提高灵活性的目的。

2. 具体模式

   > 简单工厂模式：用来生产同一等级结构中的任意产品。（对于增加新的产品，需要修改已有代码）
   > 工厂方法模式：用来生产同一等级结构中的固定产品。（支持增加任意产品)
   > 抽象工厂模式：用来生产不同产品族的全部产品。（对于增加新的产品，无能为力；支持增加产品族)

## 类的结构: 内部类

内部类：类的第五个成员

1. 定义：Java中允许将一个类A声明在另一个类B中，则类A就是内部类，类B称为外部类.

2. 内部类的分类：

   > 成员内部类（静态、非静态 ） vs 局部内部类(方法内、代码块内、构造器内)

3. 成员内部类的理解：

   * 一方面，作为外部类的成员：

     > 调用外部类的结构
     >
     > 可以被static修饰
     >
     > 可以被4种不同的权限修饰

   * 另一方面，作为一个类：

     > 类内可以定义属性、方法、构造器等
     >
     > 可以被final修饰，表示此类不能被继承。言外之意，不使用final，就可以被继承
     >
     > 可以被abstract修饰

4. 成员内部类：

   1. 如何创建成员内部类的对象？(静态的，非静态的)

      >  //创建静态的Dog内部类的实例(静态的成员内部类):
      > Person.Dog dog = new Person.Dog();
      >
      > 
      >
      > 
      >
      > //创建非静态的Bird内部类的实例(非静态的成员内部类):
      > //Person.Bird bird = new Person.Bird();//错误的
      > Person p = new Person();
      > Person.Bird bird = p.new Bird();

   2. 如何在成员内部类中调用外部类的结构？

      > class Person{
      > 	String name = "小明";
      > public void eat(){
      > }
      > //非静态成员内部类
      > 	class Bird{
      > 		String name = "杜鹃";
      > 		public void display(String name){
      > 			System.out.println(name);//方法的形参
      > 			System.out.println(this.name);//内部类的属性
      > 			System.out.println(Person.this.name);//外部类的属性
      > 		//Person.this.eat();
      > 		}
      > 	}
      > }

   3. 局部内部类的使用：

      > 	//返回一个实现了Comparable接口的类的对象
      > 	public Comparable getComparable(){
      > 		
      > 		//创建一个实现了Comparable接口的类:局部内部类
      > 		//方式一：
      > //		class MyComparable implements Comparable{
      > //
      > //			@Override
      > //			public int compareTo(Object o) {
      > //				return 0;
      > //			}
      > //			
      > //		}
      > //		
      > //		return new MyComparable();
      > 		
      >
      > //方式二：
      >
      > return new Comparable(){
      >
      > @Override
      > 			public int compareTo(Object o) {
      > 				return 0;
      >
      > ​		}
      >
      > ​	};

5. 注意点

   在局部内部类的方法中（比如：show如果调用局部内部类所声明的方法(比如：method)中的局部变量(比如：num)的话,要求此局部变量声明为final的。

   ```java
   public void method(){
		//局部变量
   		int num = 10;
   		
   		class AA{
			public void show(){
   //				num = 20;
   				System.out.println(num);
   				
   			}
   		}
   	}
   ```
   
   
   
   jdk 7及之前版本：要求此局部变量显式的声明为final的
   jdk 8及之后的版本：可以省略final的声明
   
   成员内部类和局部内部类，在编译以后，都会生成字节码文件。
   格式：成员内部类：外部类\$内部类名.class
         局部内部类：外部类\$数字内部类名.class
   
   

# 七、异常处理

## 异常

1. 异常的体系结构

   > java.lang.Throwable
   >
   > ​	|----java.lang.Error:一般不编写针对性的代码进行处理
   >
   > ​	|----java.lang.Exception:可以进行异常的处理
   >
   > ​		|----编译时异常（checked）
   >
   > ​			|----IOException
   >
   > ​				|----FileNotFoundException
   >
   > ​			|----ClassNotFoundException
   >
   > ​		|----运行时异常（unchecked,RuntimeException）
   >
   > ​			|----NullPointerException
   >
   > ​			|----ArrayIndexOutOfBoundsException
   >
   > ​			|----ClassCastException
   >
   > ​			|----NumberFormatException
   >
   > ​			|----InputMismatchException
   >
   > ​			|----ArithmeticException

   <a href="https://sm.ms/image/kCGo6TDKL9fj8gr" target="_blank"><img src="https://i.loli.net/2021/04/26/kCGo6TDKL9fj8gr.png" ></a>

   Error:

   Java虚拟机无法解决的严重问题。如：JVM系统内部错误、资源耗尽等严重情况。比如：StackOverflowError和OOM。

   一般不编写针对性的代码进行处理。

   ```java
   public class ErrorTest {
   	public static void main(String[] args) {
   		//1.栈溢出：java.lang.StackOverflowError
   //		main(args);
   		//2.堆溢出：java.lang.OutOfMemoryError 
   		Integer[] arr = new Integer[1024*1024*1024];
   		
   	}
   }
   ```

   

2. 从程序执行过程，看编译时异常和运行时异常

   <a href="https://sm.ms/image/7kERnqILj4f1lSQ" target="_blank"><img src="https://i.loli.net/2021/04/26/7kERnqILj4f1lSQ.png" ></a>

   编译时异常：执行javac.exe命令时，可能出现的异常

   运行时异常：执行java.exe命令时，出现的异常

3. 常见的异常类型，举例

   ```java
   //******************以下是运行时异常***************************
   	//ArithmeticException
   	@Test
   	public void test6(){
   		int a = 10;
   		int b = 0;
   		System.out.println(a / b);
   	}
   	
   	//InputMismatchException
   	@Test
   	public void test5(){
   		Scanner scanner = new Scanner(System.in);
   		int score = scanner.nextInt();
   		System.out.println(score);
   		
   		scanner.close();
   	}
   	
   	//NumberFormatException
   	@Test
   	public void test4(){
   		
   		String str = "123";
   		str = "abc";
   		int num = Integer.parseInt(str);
   		
   		
   		
   	}
   	
   	//ClassCastException
   	@Test
   	public void test3(){
   		Object obj = new Date();
   		String str = (String)obj;
   	}
   	
   	//IndexOutOfBoundsException
   	@Test
   	public void test2(){
   		//ArrayIndexOutOfBoundsException
   //		int[] arr = new int[10];
   //		System.out.println(arr[10]);
   		//StringIndexOutOfBoundsException
   		String str = "abc";
   		System.out.println(str.charAt(3));
   	}
   	
   	//NullPointerException
   	@Test
   	public void test1(){
   		
   //		int[] arr = null;
   //		System.out.println(arr[3]);
   		
   		String str = "abc";
   		str = null;
   		System.out.println(str.charAt(0));
   		
   	}
   
   	//******************以下是编译时异常***************************
   	@Test
   	public void test7(){
   //		File file = new File("hello.txt");
   //		FileInputStream fis = new FileInputStream(file);
   //		
   //		int data = fis.read();
   //		while(data != -1){
   //			System.out.print((char)data);
   //			data = fis.read();
   //		}
   //		
   //		fis.close();
   		
   	}
   ```

## 异常的处理

1. java异常处理的抓抛模型

   * 过程一："抛"：程序在正常执行的过程中，一旦出现异常，就会在异常代码处生成一个对应异常类的对象。

     并将此对象抛出。

     一旦抛出对象以后，其后的代码就不再执行。

     > 关于异常对象的产生：
     >
     > 1. 系统自动生成的异常对象
     > 2. 手动的生成一个异常对象，并抛出（throw）

   * 过程二："抓"：可以理解为异常的处理方式

     > 1. try-catch-finally
     > 2. throws

2. 异常处理方式一：try-catch-finally

   格式

   ```java 
   try{
   
   //可能出现异常的代码
   
   }catch(异常类型1 变量名1){
   
   //处理异常的方式1
   
   }catch(异常类型2 变量名2){
   
   //处理异常的方式2
   
   }catch(异常类型3 变量名3){
   
   //处理异常的方式3
   
   }
   ....
       finally{
           //一定会执行的代码
       }
   
   ```

   ==说明==

   * 1. finally是可的。
    * 2. 使用try将可能出现异常代码包装起来，在执行过程中，一旦出现异常，就会生成一个对应异常类的对象，根据此对象的类型，去catch中进行匹配
    * 3. 一旦try中的异常对象匹配到某一个catch时，就进入catch中进行异常的处理。一旦处理完成，就跳出当前的try-catch结构（在没写finally的情况）。继续执行其后的代码
    * 4. catch中的异常类型如果没子父类关系，则谁声明在上，谁声明在下无所谓。
    *    catch中的异常类型如果满足子父类关系，则要求子类一定声明在父类的上面。否则，报错
    * 5. 常用的异常对象处理的方式： ① String  getMessage()    ② printStackTrace()
    * 6. 在try结构中声明的变量，再出了try结构以后，就不能再被调用
    * 7. try-catch-finally结构可以嵌套：

   ==总结：如何看待代码中的编译时异常和运行时异常？==

   体会1：使用try-catch-finally处理编译时异常，是得程序在编译时就不再报错，但是运行时仍可能报错。相当于我们使用try-catch-finally将一个编译时可能出现的异常，延迟到运行时出现。

   体会2：开发中，由于运行时异常比较常见，所以我们通常就不针对运行时异常编写try-catch-finally了。针对于编译时异常，我们说一定要考虑异常的处理。

   ```java
   public class ExceptionTest1 {
   	
   	
   	@Test
   	public void test2(){
   		try{
   			File file = new File("hello.txt");
   			FileInputStream fis = new FileInputStream(file);
   			
   			int data = fis.read();
   			while(data != -1){
   				System.out.print((char)data);
   				data = fis.read();
   			}
   			
   			fis.close();
   		}catch(FileNotFoundException e){
   			e.printStackTrace();
   		}catch(IOException e){
   			e.printStackTrace();
   		}
   	}
   	
   	@Test
   	public void test1(){
   		
   		String str = "123";
   		str = "abc";
   		int num = 0;
   		try{
   			num = Integer.parseInt(str);
   			
   			System.out.println("hello-----1");
   		}catch(NumberFormatException e){
   //			System.out.println("出现数值转换异常了，不要着急....");
   			//String getMessage():
   //			System.out.println(e.getMessage());
   			//printStackTrace():
   			e.printStackTrace();
   		}catch(NullPointerException e){
   			System.out.println("出现空指针异常了，不要着急....");
   		}catch(Exception e){
   			System.out.println("出现异常了，不要着急....");
   			
   		}
   		System.out.println(num);
   		
   		System.out.println("hello-----2");
   	}
   	
   }
   ```

   

3. finally的再说明：

   * finally是可选的

   * finally中声明的是一定会被执行的代码。即使catch中又出现异常了，try中return语句，catch中return语句等情况。

   * 像数据库连接、输入输出流、网络编程Socket等资源，JVM是不能自动的回收的，我们需要自己手动的进行资源的释放。此时的资源释放，就需要声明在finally中。

     ```java 
     public class FinallyTest {
     	
     	
     	@Test
     	public void test2(){
     		FileInputStream fis = null;
     		try {
     			File file = new File("hello1.txt");
     			fis = new FileInputStream(file);
     			
     			int data = fis.read();
     			while(data != -1){
     				System.out.print((char)data);
     				data = fis.read();
     			}
     			
     			
     		} catch (FileNotFoundException e) {
     			e.printStackTrace();
     		} catch (IOException e) {
     			e.printStackTrace();
     		}finally{
     			try {
     				if(fis != null)
     					fis.close();
     			} catch (IOException e) {
     				e.printStackTrace();
     			}
     		}
     	}
     	
     	
     	@Test
     	public void testMethod(){
     		int num = method();
     		System.out.println(num);
     	}
     	
     	public int method(){
     		
     		try{
     			int[] arr = new int[10];
     			System.out.println(arr[10]);
     			return 1;
     		}catch(ArrayIndexOutOfBoundsException e){
     			e.printStackTrace();
     			return 2;
     		}finally{
     			System.out.println("我一定会被执行");
     			return 3;
     		}
     		
     		
     	}
     	
     	@Test
     	public void test1(){
     		try{
     			int a = 10;
     			int b = 0;
     			System.out.println(a / b);
     			
     		}catch(ArithmeticException e){
     			e.printStackTrace();
     			
     //			int[] arr = new int[10];
     //			System.out.println(arr[10]);
     			
     		}catch(Exception e){
     			e.printStackTrace();
     		}
     //		System.out.println("我好帅啊！！！~~");
     		
     		finally{
     			System.out.println("我好帅啊~~");
     		}
     		
     	}
     	
     }
     ```

     面试题

     > final、finally、finalize三者的区别？
     >
     > 类似：
     > throw 和 throws
     > Collection 和 Collections
     > String 、StringBuffer、StringBuilder
     > ArrayList 、 LinkedList
     > HashMap 、LinkedHashMap
     > 重写、重载
     >
     > 结构不相似的：
     > 抽象类、接口
     > == 、 equals()
     > sleep()、wait()

4. 异常处理方式二：throws

   "throws + 异常类型"写在方法的声明处。指明此方法执行时，可能会抛出的异常类型。
   一旦当方法体执行时，出现异常，仍会在异常代码处生成一个异常类的对象，此对象满足throws后异常类型时，就会被抛出。异常代码后续的代码，就不再执行！

   ```java
   public class ExceptionTest2 {
   	
   	
   	public static void main(String[] args){
   		try{
   			method2();
   			
   		}catch(IOException e){
   			e.printStackTrace();
   		}
   		
   //		method3();
   		
   	}
   	
   	
   	public static void method3(){
   		try {
   			method2();
   		} catch (IOException e) {
   			e.printStackTrace();
   		}
   	}
   	
   	
   	public static void method2() throws IOException{
   		method1();
   	}
   	
   	
   	public static void method1() throws FileNotFoundException,IOException{
   		File file = new File("hello1.txt");
   		FileInputStream fis = new FileInputStream(file);
   		
   		int data = fis.read();
   		while(data != -1){
   			System.out.print((char)data);
   			data = fis.read();
   		}
   		
   		fis.close();
   		
   		System.out.println("hahaha!");
   	}
   	
   	
   }
   ```

5. 对比两种处理方式

   try-catch-finally:真正的将异常给处理掉了。

   throws的方式只是将异常抛给了方法的调用者。并没真正将异常处理掉。

6. 体会开发中应该如何选择两种处理方式？

   * 如果父类中被重写的方法没throws方式处理异常，则子类重写的方法也不能使用throws，意味着如果子类重写的方法中异常，必须使用try-catch-finally方式处理。
   * 执行的方法a中，先后又调用了另外的几个方法，这几个方法是递进关系执行的。我们建议这几个方法使用throws的方式进行处理。而执行的方法a可以考虑使用try-catch-finally方式进行处理。

   补充：
   方法重写的规则之一：
   子类重写的方法抛出的异常类型不大于父类被重写的方法抛出的异常类型

   ```java
   public class OverrideTest {
   	
   	public static void main(String[] args) {
   		OverrideTest test = new OverrideTest();
   		test.display(new SubClass());
   	}
   
   	
   	public void display(SuperClass s){
   		try {
   			s.method();
   		} catch (IOException e) {
   			e.printStackTrace();
   		}
   	}
   }
   
   class SuperClass{
   	
   	public void method() throws IOException{
   		
   	}
   	
   	
   }
   
   class SubClass extends SuperClass{
   	public void method()throws FileNotFoundException{
   		
   	}
   }
   ```



## 手动抛出异常对象

1. 使用说明

   在程序执行中，除了自动抛出异常对象的情况之外，我们还可以手动的throw一个异常类的对象。

   ```java
   public class StudentTest {
   	
   	public static void main(String[] args) {
   		try {
   			Student s = new Student();
   			s.regist(-1001);
   			System.out.println(s);
   		} catch (Exception e) {
   //			e.printStackTrace();
   			System.out.println(e.getMessage());
   		}
   	}
   	
   }
   
   
   class Student{
   	
   	private int id;
   	
   	public void regist(int id) throws Exception {
   		if(id > 0){
   			this.id = id;
   		}else{
   //			System.out.println("您输入的数据非法！");
   			//手动抛出异常对象
   //			throw new RuntimeException("您输入的数据非法！");
   //			throw new Exception("您输入的数据非法！");
   			throw new MyException("不能输入负数");
   			//错误的
   //			throw new String("不能输入负数");
   		}
   		
   	}
   
   	@Override
   	public String toString() {
   		return "Student [id=" + id + "]";
   	}
   	
   	
   }
   ```

2. 面试题

   throw 和  throws区别：

   > throw 表示抛出一个异常类的对象，生成异常对象的过程。声明在方法体内。
   > throws 属于异常处理的一种方式，声明在方法的声明处。

3. 如何自定义一个异常类

   ```java
   /*
    * 如何自定义异常类？
    * 1. 继承于现有的异常结构：RuntimeException 、Exception
    * 2. 提供全局常量：serialVersionUID
    * 3. 提供重载的构造器
    * 
    */
   public class MyException extends Exception{
   	
   	static final long serialVersionUID = -7034897193246939L;
   	
   	public MyException(){
   		
   	}
   	
   	public MyException(String msg){
   		super(msg);
   	}
   }
   ```

## 异常练习题

问题描述

编写应用程序EcmDef.java，接收命令行的两个参数，要求不能输入负数，计算两数相除。
	对数据类型不一致(NumberFormatException)、缺少命令行参数(ArrayIndexOutOfBoundsException、
  	除0(ArithmeticException)及输入负数(EcDef 自定义的异常)进行异常处理。

提示： 
	(1)在主类(EcmDef)中定义异常方法(ecm)完成两数相除功能。
	(2)在main()方法中使用异常处理语句进行异常处理。
	(3)在程序中，自定义对应输入负数的异常类(EcDef)。
	(4)运行时接受参数 java EcmDef 20 10   //args[0]=“20” args[1]=“10”
	(5)Interger类的static方法parseInt(String s)将s转换成对应的int值。
        如：int a=Interger.parseInt(“314”);	//a=314;



EcDef.java

```java
//自定义异常类
public class EcDef extends Exception{
    static finall long serialVersionUID = -3387529948L;
    public EcDef(){
        
    }
    public EcDef(String msg){
        super(msg);
    }
}
```

EcmDef.java

```java
public class EcmDef{
    public static void main(String[] args){
        try{
            int i =Integer.parseInt(args[0]);
            int j =Integer.parseInt(args[1]);
            
            int result=ecm(i,j);
            System.out.println(result);
        }catch(NumberFormatException e){
            System.out.println("数据类型不一致");
        }catch(ArrayIndexOutOfBoundsException e){
            System.out.println("缺少命令行参数");
        }catch(ArithmeticException e){
            System.out.println("除0");
        }catch(EcDef e){
            System.out,println(e.getMessage());
        }
    }
    
    
    
    public static int ecm(int i, int j) throws EcDef{
        if(i<0||j<0){
            throw new EcDef("分子或分母为负数了！");
        }
        return i/j;
    }
}
```



# 八、多线程

## 程序、进程、线程的理解

1. 程序(program)

   概念：是为完成特定任务、用某种语言编写的一组指令的集合。即指一段静态代码。

2. 进程(process)

   概念：程序的一次执行过程，或正在运行的一个程序。

   说明：进程作为资源分配的单位，系统在运行时会为每个进程分配不同的内存区域。

3. 线程(thread)

   概念：进程可进一步细化为线程，是一个程序内部的一条执行路径。

   说明：线程作为调度和执行的单位，每个线程拥有独立的运行栈和程序计数器（pc）,线程切换开销小。

   <a href="https://sm.ms/image/c8nIb2GEa4YomKB" target="_blank"><img src="https://i.loli.net/2021/05/03/c8nIb2GEa4YomKB.png" ></a>

4. 补充 内存结构:

   <a href="https://sm.ms/image/wzSfyDIRVvkFGWN" target="_blank"><img src="https://i.loli.net/2021/05/03/wzSfyDIRVvkFGWN.png" ></a>

   

   进程可以细化为多个线程。

   每个线程，拥有自己独立的：栈、程序计数器

   多个线程，共享同一个进程的结构：方法区、堆。

## 并行与并发

1. 单核CPU与多核CPU的理解
   * 单核CPU，其实是一种假的多线程，因为在一个时间单元内，也只能执行一个线程的任务。例如：虽然有多车道，但是收费站只有一个工作人员在收费，只有收了费才能通过，那么CPU就好比收费人员。如果某个人不想交钱，那么收费人员可以把他“挂起”（晾着他，等他想通了，准备好了钱，再去收费。）但是因为CPU时间单元特别短，因此感觉不出来。
   * 如果是多核的话，才能更好的发挥多线程的效率。(现在的服务器都是多核的)
   * 一个java应用程序java.exe，其实至少三个线程：main()主线程，gc()垃圾回收线程，异常处理线程。当然如果发生异常，会影响主线程。
2. 并行与并发的理解
   * 并行：多个CPU同时执行多个任务。比如：多个人同时做不同的事。
   * 并发：一个CPU(采用时间片)同时执行多个任务。比如：秒杀、多个人做同一件事。

## 创建多线程的两种方式

1. 方式一：继承Thread类的方式：

   1. 创建一个继承于Thread类的子类
   2. 重写Thread类的run()  -->将此线程执行的操作声明在run()中
   3. 创建Thread类的子类对象
   4. 通过此对象调用start():  ①启动当前线程 ② 调用当前线程的run()

   ```java 
   // 例子：遍历100以内的所有偶数
   
   //1. 创建一个继承于Thread类的子类
   class MyThread extends Thread {
       //2. 重写Thread类的run()
       @Override
       public void run() {
           for (int i = 0; i < 100; i++) {
               if(i % 2 == 0){
                   System.out.println(Thread.currentThread().getName() + ":" + i);
               }
           }
       }
   }
   
   
   public class ThreadTest {
       public static void main(String[] args) {
           //3. 创建Thread类的子类的对象
           MyThread t1 = new MyThread();
   
           //4.通过此对象调用start():①启动当前线程 ② 调用当前线程的run()
           t1.start();
           //问题一：我们不能通过直接调用run()的方式启动线程。
   //        t1.run();
   
           //问题二：再启动一个线程，遍历100以内的偶数。不可以还让已经start()的线程去执行。会报IllegalThreadStateException
   //        t1.start();
           //我们需要重新创建一个线程的对象
           MyThread t2 = new MyThread();
           t2.start();
   
   
           //如下操作仍然是在main线程中执行的。
           for (int i = 0; i < 100; i++) {
               if(i % 2 == 0){
                   System.out.println(Thread.currentThread().getName() + ":" + i + "***********main()************");
               }
           }
       }
   
   }
   
   ```

   **说明两个问题：**

   问题一：我们启动一个线程，必须调用start(),不能调用run()的方式启动线程。

   问题二：如果在启动一个线程，必须重新创建一个新的Thread子类的对象，调用此对象的start().

2. 方式二：实现Runnable接口的方式：

   1. 创建一个实现了Runnable接口的类

   2. 实现类去实现Runnable中的抽象方法：run()

   3. 创建实现类的对象

   4. 将次对象作为参数传递到Thread类的构造器中，创建Thread类的对象

   5. 通过Thread类的对象调用start()

      ```java
      //1. 创建一个实现了Runnable接口的类
      class MThread implements Runnable{
      
          //2. 实现类去实现Runnable中的抽象方法：run()
          @Override
          public void run() {
              for (int i = 0; i < 100; i++) {
                  if(i % 2 == 0){
                      System.out.println(Thread.currentThread().getName() + ":" + i);
                  }
      
              }
          }
      }
      
      
      public class ThreadTest1 {
          public static void main(String[] args) {
              //3. 创建实现类的对象
              MThread mThread = new MThread();
              //4. 将此对象作为参数传递到Thread类的构造器中，创建Thread类的对象
              Thread t1 = new Thread(mThread);
              t1.setName("线程1");
              //5. 通过Thread类的对象调用start():① 启动线程 ②调用当前线程的run()-->调用了Runnable类型的target的run()
              t1.start();
      
              //再启动一个线程，遍历100以内的偶数
              Thread t2 = new Thread(mThread);
              t2.setName("线程2");
              t2.start();
          }
      
      }
      ```

3. 两种方式的对比

   开发中：优先选择：实现Runnable接口的方式

   原因：     实现的方式没类的单继承的局限性

   ​                 实现的方式更适合来处理多个线程共享数据的情况。

   联系：public class Thread implements  Runnable

   相同点：两种方式都需要重写run(),将线程要执行的逻辑声明在run()中。

   ​				目前两种方式，要想启动线程，都是调用的Thread类中的start()。

4. 例题

   Thread

   ```java 
   /**
    * 练习：创建两个分线程，其中一个线程遍历100以内的偶数，另一个线程遍历100以内的奇数
    */
   public class ThreadDemo {
       public static void main(String[] args) {
   //        MyThread1 m1 = new MyThread1();
   //        MyThread2 m2 = new MyThread2();
   //
   //        m1.start();
   //        m2.start();
   
           //创建Thread类的匿名子类的方式
           new Thread(){
               @Override
               public void run() {
                   for (int i = 0; i < 100; i++) {
                       if(i % 2 == 0){
                           System.out.println(Thread.currentThread().getName() + ":" + i);
   
                       }
                   }
               }
           }.start();
   
   
           new Thread(){
               @Override
               public void run() {
                   for (int i = 0; i < 100; i++) {
                       if(i % 2 != 0){
                           System.out.println(Thread.currentThread().getName() + ":" + i);
   
                       }
                   }
               }
           }.start();
   
       }
   }
   
   class MyThread1 extends Thread{
       @Override
       public void run() {
           for (int i = 0; i < 100; i++) {
               if(i % 2 == 0){
                   System.out.println(Thread.currentThread().getName() + ":" + i);
   
               }
           }
   
       }
   }
   
   
   class MyThread2 extends Thread{
       @Override
       public void run() {
           for (int i = 0; i < 100; i++) {
               if(i % 2 != 0){
                   System.out.println(Thread.currentThread().getName() + ":" + i);
   
               }
           }
   
       }
   }
   
   ```

   

## Thread 类中的常用方法

1.  常用方法

   * start():启动当前线程；调用当前线程的run()
   * run():通过需要重写Thread类中的此方法，将创建的线程要执行的操作声明在此方法中
   * currentThread():静态方法，返回执行当前代码的线程
   * getName():获取当前线程的名字
   * setName():设置当前线程的名字
   * yield():释放当前cpu的执行权
   * join():在线程a中调用线程b的join(),此时线程a就进入阻塞状态，直到线程b完全执行完以后才结束阻塞状态。
   * stop():已过时。当执行此方法时，强制性结束当前线程。
   * sleep(long millitime):让当前线程“睡眠”指定的millitime毫秒。毫秒。在指定的millitime毫秒时间内，当前线程是阻塞状态。
   * isAlive():判断当前线程是否存活

2. 线程的优先级：

  * > MAX_PRIORITY:10
  >
    > MIN_PRIORITY:1
    >
    > NORM_PRIORITY:5   ---> 默认优先级
  
  * 如何获取和设置当前线程的优先级
  
    getPriority():获取线程的优先级
  
    setPriority(int p):设置线程的优先级
  
    ==说明== 高优先级的线程要抢占低优先级线程cpu的执行权。但是只是从概率上讲，高优先级的线程高概率的情况下被执行。并不意味着只当高优先级的线程执行完以后，低优先级的线程才执行。
  
    ```java 
    class HelloThread extends Thread{
        @Override
        public void run() {
            for (int i = 0; i < 100; i++) {
                if(i % 2 == 0){
    
    //                try {
    //                    sleep(10);
    //                } catch (InterruptedException e) {
    //                    e.printStackTrace();
    //                }
    
                    System.out.println(Thread.currentThread().getName() + ":" + Thread.currentThread().getPriority() + ":" + i);
                }
    
    //            if(i % 20 == 0){
    //                yield();
    //            }
    
            }
    
        }
    
        public HelloThread(String name){
            super(name);
        }
    }
    
    
    public class ThreadMethodTest {
        public static void main(String[] args) {
    
            HelloThread h1 = new HelloThread("Thread：1");
    
    //        h1.setName("线程一");
            //设置分线程的优先级
            h1.setPriority(Thread.MAX_PRIORITY);
    
            h1.start();
    
            //给主线程命名
            Thread.currentThread().setName("主线程");
            Thread.currentThread().setPriority(Thread.MIN_PRIORITY);
    
            for (int i = 0; i < 100; i++) {
                if(i % 2 == 0){
                    System.out.println(Thread.currentThread().getName() + ":" + Thread.currentThread().getPriority() + ":" + i);
                }
    
    //            if(i == 20){
    //                try {
    //                    h1.join();
    //                } catch (InterruptedException e) {
    //                    e.printStackTrace();
    //                }
    //            }
    
            }
    
    //        System.out.println(h1.isAlive());
    
        }
    }
    ```
  
  补充：线程的分类
  
  一种是守护线程，一种是用户线程。



## 线程的生命周期



<a href="https://sm.ms/image/AjatOWxqNk7uM5R" target="_blank"><img src="https://i.loli.net/2021/05/05/AjatOWxqNk7uM5R.png" ></a>

 ==说明== ：

1. 生命周期关注两个概念：状态、相应的方法

2. 关注：状态a--->状态b:哪些方法执行了（回调方法）

   ​        某个方法主动调用：状态a--->状态b

3. 阻塞：临时状态，不可以作为最终转态

   死亡：最终状态。

## 线程的同步机制

买票线程不安全的情况

```java 
/**
 *
 * 例子：创建三个窗口卖票，总票数为100张.使用继承Thread类的方式
 *
 * 存在线程的安全问题，待解决。
 */
class Window extends Thread{


    private static int ticket = 100;
    @Override
    public void run() {

        while(true){

            if(ticket > 0){
                System.out.println(getName() + "：卖票，票号为：" + ticket);
                ticket--;
            }else{
                break;
            }

        }

    }
}


public class WindowTest {
    public static void main(String[] args) {
        Window t1 = new Window();
        Window t2 = new Window();
        Window t3 = new Window();


        t1.setName("窗口1");
        t2.setName("窗口2");
        t3.setName("窗口3");

        t1.start();
        t2.start();
        t3.start();

    }
}
```

```java 
/**
 * 例子：创建三个窗口卖票，总票数为100张.使用实现Runnable接口的方式
 * 存在线程的安全问题，待解决。
 *
 * @author shkstart
 * @create 2019-02-13 下午 4:47
 */
class Window1 implements Runnable{

    private int ticket = 100;

    @Override
    public void run() {
        while(true){
            if(ticket > 0){
                System.out.println(Thread.currentThread().getName() + ":卖票，票号为：" + ticket);
                ticket--;
            }else{
                break;
            }
        }
    }
}


public class WindowTest1 {
    public static void main(String[] args) {
        Window1 w = new Window1();

        Thread t1 = new Thread(w);
        Thread t2 = new Thread(w);
        Thread t3 = new Thread(w);

        t1.setName("窗口1");
        t2.setName("窗口2");
        t3.setName("窗口3");

        t1.start();
        t2.start();
        t3.start();
    }

}
```



1. 背景

   > 例子：创建个窗口卖票，总票数为100张.使用实现Runnable接口的方式
   > 1.问题：卖票过程中，出现了重票、错票 -->出现了线程的安全问题
   >
   > 2.问题出现的原因：当某个线程操作车票的过程中，尚未操作完成时，其他线程参与进来，也操作车票。
   >
   > 3.如何解决：当一个线程a在操作ticket的时候，其他线程不能参与进来。直到线程a操作完ticket时，其他线程才可以开始操作ticket。这种情况即使线程a出现了阻塞，也不能被改变。

2. Java解决方案：同步机制

   在Java中，我们通过同步机制，来解决线程的安全问题

### 方法一：同步代码块

synchronize（同步监视器）{

//需要被同步的代码

}

说明：

> * 操作共享数据的代码，即为需要被同步的代码。---> 不能包含代码多了，也不能包含代码少了
>
> * 共享数据：多个线程共同操作的变量。比如：ticket就是共享数据
>
> * 同步监视器，俗称：锁。任何一个类的对象，都可以充当锁。
>
>    要求：多个线程必须要共用同一把锁。

补充：在现实Runnable接口创建多线程的方式中，我们可以考虑使用this充当同步监视器。

​			在继承Thread类创建多线程的方式中，慎用this充当同步监视器，考虑使用当前类充当同步监视器。

使用同步代码块解决继承Thread类的方式的线程安全问题

```java
class Window2 extends Thread{


    private static int ticket = 100;

    private static Object obj = new Object();

    @Override
    public void run() {

        while(true){
            //正确的
//            synchronized (obj){
            synchronized (Window2.class){//Class clazz = Window2.class,Window2.class只会加载一次
                //错误的方式：this代表着t1,t2,t3三个对象
//              synchronized (this){

                if(ticket > 0){

                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    System.out.println(getName() + "：卖票，票号为：" + ticket);
                    ticket--;
                }else{
                    break;
                }
            }

        }

    }
}


public class WindowTest2 {
    public static void main(String[] args) {
        Window2 t1 = new Window2();
        Window2 t2 = new Window2();
        Window2 t3 = new Window2();


        t1.setName("窗口1");
        t2.setName("窗口2");
        t3.setName("窗口3");

        t1.start();
        t2.start();
        t3.start();

    }
}
```

使用同步代码块解决使用实现Runnable接口的方式的线程安全问题

```java 
class Window1 implements Runnable{

    private int ticket = 100;
//    Object obj = new Object();
//    Dog dog = new Dog();
    @Override
    public void run() {
//        Object obj = new Object();
        while(true){
            synchronized (this){//此时的this:唯一的Window1的对象   //方式二：synchronized (dog) {

                if (ticket > 0) {

                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    System.out.println(Thread.currentThread().getName() + ":卖票，票号为：" + ticket);


                    ticket--;
                } else {
                    break;
                }
            }
        }
    }
}


public class WindowTest1 {
    public static void main(String[] args) {
        Window1 w = new Window1();

        Thread t1 = new Thread(w);
        Thread t2 = new Thread(w);
        Thread t3 = new Thread(w);

        t1.setName("窗口1");
        t2.setName("窗口2");
        t3.setName("窗口3");

        t1.start();
        t2.start();
        t3.start();
    }

}


class Dog{

}
```

### 方式二：同步方法

如果操作共享数据的代码完整的声明在一个方法中，我们不妨将此方法声明为同步的。

同步方法的总结：

1. 同步方法任然涉及到同步监视器，只是不需要我们显示的声明。

2. 非静态的同步方法，同步监视器是：this

   静态的同步方法，同步监视器是：当前类本身

使用同步方法解决实现Runnable接口的线程安全问题

```java 
class Window3 implements Runnable {

    private int ticket = 100;

    @Override
    public void run() {
        while (true) {

            show();
        }
    }

    private synchronized void show(){//同步监视器：this
        //synchronized (this){

            if (ticket > 0) {

                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                System.out.println(Thread.currentThread().getName() + ":卖票，票号为：" + ticket);

                ticket--;
            }
        //}
    }
}


public class WindowTest3 {
    public static void main(String[] args) {
        Window3 w = new Window3();

        Thread t1 = new Thread(w);
        Thread t2 = new Thread(w);
        Thread t3 = new Thread(w);

        t1.setName("窗口1");
        t2.setName("窗口2");
        t3.setName("窗口3");

        t1.start();
        t2.start();
        t3.start();
    }

}
```

使用同步方法处理继承Thread类的方式中的线程安全问题

```java
class Window4 extends Thread {


    private static int ticket = 100;

    @Override
    public void run() {

        while (true) {

            show();
        }

    }
    private static synchronized void show(){//同步监视器：Window4.class
        //private synchronized void show(){ //同步监视器：t1,t2,t3。此种解决方式是错误的
        if (ticket > 0) {

            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println(Thread.currentThread().getName() + "：卖票，票号为：" + ticket);
            ticket--;
        }
    }
}


public class WindowTest4 {
    public static void main(String[] args) {
        Window4 t1 = new Window4();
        Window4 t2 = new Window4();
        Window4 t3 = new Window4();


        t1.setName("窗口1");
        t2.setName("窗口2");
        t3.setName("窗口3");

        t1.start();
        t2.start();
        t3.start();

    }
}
```

### 方式三：Lock锁 ------JDK5.0新增

1. 面试题：synchronized与Lock的异同？

   相同：二者都可以解决线程安全问题

   不同：synchronized机制在执行完相应的同步代码以后，自动的释放同步监视器

   ​			Lock需手动的启动同步（lock()），同时结束同步也需要的=手动的实现（unlock()）

2. 优先使用顺序：

   Lock ---> 同步代码块（已经进入了方法体，分配了相应资源 ) --->同步方法（在方法体之外)

3. 利弊

   利 ：同步的方式，解决了线程的安全问题。

   弊：操作同步代码时，只能一个线程参与，其他线程等待。相当于是一个单线程的过程，效率低。

   ```java
   class Window implements Runnable{
   
       private int ticket = 100;
       //1.实例化reentrantlock
       private ReentrantLock lock = new ReentrantLock();
   
       @Override
       public void run() {
           while(true){
               try{
   
                   //2.调用锁定方法lock()
                   lock.lock();
   
                   if(ticket > 0){
   
                       try {
                           Thread.sleep(100);
                       } catch (InterruptedException e) {
                           e.printStackTrace();
                       }
   
                       System.out.println(Thread.currentThread().getName() + "：售票，票号为：" + ticket);
                       ticket--;
                   }else{
                       break;
                   }
               }finally {
                   //3.调用解锁方法：unlock()
                   lock.unlock();
               }
   
           }
       }
   }
   
   public class LockTest {
       public static void main(String[] args) {
           Window w = new Window();
   
           Thread t1 = new Thread(w);
           Thread t2 = new Thread(w);
           Thread t3 = new Thread(w);
   
           t1.setName("窗口1");
           t2.setName("窗口2");
           t3.setName("窗口3");
   
           t1.start();
           t2.start();
           t3.start();
       }
   }
   ```



#### 线程安全的单例模式（懒汉式）

使用同步机制将单例模式中的懒汉式改写为线程安全的。

```java
public class BankTest {

}

class Bank{

    private Bank(){}

    private static Bank instance = null;

    public static Bank getInstance(){
        //方式一：效率稍差
//        synchronized (Bank.class) {
//            if(instance == null){
//
//                instance = new Bank();
//            }
//            return instance;
//        }
        //方式二：效率更高
        if(instance == null){

            synchronized (Bank.class) {
                if(instance == null){

                    instance = new Bank();
                }

            }
        }
        return instance;
    }

}
```

面试题：写一个线程安全的单例模式。
饿汉式。
懒汉式：上面提供的。



## 死锁问题

1. 死锁的理解：

   不同的线程分别占用对方需要的同步资源不放弃，都在等待对方放弃自己需要的同步资源，就形成了死锁。

2. 说明：

   1. 出现死锁后，不会出现异常，不会出现提示，只是所的线程都处于阻塞状态，无法继续
   2. 我们使用同步时，要避免出现死锁。

   举例

   ```java 
   public class ThreadTest {
   
       public static void main(String[] args) {
   
           StringBuffer s1 = new StringBuffer();
           StringBuffer s2 = new StringBuffer();
   
   
           new Thread(){
               @Override
               public void run() {
   
                   synchronized (s1){
   
                       s1.append("a");
                       s2.append("1");
   
                       try {
                           Thread.sleep(100);
                       } catch (InterruptedException e) {
                           e.printStackTrace();
                       }
   
   
                       synchronized (s2){
                           s1.append("b");
                           s2.append("2");
   
                           System.out.println(s1);
                           System.out.println(s2);
                       }
   
   
                   }
   
               }
           }.start();
   
   
           new Thread(new Runnable() {
               @Override
               public void run() {
                   synchronized (s2){
   
                       s1.append("c");
                       s2.append("3");
   
                       try {
                           Thread.sleep(100);
                       } catch (InterruptedException e) {
                           e.printStackTrace();
                       }
   
                       synchronized (s1){
                           s1.append("d");
                           s2.append("4");
   
                           System.out.println(s1);
                           System.out.println(s2);
                       }
   
   
                   }
   
   
   
               }
           }).start();
   
   
       }
   
   
   }
   ```



```java 
class A {
	public synchronized void foo(B b) { //同步监视器：A类的对象：a
		System.out.println("当前线程名: " + Thread.currentThread().getName()
				+ " 进入了A实例的foo方法"); // ①
		try {
			Thread.sleep(200);
		} catch (InterruptedException ex) {
			ex.printStackTrace();
		}
		System.out.println("当前线程名: " + Thread.currentThread().getName()
				+ " 企图调用B实例的last方法"); // ③
		b.last();
	}

	public synchronized void last() {//同步监视器：A类的对象：a
		System.out.println("进入了A类的last方法内部");
	}
}

class B {
	public synchronized void bar(A a) {//同步监视器：b
		System.out.println("当前线程名: " + Thread.currentThread().getName()
				+ " 进入了B实例的bar方法"); // ②
		try {
			Thread.sleep(200);
		} catch (InterruptedException ex) {
			ex.printStackTrace();
		}
		System.out.println("当前线程名: " + Thread.currentThread().getName()
				+ " 企图调用A实例的last方法"); // ④
		a.last();
	}

	public synchronized void last() {//同步监视器：b
		System.out.println("进入了B类的last方法内部");
	}
}

public class DeadLock implements Runnable {
	A a = new A();
	B b = new B();

	public void init() {
		Thread.currentThread().setName("主线程");
		// 调用a对象的foo方法
		a.foo(b);
		System.out.println("进入了主线程之后");
	}

	public void run() {
		Thread.currentThread().setName("副线程");
		// 调用b对象的bar方法
		b.bar(a);
		System.out.println("进入了副线程之后");
	}

	public static void main(String[] args) {
		DeadLock dl = new DeadLock();
		new Thread(dl).start();


		dl.init();
	}
}
```





## 线程通信

1. 线程通信涉及到的三个方法：

   wait():一旦执行此方法，当前线程就进入阻塞状态，并释放同步监视器。

   notify():一旦执行此方法，就会唤醒被wait的一个线程。如果有多个线程被wait，就唤醒优先级高的那个。

   notifyAll(): 一旦执行此方法，就会唤醒所有被wait的线程。

2. 说明

   1. wait(),notify(),notifyAll()三个方法必须使用在同步代码块或同步方法中。
   2. wait(),notify(),notifyAll()三个方法的调用者必须是同步代码块或同步方法中的同步监视器。
   3. wait(),notify(),notifyAll()三个方法是定义在java.lang.Object类中。

3. 面试题：sleep()和wait()的异同？

   1. 相同点：一旦执行方法，都可以使得当前的线程进入阻塞状态。

   2. 不同点：

      > * 两个方法声明的位置不同：Thread类中声明sleep(),Object类中声明wait()
      > * 调用的要求不同：sleep()可以再任何需要的的场景下调用。wait()必须使用在同步代码块或同步方法中
      > * 关于是否释放同步监视器：如果两个方法都使用在同步代码块或同步方法中sleep()不会释放锁，wait()会释放锁。

线程通信举例：使用两个线程打印1-100。线程1，线程2 交替打印

```java
//线程通信的例子：使用两个线程打印 1-100。线程1, 线程2 交替打印

class Number implements Runnable{
    private int number = 1;
    private Object obj = new Object();
    @Override
    public void run() {

        while(true){

            synchronized (obj) {  //this、Number.class

                obj.notify();

                if(number <= 100){

                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    System.out.println(Thread.currentThread().getName() + ":" + number);
                    number++;

                    try {
                        //使得调用如下wait()方法的线程进入阻塞状态
                        obj.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }else{
                    break;
                }
            }

        }

    }
}


public class CommunicationTest {
    public static void main(String[] args) {
        Number number = new Number();
        Thread t1 = new Thread(number);
        Thread t2 = new Thread(number);

        t1.setName("线程1");
        t2.setName("线程2");

        t1.start();
        t2.start();
    }
}
```



线程通信的经典例题：生产者/消费者问题

> ```
> * 生产者(Productor)将产品交给店员(Clerk)，而消费者(Customer)从店员处取走产品，
> * 店员一次只能持有固定数量的产品(比如:20），如果生产者试图生产更多的产品，店员
> * 会叫生产者停一下，如果店中有空位放产品了再通知生产者继续生产；如果店中没有产品
> * 了，店员会告诉消费者等一下，如果店中有产品了再通知消费者来取走产品。
> ```

分析

> ```
> * 1. 是否是多线程问题？是，生产者线程，消费者线程
> * 2. 是否有共享数据？是，店员（或产品）
> * 3. 如何解决线程的安全问题？同步机制,有三种方法
> * 4. 是否涉及线程的通信？是
> ```

```java 
class Clerk{

    private int productCount = 0;
    //生产产品
    public synchronized void produceProduct() {

        if(productCount < 20){
            productCount++;
            System.out.println(Thread.currentThread().getName() + ":开始生产第" + productCount + "个产品");

            notify();

        }else{
            //等待
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
    //消费产品
    public synchronized void consumeProduct() {
        if(productCount > 0){
            System.out.println(Thread.currentThread().getName() + ":开始消费第" + productCount + "个产品");
            productCount--;

            notify();
        }else{
            //等待
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}

class Producer extends Thread{//生产者

    private Clerk clerk;

    public Producer(Clerk clerk) {
        this.clerk = clerk;
    }

    @Override
    public void run() {
        System.out.println(getName() + ":开始生产产品.....");

        while(true){

            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            clerk.produceProduct();
        }

    }
}

class Consumer extends Thread{//消费者
    private Clerk clerk;

    public Consumer(Clerk clerk) {
        this.clerk = clerk;
    }

    @Override
    public void run() {
        System.out.println(getName() + ":开始消费产品.....");

        while(true){

            try {
                Thread.sleep(20);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            clerk.consumeProduct();
        }
    }
}

public class ProductTest {

    public static void main(String[] args) {
        Clerk clerk = new Clerk();

        Producer p1 = new Producer(clerk);
        p1.setName("生产者1");

        Consumer c1 = new Consumer(clerk);
        c1.setName("消费者1");
        Consumer c2 = new Consumer(clerk);
        c2.setName("消费者2");

        p1.start();
        c1.start();
        c2.start();

    }
}
```

4. 小结释放锁的操作：

   <a href="https://sm.ms/image/fmR3tITxb4JE9zq" target="_blank"><img src="https://i.loli.net/2021/05/07/fmR3tITxb4JE9zq.png" ></a>

小结不会释放锁的操作：

<a href="https://sm.ms/image/jb1GAFrsoXgQic4" target="_blank"><img src="https://i.loli.net/2021/05/07/jb1GAFrsoXgQic4.png" ></a>



## JDK5.0新增两种线程创建的方式



### 创建线程的方式三：实现Callable接口。

如何理解实现Callable接口的方式创建多线程比实现Runnable接口创建多线程方式强大？

> call()可以有返回值的。
>
> call()可以抛出异常，被外面的操作捕获，获取异常的信息
>
> Callable是支持泛型的

 

```java
//1.创建一个实现Callable的实现类
class NumThread implements Callable{
    //2.实现call方法，将此线程需要执行的操作声明在call()中
    @Override
    public Object call() throws Exception {
        int sum = 0;
        for (int i = 1; i <= 100; i++) {
            if(i % 2 == 0){
                System.out.println(i);
                sum += i;
            }
        }
        return sum;
    }
}


public class ThreadNew {
    public static void main(String[] args) {
        //3.创建Callable接口实现类的对象
        NumThread numThread = new NumThread();
        //4.将此Callable接口实现类的对象作为传递到FutureTask构造器中，创建FutureTask的对象
        FutureTask futureTask = new FutureTask(numThread);
        //5.将FutureTask的对象作为参数传递到Thread类的构造器中，创建Thread对象，并调用start()
        new Thread(futureTask).start();

        try {
            //6.获取Callable中call方法的返回值
            //get()返回值即为FutureTask构造器参数Callable实现类重写的call()的返回值。
            Object sum = futureTask.get();
            System.out.println("总和为：" + sum);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }

}
```



### 创建线程的方式四： 使用线程池

好处：

1. 提高相应速度（减少了创建新线程的时间）

2. 降低资源消耗（重复利用线程池中线程，不需要每次都创建）

3. 便于线程管理

   ​	corePoolSize:核心池的大小

   ​	maximumPoolSize:最大线程数

   ​	keepAliveTime：线程没有任务时最多保持多长时间后会终止



```java
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;



class NumberThread implements Runnable{

    @Override
    public void run() {
        for(int i = 0;i <= 100;i++){
            if(i % 2 == 0){
                System.out.println(Thread.currentThread().getName() + ": " + i);
            }
        }
    }
}

class NumberThread1 implements Runnable{

    @Override
    public void run() {
        for(int i = 0;i <= 100;i++){
            if(i % 2 != 0){
                System.out.println(Thread.currentThread().getName() + ": " + i);
            }
        }
    }
}

public class ThreadPool {

    public static void main(String[] args) {
        //1. 提供指定线程数量的线程池
        ExecutorService service = Executors.newFixedThreadPool(10);
        ThreadPoolExecutor service1 = (ThreadPoolExecutor) service;
        //设置线程池的属性
//        System.out.println(service.getClass());
//        service1.setCorePoolSize(15);
//        service1.setKeepAliveTime();


        //2.执行指定的线程的操作。需要提供实现Runnable接口或Callable接口实现类的对象
        service.execute(new NumberThread());//适合适用于Runnable
        service.execute(new NumberThread1());//适合适用于Runnable

//        service.submit(Callable callable);//适合使用于Callable
        //3.关闭连接池
        service.shutdown();
    }

}

```

面试题：Java中多线程的创建有几种方式？ 四种。





# 九、Java常用类

## String 类

java.lang.String类的使用

1. 概述

   String:字符串，使用一对""引起来表示。

   * String声明为final的，不可被继承

   * String实现了Serializable接口：表示字符串是支持序列化的。

     实现了Comparable接口：表示String可以比较大小

   * String内部定义了final   char[] value用于存储字符串数据

   * 通过字面量的方式（区别于new给一个字符串赋值此时的字符串值声明在字符串常量池中）。

   * 字符串常量池中是不会存储相同内容（使用String类的equals()比较，返回true）的字符串的。

2. String的不可变性

   2.1 说明

  * 当对字符串重新赋值时，需要重写指定内存区域赋值，不能使用原来的value进行赋值.
  * 当对现有的字符串进行连接操作时，也需要重新指定内存区域赋值，不能使用原有的value进行赋值
  * 当调用String的replace()方法修改指定字符或字符串时，也需要重新指定内存区域赋值，不能使用原有的value进行赋值。

  ```java
   @Test
      public  void test1(){
          String s1 = "abc";//字面量的定义方式
          String s2 = "abc";
          s1 = "hello";
  
          System.out.println(s1 == s2);//比较s1和s2的地址值
  
          System.out.println(s1);//hello
          System.out.println(s2);//abc
  
          System.out.println("*****************");
  
          String s3 = "abc";
          s3 += "def";
          System.out.println(s3);//abcdef
          System.out.println(s2);
  
          System.out.println("*****************");
  
          String s4 = "abc";
          String s5 = s4.replace("ab", "m");
          String s6 = s4.replace("a", "d");
          System.out.println(s4);//abc
          System.out.println(s5);//mbc
          System.out.println(s6);//dbc
  
      }
  ```

  图示

  <a href="https://sm.ms/image/uIpAsik7SFwy2hQ" target="_blank"><img src="https://i.loli.net/2021/05/08/uIpAsik7SFwy2hQ.png" ></a>



### String实例化的不同方式

1. 方式说明

   * 通过字面量定义的方式
   * 通过new+构造器的方式

   ```java
    @Test
       public void test2(){
           //通过字面量定义的方式：此时的s1和s2的数据javaEE声明在方法区中的字符串常量池中。
           String s1 = "javaEE";
           String s2 = "javaEE";
           //通过new + 构造器的方式:此时的s3和s4保存的地址值，是数据在堆空间中开辟空间以后对应的地址值。
           String s3 = new String("javaEE");
           String s4 = new String("javaEE");
   
           System.out.println(s1 == s2);//true
           System.out.println(s1 == s3);//false
           System.out.println(s1 == s4);//false
           System.out.println(s3 == s4);//false
   
           System.out.println("***********************");
           System.out.println(s1.equals(s3));//true
           Person p1 = new Person("Tom",12);
           Person p2 = new Person("Tom",12);
   
           System.out.println(p1.name.equals(p2.name));//true
           System.out.println(p1.name == p2.name);//true
   
           p1.name = "Jerry";
           System.out.println(p2.name);//Tom
       }
   ```

2. 面试题 

   String s=new String("abc");方式创建对象，在内存中创建了几个对象？

   ​	两个：一个是堆空间中new结构，另一个是char[]对应的常量池中的数据："abc"

   <a href="https://sm.ms/image/LTDXn8bozphO2we" target="_blank"><img src="https://i.loli.net/2021/05/08/LTDXn8bozphO2we.png" ></a>

   

### 字符串拼接方式赋值的对比

1. 说明

   * 常量与常量的拼接结果在常量池。且常量池中不会存在相同内容的常量。
   * 只要其中一个是变量，结果就在堆中
   * 如果拼接的结果调用intern()方法，返回值就在常量池中

   ```java
   @Test
       public void test3(){
           String s1 = "javaEE";
           String s2 = "hadoop";
   
           String s3 = "javaEEhadoop";
           String s4 = "javaEE" + "hadoop";
           String s5 = s1 + "hadoop";
           String s6 = "javaEE" + s2;
           String s7 = s1 + s2;
   
           System.out.println(s3 == s4);//true
           System.out.println(s3 == s5);//false
           System.out.println(s3 == s6);//false
           System.out.println(s3 == s7);//false
           System.out.println(s5 == s6);//false
           System.out.println(s5 == s7);//false
           System.out.println(s6 == s7);//false
   
           String s8 = s6.intern();//返回值得到的s8使用的常量池中已经存在的“javaEEhadoop”
           System.out.println(s3 == s8);//true
   
   
       }
   ```

   ​	

   ```java
   @Test
       public void test4(){
           String s1 = "javaEEhadoop";
           String s2 = "javaEE";
           String s3 = s2 + "hadoop";
           System.out.println(s1 == s3);//false
   
           final String s4 = "javaEE";//s4:常量
           String s5 = s4 + "hadoop";
           System.out.println(s1 == s5);//true
   
       }
   ```

   



### String类常用方法

* int length():返回字符串的长度：return value.length

* char charAt(int index):返回某索引处的字符 return value[index]

* boolean isEmpty():判断是否是空字符串：return value.length == 0

* String toLowerCase():：使用默认语言环境，将 String 中的所字符转换为小写

* String toUpperCase()：使用默认语言环境，将 String 中的所字符转换为大写

* String trim():返回字符串的副本，忽略前导空白和尾部空白

* boolean equals(Object obj)：比较字符串的内容是否相同

* boolean equalsIgnoreCase(String anotherString)：与equals方法类似，忽略大小写

* String concat(String str):：将指定字符串连接到此字符串的结尾。 等价于用“+”

* int compareTo(String anotherString):比较两个字符串的大小

* String substring(int beginIndex):：返回一个新的字符串，它是此字符串的从beginIndex开始截取到最后的一个子字符串。

* String substring(int beginIndex, int endIndex) ：返回一个新字符串，它是此字符串从beginIndex开始截取到endIndex(不包含)的一个子字符串。

  ``` java
  @Test
      public void test1() {
          String s1 = "HelloWorld";
          System.out.println(s1.length());
          System.out.println(s1.charAt(0));
          System.out.println(s1.charAt(9));
  //        System.out.println(s1.charAt(10));
  //        s1 = "";
          System.out.println(s1.isEmpty());
  
          String s2 = s1.toLowerCase();
          System.out.println(s1);//s1不可变的，仍然为原来的字符串
          System.out.println(s2);//改成小写以后的字符串
  
          String s3 = "   he  llo   world   ";
          String s4 = s3.trim();
          System.out.println("-----" + s3 + "-----");
          System.out.println("-----" + s4 + "-----");
      }
  ```

```java
@Test
    public void test2() {
        String s1 = "HelloWorld";
        String s2 = "helloworld";
        System.out.println(s1.equals(s2));
        System.out.println(s1.equalsIgnoreCase(s2));

        String s3 = "abc";
        String s4 = s3.concat("def");
        System.out.println(s4);

        String s5 = "abc";
        String s6 = new String("abe");
        System.out.println(s5.compareTo(s6));//涉及到字符串排序

        String s7 = "北京大峡谷教育";
        String s8 = s7.substring(2);
        System.out.println(s7);
        System.out.println(s8);

        String s9 = s7.substring(2, 5);
        System.out.println(s9);
    }
```



* boolean endsWith(String suffix):测试此字符串是否以指定的后缀结束
* boolean startsWith(String prefix)：测试此字符串是否以指定的前缀开始
* boolean startsWith(String prefix, int toffset)：测试此字符串从指定索引开始的子字符串是否以指定前缀开始
* boolean contains(CharSequence s)：当且仅当此字符串包含指定的 char 值序列时，返回 true
* int indexOf(String str)：返回指定子字符串在此字符串中第一次出现处的索引
* int indexOf(String str, int fromIndex)：返回指定子字符串在此字符串中第一次出现处的索引，从指定的索引开始
* int lastIndexOf(String str)：返回指定子字符串在此字符串中最右边出现处的索引
* int lastIndexOf(String str, int fromIndex)：返回指定子字符串在此字符串中最后一次出现处的索引，从指定的索引开始反向搜索

==注==：indexOf和lastIndexOf方法如果未找到都是返回-1

```java
@Test
    public void test3(){
        String str1 = "hellowworld";
        boolean b1 = str1.endsWith("rld");
        System.out.println(b1);

        boolean b2 = str1.startsWith("He");
        System.out.println(b2);

        boolean b3 = str1.startsWith("ll",2);
        System.out.println(b3);

        String str2 = "wor";
        System.out.println(str1.contains(str2));

        System.out.println(str1.indexOf("lol"));

        System.out.println(str1.indexOf("lo",5));

        String str3 = "hellorworld";

        System.out.println(str3.lastIndexOf("or"));
        System.out.println(str3.lastIndexOf("or",6));

        //什么情况下，indexOf(str)和lastIndexOf(str)返回值相同？
        //情况一：存在唯一的一个str。情况二：不存在str
    }
```



* String replace(char oldChar, char newChar)：返回一个新的字符串，它是通过用 newChar 替换此字符串中出现的所有 oldChar 得到的。
* String replace(CharSequence target, CharSequence replacement)：使用指定的字面值替换序列替换此字符串所匹配字面值目标序列的子字符串。
* String replaceAll(String regex, String replacement)：使用给定的 replacement 替换此字符串所匹配给定的正则表达式的子字符串。
* String replaceFirst(String regex, String replacement)：使用给定的 replacement 替换此字符串匹配给定的正则表达式的第一个子字符串。

匹配:

* boolean matches(String regex)：告知此字符串是否匹配给定的正则表达式。

切片：

* String[] split(String regex)：根据给定正则表达式的匹配拆分此字符串。
* String[] split(String regex, int limit)：根据匹配给定的正则表达式来拆分此字符串，最多不超过limit个，如果超过了，剩下的全部都放到最后一个元素中。

```java
@Test
    public void test4(){
        String str1 = "北京尚硅谷教育北京";
        String str2 = str1.replace('北', '东');

        System.out.println(str1);
        System.out.println(str2);


        String str3 = str1.replace("北京", "上海");
        System.out.println(str3);

        System.out.println("*************************");
        String str = "12hello34world5java7891mysql456";
        //把字符串中的数字替换成,，如果结果中开头和结尾有，的话去掉
        String string = str.replaceAll("\\d+", ",").replaceAll("^,|,$", "");
        System.out.println(string);

        System.out.println("*************************");
        str = "12345";
        //判断str字符串中是否全部有数字组成，即有1-n个数字组成
        boolean matches = str.matches("\\d+");
        System.out.println(matches);
        String tel = "0571-4534289";
        //判断这是否是一个杭州的固定电话
        boolean result = tel.matches("0571-\\d{7,8}");
        System.out.println(result);


        System.out.println("*************************");
        str = "hello|world|java";
        String[] strs = str.split("\\|");
        for (int i = 0; i < strs.length; i++) {
            System.out.println(strs[i]);
        }
        for (String ch: strs) {
            System.out.println(ch);
        }


        System.out.println();
        str2 = "hello.world.java";
        String[] strs2 = str2.split("\\.");
        for (int i = 0; i < strs2.length; i++) {
            System.out.println(strs2[i]);
        }

    }
```





### String 与其它结构的转换

1. 与基本数据类型、包装类之间的转换

   String---> 基本数据类型、包装类：调用包装类的静态方法：parseXxx(str)

   基本数据类型、包装类---->String:调用String重载的valueOf(xxx)

   ```java
   @Test
       public void test1(){
           String str1 = "123";
   //        int num = (int)str1;//错误的
           int num = Integer.parseInt(str1);
   
           String str2 = String.valueOf(num);//"123"
           String str3 = num + "";
   
           System.out.println(str1 == str3);//false
       }
   ```

2. 与字符数组之间的转换

   String--->char[] :调用String 的toCharArray()

   char[]-----> String:调用String的构造器

   ```java
   @Test
       public void test2(){
           String str1 = "abc123";  //题目： a21cb3
   
           char[] charArray = str1.toCharArray();
           for (int i = 0; i < charArray.length; i++) {
               System.out.println(charArray[i]);
           }
   
           char[] arr = new char[]{'h','e','l','l','o'};
           String str2 = new String(arr);
           System.out.println(str2);
       }
   ```

3. 与字节数组之间的转换

   编码：String --> byte[]:调用String的getBytes()

   ​			编码：字符串 -->字节  (看得懂 --->看不懂的二进制数据)

   解码：byte[] --> String:调用String的构造器

   ​			解码：编码的逆过程，字节 --> 字符串 （看不懂的二进制数据 ---> 看得懂）

   说明：解码时，要求解码使用的字符集必须与编码时使用的字符集一致，否则会出现乱码。

   ```java
   @Test
       public void test3() throws UnsupportedEncodingException {
           String str1 = "abc123中国";
           byte[] bytes = str1.getBytes();//使用默认的字符集，进行编码。
           System.out.println(Arrays.toString(bytes));
   
           byte[] gbks = str1.getBytes("gbk");//使用gbk字符集进行编码。
           System.out.println(Arrays.toString(gbks));
   
           System.out.println("******************");
   
           String str2 = new String(bytes);//使用默认的字符集，进行解码。
           System.out.println(str2);
   
           String str3 = new String(gbks);
           System.out.println(str3);//出现乱码。原因：编码集和解码集不一致！
   
   
           String str4 = new String(gbks, "gbk");
           System.out.println(str4);//没有出现乱码。原因：编码集和解码集一致！
   
   
       }
   ```

4. 与StringBuffer、StringBuilder之间的转换

   String -->StringBuffer、StringBuilder:调用StringBuffer、StringBuilder构造器

   StringBuffer、StringBuilder -->String:①调用String构造器；②StringBuffer、StringBuilder的toString()

5. JVM中字符串常量池存放位置说明：

   jdk 1.6 (jdk 6.0 ,java 6.0):字符串常量池存储在方法区（永久区）

   jdk 1.7:字符串常量池存储在堆空间

   jdk 1.8:字符串常量池存储在方法区（元空间）

   

   

## StringBuffer、StringBuilder三者的对比

1. String、StringBuffer、StringBuilder三者的对比

   * String:不可变的字符序列；底层使用char[]存储
   * StringBuffer:可变的字符序列；==线程安全的==，效率低；底层使用char[]存储
   * StringBuilder:可变的字符序列；jdk5.0新增的，线程不安全的，效率高；底层使用char[]存储

2. StringBuffer与StringBuilder的内存解析

   以StringBuffer为例：源码分析

   String str = new String();//char[] value = new char[0];

   String str1 = new String("abc");//char[] value = new char[]{'a','b','c'};

   StringBuffer sb1 = new StringBuffer();//char[] value = new char[16];底层创建了一个长度是16的数组。

   System.out.println(sb1.length());//0

   sb1.append('a');//value[0] = 'a';

   sb1.append('b');//value[1] = 'b';

   StringBuffer sb2 = new StringBuffer("abc");//char[] value = new char["abc".length() + 16];

   

   //问题1. System.out.println(sb2.length());//3
   //问题2. 扩容问题:如果要添加的数据底层数组盛不下了，那就需要扩容底层的数组。
            默认情况下，扩容为原来容量的2倍 + 2，同时将原数组中的元素复制到新的数组中。

   ​		指导意义：开发中建议大家使用：StringBuffer(int capacity) 或 StringBuilder(int capacity)

   

   ```java
   @Test
       public void test1(){
           StringBuffer sb1 = new StringBuffer("abc");
           sb1.setCharAt(0,'m');
           System.out.println(sb1);
   
           StringBuffer sb2 = new StringBuffer();
           System.out.println(sb2.length());//0
       }
   ```

   

3. StringBuffer的常用方法（StringBuilder一样）：

   * StringBuffer append(xxx)：提供了很多的append()方法，用于进行字符串拼接
   * StringBuffer delete(int start,int end)：删除指定位置的内容
   * StringBuffer replace(int start, int end, String str)：把[start,end)位置替换为str
   * StringBuffer insert(int offset, xxx)：在指定位置插入xxx
   * StringBuffer reverse() ：把当前字符序列逆转
   * public int indexOf(String str)
   * public String substring(int start,int end):返回一个从start开始到end索引结束的左闭右开区间的子字符串
   * public int length()
   * public int length()
   * public char charAt(int n)
   * public void setCharAt(int n,char ch)

### 总结：

> 增：append(xxx)
> 删：delete(int start,int end)
> 改：setCharAt(int n ,char ch) / replace(int start, int end, String str)
> 查：charAt(int n )
> 插：insert(int offset, xxx)
> 长度：length();
> 遍历：for() + charAt() / toString()

```java
@Test
    public void test2(){
        StringBuffer s1 = new StringBuffer("abc");
        s1.append(1);
        s1.append('1');
        System.out.println(s1);
//        s1.delete(2,4);
//        s1.replace(2,4,"hello");
//        s1.insert(2,false);
//        s1.reverse();
        String s2 = s1.substring(1, 3);
        System.out.println(s1);
        System.out.println(s1.length());
        System.out.println(s2);
    }
```



4. 对比String、StringBuffer、StringBuilder三者的执行效率

   从高到低排列：StringBuilder>StringBuffer>String

   ```java
   @Test
       public void test3(){
           //初始设置
           long startTime = 0L;
           long endTime = 0L;
           String text = "";
           StringBuffer buffer = new StringBuffer("");
           StringBuilder builder = new StringBuilder("");
           //开始对比
           startTime = System.currentTimeMillis();
           for (int i = 0; i < 20000; i++) {
               buffer.append(String.valueOf(i));
           }
           endTime = System.currentTimeMillis();
           System.out.println("StringBuffer的执行时间：" + (endTime - startTime));
   
           startTime = System.currentTimeMillis();
           for (int i = 0; i < 20000; i++) {
               builder.append(String.valueOf(i));
           }
           endTime = System.currentTimeMillis();
           System.out.println("StringBuilder的执行时间：" + (endTime - startTime));
   
           startTime = System.currentTimeMillis();
           for (int i = 0; i < 20000; i++) {
               text = text + i;
           }
           endTime = System.currentTimeMillis();
           System.out.println("String的执行时间：" + (endTime - startTime));
   
       }
   ```

   

## JDK 8之前日期的时间的API

### System、Date

1. 获取系统当前时间：System类中的currentTimeMillis()

   ```java
   long time = System.currentTimeMillis();
   //返回当前时间与1970年1月1日0时0分0秒之间以毫秒为单位的时间差。
   //称为时间戳
   ```

2. java.util.Date类与java.sql.Date类

   >java.util.Date类
   >           |---java.sql.Date类
   >
   >    1.两个构造器的使用
   >        >构造器一：Date()：创建一个对应当前时间的Date对象
   >        >构造器二：创建指定毫秒数的Date对象
   >    2.两个方法的使用
   >        >toString():显示当前的年、月、日、时、分、秒
   >        >getTime():获取当前Date对象对应的毫秒数。（时间戳）
   >    
   >    3. java.sql.Date对应着数据库中的日期类型的变量
   >        >如何实例化
   >        >如何将java.util.Date对象转换为java.sql.Date对象

   ```java
   @Test
       public void test2(){
           //构造器一：Date()：创建一个对应当前时间的Date对象
           Date date1 = new Date();
           System.out.println(date1.toString());//Sat Feb 16 16:35:31 GMT+08:00 2019
   
           System.out.println(date1.getTime());//1550306204104
   
           //构造器二：创建指定毫秒数的Date对象
           Date date2 = new Date(155030620410L);
           System.out.println(date2.toString());
   
           //创建java.sql.Date对象
           java.sql.Date date3 = new java.sql.Date(35235325345L);
           System.out.println(date3);//1971-02-13
   
           //如何将java.util.Date对象转换为java.sql.Date对象
           //情况一：
   //        Date date4 = new java.sql.Date(2343243242323L);
   //        java.sql.Date date5 = (java.sql.Date) date4;
           //情况二：
           Date date6 = new Date();
           java.sql.Date date7 = new java.sql.Date(date6.getTime());
   
   
       }
   ```



3. java.text.SimpleDateFormat类

   SimpleDateFormat对日期Date类的格式化和解析

   1. 两个操作：

      1.1  格式化：日期 --->字符串

      1.2  解析：格式化的逆过程，字符串 ---> 日期

   2. SimpleDateFormat的实例化:new + 构造器

   ```java
   @Test
       public void testSimpleDateFormat() throws ParseException {
           //实例化SimpleDateFormat:使用默认的构造器
           SimpleDateFormat sdf = new SimpleDateFormat();
   
           //格式化：日期 --->字符串
           Date date = new Date();
           System.out.println(date);
   
           String format = sdf.format(date);
           System.out.println(format);
   
           //解析：格式化的逆过程，字符串 ---> 日期
           String str = "19-12-18 上午11:43";
           Date date1 = sdf.parse(str);
           System.out.println(date1);
   
           //*************按照指定的方式格式化和解析：调用带参的构造器*****************
   //        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyyy.MMMMM.dd GGG hh:mm aaa");
           SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
           //格式化
           String format1 = sdf1.format(date);
           System.out.println(format1);//2019-02-18 11:48:27
           //解析:要求字符串必须是符合SimpleDateFormat识别的格式(通过构造器参数体现),
           //否则，抛异常
           Date date2 = sdf1.parse("2020-02-18 11:48:27");
           System.out.println(date2);
       }
   ```

   

练习一：字符串"2020-09-08"转换为java.sql.Date

```java
@Test
    public void testExer() throws ParseException {
        String birth = "2020-09-08";

        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
        Date date = sdf1.parse(birth);
//        System.out.println(date);

        java.sql.Date birthDate = new java.sql.Date(date.getTime());
        System.out.println(birthDate);
    }
```



### Calendar类：日历类、抽象类

```java
 @Test
    public void testCalendar(){
        //1.实例化
        //方式一：创建其子类（GregorianCalendar）的对象
        //方式二：调用其静态方法getInstance()
        Calendar calendar = Calendar.getInstance();
//        System.out.println(calendar.getClass());

        //2.常用方法
        //get()
        int days = calendar.get(Calendar.DAY_OF_MONTH);
        System.out.println(days);
        System.out.println(calendar.get(Calendar.DAY_OF_YEAR));

        //set()
        //calendar可变性
        calendar.set(Calendar.DAY_OF_MONTH,22);
        days = calendar.get(Calendar.DAY_OF_MONTH);
        System.out.println(days);

        //add()
        calendar.add(Calendar.DAY_OF_MONTH,-3);
        days = calendar.get(Calendar.DAY_OF_MONTH);
        System.out.println(days);

        //getTime():日历类---> Date
        Date date = calendar.getTime();
        System.out.println(date);

        //setTime():Date ---> 日历类
        Date date1 = new Date();
        calendar.setTime(date1);
        days = calendar.get(Calendar.DAY_OF_MONTH);
        System.out.println(days);

    }
```





## JDK8中新日期时间API

1. 日期时间API的迭代：

   第一代：jdk 1.0 Date类
   第二代：jdk 1.1 Calendar类，一定程度上替换Date类
   第三代：jdk 1.8 提出了新的一套API

2. 前两代存在的问题举例：

   可变性：像日期和时间这样的类应该是不可变的。
   偏移性：Date中的年份是从1900开始的，而月份都从0开始。
   格式化：格式化只对Date用，Calendar则不行。
   此外，它们也不是线程安全的；不能处理闰秒等。

3. java 8 中新的日期时间API涉及到的包

   <a href="https://sm.ms/image/jBsitvwflQuxJAU" target="_blank"><img src="https://i.loli.net/2021/05/09/jBsitvwflQuxJAU.png" ></a>

4. 本地日期、本地时间、本地日期时间的使用：LocalDate / LocalTime / LocalDateTime

   1. 说明

      ① 分别表示使用 ISO-8601日历系统的日期、时间、日期和时间。它们提供了简单的本地日期或时间，并不包含当前的时间信息，也不包含与时区相关的信息。
      ② LocalDateTime相较于LocalDate、LocalTime，使用频率要高
      ③ 类似于Calendar

   2. 常用方法

      <a href="https://sm.ms/image/QZntLdE3gkDMzA8" target="_blank"><img src="https://i.loli.net/2021/05/09/QZntLdE3gkDMzA8.png" ></a>

      ```java
      @Test
          public void testDate(){
              //偏移量
              Date date1 = new Date(2020 - 1900,9 - 1,8);
              System.out.println(date1);//Tue Sep 08 00:00:00 GMT+08:00 2020
          }
      ```

      ```java
      @Test
          public void test1(){
              //now():获取当前的日期、时间、日期+时间
              LocalDate localDate = LocalDate.now();
              LocalTime localTime = LocalTime.now();
              LocalDateTime localDateTime = LocalDateTime.now();
      
              System.out.println(localDate);
              System.out.println(localTime);
              System.out.println(localDateTime);
      
              //of():设置指定的年、月、日、时、分、秒。没有偏移量
              LocalDateTime localDateTime1 = LocalDateTime.of(2020, 10, 6, 13, 23, 43);
              System.out.println(localDateTime1);
      
      
              //getXxx()：获取相关的属性
              System.out.println(localDateTime.getDayOfMonth());
              System.out.println(localDateTime.getDayOfWeek());
              System.out.println(localDateTime.getMonth());
              System.out.println(localDateTime.getMonthValue());
              System.out.println(localDateTime.getMinute());
      
              //体现不可变性
              //withXxx():设置相关的属性
              LocalDate localDate1 = localDate.withDayOfMonth(22);
              System.out.println(localDate);
              System.out.println(localDate1);
      
      
              LocalDateTime localDateTime2 = localDateTime.withHour(4);
              System.out.println(localDateTime);
              System.out.println(localDateTime2);
      
              //不可变性
              LocalDateTime localDateTime3 = localDateTime.plusMonths(3);
              System.out.println(localDateTime);
              System.out.println(localDateTime3);
      
              LocalDateTime localDateTime4 = localDateTime.minusDays(6);
              System.out.println(localDateTime);
              System.out.println(localDateTime4);
          }
      
      ```

      

5. 时间点：Instant

   1. 说明：

      ① 时间线上的一个瞬时点。 概念上讲，它只是简单的表示自1970年1月1日0时0分0秒（UTC开始的秒数。）
      ② 类似于 java.util.Date类

   2. 常用方法：

      <a href="https://sm.ms/image/aBj9ATvcgR4IJi1" target="_blank"><img src="https://i.loli.net/2021/05/09/aBj9ATvcgR4IJi1.png" ></a>

      ```java 
      @Test
          public void test2(){
              //now():获取本初子午线对应的标准时间
              Instant instant = Instant.now();
              System.out.println(instant);//2019-02-18T07:29:41.719Z
      
              //添加时间的偏移量
              OffsetDateTime offsetDateTime = instant.atOffset(ZoneOffset.ofHours(8));
              System.out.println(offsetDateTime);//2019-02-18T15:32:50.611+08:00
      
              //toEpochMilli():获取自1970年1月1日0时0分0秒（UTC）开始的毫秒数  ---> Date类的getTime()
              long milli = instant.toEpochMilli();
              System.out.println(milli);
      
              //ofEpochMilli():通过给定的毫秒数，获取Instant实例  -->Date(long millis)
              Instant instant1 = Instant.ofEpochMilli(1550475314878L);
              System.out.println(instant1);
          }
      ```

      







6. 日期时间格式化类：DateTimeFormatter

   1. 说明：

      ① 格式化或解析日期、时间
      ② 类似于SimpleDateFormat

   2. 常用方法：

      ① 实例化方式：
      预定义的标准格式。如：ISO_LOCAL_DATE_TIME;ISO_LOCAL_DATE;ISO_LOCAL_TIME
      本地化相关的格式。如：ofLocalizedDateTime(FormatStyle.LONG)
      自定义的格式。如：ofPattern(“yyyy-MM-dd hh:mm:ss”)

      <a href="https://sm.ms/image/jtFKfGbdMW7hasC" target="_blank"><img src="https://i.loli.net/2021/05/09/jtFKfGbdMW7hasC.png" ></a>

   ```java
    @Test
       public void test3(){
   //        方式一：预定义的标准格式。如：ISO_LOCAL_DATE_TIME;ISO_LOCAL_DATE;ISO_LOCAL_TIME
           DateTimeFormatter formatter = DateTimeFormatter.ISO_LOCAL_DATE_TIME;
           //格式化:日期-->字符串
           LocalDateTime localDateTime = LocalDateTime.now();
           String str1 = formatter.format(localDateTime);
           System.out.println(localDateTime);
           System.out.println(str1);//2019-02-18T15:42:18.797
   
           //解析：字符串 -->日期
           TemporalAccessor parse = formatter.parse("2019-02-18T15:42:18.797");
           System.out.println(parse);
   
   //        方式二：
   //        本地化相关的格式。如：ofLocalizedDateTime()
   //        FormatStyle.LONG / FormatStyle.MEDIUM / FormatStyle.SHORT :适用于LocalDateTime
           DateTimeFormatter formatter1 = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.LONG);
           //格式化
           String str2 = formatter1.format(localDateTime);
           System.out.println(str2);//2019年2月18日 下午03时47分16秒
   
   
   //      本地化相关的格式。如：ofLocalizedDate()
   //      FormatStyle.FULL / FormatStyle.LONG / FormatStyle.MEDIUM / FormatStyle.SHORT : 适用于LocalDate
           DateTimeFormatter formatter2 = DateTimeFormatter.ofLocalizedDate(FormatStyle.MEDIUM);
           //格式化
           String str3 = formatter2.format(LocalDate.now());
           System.out.println(str3);//2019-2-18
   
   
   //       重点： 方式三：自定义的格式。如：ofPattern(“yyyy-MM-dd hh:mm:ss”)
           DateTimeFormatter formatter3 = DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss");
           //格式化
           String str4 = formatter3.format(LocalDateTime.now());
           System.out.println(str4);//2019-02-18 03:52:09
   
           //解析
           TemporalAccessor accessor = formatter3.parse("2019-02-18 03:52:09");
           System.out.println(accessor);
   
       }
   
   ```

7. 其它API的使用 (不讲)

   1. 带时区的日期时间：ZonedDateTime / ZoneId 

      ```java
      举例：
      // ZoneId:类中包含了所的时区信息
      	@Test
      	public void test1(){
      		//getAvailableZoneIds():获取所的ZoneId
      		Set<String> zoneIds = ZoneId.getAvailableZoneIds();
      		for(String s : zoneIds){
      			System.out.println(s);
      		}
      		System.out.println();
      		
      		//获取“Asia/Tokyo”时区对应的时间
      		LocalDateTime localDateTime = LocalDateTime.now(ZoneId.of("Asia/Tokyo"));
      		System.out.println(localDateTime);
      		
      		
      	}
      //ZonedDateTime:带时区的日期时间
      	@Test
      	public void test2(){
      		//now():获取本时区的ZonedDateTime对象
      		ZonedDateTime zonedDateTime = ZonedDateTime.now();
      		System.out.println(zonedDateTime);
      		//now(ZoneId id):获取指定时区的ZonedDateTime对象
      		ZonedDateTime zonedDateTime1 = ZonedDateTime.now(ZoneId.of("Asia/Tokyo"));
      		System.out.println(zonedDateTime1);
      	}
      ```

   2. 时间间隔：Duration--用于计算两个“时间”间隔，以秒和纳秒为基准

      <a href="https://sm.ms/image/yqfBvG4TU6zwpxY" target="_blank"><img src="https://i.loli.net/2021/05/09/yqfBvG4TU6zwpxY.png" ></a>

      ```java 
      @Test
      	public void test3(){
      		LocalTime localTime = LocalTime.now();
      		LocalTime localTime1 = LocalTime.of(15, 23, 32);
      		//between():静态方法，返回Duration对象，表示两个时间的间隔
      		Duration duration = Duration.between(localTime1, localTime);
      		System.out.println(duration);
      		
      		System.out.println(duration.getSeconds());
      		System.out.println(duration.getNano());
      		
      		LocalDateTime localDateTime = LocalDateTime.of(2016, 6, 12, 15, 23, 32);
      		LocalDateTime localDateTime1 = LocalDateTime.of(2017, 6, 12, 15, 23, 32);
      		
      		Duration duration1 = Duration.between(localDateTime1, localDateTime);
      		System.out.println(duration1.toDays());
      		
      	}
      ```

   3. 日期间隔：Period --用于计算两个“日期”间隔，以年、月、日衡量

      <a href="https://sm.ms/image/nEFwY1S6ZU3NaBA" target="_blank"><img src="https://i.loli.net/2021/05/09/nEFwY1S6ZU3NaBA.png" ></a>

      ```java 
      @Test
      	public void test4(){
      		LocalDate localDate = LocalDate.now();
      		LocalDate localDate1 = LocalDate.of(2028, 3, 18);
      		
      		Period period = Period.between(localDate, localDate1);
      		System.out.println(period);
      		
      		System.out.println(period.getYears());
      		System.out.println(period.getMonths());
      		System.out.println(period.getDays());
      		
      		Period period1 = period.withYears(2);
      		System.out.println(period1);
      		
      	}
      ```

   4. 日期时间校正器：TemporalAdjuster

      ```java
      @Test
      	public void test5(){
      		//获取当前日期的下一个周日是哪天？
      		TemporalAdjuster temporalAdjuster = TemporalAdjusters.next(DayOfWeek.SUNDAY);
      		
      		LocalDateTime localDateTime = LocalDateTime.now().with(temporalAdjuster);
      		System.out.println(localDateTime);
      		
      		//获取下一个工作日是哪天？
      		LocalDate localDate = LocalDate.now().with(new TemporalAdjuster(){
      
      			@Override
      			public Temporal adjustInto(Temporal temporal) {
      				LocalDate date = (LocalDate)temporal;
      				if(date.getDayOfWeek().equals(DayOfWeek.FRIDAY)){
      					return date.plusDays(3);
      				}else if(date.getDayOfWeek().equals(DayOfWeek.SATURDAY)){
      					return date.plusDays(2);
      				}else{
      					return date.plusDays(1);
      				}
      					
      			}
      			
      		});
      		
      		System.out.println("下一个工作日是：" + localDate);
      	}
      ```

      

## Java 比较器

1. Java比较器的使用背景：

   Java中的对象，正常情况下，只能进行比较：==  或  != 。不能使用 > 或 < 的
   但是在开发场景中，我们需要对多个对象进行排序，言外之意，就需要比较对象的大小。
   如何实现？使用两个接口中的任何一个：Comparable 或 Comparator

2. 自然排序：使用Comparable接口

   1. 说明

      * 像String、包装类等实现了Comparable接口，重写了compareTo(obj)方法，给出了比较两个对象大小的方式。

      * 像String、包装类重写compareTo()方法以后，进行了从小到大的排列

      * ==重写compareTo(obj)的规则==：

        如果当前对象this大于形参对象obj，则返回正整数，

        如果当前对象this小于形参对象obj，则返回负整数，

        如果当前对象this等于形参对象obj，则返回零。

        ```java
        @Test
            public void test1(){
                String[] arr = new String[]{"AA","CC","KK","MM","GG","JJ","DD"};
                //
                Arrays.sort(arr);
        
                System.out.println(Arrays.toString(arr));
        
            }
        
        ```

        

      * 对于自定义类来说，如果需要排序，我们可以让自定义类实现Comparable接口，重写compareTo(obj)方法。在compareTo(obj)方法中指明如何排序

        Goods.java

        ```java
        public class Goods implements  Comparable{
        
            private String name;
            private double price;
        
            public Goods() {
            }
        
            public Goods(String name, double price) {
                this.name = name;
                this.price = price;
            }
        
            public String getName() {
                return name;
            }
        
            public void setName(String name) {
                this.name = name;
            }
        
            public double getPrice() {
                return price;
            }
        
            public void setPrice(double price) {
                this.price = price;
            }
        
            @Override
            public String toString() {
                return "Goods{" +
                        "name='" + name + '\'' +
                        ", price=" + price +
                        '}';
            }
        
            //指明商品比较大小的方式:按照价格从低到高排序,再按照产品名称从高到低排序
            @Override
            public int compareTo(Object o) {
        //        System.out.println("**************");
                if(o instanceof Goods){
                    Goods goods = (Goods)o;
                    //方式一：
                    if(this.price > goods.price){
                        return 1;
                    }else if(this.price < goods.price){
                        return -1;
                    }else{
        //                return 0;
                       return -this.name.compareTo(goods.name);
                    }
                    //方式二：
        //           return Double.compare(this.price,goods.price);
                }
        //        return 0;
                throw new RuntimeException("传入的数据类型不一致！");
            }
        }
        ```

        

        ```java
        @Test
            public void test2(){
                Goods[] arr = new Goods[5];
                arr[0] = new Goods("lenovoMouse",34);
                arr[1] = new Goods("dellMouse",43);
                arr[2] = new Goods("xiaomiMouse",12);
                arr[3] = new Goods("huaweiMouse",65);
                arr[4] = new Goods("microsoftMouse",43);
        
                Arrays.sort(arr);
        
                System.out.println(Arrays.toString(arr));
            }
        ```

        

        

  3. 定制排序：使用Comparator接口

       1. 说明

          * 背景：

            当元素的类型没实现java.lang.Comparable接口而又不方便修改代码，或者实现了java.lang.Comparable接口的排序规则不适合当前的操作，那么可以考虑使用 Comparator 的对象来排序

          * 重写compare(Object o1,Object o2)方法，比较o1和o2的大小：

            如果方法返回正整数，则表示o1大于o2；
            如果返回0，表示相等；
            返回负整数，表示o1小于o2。

            ```java
            @Test
                public void test3(){
                    String[] arr = new String[]{"AA","CC","KK","MM","GG","JJ","DD"};
                    Arrays.sort(arr,new Comparator(){
            
                        //按照字符串从大到小的顺序排列
                        @Override
                        public int compare(Object o1, Object o2) {
                            if(o1 instanceof String && o2 instanceof  String){
                                String s1 = (String) o1;
                                String s2 = (String) o2;
                                return -s1.compareTo(s2);
                            }
            //                return 0;
                            throw new RuntimeException("输入的数据类型不一致");
                        }
                    });
                    System.out.println(Arrays.toString(arr));
                }
            ```

            ```java 
            @Test
                public void test4(){
                    Goods[] arr = new Goods[6];
                    arr[0] = new Goods("lenovoMouse",34);
                    arr[1] = new Goods("dellMouse",43);
                    arr[2] = new Goods("xiaomiMouse",12);
                    arr[3] = new Goods("huaweiMouse",65);
                    arr[4] = new Goods("huaweiMouse",224);
                    arr[5] = new Goods("microsoftMouse",43);
            
                    Arrays.sort(arr, new Comparator() {
                        //指明商品比较大小的方式:按照产品名称从低到高排序,再按照价格从高到低排序
                        @Override
                        public int compare(Object o1, Object o2) {
                            if(o1 instanceof Goods && o2 instanceof Goods){
                                Goods g1 = (Goods)o1;
                                Goods g2 = (Goods)o2;
                                if(g1.getName().equals(g2.getName())){
                                    return -Double.compare(g1.getPrice(),g2.getPrice());
                                }else{
                                    return g1.getName().compareTo(g2.getName());
                                }
                            }
                            throw new RuntimeException("输入的数据类型不一致");
                        }
                    });
            
                    System.out.println(Arrays.toString(arr));
                }
            
            ```

            使用：
            Arrays.sort(goods,com);
            Collections.sort(coll,com);
            new TreeSet(com);

          

          

     2. 两种排序方式对比

        * Comparable接口的方式一旦一定，保证Comparable接口实现类的对象在任何位置都可以比较大小。
        * Comparator接口属于临时性的比较。

        

        

## 其他类

1. System类

   * System类代表系统，系统级的很多属性和控制方法都放置在该类的内部。该类位于java.lang包。
   * 由于该类的构造器是private的，所以无法创建该类的对象，也就是无法实例化该类。其内部的成员变量和成员方法都是static的，所以也可以很方便的进行调用。
   * 方法：
     native long currentTimeMillis()
     void exit(int status)
     void gc()
     String getProperty(String key)

   ```java
   @Test
       public void test1() {
           String javaVersion = System.getProperty("java.version");
           System.out.println("java的version:" + javaVersion);
   
           String javaHome = System.getProperty("java.home");
           System.out.println("java的home:" + javaHome);
   
           String osName = System.getProperty("os.name");
           System.out.println("os的name:" + osName);
   
           String osVersion = System.getProperty("os.version");
           System.out.println("os的version:" + osVersion);
   
           String userName = System.getProperty("user.name");
           System.out.println("user的name:" + userName);
   
           String userHome = System.getProperty("user.home");
           System.out.println("user的home:" + userHome);
   
           String userDir = System.getProperty("user.dir");
           System.out.println("user的dir:" + userDir);
   
       }
   ```

   

2. Math类

   java.lang.Math提供了一系列静态方法用于科学计算。其方法的参数和返回值类型一般为double型。

3. BigInteger类、BigDecimal类

   说明：

   ① java.math包的BigInteger可以表示不可变的任意精度的整数。
   ② 要求数字精度比较高，用到java.math.BigDecimal类

   ```java
   @Test
       public void test2() {
           BigInteger bi = new BigInteger("1243324112234324324325235245346567657653");
           BigDecimal bd = new BigDecimal("12435.351");
           BigDecimal bd2 = new BigDecimal("11");
           System.out.println(bi);
   //         System.out.println(bd.divide(bd2));
           System.out.println(bd.divide(bd2, BigDecimal.ROUND_HALF_UP));
           System.out.println(bd.divide(bd2, 25, BigDecimal.ROUND_HALF_UP));
   
       }
   ```

   

   

# 十、枚举类和注解

## 枚举类的使用

1. 枚举类的说明：

   * 枚举类的理解：类的对象只有有限个，确定的。我们称此类为枚举类
   * 当需要定义一组常量时，强烈建议使用枚举类
   * 如果枚举类中只有一个对象，则可以作为单例模式的实现方式

2. 如何自定义枚举类？步骤

   ```java
   //自定义枚举类
   class Season{
       //1.声明Season对象的属性:private final修饰
       private final String seasonName;
       private final String seasonDesc;
   
       //2.私有化类的构造器,并给对象属性赋值
       private Season(String seasonName,String seasonDesc){
           this.seasonName = seasonName;
           this.seasonDesc = seasonDesc;
       }
   
       //3.提供当前枚举类的多个对象：public static final的
       public static final Season SPRING = new Season("春天","春暖花开");
       public static final Season SUMMER = new Season("夏天","夏日炎炎");
       public static final Season AUTUMN = new Season("秋天","秋高气爽");
       public static final Season WINTER = new Season("冬天","冰天雪地");
   
       //4.其他诉求1：获取枚举类对象的属性
       public String getSeasonName() {
           return seasonName;
       }
   
       public String getSeasonDesc() {
           return seasonDesc;
       }
       //4.其他诉求1：提供toString()
       @Override
       public String toString() {
           return "Season{" +
                   "seasonName='" + seasonName + '\'' +
                   ", seasonDesc='" + seasonDesc + '\'' +
                   '}';
       }
   ```

3. jdk 5.0新增使用enum定义枚举类。步骤：

   ```java
   //使用enum关键字枚举类
   enum Season1 {
       //1.提供当前枚举类的对象，多个对象之间用","隔开，末尾对象";"结束
       SPRING("春天","春暖花开"),
       SUMMER("夏天","夏日炎炎"),
       AUTUMN("秋天","秋高气爽"),
       WINTER("冬天","冰天雪地");
   
       //2.声明Season对象的属性:private final修饰
       private final String seasonName;
       private final String seasonDesc;
   
       //2.私化类的构造器,并给对象属性赋值
   
       private Season1(String seasonName,String seasonDesc){
           this.seasonName = seasonName;
           this.seasonDesc = seasonDesc;
       }
   
       //4.其他诉求1：获取枚举类对象的属性
       public String getSeasonName() {
           return seasonName;
       }
   
       public String getSeasonDesc() {
           return seasonDesc;
       }
   
   }
   ```

4. 使用enum定义枚举类之后，枚举类常用方法：（继承于java.lang.Enum类）

    toString\values\valueOf

   ```java
           Season1 summer = Season1.SUMMER;
           //toString():返回枚举类对象的名称
           System.out.println(summer.toString());
   
   //        System.out.println(Season1.class.getSuperclass());
           System.out.println("****************");
           //values():返回所有的枚举类对象构成的数组
           Season1[] values = Season1.values();
           for(int i = 0;i < values.length;i++){
               System.out.println(values[i]);
               values[i].show();
           }
           System.out.println("****************");
           Thread.State[] values1 = Thread.State.values();
           for (int i = 0; i < values1.length; i++) {
               System.out.println(values1[i]);
           }
   
           //valueOf(String objName):返回枚举类中对象名是objName的对象。
           Season1 winter = Season1.valueOf("WINTER");
           //如果没有objName的枚举类对象，则抛异常：IllegalArgumentException
   //        Season1 winter = Season1.valueOf("WINTER1");
           System.out.println(winter);
   ```

5. 使用enum定义枚举类之后，如何让枚举类对象分别实现接口：

   ```java
   interface Info{
       void show();
   }
   
   //使用enum关键字枚举类
   enum Season1 implements Info{
       //1.提供当前枚举类的对象，多个对象之间用","隔开，末尾对象";"结束
       SPRING("春天","春暖花开"){
           @Override
           public void show() {
               System.out.println("春天在哪里？");
           }
       },
       SUMMER("夏天","夏日炎炎"){
           @Override
           public void show() {
               System.out.println("宁夏");
           }
       },
       AUTUMN("秋天","秋高气爽"){
           @Override
           public void show() {
               System.out.println("秋天不回来");
           }
       },
       WINTER("冬天","冰天雪地"){
           @Override
           public void show() {
               System.out.println("大约在冬季");
           }
       };
   
       //2.声明Season对象的属性:private final修饰
       private final String seasonName;
       private final String seasonDesc;
   
       //2.私有化类的构造器,并给对象属性赋值
   
       private Season1(String seasonName,String seasonDesc){
           this.seasonName = seasonName;
           this.seasonDesc = seasonDesc;
       }
   
       //4.其他诉求1：获取枚举类对象的属性
       public String getSeasonName() {
           return seasonName;
       }
   
       public String getSeasonDesc() {
           return seasonDesc;
       }
   //    //4.其他诉求1：提供toString()
   //
   //    @Override
   //    public String toString() {
   //        return "Season1{" +
   //                "seasonName='" + seasonName + '\'' +
   //                ", seasonDesc='" + seasonDesc + '\'' +
   //                '}';
   //    }
   
   
   //    @Override
   //    public void show() {
   //        System.out.println("这是一个季节");
   //    }
   ```



## 注解的使用

1. 注解的理解

   * jdk 5.0 新增的功能
   * Annotation 其实就是代码里的特殊标记, 这些标记可以在编译, 类加载, 运行时被读取, 并执行相应的处理。通过使用 Annotation,程序员可以在不改变原逻辑的情况下, 在源文件中嵌入一些补充信息。
   * 在JavaSE中，注解的使用目的比较简单，例如标记过时的功能，忽略警告等。在JavaEE/Android中注解占据了更重要的角色，例如用来配置应用程序的任何切面，代替JavaEE旧版中所遗留的繁冗代码和XML配置等。

   框架 = 注解 + 反射机制 + 设计模式

2. 注解的使用示例

   * 示例一：生成文档相关的注解

     如

     >```
     >/**
     > * @author xfy
     > * @create 2021-05-10 9:09
     > */
     >```

   * 示例二：在编译时进行格式检查(JDK内置的个基本注解)

     >     @Override: 限定重写父类方法, 该注解只能用于方法
     >     @Deprecated: 用于表示所修饰的元素(类, 方法等)已过时。通常是因为所修饰的结构危险或存在更好的选择
     >     @SuppressWarnings: 抑制编译器警告

   * 示例三：跟踪代码依赖性，实现替代配置文件功能

3. 如何自定义注解：参照@SuppressWarnings定义

   * 注解声明为：@interface
   * 内部定义成员，通常使用value表示
   * 可以指定成员的默认值，使用default定义
   * 如果自定义注解没成员，表明是一个标识作用。

   ```java
   @Inherited
   @Repeatable(MyAnnotations.class)
   @Retention(RetentionPolicy.RUNTIME)
   @Target({TYPE, FIELD, METHOD, PARAMETER, CONSTRUCTOR, LOCAL_VARIABLE,TYPE_PARAMETER,TYPE_USE})
   public @interface MyAnnotation {
   
       String value() default "hello";
   }
   ```

   ```java
   @Inherited
   @Retention(RetentionPolicy.RUNTIME)
   @Target({TYPE, FIELD, METHOD, PARAMETER, CONSTRUCTOR, LOCAL_VARIABLE})
   public @interface MyAnnotations {
   
       MyAnnotation[] value();
   }
   ```

   

   ==说明==

   如果注解有成员，在使用注解时，需要指明成员的值。
   自定义注解必须配上注解的信息处理流程(使用反射)才意义。
   自定义注解通过都会指明两个元注解：Retention、Target

4. 元注解 ：对现有的注解进行解释说明的注解。 

   jdk 提供的4种元注解：

   * Retention：指定所修饰的 Annotation 的生命周期：SOURCE\CLASS（默认行为）\RUNTIME
            只声明为RUNTIME生命周期的注解，才能通过反射获取。

   * Target:用于指定被修饰的 Annotation 能用于修饰哪些程序元素

     *******出现的频率较低*******

   * Documented:表示所修饰的注解在被javadoc解析时，保留下来。

   * Inherited:被它修饰的 Annotation 将具继承性。

5. 如何获取注解信息:通过反射来进行获取、调用。

   前提：要求此注解的元注解Retention中声明的生命周期状态为：RUNTIME.

6. JDK8中注解的新特性：可重复注解、类型注解

   1. 可重复注解：① 在MyAnnotation上声明@Repeatable，成员值为MyAnnotations.class
                     		② MyAnnotation的Target和Retention等元注解与MyAnnotations相同。

      ```java
      //jdk 8之前的写法：
      //@MyAnnotations({@MyAnnotation(value="hi"),@MyAnnotation(value="hi")})
      @MyAnnotation(value="hi")
      @MyAnnotation(value="abc")
      class Person{
          private String name;
          private int age;
      
          public Person() {
          }
          @MyAnnotation
          public Person(String name, int age) {
              this.name = name;
              this.age = age;
          }
          @MyAnnotation
          public void walk(){
              System.out.println("人走路");
          }
          public void eat(){
              System.out.println("人吃饭");
          }
      }
      ```

   2. 类型注解：

      ​	ElementType.TYPE_PARAMETER 表示该注解能写在类型变量的声明语句中（如：泛型声明。

      ​	ElementType.TYPE_USE 表示该注解能写在使用类型的任何语句中。

      ```java
      class Generic<@MyAnnotation T>{
      
          public void show() throws @MyAnnotation RuntimeException{
      
              ArrayList<@MyAnnotation String> list = new ArrayList<>();
      
              int num = (@MyAnnotation int) 10L;
          }
      
      }
      ```






# 十一、集合

## 数组与集合

1. 集合与数组存储数据概述：

   集合、数组都是对多个数据进行存储操作的结构，简称Java容器。

   说明：此时的存储，主要是指的是内存层面的存储，不涉及到持久化的存储（.txt,.jpg,.avi，数据库中）

2. 数组存储的特点：

   一旦初始化以后，其长度就确定了。

   数组一旦定义好，其元素的类型也就确定了。我们也就只能操作指定类型的数据了。

3. 数组存储的特点：

   一旦初始化以后，其长度就不可修改。

   数组中提供的方法非常有限，对于添加、删除、插入数据等操作，非常不便，同时效率不高

   获取数组中实际元素的个数的需求，数组没有现成的属性或方法可用

   数组存储数据的特点：有序、可重复。对于无序、不可重复的需求，不能满足。

4. 集合存储的优点：

   解决数组存储数据方面的弊端

## Collection接口

1. 单列集合框架结构

   > |----Collection接口：单列集合，用来存储一个一个的对象
   >
   > ​		|----List接口：存储序的、可重复的数据。  -->“动态”数组
   >
   > ​					|----ArrayList、LinkedList、Vector
   > 
   >
   > ​		|----Set接口：存储无序的、不可重复的数据   -->高中讲的“集合”
   >
   > ​					|----HashSet、LinkedHashSet、TreeSet

   

对应图示：

<a href="https://sm.ms/image/D54BoexZOrdtIN2" target="_blank"><img src="https://i.loli.net/2021/05/11/D54BoexZOrdtIN2.png" ></a>



### Collection接口常用15种方法：

​	1. add(Object e):将元素e添加到集合coll中

​	2. size():获取添加的元素的个数

​	3. addAll(Clollection coll1):集合中的元素添加到当前的集合中

​	4. clear():清空集合元素

​	5. isEmpty(): 判断当前的集合是否为空

```java
@Test
    public void test1(){
        Collection coll = new ArrayList();

        //add(Object e):将元素e添加到集合coll中
        coll.add("AA");
        coll.add("BB");
        coll.add(123);//自动装箱
        coll.add(new Date());

        //size():获取添加的元素的个数
        System.out.println(coll.size());//4

        //addAll(Collection coll1):将coll1集合中的元素添加到当前的集合中
        Collection coll1 = new ArrayList();
        coll1.add(456);
        coll1.add("CC");
        coll.addAll(coll1);

        System.out.println(coll.size());//6
        System.out.println(coll);

        //clear():清空集合元素
        coll.clear();

        //isEmpty():判断当前集合是否为空
        System.out.println(coll.isEmpty());

    }
```



6. contains(Object obj):判断当前集合中是否包含obj

   ==我们在判断时会调用obj对象所在类的equals()==

结论 ：**向Collection接口的实现类的对象中添加数据obj时，要求obj所在类要重写equals().**

7. containsAll(Collection coll1):判断形参coll1中的所有元素是否都存在当前集合中

   ```java
   @Test
       public void test1(){
           Collection coll = new ArrayList();
           coll.add(123);
           coll.add(456);
   //        Person p = new Person("Jerry",20);
   //        coll.add(p);
           coll.add(new Person("Jerry",20));
           coll.add(new String("Tom"));
           coll.add(false);
           //1.contains(Object obj):判断当前集合中是否包含obj
           //我们在判断时会调用obj对象所在类的equals()。
           boolean contains = coll.contains(123);
           System.out.println(contains);
           System.out.println(coll.contains(new String("Tom")));//true
   //        System.out.println(coll.contains(p));//true
           System.out.println(coll.contains(new Person("Jerry",20)));//false -->true(重写了equals（）)
   
           //2.containsAll(Collection coll1):判断形参coll1中的所有元素是否都存在于当前集合中。
           Collection coll1 = Arrays.asList(123,4567);
           System.out.println(coll.containsAll(coll1));
       }
   ```

8. remove(Object obj):从当前集合中移除obj元素

9. removeAll(Collection coll1):差集：从当前集合找中移除coll1中所有的元素。

   ```java 
   @Test
       public void test2(){
           //3.remove(Object obj):从当前集合中移除obj元素。
           Collection coll = new ArrayList();
           coll.add(123);
           coll.add(456);
           coll.add(new Person("Jerry",20));
           coll.add(new String("Tom"));
           coll.add(false);
   
           coll.remove(1234);
           System.out.println(coll);
   
           coll.remove(new Person("Jerry",20));  //需重写equals（）
           System.out.println(coll);
   
           //4. removeAll(Collection coll1):差集：从当前集合中移除coll1中所有的元素。
           Collection coll1 = Arrays.asList(123,456);
           coll.removeAll(coll1);
           System.out.println(coll);
   
   
       }
   ```

10. retainAll(Collection coll1):交集：获取当前集合和coll1集合的交集，并返回给当前集合

11. equals(Object obj):要想返回true，需要当前集合和形参集合的元素都相同,且添加顺序也要相同,obj需重写equals（）。

    ```java
    @Test
        public void test3(){
            Collection coll = new ArrayList();
            coll.add(123);
            coll.add(456);
            coll.add(new Person("Jerry",20));
            coll.add(new String("Tom"));
            coll.add(false);
    
            //5.retainAll(Collection coll1):交集：获取当前集合和coll1集合的交集，并返回给当前集合
    //        Collection coll1 = Arrays.asList(123,456,789);
    //        coll.retainAll(coll1);
    //        System.out.println(coll);
    
            //6.equals(Object obj):要想返回true，需要当前集合和形参集合的元素都相同,且添加顺序也要相同,obj需重写equals（）。
            Collection coll1 = new ArrayList();
            coll1.add(456);
            coll1.add(123);
            coll1.add(new Person("Jerry",20));
            coll1.add(new String("Tom"));
            coll1.add(false);
    
            System.out.println(coll.equals(coll1));
    
    
        }
    ```

12. hashCode():返回当前对象的哈希值

    

    ```java
    @Test
        public void test4(){
            Collection coll = new ArrayList();
            coll.add(123);
            coll.add(456);
            coll.add(new Person("Jerry",20));
            coll.add(new String("Tom"));
            coll.add(false);
    
            //7.hashCode():返回当前对象的哈希值
            System.out.println(coll.hashCode());
        }
    ```

#### Tterator接口与foreach循环

遍历Collection的两种方式：

* 使用迭代器Iterator
* foreach循环（或增强for循环）

​	说明：

​		java.utils包下定义的迭代器接口：Iterator

* Iterator对象称为迭代器(设计模式的一种)，主要用于遍历 Collection 集合中的元素。
  ==GOF给迭代器模式的定义为：提供一种方法访问一个容器(container)对象中各个元素，而又不需暴露该对象的内部细节。迭代器模式，就是为容器而生。==

如何获取实例：coll.iterator()返回一个迭代器

图示

<a href="https://sm.ms/image/4u9LFsXyY2VfqkA" target="_blank"><img src="https://i.loli.net/2021/05/12/4u9LFsXyY2VfqkA.png" ></a>

1. iterator():返回Iterator接口的实例，用于遍历集合元素。

   集合元素的遍历操作，使用迭代器Iterator接口

   * 内部的方法：hasNext()和next()

   * 集合对象每此调用iterator()方法都得到一个全新的迭代器对象，默认游标都在集合的第一个元素之前。

   * 内部定义了remove（），可以在遍历的时候，删除集合中的元素。此方法不同于集合中直接调用remove()

     ```java
     public class IteratorTest {
     
         @Test
         public void test1(){
             Collection coll = new ArrayList();
             coll.add(123);
             coll.add(456);
             coll.add(new Person("Jerry",20));
             coll.add(new String("Tom"));
             coll.add(false);
     
             Iterator iterator = coll.iterator();
             //方式一：
     //        System.out.println(iterator.next());
     //        System.out.println(iterator.next());
     //        System.out.println(iterator.next());
     //        System.out.println(iterator.next());
     //        System.out.println(iterator.next());
     //        //报异常：NoSuchElementException
     //        System.out.println(iterator.next());
     
             //方式二：不推荐
     //        for(int i = 0;i < coll.size();i++){
     //            System.out.println(iterator.next());
     //        }
     
             //方式三：推荐
             ////hasNext():判断是否还有下一个元素
             while(iterator.hasNext()){
                 //next():①指针下移 ②将下移以后集合位置上的元素返回
                 System.out.println(iterator.next());
             }
     
         }
     
         @Test
         public void test2(){
     
             Collection coll = new ArrayList();
             coll.add(123);
             coll.add(456);
             coll.add(new Person("Jerry",20));
             coll.add(new String("Tom"));
             coll.add(false);
     
             //错误方式一：
     //        Iterator iterator = coll.iterator();
     //        while((iterator.next()) != null){
     //            System.out.println(iterator.next()); //跳起输出
     //        }
     
             //错误方式二：
             //集合对象每次调用iterator()方法都得到一个全新的迭代器对象，默认游标都在集合的第一个元素之前。
             while (coll.iterator().hasNext()){
                 System.out.println(coll.iterator().next());
             }
     
     
         }
     
         //测试Iterator中的remove()
         //如果还未调用next()或在上一次调用 next 方法之后已经调用了 remove 方法，
         // 再调用remove都会报IllegalStateException。
         @Test
         public void test3(){
             Collection coll = new ArrayList();
             coll.add(123);
             coll.add(456);
             coll.add(new Person("Jerry",20));
             coll.add(new String("Tom"));
             coll.add(false);
     
             //删除集合中"Tom"
             Iterator iterator = coll.iterator();
             while (iterator.hasNext()){
     //            iterator.remove();
                 Object obj = iterator.next();
                 if("Tom".equals(obj)){
                     iterator.remove();
     //                iterator.remove();
                 }
     
             }
             //遍历集合
             iterator = coll.iterator();
             while (iterator.hasNext()){
                 System.out.println(iterator.next());
             }
         }
     }
     ```

     

2. jdk5.0新特性--增强for循环：(foreach循环)

   ```java
   public class ForTest {
   
       @Test
       public void test1(){
           Collection coll = new ArrayList();
           coll.add(123);
           coll.add(456);
           coll.add(new Person("Jerry",20));
           coll.add(new String("Tom"));
           coll.add(false);
   
           //for(集合元素的类型 局部变量 : 集合对象)
           //内部仍然调用了迭代器。
           for(Object obj : coll){
               System.out.println(obj);
           }
       }
   
       @Test
       public void test2(){
           int[] arr = new int[]{1,2,3,4,5,6};
           //for(数组元素的类型 局部变量 : 数组对象)
           for(int i : arr){
               System.out.println(i);
           }
       }
   
       //练习题
       @Test
       public void test3(){
   
           String[] arr = new String[]{"MM","MM","MM"};
   
   //        //方式一：普通for赋值
   //        for(int i = 0;i < arr.length;i++){
   //            arr[i] = "GG";
   //        }
   
           //方式二：增强for循环
           for(String s : arr){
               s = "GG";
           }
   
           for(int i = 0;i < arr.length;i++){
               System.out.println(arr[i]);
           }
   
   
       }
   }
   ```

   

#### Collection集合与数组间的转换

```java
//8.集合 --->数组：toArray()
        Object[] arr = coll.toArray();
        for(int i = 0;i < arr.length;i++){
            System.out.println(arr[i]);
        }

        //拓展：数组 --->集合:调用Arrays类的静态方法asList()
        List<String> list = Arrays.asList(new String[]{"AA", "BB", "CC"});
        System.out.println(list);

        List arr1 = Arrays.asList(new int[]{123, 456});
        System.out.println(arr1.size());//1
        System.out.println(arr1);

        List arr2 = Arrays.asList(new Integer[]{123, 456});
        System.out.println(arr2.size());//2
        System.out.println(arr2);
```



#### 重要结论

使用Collection集合存储对象，要求对象所属的类满足：

向Collection接口的实现类的对象中添加数据obj时，要求obj所在类要重写equals().





## Collection 子接口：List接口

### 概述

1. 存储的数据特点：存储有序的、可重复的数据。

2. List接口框架及实现类

   > |----Collection接口：单列集合，用来存储一个一个的对象
   >
   > ​			|----List接口：存储有序的、可重复的数据。  -->“动态”数组,替换原有的数组
   >
   > ​					|----ArrayList：作为List接口的主要实现类；线程不安全的，效率高；底层使用Object[] elementData存储
   >
   > ​					|----LinkedList：对于频繁的插入、删除操作，使用此类效率比ArrayList高；底层使用双向链表存储
   >
   > ​					|----Vector：作为List接口的古老实现类；线程安全的，效率低；底层使用Object[] elementData存储				

3. ArrayList的源码分析：

   1.  jdk 7情况下

      > ArrayList list = new ArrayList();//底层创建了长度是10的Object[]数组elementData
      >
      > list.add(123);//elementData[0] = new Integer(123);
      >
      > ......
      >
      > list.add(11);//如果此次的添加导致底层elementData数组容量不够，则扩容。
      >
      > 默认情况下，扩容为原来的容量的1.5倍，同时需要将原有数组中的数据复制到新的数组中。

      结论：==建议开发中使用带参的构造器：ArrayList list=new ArrayList(int capacity)==

   2. jdk 8中ArrayList的变化：

      > ArrayList list = new ArrayList();//底层Object[] elementData初始化为{}.并没创建长度为10的数组
      >
      > list.add(123);//第一次调用add()时，底层才创建了长度10的数组，并将数据123添加到elementData[0]
      >
      > ....
      >
      > 后续的添加和扩容操作与jdk 7 无异。

      小结： ==jdk7中的ArrayList的对象的创建类似于单例的饿汉式，而jdk8中的ArrayList的对象的创建类似于单例的懒汉式，延迟了数组的创建，节省内存。==

   

4. LinkedList的源码分析：

   > LinkedList list = new LinkedList(); 内部声明了Node类型的first和last属性，默认值为null
   >
   > list.add(123);//将123封装到Node中，创建了Node对象。
   >
   > 其中，Node定义为：体现了LinkedList的双向链表的说法
   >
   > ```java
   > private static class Node<E> {
   >             E item;
   >             Node<E> next;
   >             Node<E> prev;
   > 
   >             Node(Node<E> prev, E element, Node<E> next) {
   >             this.item = element;
   >             this.next = next;
   >             this.prev = prev;
   >             }
   >         }
   > ```

5. Vector的源码分析：

   jdk7和jdk8中通过Vector()构造器创建对象时，底层都创建了长度为10的数组。
   在扩容方面，默认扩容为原来的数组长度的2倍。

6. 存储的元素的要求

   添加的对象，所在的类要重写equals()方法

### List接口中的常用方法

* void add（int index, Object ele）:在index位置插入ele元素
* boolean addAll(int index, Collection eles):从index位置开始将eles中的所有元素添加进来
* Object  get(int index):获取指定index位置的元素



本小结的Person.java

```java
public class Person {

    private String name;
    private int age;

    public Person() {
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        System.out.println("Person equals()....");
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return age == person.age &&
                Objects.equals(name, person.name);
    }

    @Override
    public int hashCode() {

        return Objects.hash(name, age);
    }
}
```



```java
@Test
    public void test1(){
        ArrayList list = new ArrayList();
        list.add(123);
        list.add(456);
        list.add("AA");
        list.add(new Person("Tom",12));
        list.add(456);

        System.out.println(list);

        //void add(int index, Object ele):在index位置插入ele元素
        list.add(1,"BB");//默认添加到最后
        System.out.println(list);

        //boolean addAll(int index, Collection eles):从index位置开始将eles中的所有元素添加进来
        List list1 = Arrays.asList(1, 2, 3);
        list.addAll(list1); //默认添加到最后
//        list.add(list1);
        System.out.println(list);
        System.out.println(list.size());//9

        //Object get(int index):获取指定index位置的元素
        System.out.println(list.get(2));

    }
```



* int indexOf(Object obj):返回obj在集合中首次出现的位置

* int  lastIndexOf(Object obj):返回obj在当前集合中末次出现的位置

* Object  remove(int index):移除指定index位置的元素，并返回此元素

* Object remove(int index):移除指定index位置的元素，并返回此元素

* List subList(int fromIndex, int toIndex):返回从fromIndex到toIndex位置的子集合

  ```java 
  @Test
      public void test2(){
          ArrayList list = new ArrayList();
          list.add(123);
          list.add(456);
          list.add("AA");
          list.add(new Person("Tom",12));
          list.add(456);
          //int indexOf(Object obj):返回obj在集合中首次出现的位置。如果不存在，返回-1.
          int index = list.indexOf(4567);
          System.out.println(index);
  
          //int lastIndexOf(Object obj):返回obj在当前集合中末次出现的位置。如果不存在，返回-1.
          System.out.println(list.lastIndexOf(456));
  
          //Object remove(int index):移除指定index位置的元素，并返回此元素
          Object obj = list.remove(0);
          System.out.println(obj);
          System.out.println(list);
  
          //Object set(int index, Object ele):设置指定index位置的元素为ele
          list.set(1,"CC");
          System.out.println(list);
  
          //List subList(int fromIndex, int toIndex):返回从fromIndex到toIndex位置的左闭右开区间的子集合
          List subList = list.subList(2, 4);
          System.out.println(subList);
          System.out.println(list);
  
  
      }
  ```

  

  

### 总结常用方法

增：add(Object obj)

删：remove(int index) / remove(Object obj)

改：set(int index, Object ele)

查：get(int index)

插：add(int index, Object ele)/addAll(int index, Collection eles)

长度：size()

遍历：① Iterator迭代器方式

​			② 增强for循环

​			③ 普通的循环

```java
@Test
    public void test3(){
        ArrayList list = new ArrayList();
        list.add(123);
        list.add(456);
        list.add("AA");

        //方式一：Iterator迭代器方式
        Iterator iterator = list.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }

        System.out.println("***************");

        //方式二：增强for循环
        for(Object obj : list){
            System.out.println(obj);
        }

        System.out.println("***************");

        //方式三：普通for循环
        for(int i = 0;i < list.size();i++){
            System.out.println(list.get(i));
        }



    }
```





## Collection子接口：Set接口

### 概述

1. 存储的数据特点：无序的、不可重复的元素

   具体的：

   以HashSet为例说明：

   * 无序性：不等于随机性。存储的数据在底层数组中并非照数组索引的顺序添加，而是根据数据的哈希值决定的。
   * 不可重复性：保证添加的元素按照equals()判断时，不能返回true。即：相同的元素只能添加一个。

2. 、Set接口框架及实现类

   > |----Collection接口：单列集合，用来存储一个一个的对象
   >
   > ​			|----Set接口：存储无序的、不可重复的数据   -->高中讲的“集合”
   >
   > ​						|----HashSet：作为Set接口的主要实现类；线程不安全的；可以存储null值
   >
   > ​									|----LinkedHashSet：作为HashSet的子类；遍历其内部数据时，可以按照添加的顺序遍历,对于频繁的遍历操作，LinkedHashSet效率高于HashSet.
   >
   > ​						|----TreeSet：可以按照添加对象的指定属性，进行排序。

   

### Set接口的具体用法

3. 常用方法

   Set接口中没有额外定义新的方法，使用的都是Collection中声明过的方法。

4. 元素添加过程：（以HashSet为例）

   我们向HashSet中添加元素a,首先调用元素a所在类的hashCode()方法，计算元素a的哈希值，此哈希值接着通过某种算法计算出在HashSet底层数组中的存放位置（即为：索引位置，判断数组此位置上是否已经元素：

   ​					如果此位置上没其他元素，则元素a添加成功。 --->情况1

   ​					如果此位置上其他元素b(或以链表形式存在的多个元素，则比较元素a与元素b的hash值：

   ​							如果hash值不相同，则元素a添加成功。--->情况2

   ​							如果hash值相同，进而需要调用元素a所在类的equals()方法：

   ​										equals()返回true,元素a添加失败

   ​										equals()返回false,则元素a添加成功。--->情况3

对于添加成功的情况2和情况3而言：元素a 与已经存在指定索引位置上的数据以链表的方式存储。

jdk 7 :元素a放到数组中，指向原来的元素。
jdk 8 :原来的元素在数组中，指向元素a

==总结：七上八下==

HashSet底层：数组+链表的结构。（前提：jdk7)



5. **存储对象所在类的要求：**

   HashSet/LinkedHashSet:

   ==要求==：向Set(主要指：HashSet、LinkedHashSet)中添加的数据，其所在的类==一定要重写hashCode()和equals()==

   要求：重写的hashCode()和equals()尽可能保持一致性：相等的对象必须具有相等的散列码

   ​			重写两个方法的小技巧：对象中用作 equals() 方法比较的 Field，都应该用来计算 hashCode 值。



本小结用到的添加对象User.java

```java
public class User implements Comparable{
    private String name;
    private int age;

    public User() {
    }

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        System.out.println("User equals()....");
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (age != user.age) return false;
        return name != null ? name.equals(user.name) : user.name == null;
    }

    @Override
    public int hashCode() { //return name.hashCode() + age;
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + age;
        return result;
    }

    //按照姓名从大到小排列,年龄从小到大排列
    @Override
    public int compareTo(Object o) {
        if(o instanceof User){
            User user = (User)o;
//            return -this.name.compareTo(user.name);
            int compare = -this.name.compareTo(user.name);
            if(compare != 0){
                return compare;
            }else{
                return Integer.compare(this.age,user.age);
            }
        }else{
            throw new RuntimeException("输入的类型不匹配");
        }

    }
}
```



```java
@Test
    public void test1(){
        Set set = new HashSet();
        set.add(456);
        set.add(123);
        set.add(123);
        set.add("AA");
        set.add("CC");
        set.add(new User("Tom",12));
        set.add(new User("Tom",12));
        set.add(129);

        Iterator iterator = set.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }

    //LinkedHashSet的使用
    //LinkedHashSet作为HashSet的子类，在添加数据的同时，每个数据还维护了两个引用，记录此数据前一个
    //数据和后一个数据。
    //优点：对于频繁的遍历操作，LinkedHashSet效率高于HashSet
    @Test
    public void test2(){
        Set set = new LinkedHashSet();
        set.add(456);
        set.add(123);
        set.add(123);
        set.add("AA");
        set.add("CC");
        set.add(new User("Tom",12));
        set.add(new User("Tom",12));
        set.add(129);

        Iterator iterator = set.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }
```



### TreeSet的使用

1. 使用说明
   * 向TreeSet中添加的数据，要求是相同类的对象
   * 两种排序方式：自然排序（实现Comparable接口 和 定制排序（Comparator）(红黑树左小右大  等于0相等不添加)

```java
   @Test
    public void test1(){
        TreeSet set = new TreeSet();

        //失败：不能添加不同类的对象
//        set.add(123);
//        set.add(456);
//        set.add("AA");
//        set.add(new User("Tom",12));

            //举例一：
//        set.add(34);
//        set.add(-34);
//        set.add(43);
//        set.add(11);
//        set.add(8);

        //举例二：
        set.add(new User("Tom",12));
        set.add(new User("Jerry",32));
        set.add(new User("Jim",2));
        set.add(new User("Mike",65));
        set.add(new User("Jack",33));
        set.add(new User("Jack",56));


        Iterator iterator = set.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }

    }

    @Test
    public void test2(){
        Comparator com;
         com = new Comparator() {
            //按照年龄从小到大排列
            @Override
            public int compare(Object o1, Object o2) {
                if(o1 instanceof User && o2 instanceof User){
                    User u1 = (User)o1;
                    User u2 = (User)o2;
                    return Integer.compare(u1.getAge(),u2.getAge());
                }else{
                    throw new RuntimeException("输入的数据类型不匹配");
                }
            }
        };

        TreeSet set = new TreeSet(com);
        set.add(new User("Tom",12));
        set.add(new User("Jerry",32));
        set.add(new User("Jim",2));
        set.add(new User("Mike",65));
        set.add(new User("Mary",33));
        set.add(new User("Jack",33));
        set.add(new User("Jack",56));


        Iterator iterator = set.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }
```

#### 练习

```java
public class ListExer {
    /*
    区分List中remove(int index)和remove(Object obj)
     */
    @Test
    public void testListRemove() {
        List list = new ArrayList();
        list.add(1);
        list.add(2);
        list.add(3);
        updateList(list);
        System.out.println(list);//
    }

    private void updateList(List list) {
//        list.remove(2);
        list.remove(new Integer(2));
    }

}
```



## Map接口

双列集合框架：Map

1. 常用实现类结构

   |--------Map:双列数据，存储key-value对的数据   -------类似于高中的函数： y=f(x)

   ​             |-------HashMap:作为Map的主要实现类：线程不安全的，效率高；可以存储null的key和value

   ​					  |-------LinkedHashMap:保证在遍历map元素时，可以照添加的顺序实现遍历。

   ​							原因：在原有的HashMap底层结构基础上，添加了一对指针，指向前一个和后一个元素

   ​							对于频繁的遍历操作，此类执行效率高于HashMap。

   ​			 |-------TreeMap:保证按照添加的key-value对进行排序，实现排序遍历。此时考虑key的自然排序或定制排序  ，底层使用红黑树

   ​			 |---------Hashtable:作为古老的实现类；线程安全的，效率低；不能存储null的key和value
   
   ​							|------Properties：常用来处理配置文件。key和value都是String类型
   
   

HashMap的底层：数组+链表  （jdk及之前）

​								数组+链表+红黑树（jdk 8）



### Map结构的理解

以HashMap为例

1. Map中的key：无序的、不可重复的，使用Set存储所有的key----->**key所在的类要重写equals()和hashCode()** 

2. Map中的value：无序的、可重复的，使用Collection存储所有的value----->**value所在的类要重写equals（）**

3. 一个键值对：key-value构成了一个Entry对象。

   Map中的entry：无序的、不可重复的使用Set存储所有的entry

   <a href="https://sm.ms/image/RdUAN4pZkhilEjW" target="_blank"><img src="https://i.loli.net/2021/05/14/RdUAN4pZkhilEjW.png" ></a>



#### 面试题

> ```
> *  1. HashMap的底层实现原理？
> *  2. HashMap 和 Hashtable的异同？
> *  3. CurrentHashMap 与 Hashtable的异同？（暂时不讲）
> ```



### 内存结构说明（难点）

#### HashMap在jdk7中实现原理：

```java
/**
HashMap map= new HashMap():
在实例化以后，底层创建了长度是16的一维数组Entry[] table.
....可能已经执行过多次put.....
map.put(key1,value1):
首先，调用key1所在类的hashCode()计算key1哈希值，此哈希值经过某种算法以后，得到在Entry数组中的存储位置。
如果此位置上的数据为空，此时的key1-value1添加成功。------情况1
如果此位置上的数据不为空，（意味着此位置上存在一个或多个数据（以链表形式存在）），比较key1和已经存在的一个或多个数据的哈希值：
		如果key1的哈希值与已经存在的数据的哈希值都不同，此时key1-value1添加成功------情况2
		如果key1的哈希值和已经存在的某一个数据（key2-value2）的哈希值相同，继续比较：调用key1所在类的equals（key2）方法，比较：
				如果equals（）返回false：此时key1-value1添加成功-----情况3
				如果equals（）返回true：使用value替换value2.
				
补充：关于情况2和情况3：此时key1-value1和原来的数据以链表的方式存储。
在不断的添加过程中，会涉及到扩容问题，当超出临界值(且要存放的位置非空)时，扩容。默认的扩容方式：扩容为原来容量的2倍，并将原有的数据复制过来。
```



#### jdk8相较于jdk7在底层实现方面的不同：

1. new HashMap():底层没有创建一个长度为16的数组
2. jdk 8底层的数组是: Node[]，而非Entry[]
3. 首次调用put（）方法时，底层创建长度为16的数组
4. jdk7底层结构只有：数组+链表。jdk8中底层结构：数组+链表+红黑树。
   1. 形成链表时，七上八下（jdk7:新的元素指向旧的元素。jdk8：旧的元素指向新的元素）
   2. 当数组的某一个索引位置上的元素以链表形式存在的数据个数>8且当前数组的长度>64时，此时此索引位置上的所有数据改为红黑树存储。



#### HashMap底层典型属性的属性说明：

1. DEFAULT_INITIAL_CAPACITY : HashMap的默认容量，16
2. DEFAULT_LOAD_FACTOR：HashMap的默认加载因子：0.75
3. threshold：扩容的临界值，=容量*填充因子：16 * 0.75 => 12
4. TREEIFY_THRESHOLD：Bucket中链表长度大于该默认值，转化为红黑树:8
5. MIN_TREEIFY_CAPACITY：桶中的Node被树化时最小的hash表容量:64



#### LinkedHashMap 的底层实现原理（了解）

LinkedHashMap底层使用的结构与HashMap相同，因为LinkedHashMap继承于HashMap。区别就在于：LinkedHashMap内部提供了Entry，替换HashMap中的Node.

<a href="https://sm.ms/image/wi2Yh3gdNOPVUM9" target="_blank"><img src="https://i.loli.net/2021/05/14/wi2Yh3gdNOPVUM9.png" ></a>



## Map中定义的方法：

添加、删除、修改操作：

* Object put（Object key ,Object value）:将指定的key-value添加到（或修改）当前map对象中。
* void putAll(Map m):将m中的所有key-value对存放到当前map中
* Object remove(Object key)：移除指定key的key-value对，并返回value
* void clear()：清空当前map中的所有数据

```java
 @Test
    public void test3(){
        Map map = new HashMap();
        //添加
        map.put("AA",123);
        map.put(45,123);
        map.put("BB",56);
        //修改
        map.put("AA",87);

        System.out.println(map);

        Map map1 = new HashMap();
        map1.put("CC",123);
        map1.put("DD",123);

        map.putAll(map1);

        System.out.println(map);

        //remove(Object key)
        Object value = map.remove("CC");
        System.out.println(value);
        System.out.println(map);

        //clear()
        map.clear();//与map = null操作不同
        System.out.println(map.size());
        System.out.println(map);
    }
```



元素查询的操作：

* Object get(Object key)：获取指定key对应的value
* boolean containsKey(Object key)：是否包含指定的key
* boolean containsValue(Object value)：是否包含指定的value
* int size()：返回map中key-value对的个数
* boolean isEmpty()：判断当前map是否为空
* boolean equals(Object obj)：判断当前map和参数对象obj是否相等

```java
@Test
    public void test4(){
        Map map = new HashMap();
        map.put("AA",123);
        map.put(45,123);
        map.put("BB",56);
        // Object get(Object key)
        System.out.println(map.get(45));
        //containsKey(Object key)
        boolean isExist = map.containsKey("BB");
        System.out.println(isExist);

        isExist = map.containsValue(123);
        System.out.println(isExist);

        map.clear();

        System.out.println(map.isEmpty());

    }
```



元视图操作的方法：

* Set keySet()：返回所有key构成的Set集合
* Collection values()：返回所有value构成的Collection集合
* Set entrySet()：返回所有key-value对构成的Set集合

```java
 @Test
    public void test5(){
        Map map = new HashMap();
        map.put("AA",123);
        map.put(45,1234);
        map.put("BB",56);

        //遍历所有的key集：keySet()
        Set set = map.keySet();
            Iterator iterator = set.iterator();
            while(iterator.hasNext()){
                System.out.println(iterator.next());
        }
        System.out.println();
        //遍历所有的value集：values()
        Collection values = map.values();
        for(Object obj : values){
            System.out.println(obj);
        }
        System.out.println();
        //遍历所有的key-value
        //方式一：entrySet()
        Set entrySet = map.entrySet();
        Iterator iterator1 = entrySet.iterator();
        while (iterator1.hasNext()){
            Object obj = iterator1.next();
            //entrySet集合中的元素都是entry
            Map.Entry entry = (Map.Entry) obj;
            System.out.println(entry.getKey() + "---->" + entry.getValue());

        }
        System.out.println();
        //方式二：
        Set keySet = map.keySet();
        Iterator iterator2 = keySet.iterator();
        while(iterator2.hasNext()){
            Object key = iterator2.next();
            Object value = map.get(key);
            System.out.println(key + "=====" + value);

        }

    }
```



总结常用方法：

> ```
> * 添加：put(Object key,Object value)
> * 删除：remove(Object key)
> * 修改：put(Object key,Object value)
> * 查询：get(Object key)/Map.Entry下的getKey()/getValue()
> * 长度：size()
> * 遍历：keySet() / values() / entrySet()
> ```





## treeMap的使用

* 向TreeMap中添加key-value，==要求key必须是由同一个类创建的对象==
* 因为要照key进行排序：自然排序 、定制排序

User.java

```java
public class User implements Comparable{
    private String name;
    private int age;

    public User() {
    }

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

//    @Override
//    public boolean equals(Object o) {
//        System.out.println("User equals()....");
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//
//        User user = (User) o;
//
//        if (age != user.age) return false;
//        return name != null ? name.equals(user.name) : user.name == null;
//    }
//
//    @Override
//    public int hashCode() { //return name.hashCode() + age;
//        int result = name != null ? name.hashCode() : 0;
//        result = 31 * result + age;
//        return result;
//    }

    //按照姓名从大到小排列,年龄从小到大排列
    @Override
    public int compareTo(Object o) {
        if(o instanceof User){
            User user = (User)o;
//            return -this.name.compareTo(user.name);
            int compare = -this.name.compareTo(user.name);
            if(compare != 0){
                return compare;
            }else{
                return Integer.compare(this.age,user.age);
            }
        }else{
            throw new RuntimeException("输入的类型不匹配");
        }

    }
}
```



```java
public class TreeMapTest {

    //向TreeMap中添加key-value，要求key必须是由同一个类创建的对象
    //因为要按照key进行排序：自然排序 、定制排序
    //自然排序
    @Test
    public void test1(){
        TreeMap map = new TreeMap();
        User u1 = new User("Tom",23);
        User u2 = new User("Jerry",32);
        User u3 = new User("Jack",20);
        User u4 = new User("Rose",18);

        map.put(u1,98);
        map.put(u2,89);
        map.put(u3,76);
        map.put(u4,100);

        Set entrySet = map.entrySet();
        Iterator iterator1 = entrySet.iterator();
        while (iterator1.hasNext()){
            Object obj = iterator1.next();
            Map.Entry entry = (Map.Entry) obj;
            System.out.println(entry.getKey() + "---->" + entry.getValue());

        }
    }

    //定制排序
    @Test
    public void test2(){
        TreeMap map = new TreeMap(new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                if(o1 instanceof User && o2 instanceof User){
                    User u1 = (User)o1;
                    User u2 = (User)o2;
                    return Integer.compare(u1.getAge(),u2.getAge());
                }
                throw new RuntimeException("输入的类型不匹配！");
            }
        });
        User u1 = new User("Tom",23);
        User u2 = new User("Jerry",32);
        User u3 = new User("Jack",20);
        User u4 = new User("Rose",18);

        map.put(u1,98);
        map.put(u2,89);
        map.put(u3,76);
        map.put(u4,100);

        Set entrySet = map.entrySet();
        Iterator iterator1 = entrySet.iterator();
        while (iterator1.hasNext()){
            Object obj = iterator1.next();
            Map.Entry entry = (Map.Entry) obj;
            System.out.println(entry.getKey() + "---->" + entry.getValue());

        }
    }


}
```



## 使用Properties读取配置文件

```java
public class PropertiesTest {

    //Properties:常用来处理配置文件。key和value都是String类型
    public static void main(String[] args)  {
        FileInputStream fis = null;
        try {
            Properties pros = new Properties();

            fis = new FileInputStream("jdbc.properties");
            pros.load(fis);//加载流对应的文件

            String name = pros.getProperty("name");
            String password = pros.getProperty("password");

            System.out.println("name = " + name + ", password = " + password);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(fis != null){
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        }

    }
}
```







## Collections工具类的使用

1. 作用：操作Collection和Map的工具类

2. 常用方法：

   reverse(List)：反转 List 中元素的顺序
   shuffle(List)：对 List 集合元素进行随机排序
   sort(List)：根据元素的自然顺序对指定 List 集合元素升序排序
   sort(List，Comparator)：根据指定的 Comparator 产生的顺序对 List 集合元素进行排序
   swap(List，int， int)：将指定 list 集合中的 i 处元素和 j 处元素进行交换
   Object max(Collection)：根据元素的自然顺序，返回给定集合中的最大元素
   Object max(Collection，Comparator)：根据 Comparator 指定的顺序，返回给定集合中的最大元素
   Object min(Collection)
   Object min(Collection，Comparator)
   int frequency(Collection，Object)：返回指定集合中指定元素的出现次数
   void copy(List dest,List src)：将src中的内容复制到dest中
   boolean replaceAll(List list，Object oldVal，Object newVal)：使用新值替换 List 对象的所有旧值

   <a href="https://sm.ms/image/Q45NtrgnLSl8TWB" target="_blank"><img src="https://i.loli.net/2021/05/14/Q45NtrgnLSl8TWB.png" ></a>

   ==说明==：ArrayList和HashMap都是线程不安全的，如果程序要求线程安全，我们可以将ArrayList、HashMap转换为线程的。
   使用synchronizedList(List list） 和 synchronizedMap(Map map）

```java
public class CollectionsTest {

/*
reverse(List)：反转 List 中元素的顺序
shuffle(List)：对 List 集合元素进行随机排序
sort(List)：根据元素的自然顺序对指定 List 集合元素按升序排序
sort(List，Comparator)：根据指定的 Comparator 产生的顺序对 List 集合元素进行排序
swap(List，int， int)：将指定 list 集合中的 i 处元素和 j 处元素进行交换

Object max(Collection)：根据元素的自然顺序，返回给定集合中的最大元素
Object max(Collection，Comparator)：根据 Comparator 指定的顺序，返回给定集合中的最大元素
Object min(Collection)
Object min(Collection，Comparator)
int frequency(Collection，Object)：返回指定集合中指定元素的出现次数
void copy(List dest,List src)：将src中的内容复制到dest中
boolean replaceAll(List list，Object oldVal，Object newVal)：使用新值替换 List 对象的所有旧值

 */
    @Test
    public void test2(){
        List list = new ArrayList();
        list.add(123);
        list.add(43);
        list.add(765);
        list.add(-97);
        list.add(0);

        //报异常：IndexOutOfBoundsException("Source does not fit in dest")
//        List dest = new ArrayList();
//        Collections.copy(dest,list);
        //正确的：
        List dest = Arrays.asList(new Object[list.size()]);
        System.out.println(dest.size());//list.size();
        Collections.copy(dest,list);

        System.out.println(dest);


        /*
        Collections 类中提供了多个 synchronizedXxx() 方法，
        该方法可使将指定集合包装成线程同步的集合，从而可以解决
        多线程并发访问集合时的线程安全问题

         */
        //返回的list1即为线程安全的List
        List list1 = Collections.synchronizedList(list);


    }

    @Test
    public void test1(){
        List list = new ArrayList();
        list.add(123);
        list.add(43);
        list.add(765);
        list.add(765);
        list.add(765);
        list.add(-97);
        list.add(0);

        System.out.println(list);

//        Collections.reverse(list);
//        Collections.shuffle(list);
//        Collections.sort(list);
//        Collections.swap(list,1,2);
        int frequency = Collections.frequency(list, 123);

        System.out.println(list);
        System.out.println(frequency);

    }

}
```



### 面试题

面试题：Collection 和 Collections的区别？



# 十二、泛型

## 泛型的理解

1. 泛型的概念

   所谓泛型，就是允许在定义类、接口时通过一个标识表示类中某个属性的类型或者是某个方法的返回值及参数类型。这个类型参数将在使用时（例如，继承或实现这个接口，用这个类型声明变量、创建对象时确定（即传入实际的类型参数，也称为类型实参）。

2. 泛型的引入背景

   集合容器类在设计阶段/声明阶段不能确定这个容器到底实际存的是什么类型的对象，所以在JDK1.5之前只能把元素类型设计为Object，JDK1.5之后使用泛型来解决。因为这个时候除了元素的类型不确定，其他的部分是确定的，例如关于这个元素如何保存，如何管理等是确定的，因此此时把元素的类型设计成一个参数，这个类型参数叫做泛型。Collection<E>，List<E>，ArrayList<E>   这个<E>就是类型参数，即泛型。

## 泛型在集合中的使用

1. 在集合中使用泛型之前的例子

```java
//在集合中使用泛型之前的情况：
    @Test
    public void test1(){
        ArrayList list = new ArrayList();
        //需求：存放学生的成绩
        list.add(78);
        list.add(76);
        list.add(89);
        list.add(88);
        //问题一：类型不安全
//        list.add("Tom");

        for(Object score : list){
            //问题二：强转时，可能出现ClassCastException
            int stuScore = (Integer) score;

            System.out.println(stuScore);

        }

    }
```

图示：

<a href="https://sm.ms/image/TM4LrhuRP1FJxYV" target="_blank"><img src="https://i.loli.net/2021/05/17/TM4LrhuRP1FJxYV.png" ></a>

```java
//在集合中使用泛型的情况：以ArrayList为例
    @Test
    public void test2(){
       ArrayList<Integer> list =  new ArrayList<Integer>();

        list.add(78);
        list.add(87);
        list.add(99);
        list.add(65);
        //编译时，就会进行类型检查，保证数据的安全
//        list.add("Tom");

        //方式一：
//        for(Integer score : list){
//            //避免了强转操作
//            int stuScore = score;
//
//            System.out.println(stuScore);
//
//        }
        //方式二：
        Iterator<Integer> iterator = list.iterator();
        while(iterator.hasNext()){
            int stuScore = iterator.next();
            System.out.println(stuScore);
        }
        
    }
```



图示：

<a href="https://sm.ms/image/QRu2rwLtAGVf5nS" target="_blank"><img src="https://i.loli.net/2021/05/17/QRu2rwLtAGVf5nS.png" ></a>

3. 在集合中使用泛型例子2

   ```java 
   //在集合中使用泛型的情况：以HashMap为例
       @Test
       public void test3(){
   //        Map<String,Integer> map = new HashMap<String,Integer>();
           //jdk7新特性：类型推断
           Map<String,Integer> map = new HashMap<>();
   
           map.put("Tom",87);
           map.put("Jerry",87);
           map.put("Jack",67);
   
   //        map.put(123,"ABC");
           //泛型的嵌套
           Set<Map.Entry<String,Integer>> entry = map.entrySet();
           Iterator<Map.Entry<String, Integer>> iterator = entry.iterator();
   
           while(iterator.hasNext()){
               Map.Entry<String, Integer> e = iterator.next();
               String key = e.getKey();
               Integer value = e.getValue();
               System.out.println(key + "----" + value);
           }
   
       }
   ```

### 集合中使用泛型总结：

1. 集合接口或集合类在jdk5.0时都修改为带泛型的结构。

2. 在实例化集合类时，可以指明具体的泛型类型

3. 指明完以后，在集合类或接口中凡是定义类或接口时，内部结构（比如：方法、构造器、属性等）使用到类的泛型的位置，都指定为实例化的泛型类型。

   比如：add(E e)  --->实例化以后：add(Integer e)

4. ==注意点：泛型的类型必须是类，不能是基本数据类型。需要用到基本数据类型的位置，拿包装类替换==

5. 如果实例化时，没指明泛型的类型。默认类型为java.lang.Object类型。



## 自定义泛型类、泛型接口、泛型方法

1. 举例

   Order.java

   ```java
   public class Order<T> {
   
       String orderName;
       int orderId;
   
       //类的内部结构就可以使用类的泛型
   
       T orderT;
   
       public Order(){
           //编译不通过
   //        T[] arr = new T[10];
           //编译通过
           T[] arr = (T[]) new Object[10];
       }
   
       public Order(String orderName,int orderId,T orderT){
           this.orderName = orderName;
           this.orderId = orderId;
           this.orderT = orderT;
       }
   
       //如下的三个方法都不是泛型方法
       public T getOrderT(){
           return orderT;
       }
   
       public void setOrderT(T orderT){
           this.orderT = orderT;
       }
   
       @Override
       public String toString() {
           return "Order{" +
                   "orderName='" + orderName + '\'' +
                   ", orderId=" + orderId +
                   ", orderT=" + orderT +
                   '}';
       }
       //静态方法中不能使用类的泛型。
   //    public static void show(T orderT){
   //        System.out.println(orderT);
   //    }
   
       public void show(){
           //编译不通过
   //        try{
   //
   //
   //        }catch(T t){
   //
   //        }
   
       }
   
       //泛型方法：在方法中出现了泛型的结构，泛型参数与类的泛型参数没有任何关系。
       //换句话说，泛型方法所属的类是不是泛型类都没有关系。
       //泛型方法，可以声明为静态的。原因：泛型参数是在调用方法时确定的。并非在实例化类时确定。
       public static <E>  List<E> copyFromArrayToList(E[] arr){
   
           ArrayList<E> list = new ArrayList<>();
   
           for(E e : arr){
               list.add(e);
           }
           return list;
   
       }
   }
   ```

2. SubOrder.java

   ```java
   public class SubOrder extends Order<Integer> {//SubOrder:不是泛型类
   
   
       public static <E> List<E> copyFromArrayToList(E[] arr){
   
           ArrayList<E> list = new ArrayList<>();
   
           for(E e : arr){
               list.add(e);
           }
           return list;
   
       }
   
   
   }
   ```

   //实例化时，如下的代码是错误的
   SubOrder<Integer> o = new SubOrder<>();

   SubOrder1.java

   ```java
   public class SubOrder1<T> extends Order<T> {//SubOrder1<T>:仍然是泛型类
   }
   ```

3. 测试

   ```java
   public class GenericTest1 {
   
       @Test
       public void test1(){
           //如果定义了泛型类，实例化没有指明类的泛型，则认为此泛型类型为Object类型
           //要求：如果大家定义了类是带泛型的，建议在实例化时要指明类的泛型。
           Order order = new Order();
           order.setOrderT(123);
           order.setOrderT("ABC");
   
           //建议：实例化时指明类的泛型
           Order<String> order1 = new Order<String>("orderAA",1001,"order:AA");
   
           order1.setOrderT("AA:hello");
   
       }
   
       @Test
       public void test2(){
           SubOrder sub1 = new SubOrder();
           //由于子类在继承带泛型的父类时，指明了泛型类型。则实例化子类对象时，不再需要指明泛型。
           sub1.setOrderT(1122);
   
           SubOrder1<String> sub2 = new SubOrder1<>();
           sub2.setOrderT("order2...");
       }
   
       @Test
       public void test3(){
   
           ArrayList<String> list1 = null;
           ArrayList<Integer> list2 = new ArrayList<Integer>();
           //泛型不同的引用不能相互赋值。
   //        list1 = list2;
   
           Person p1 = null;
           Person p2 = null;
           p1 = p2;
   
   
       }
   
       //测试泛型方法
       @Test
       public void test4(){
           Order<String> order = new Order<>();
           Integer[] arr = new Integer[]{1,2,3,4};
           //泛型方法在调用时，指明泛型参数的类型。
           List<Integer> list = order.copyFromArrayToList(arr);
   
           System.out.println(list);
       }
   }
   ```

### 注意点



<a href="https://sm.ms/image/8ij9m7PNcZBxQTE" target="_blank"><img src="https://i.loli.net/2021/05/17/8ij9m7PNcZBxQTE.png" ></a>



<a href="https://sm.ms/image/lFpdfgrHwqbaPei" target="_blank"><img src="https://i.loli.net/2021/05/17/lFpdfgrHwqbaPei.png" ></a>



### 应用场景举例：

```java
/**
 * 定义个泛型类 DAO<T>，在其中定义一个Map 成员变量，Map 的键为 String 类型，值为 T 类型。

 分别创建以下方法：
 public void save(String id,T entity)： 保存 T 类型的对象到 Map 成员变量中
 public T get(String id)：从 map 中获取 id 对应的对象
 public void update(String id,T entity)：替换 map 中key为id的内容,改为 entity 对象
 public List<T> list()：返回 map 中存放的所有 T 对象
 public void delete(String id)：删除指定 id 对象

 *
 * @author shkstart
 * @create 2019 下午 3:34
 */
public class DAO<T> {

    private Map<String,T> map = new HashMap<String,T>();
    //保存 T 类型的对象到 Map 成员变量中
    public void save(String id,T entity){
        map.put(id,entity);
    }
    //从 map 中获取 id 对应的对象
    public T get(String id){
        return map.get(id);
    }
    //替换 map 中key为id的内容,改为 entity 对象
    public void update(String id,T entity){
        if(map.containsKey(id)){
            map.put(id,entity);
        }
    }
    //返回 map 中存放的所有 T 对象
    public List<T> list(){
        //错误的：
//        Collection<T> values = map.values();
//        return (List<T>) values;
        //正确的：
        ArrayList<T> list = new ArrayList<>();
        Collection<T> values = map.values();
        for(T t : values){
            list.add(t);
        }
        return list;

    }
    //删除指定 id 对象
    public void delete(String id){
        map.remove(id);
    }

}
```

```java
/**
 * 创建 DAO 类的对象， 分别调用其 save、get、update、list、delete 方法来操作 User 对象，
 使用 Junit 单元测试类进行测试。

 * @author shkstart
 * @create 2019 下午 3:45
 */
public class DAOTest {

    public static void main(String[] args) {
        DAO<User> dao = new DAO<User>();

        dao.save("1001",new User(1001,34,"周杰伦"));
        dao.save("1002",new User(1002,20,"昆凌"));
        dao.save("1003",new User(1003,25,"蔡依林"));

        dao.update("1003",new User(1003,30,"方文山"));

        dao.delete("1002");

        List<User> list = dao.list();
//        System.out.println(list);
        list.forEach(System.out::println);



    }

}
```

```java
/**
 * 定义一个 User 类：
 该类包含：private成员变量（int类型） id，age；（String 类型）name。

 * @author shkstart
 * @create 2019 下午 3:44
 */
public class User {

    private int id;
    private int age;
    private String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public User(int id, int age, String name) {

        this.id = id;
        this.age = age;
        this.name = name;
    }

    public User() {

    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", age=" + age +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (id != user.id) return false;
        if (age != user.age) return false;
        return name != null ? name.equals(user.name) : user.name == null;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + age;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }
}
```



## 泛型在继承上的体现

```java

    /*
    1. 泛型在继承方面的体现

      虽然类A是类B的父类，但是G<A> 和G<B>二者不具备子父类关系，二者是并列关系。

       补充：类A是类B的父类，A<G> 是 B<G> 的父类

     */
    @Test
    public void test1(){

        Object obj = null;
        String str = null;
        obj = str;

        Object[] arr1 = null;
        String[] arr2 = null;
        arr1 = arr2;
        //编译不通过
//        Date date = new Date();
//        str = date;
        List<Object> list1 = null;
        List<String> list2 = new ArrayList<String>();
        //此时的list1和list2的类型不具有子父类关系
        //编译不通过
//        list1 = list2;
        /*
        反证法：
        假设list1 = list2;
           list1.add(123);导致混入非String的数据。出错。

         */

        show(list1);
        show1(list2);

    }



    public void show1(List<String> list){

    }

    public void show(List<Object> list){

    }

    @Test
    public void test2(){

        AbstractList<String> list1 = null;
        List<String> list2 = null;
        ArrayList<String> list3 = null;

        list1 = list3;
        list2 = list3;

        List<String> list4 = new ArrayList<>();

    }
```



## 通配符

```java
    /*
    2. 通配符的使用
       通配符：?

       类A是类B的父类，G<A>和G<B>是没有关系的，二者共同的父类是：G<?>


     */

    @Test
    public void test3(){
        List<Object> list1 = null;
        List<String> list2 = null;

        List<?> list = null;

        list = list1;
        list = list2;
        //编译通过
//        print(list1);
//        print(list2);


        //
        List<String> list3 = new ArrayList<>();
        list3.add("AA");
        list3.add("BB");
        list3.add("CC");
        list = list3;
        //添加(写入)：对于List<?>就不能向其内部添加数据。
        //除了添加null之外。
//        list.add("DD");
//        list.add('?');

        list.add(null);

        //获取(读取)：允许读取数据，读取的数据类型为Object。
        Object o = list.get(0);
        System.out.println(o);


    }

    public void print(List<?> list){
        Iterator<?> iterator = list.iterator();
        while(iterator.hasNext()){
            Object obj = iterator.next();
            System.out.println(obj);
        }
    }
```



```java
    3.有限制条件的通配符的使用。
        ? extends A:
                G<? extends A> 可以作为G<A>和G<B>的父类，其中B是A的子类

        ? super A:
                G<? super A> 可以作为G<A>和G<B>的父类，其中B是A的父类

     */
    @Test
    public void test4(){

        List<? extends Person> list1 = null;
        List<? super Person> list2 = null;

        List<Student> list3 = new ArrayList<Student>();
        List<Person> list4 = new ArrayList<Person>();
        List<Object> list5 = new ArrayList<Object>();

        list1 = list3;
        list1 = list4;
//        list1 = list5;

//        list2 = list3;
        list2 = list4;
        list2 = list5;

        //读取数据：
        list1 = list3;
        Person p = list1.get(0);
        //编译不通过
        //Student s = list1.get(0);

        list2 = list4;
        Object obj = list2.get(0);
        ////编译不通过
//        Person obj = list2.get(0);

        //写入数据：
        //编译不通过
//        list1.add(new Student());

        //编译通过
        list2.add(new Person());
        list2.add(new Student());

    }

}
```





# 十三、IO流

## File类

### File类的理解

1. File类的一个对象，代表一个文件或一个文件目录(俗称：文件夹)
2. File类声明在java.io包下
3.  File类中涉及到关于文件或文件目录的==创建、删除、重命名、修改时间、文件大小==等方法，并未涉及到写入或读取文件内容的操作。如果需要读取或写入文件内容，必须使用IO流来完成。
4. 后续File类的对象常会作为参数传递到流的构造器中，指明读取或写入的“终点”。



### File的实例化

1. 常用构造器

   File(String filePath)

   File(String parentPath, String childPath)

   File(File parentFile, String childPath)

   ```java
   @Test
       public void test1(){
           //构造器1
           File file1 = new File("hello.txt");//相对于当前module
           File file2 =  new File("D:\\workspace_idea1\\JavaSenior\\day08\\he.txt");
   
           System.out.println(file1);
           System.out.println(file2);
   
           //构造器2：
           File file3 = new File("D:\\workspace_idea1","JavaSenior");
           System.out.println(file3);
   
           //构造器3：
           File file4 = new File(file3,"hi.txt");
           System.out.println(file4);
       }
   ```

   

2. 路径的分类

   相对路径：相较于某个路径下，指明的路径

   绝对路径：包含盘符在内的文件或文件目录的路径

   说明：

   IDEA中：如果大家开发使用JUnit中的单元测试方法测试，相对路径即为当前Module下。如果大家使用main()测试，相对路径即为当前的Project下。

   Eclipse中：不管使用单元测试方法还是使用main()测试，相对路径都是当前的Project下。

3. 路径分隔符

   windows和DOS系统默认使用“\”来表示

   UNIX和URL使用“/”来表示

   

### File类的常用方法

<a href="https://sm.ms/image/Sdwt2oWAMQJG465" target="_blank"><img src="https://i.loli.net/2021/05/21/Sdwt2oWAMQJG465.png" ></a>

```java
@Test
    public void test2(){
        File file1 = new File("hello.txt");
        File file2 = new File("d:\\io\\hi.txt");

        System.out.println(file1.getAbsolutePath());
        System.out.println(file1.getPath());
        System.out.println(file1.getName());
        System.out.println(file1.getParent());
        System.out.println(file1.length());
        System.out.println(new Date(file1.lastModified()));

        System.out.println();

        System.out.println(file2.getAbsolutePath());
        System.out.println(file2.getPath());
        System.out.println(file2.getName());
        System.out.println(file2.getParent());
        System.out.println(file2.length());
        System.out.println(file2.lastModified());
    }
```

```java
@Test
    public void test3(){
        File file = new File("D:\\");

        String[] list = file.list();
        for(String s : list){
            System.out.println(s);
        }

        System.out.println();

        File[] files = file.listFiles();
        for(File f : files){
            System.out.println(f);
        }

    }
```

```java
/*
    public boolean renameTo(File dest):把文件重命名为指定的文件路径
     比如：file1.renameTo(file2)为例：
        要想保证返回true,需要file1在硬盘中是存在的，且file2不能在硬盘中存在。
     */
    @Test
    public void test4(){
        File file1 = new File("hello.txt");
        File file2 = new File("D:\\hi.txt");

        boolean renameTo = file1.renameTo(file2);
        System.out.println(renameTo);

    }
```

<a href="https://sm.ms/image/jKas8vewEQhyIRD" target="_blank"><img src="https://i.loli.net/2021/05/21/jKas8vewEQhyIRD.png" ></a>

```java
@Test
    public void test5(){
        File file1 = new File("hello.txt");
//        file1 = new File("hello1.txt");

        System.out.println(file1.isDirectory());
        System.out.println(file1.isFile());
        System.out.println(file1.exists());
        System.out.println(file1.canRead());
        System.out.println(file1.canWrite());
        System.out.println(file1.isHidden());

        System.out.println();

        File file2 = new File("d:\\io");
//        file2 = new File("d:\\io1");
        System.out.println(file2.isDirectory());
        System.out.println(file2.isFile());
        System.out.println(file2.exists());
        System.out.println(file2.canRead());
        System.out.println(file2.canWrite());
        System.out.println(file2.isHidden());

    }
```

<a href="https://sm.ms/image/t7eF8NuCLhclVf3" target="_blank"><img src="https://i.loli.net/2021/05/21/t7eF8NuCLhclVf3.png" ></a>

```java
@Test
    public void test6() throws IOException {
        File file1 = new File("hi.txt");
        if(!file1.exists()){
            //文件的创建
            file1.createNewFile();
            System.out.println("创建成功");
        }else{//文件存在
            file1.delete();
            System.out.println("删除成功");
        }


    }
```

```java
@Test
    public void test7(){
        //文件目录的创建
        File file1 = new File("d:\\io\\io1\\io3");

        boolean mkdir = file1.mkdir();
        if(mkdir){
            System.out.println("创建成功1");
        }

        File file2 = new File("d:\\io\\io1\\io4");

        boolean mkdir1 = file2.mkdirs();
        if(mkdir1){
            System.out.println("创建成功2");
        }
        //要想删除成功，io4文件目录下不能有子目录或文件
        File file3 = new File("D:\\io\\io1\\io4");
//        file3 = new File("D:\\io\\io1");
        System.out.println(file3.delete());
    }
```



### File类举例

1. 创建一个与file同目录下的另一个文件

   ```java
   @Test
       public void test1() throws IOException {
           File file = new File("D:\\io\\io1\\hello.txt");
           //创建一个与file同目录下的另外一个文件，文件名为：haha.txt
           File destFile = new File(file.getParent(),"haha.txt");
           boolean newFile = destFile.createNewFile();
           if(newFile){
               System.out.println("创建成功！");
           }
       }
   ```

2. 判断指定目录下是否有后缀名为.jpg的文件，如果有，就输出该文件名称。

   ```java
   public class FindJPGFileTest {
   
   	@Test
   	public void test1(){
   		File srcFile = new File("d:\\code");
   		
   		String[] fileNames = srcFile.list();
   		for(String fileName : fileNames){
   			if(fileName.endsWith(".jpg")){
   				System.out.println(fileName);
   			}
   		}
   	}
   	@Test
   	public void test2(){
   		File srcFile = new File("d:\\code");
   		
   		File[] listFiles = srcFile.listFiles();
   		for(File file : listFiles){
   			if(file.getName().endsWith(".jpg")){
   				System.out.println(file.getAbsolutePath());
   			}
   		}
   	}
   ```

   ```java
   /*
   	 * File类提供了两个文件过滤器方法
   	 * public String[] list(FilenameFilter filter)
   	 * public File[] listFiles(FileFilter filter)
   
   	 */
   	@Test
   	public void test3(){
   		File srcFile = new File("d:\\code");
   		
   		File[] subFiles = srcFile.listFiles(new FilenameFilter() {
   			
   			@Override
   			public boolean accept(File dir, String name) {
   				return name.endsWith(".jpg");
   			}
   		});
   		
   		for(File file : subFiles){
   			System.out.println(file.getAbsolutePath());
   		}
   	}
   ```

   

3. 遍历指定目录所有文件名称，包括子文件目录中的文件。

   拓展1：并计算指定目录占用空间的大小

   拓展2：删除指定文件目录及其下的所有文件

   ```java
   public class ListFilesTest {
   
   	public static void main(String[] args) {
   		// 递归:文件目录
   		/** 打印出指定目录所有文件名称，包括子文件目录中的文件 */
   
   		// 1.创建目录对象
   		File dir = new File("E:\\teach\\01_javaSE\\_尚硅谷Java编程语言\\3_软件");
   
   		// 2.打印目录的子文件
   		printSubFile(dir);
   	}
   
   	public static void printSubFile(File dir) {
   		// 打印目录的子文件
   		File[] subfiles = dir.listFiles();
   
   		for (File f : subfiles) {
   			if (f.isDirectory()) {// 文件目录
   				printSubFile(f);
   			} else {// 文件
   				System.out.println(f.getAbsolutePath());
   			}
   
   		}
   	}
   
   	// 方式二：循环实现
   	// 列出file目录的下级内容，仅列出一级的话
   	// 使用File类的String[] list()比较简单
   	public void listSubFiles(File file) {
   		if (file.isDirectory()) {
   			String[] all = file.list();
   			for (String s : all) {
   				System.out.println(s);
   			}
   		} else {
   			System.out.println(file + "是文件！");
   		}
   	}
   
   	// 列出file目录的下级，如果它的下级还是目录，接着列出下级的下级，依次类推
   	// 建议使用File类的File[] listFiles()
   	public void listAllSubFiles(File file) {
   		if (file.isFile()) {
   			System.out.println(file);
   		} else {
   			File[] all = file.listFiles();
   			// 如果all[i]是文件，直接打印
   			// 如果all[i]是目录，接着再获取它的下一级
   			for (File f : all) {
   				listAllSubFiles(f);// 递归调用：自己调用自己就叫递归
   			}
   		}
   	}
   
   	// 拓展1：求指定目录所在空间的大小
   	// 求任意一个目录的总大小
   	public long getDirectorySize(File file) {
   		// file是文件，那么直接返回file.length()
   		// file是目录，把它的下一级的所有大小加起来就是它的总大小
   		long size = 0;
   		if (file.isFile()) {
   			size += file.length();
   		} else {
   			File[] all = file.listFiles();// 获取file的下一级
   			// 累加all[i]的大小
   			for (File f : all) {
   				size += getDirectorySize(f);// f的大小;
   			}
   		}
   		return size;
   	}
   
   	// 拓展2：删除指定的目录
   	public void deleteDirectory(File file) {
   		// 如果file是文件，直接delete
   		// 如果file是目录，先把它的下一级干掉，然后删除自己
   		if (file.isDirectory()) {
   			File[] all = file.listFiles();
   			// 循环删除的是file的下一级
   			for (File f : all) {// f代表file的每一个下级
   				deleteDirectory(f);
   			}
   		}
   		// 删除自己
   		file.delete();
   	}
   
   }
   ```




## IO流概述

### 流的分类

1. 操作数据的单位：字节流、字符流
2. 数据的流向：输入流、输出流
3. 流的角色：节点流、处理流

图示

<a href="https://sm.ms/image/xv3HmJQfh1GeFop" target="_blank"><img src="https://i.loli.net/2021/05/21/xv3HmJQfh1GeFop.png" ></a>



### 流的体系结构

![image-20210521171640390](C:\Users\Dell\AppData\Roaming\Typora\typora-user-images\image-20210521171640390.png)

重点说明的几个流结构

<a href="https://sm.ms/image/LsVAP6mj1yOdqQJ" target="_blank"><img src="https://i.loli.net/2021/05/21/LsVAP6mj1yOdqQJ.png" ></a>

### 输入、输出的标准化过程

1. 输入过程

   ① 创建File类的对象，指明读取的数据的来源。（要求此文件一定要存在）

   ② 创建相应的输入流，将File类的对象作为参数，传入流的构造器中

   ③ 具体的读入过程：

   ​			创建相应的byte[] 或 char[]。

   ④ 关闭流资源

   ==说明==：程序中出现的异常需要使用try-catch-finally处理。

2. 输出过程

   ① 创建File类的对象，指明写出的数据的位置。（不要求此文件一定要存在）

   ②创建相应的输出流，将File类的对象作为参数，传入流的构造器中。

   ③具体的写出过程：

    		write(char[]/byte[] buffer,0,len)

   ④关闭流资源

   ==说明==： 程序中出现的异常需要使用try-catch-finally

   

## 节点流（或文件流）

### FileReader/FileWriter的使用：

1. FileReader的使用

   read()的理解：返回读入的一个字符。如果达到文件末尾，返回-1

   read(char[] cbuf):返回每次读入cbuf数组中的字符的个数。如果达到文件末尾，返回-1

   异常的处理：为了保证流资源一定可以执行关闭操作。需要使用try-catch-finally处理

   读入的文件一定要存在，否则就会报FileNotFoundException。

   ```java
   @Test
       public void testFileReader(){
           FileReader fr = null;
           try {
               //1.实例化File类的对象，指明要操作的文件
               File file = new File("hello.txt");//相较于当前Module
               //2.提供具体的流
               fr = new FileReader(file);
   
               //3.数据的读入
               //read():返回读入的一个字符。如果达到文件末尾，返回-1
               //方式一：
   //        int data = fr.read();
   //        while(data != -1){
   //            System.out.print((char)data);
   //            data = fr.read();
   //        }
   
               //方式二：语法上针对于方式一的修改
               int data;
               while((data = fr.read()) != -1){
                   System.out.print((char)data);
               }
           } catch (IOException e) {
               e.printStackTrace();
           } finally {
               //4.流的关闭操作
   //            try {
   //                if(fr != null)
   //                    fr.close();
   //            } catch (IOException e) {
   //                e.printStackTrace();
   //            }
               //或
               if(fr != null){
                   try {
                       fr.close();
                   } catch (IOException e) {
                       e.printStackTrace();
                   }
               }
           }
   
       }
   
       //对read()操作升级：使用read的重载方法
       @Test
       public void testFileReader1()  {
           FileReader fr = null;
           try {
               //1.File类的实例化
               File file = new File("hello.txt");
   
               //2.FileReader流的实例化
               fr = new FileReader(file);
   
               //3.读入的操作
               //read(char[] cbuf):返回每次读入cbuf数组中的字符的个数。如果达到文件末尾，返回-1
               char[] cbuf = new char[5];
               int len;
               while((len = fr.read(cbuf)) != -1){
                   //方式一：
                   //错误的写法
   //                for(int i = 0;i < cbuf.length;i++){
   //                    System.out.print(cbuf[i]);
   //                }
                   //正确的写法
   //                for(int i = 0;i < len;i++){
   //                    System.out.print(cbuf[i]);
   //                }
                   //方式二：
                   //错误的写法,对应着方式一的错误的写法
   //                String str = new String(cbuf);
   //                System.out.print(str);
                   //正确的写法
                   String str = new String(cbuf,0,len);
                   System.out.print(str);
               }
           } catch (IOException e) {
               e.printStackTrace();
           } finally {
               if(fr != null){
                   //4.资源的关闭
                   try {
                       fr.close();
                   } catch (IOException e) {
                       e.printStackTrace();
                   }
   
               }
           }
   
       }
   ```

2. FileWriter的使用

   从内存中写出数据到硬盘的文件里。

   说明：

   1. 输出操作，对应的File可以不存在的。并不会报异常 

   2. File对应的硬盘中的文件如果不存在，在输出的过程中，会自动创建此文件。

      File对应的硬盘中的文件如果存在：

      ​	如果流使用的构造器是：FileWriter(file,false) / FileWriter(file):对原文件的==覆盖==

      ​	如果流使用的构造器是：FileWriter(file,true):不会对原文件覆盖，而是在原文件基础上追加内容

      ```java
      @Test
          public void testFileWriter() {
              FileWriter fw = null;
              try {
                  //1.提供File类的对象，指明写出到的文件
                  File file = new File("hello1.txt");
      
                  //2.提供FileWriter的对象，用于数据的写出
                  fw = new FileWriter(file,false);
      
                  //3.写出的操作
                  fw.write("I have a dream!\n");
                  fw.write("you need to have a dream!");
              } catch (IOException e) {
                  e.printStackTrace();
              } finally {
                  //4.流资源的关闭
                  if(fw != null){
      
                      try {
                          fw.close();
                      } catch (IOException e) {
                          e.printStackTrace();
                      }
                  }
              }
      
      
          }
      
          @Test
          public void testFileReaderFileWriter() {
              FileReader fr = null;
              FileWriter fw = null;
              try {
                  //1.创建File类的对象，指明读入和写出的文件
                  File srcFile = new File("hello.txt");
                  File destFile = new File("hello2.txt");
      
                  //不能使用字符流来处理图片等字节数据
      //            File srcFile = new File("爱情与友情.jpg");
      //            File destFile = new File("爱情与友情1.jpg");
      
      
                  //2.创建输入流和输出流的对象
                  fr = new FileReader(srcFile);
                  fw = new FileWriter(destFile);
      
      
                  //3.数据的读入和写出操作
                  char[] cbuf = new char[5];
                  int len;//记录每次读入到cbuf数组中的字符的个数
                  while((len = fr.read(cbuf)) != -1){
                      //每次写出len个字符
                      fw.write(cbuf,0,len);
      
                  }
              } catch (IOException e) {
                  e.printStackTrace();
              } finally {
                  //4.关闭流资源
                  //方式一：
      //            try {
      //                if(fw != null)
      //                    fw.close();
      //            } catch (IOException e) {
      //                e.printStackTrace();
      //            }finally{
      //                try {
      //                    if(fr != null)
      //                        fr.close();
      //                } catch (IOException e) {
      //                    e.printStackTrace();
      //                }
      //            }
                  //方式二：
                  try {
                      if(fw != null)
                          fw.close();
                  } catch (IOException e) {
                      e.printStackTrace();
                  }
      
                  try {
                      if(fr != null)
                          fr.close();
                  } catch (IOException e) {
                      e.printStackTrace();
                  }
      
              }
      
          }
      
      }
      ```

      

### FileInputStream/FileOutputStream的使用：

测试FileInputStream和FileOutputStream的使用

结论：

对于文本文件(.txt,.java,.c,.cpp)，使用字符流处理

对于非文本文件(.jpg,.mp3,.mp4,.avi,.doc,.ppt,...)，使用字节流处理

```java
@Test
    public void testFileInputOutputStream()  {
        FileInputStream fis = null;
        FileOutputStream fos = null;
        try {
            //1.造文件
            File srcFile = new File("爱情与友情.jpg");
            File destFile = new File("爱情与友情2.jpg");

            //2.造流
            fis = new FileInputStream(srcFile);
            fos = new FileOutputStream(destFile);

            //复制的过程
            byte[] buffer = new byte[5];
            int len;
            while((len = fis.read(buffer)) != -1){
                fos.write(buffer,0,len);
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(fos != null){
                //
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(fis != null){
                //4.关闭流
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        }

    }
```



## 缓冲流的使用

### 缓冲流涉及到的类及作用：

BufferedInputStream

BufferedOutputStream

BufferedReader

BufferedWriter

作用：提高流的读取、写入的速度

提高读写速度的原因：内部提供了一个缓冲区。默认情况下是8kb

处理流，就是“套接”在已有的流的基础上

<a href="https://sm.ms/image/wUNyARLc8S5JGz6" target="_blank"><img src="https://i.loli.net/2021/05/21/wUNyARLc8S5JGz6.png" ></a>



### BufferedInputStream和BufferedOutputStream使用

```java
/*
    实现非文本文件的复制
     */
    @Test
    public void BufferedStreamTest() throws FileNotFoundException {
        BufferedInputStream bis = null;
        BufferedOutputStream bos = null;

        try {
            //1.造文件
            File srcFile = new File("爱情与友情.jpg");
            File destFile = new File("爱情与友情3.jpg");
            //2.造流
            //2.1 造节点流
            FileInputStream fis = new FileInputStream((srcFile));
            FileOutputStream fos = new FileOutputStream(destFile);
            //2.2 造缓冲流
            bis = new BufferedInputStream(fis);
            bos = new BufferedOutputStream(fos);

            //3.复制的细节：读取、写入
            byte[] buffer = new byte[10];
            int len;
            while((len = bis.read(buffer)) != -1){
                bos.write(buffer,0,len);

//                bos.flush();//刷新缓冲区

            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //4.资源关闭
            //要求：先关闭外层的流，再关闭内层的流
            if(bos != null){
                try {
                    bos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
            if(bis != null){
                try {
                    bis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
            //说明：关闭外层流的同时，内层流也会自动的进行关闭。关于内层流的关闭，我们可以省略.
//        fos.close();
//        fis.close();
        }
    }

    //实现文件复制的方法
    public void copyFileWithBuffered(String srcPath,String destPath){
        BufferedInputStream bis = null;
        BufferedOutputStream bos = null;

        try {
            //1.造文件
            File srcFile = new File(srcPath);
            File destFile = new File(destPath);
            //2.造流
            //2.1 造节点流
            FileInputStream fis = new FileInputStream((srcFile));
            FileOutputStream fos = new FileOutputStream(destFile);
            //2.2 造缓冲流
            bis = new BufferedInputStream(fis);
            bos = new BufferedOutputStream(fos);

            //3.复制的细节：读取、写入
            byte[] buffer = new byte[1024];
            int len;
            while((len = bis.read(buffer)) != -1){
                bos.write(buffer,0,len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //4.资源关闭
            //要求：先关闭外层的流，再关闭内层的流
            if(bos != null){
                try {
                    bos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
            if(bis != null){
                try {
                    bis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
            //说明：关闭外层流的同时，内层流也会自动的进行关闭。关于内层流的关闭，我们可以省略.
//        fos.close();
//        fis.close();
        }
    }
```



###  使用BufferedReader和BufferedWriter：处理文本文件

```java
    /*
    使用BufferedReader和BufferedWriter实现文本文件的复制

     */
    @Test
    public void testBufferedReaderBufferedWriter(){
        BufferedReader br = null;
        BufferedWriter bw = null;
        try {
            //创建文件和相应的流
            br = new BufferedReader(new FileReader(new File("dbcp.txt")));
            bw = new BufferedWriter(new FileWriter(new File("dbcp1.txt")));

            //读写操作
            //方式一：使用char[]数组
//            char[] cbuf = new char[1024];
//            int len;
//            while((len = br.read(cbuf)) != -1){
//                bw.write(cbuf,0,len);
//    //            bw.flush();
//            }

            //方式二：使用String
            String data;
            while((data = br.readLine()) != null){
                //方法一：
//                bw.write(data + "\n");//data中不包含换行符
                //方法二：
                bw.write(data);//data中不包含换行符
                bw.newLine();//提供换行的操作

            }


        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //关闭资源
            if(bw != null){

                try {
                    bw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(br != null){
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        }

    }
```



## 转换流的使用

1. 转换流涉及到的类：属于字符流

   InputStreamReader：将一个字节的输入流转换为字符的输入流

   解码：字节、字节数组  --->字符数组、字符串

   OutputStreamWriter：将一个字符的输出流转换为字节的输出流

   编码：字符数组、字符串----->字节、字节数组

   说明：编码决定了解码的方式

2. 作用：提供字节流与字符流之间的转换

   图示

   <a href="https://sm.ms/image/osByfTKuHr9nEd5" target="_blank"><img src="https://i.loli.net/2021/05/21/osByfTKuHr9nEd5.png" ></a>

   

3. 典型实现

   ```java
   /*
       此时处理异常的话，仍然应该使用try-catch-finally
       InputStreamReader的使用，实现字节的输入流到字符的输入流的转换
        */
       @Test
       public void test1() throws IOException {
   
           FileInputStream fis = new FileInputStream("dbcp.txt");
   //        InputStreamReader isr = new InputStreamReader(fis);//使用系统默认的字符集
           //参数2指明了字符集，具体使用哪个字符集，取决于文件dbcp.txt保存时使用的字符集
           InputStreamReader isr = new InputStreamReader(fis,"UTF-8");//使用系统默认的字符集
   
           char[] cbuf = new char[20];
           int len;
           while((len = isr.read(cbuf)) != -1){
               String str = new String(cbuf,0,len);
               System.out.print(str);
           }
   
           isr.close();
   
       }
   
       /*
       此时处理异常的话，仍然应该使用try-catch-finally
   
       综合使用InputStreamReader和OutputStreamWriter
        */
       @Test
       public void test2() throws Exception {
           //1.造文件、造流
           File file1 = new File("dbcp.txt");
           File file2 = new File("dbcp_gbk.txt");
   
           FileInputStream fis = new FileInputStream(file1);
           FileOutputStream fos = new FileOutputStream(file2);
   
           InputStreamReader isr = new InputStreamReader(fis,"utf-8");
           OutputStreamWriter osw = new OutputStreamWriter(fos,"gbk");
   
           //2.读写过程
           char[] cbuf = new char[20];
           int len;
           while((len = isr.read(cbuf)) != -1){
               osw.write(cbuf,0,len);
           }
   
           //3.关闭资源
           isr.close();
           osw.close();
   
   
       }
   
   
   }
   ```

   



## 编码集

1. 常见的编码表

   ASCII：美国标准信息交换码。
   		用一个字节的7位可以表示。
   ISO8859-1：拉丁码表。欧洲码表
   		用一个字节的8位表示。
   GB2312：中国的中文编码表。最多两个字节编码所有字符
   GBK：中国的中文编码表升级，融合了更多的中文文字符号。最多两个字节编码
   Unicode：国际标准码，融合了目前人类使用的所字符。为每个字符分配唯一的字符码。所有的文字都用两个字节来表示。
   UTF-8：变长的编码方式，可用1-4个字节来表示一个字符

2. 对后面学习的启示

   客户端/浏览器端    <---->  后台(java,GO,Python,Node.js,php)   <----> 数据库

   要求前前后后使用的字符集都要统一：UTF-8.



## 其它的流的使用

1. 标准的输入输出流：

   System.in:标准的输入流，默认从键盘输入

   System.out：标准的输出流，默认从控制台输出

   修改默认的输入和输出行为：

   System类的setIn(InputStream is )/setOut(PrintStream ps)方式重新指定输入和输出的流。

   练习：

   ```
   从键盘输入字符串，要求将读取到的整行字符串转成大写输出。然后继续进行输入操作，
   直至当输入“e”或者“exit”时，退出程序。
   方法一：使用Scanner实现，调用next()返回一个字符串
   方法二：使用System.in实现。System.in  --->  转换流 ---> BufferedReader的readLine()
   ```

   ```java
   public static void main(String[] args) {
           BufferedReader br = null;
           try {
               InputStreamReader isr = new InputStreamReader(System.in);
               br = new BufferedReader(isr);
   
               while (true) {
                   System.out.println("请输入字符串：");
                   String data = br.readLine();
                   if ("e".equalsIgnoreCase(data) || "exit".equalsIgnoreCase(data)) {
                       System.out.println("程序结束");
                       break;
                   }
   
                   String upperCase = data.toUpperCase();
                   System.out.println(upperCase);
   
               }
           } catch (IOException e) {
               e.printStackTrace();
           } finally {
               if (br != null) {
                   try {
                       br.close();
                   } catch (IOException e) {
                       e.printStackTrace();
                   }
   
               }
           }
       }
   ```

   

2. 打印流：

   PrintStream和PrintWriter

   说明：

   提供了一系列重载的print()和println()方法，用于多种数据类型的输出

   System.out返回的是PrintStream的实例

   练习：

   ```java
   @Test
       public void test2() {
           PrintStream ps = null;
           try {
               FileOutputStream fos = new FileOutputStream(new File("D:\\IO\\text.txt"));
               // 创建打印输出流,设置为自动刷新模式(写入换行符或字节 '\n' 时都会刷新输出缓冲区)
               ps = new PrintStream(fos, true);
               if (ps != null) {// 把标准输出流(控制台输出)改成文件
                   System.setOut(ps);
               }
   
   
               for (int i = 0; i <= 255; i++) { // 输出ASCII字符
                   System.out.print((char) i);
                   if (i % 50 == 0) { // 每50个数据一行
                       System.out.println(); // 换行
                   }
               }
   
   
           } catch (FileNotFoundException e) {
               e.printStackTrace();
           } finally {
               if (ps != null) {
                   ps.close();
               }
           }
   
       }
   ```

   

3. 数据流

   DataInputStream和DataOutputStream

   作用：

   用于读取或写出基本数据类型的变量或字符串

   练习：将内存中的字符串、基本数据类型的变量写出到文件中。

   注意：处理异常的话，仍然应该使用try-catch-finally.

   ```java
   @Test
       public void test3() throws IOException {
           //1.
           DataOutputStream dos = new DataOutputStream(new FileOutputStream("data.txt"));
           //2.
           dos.writeUTF("刘建辰");
           dos.flush();//刷新操作，将内存中的数据写入文件
           dos.writeInt(23);
           dos.flush();
           dos.writeBoolean(true);
           dos.flush();
           //3.
           dos.close();
   
   
       }
   ```

   练习：

   将文件中存储的基本数据类型变量和字符串读取到内存中，保存在变量中。

   注意点：读取不同类型的数据的顺序要与当初写入文件时，保存的数据的顺序一致！

   ```java
   @Test
   public void test4() throws IOException {
       //1.
       DataInputStream dis = new DataInputStream(new FileInputStream("data.txt"));
       //2.
       String name = dis.readUTF();
       int age = dis.readInt();
       boolean isMale = dis.readBoolean();
   
       System.out.println("name = " + name);
       System.out.println("age = " + age);
       System.out.println("isMale = " + isMale);
   
       //3.
       dis.close();
   
   }
   ```

   

## 对象流的使用

1. 对象流：

   ObjectInputStream和ObjectOutputStream

2. 作用：

   ObjectOutputStream：内存中的对象------>存储中的文件、通过网络传输出去：序列化过程

   ObjectInputStream:存储中的文件、通过网络接收过来 --->内存中的对象：反序列化过程

3. 对象的序列化机制：

   对象序列化机制允许把内存中的Java对象转换成平台无关的二进制流，从而允许把这种二进制流持久地保存在磁盘上，或通过网络将这种二进制流传输到另一个网络节点。当其它程序获取了这种二进制流，就可以恢复成原来的Java对象。

   ```java
   public class ObjectInputOutputStreamTest {
   
       /*
       序列化过程：将内存中的java对象保存到磁盘中或通过网络传输出去
       使用ObjectOutputStream实现
        */
       @Test
       public void testObjectOutputStream(){
           ObjectOutputStream oos = null;
   
           try {
               //1.
               oos = new ObjectOutputStream(new FileOutputStream("object.dat"));
               //2.
               oos.writeObject(new String("我爱北京天安门"));
               oos.flush();//刷新操作
   
               oos.writeObject(new Person("王铭",23));
               oos.flush();
   
               oos.writeObject(new Person("张学良",23,1001,new Account(5000)));
               oos.flush();
   
           } catch (IOException e) {
               e.printStackTrace();
           } finally {
               if(oos != null){
                   //3.
                   try {
                       oos.close();
                   } catch (IOException e) {
                       e.printStackTrace();
                   }
   
               }
           }
   
       }
   
       /*
       反序列化：将磁盘文件中的对象还原为内存中的一个java对象
       使用ObjectInputStream来实现
        */
       @Test
       public void testObjectInputStream(){
           ObjectInputStream ois = null;
           try {
               ois = new ObjectInputStream(new FileInputStream("object.dat"));
   
               Object obj = ois.readObject();
               String str = (String) obj;
   
               Person p = (Person) ois.readObject();
               Person p1 = (Person) ois.readObject();
   
               System.out.println(str);
               System.out.println(p);
               System.out.println(p1);
   
           } catch (IOException e) {
               e.printStackTrace();
           } catch (ClassNotFoundException e) {
               e.printStackTrace();
           } finally {
               if(ois != null){
                   try {
                       ois.close();
                   } catch (IOException e) {
                       e.printStackTrace();
                   }
   
               }
           }
   
   
   
       }
   
   }
   ```

4. 实现序列化的对象所属的类需要满足：

   1. 需要实现接口：Serializable

   2. 当前类提供一个全局常量：serialVersionUID

   3. 除了当前Person类需要实现Serializable接口之外，还必须保证其内部所属性也必须是可序列化的。（默认情况下，基本数据类型可序列化）

      补充：ObjectOutputStream和ObjectInputStream不能序列化static和transient修饰的成员变量

      ```java
      public class Person implements Serializable{
      
          public static final long serialVersionUID = 475463534532L;
      
          private String name;
          private int age;
          private int id;
          private Account acct;
      
          public Person(String name, int age, int id) {
              this.name = name;
              this.age = age;
              this.id = id;
          }
      
          public Person(String name, int age, int id, Account acct) {
              this.name = name;
              this.age = age;
              this.id = id;
              this.acct = acct;
          }
      
          @Override
          public String toString() {
              return "Person{" +
                      "name='" + name + '\'' +
                      ", age=" + age +
                      ", id=" + id +
                      ", acct=" + acct +
                      '}';
          }
      
          public int getId() {
              return id;
          }
      
          public void setId(int id) {
              this.id = id;
          }
      
          public String getName() {
              return name;
          }
      
          public void setName(String name) {
              this.name = name;
          }
      
          public int getAge() {
              return age;
          }
      
          public void setAge(int age) {
              this.age = age;
          }
      
          public Person(String name, int age) {
      
              this.name = name;
              this.age = age;
          }
      
          public Person() {
      
          }
      }
      
      class Account implements Serializable{
          public static final long serialVersionUID = 4754534532L;
          private double balance;
      
          @Override
          public String toString() {
              return "Account{" +
                      "balance=" + balance +
                      '}';
          }
      
          public double getBalance() {
              return balance;
          }
      
          public void setBalance(double balance) {
              this.balance = balance;
          }
      
          public Account(double balance) {
      
              this.balance = balance;
          }
      }
      ```



## RandomAccessFile的使用

1. 随机存取文件流：RandomAccessFile

2. 使用说明

   1. RandomAccessFile直接继承于java.lang.Object类，实现了DataInput和DataOutput接口
   2. RandomAccessFile==既可以作为一个输入流，又可以作为一个输出流==
   3. 如果RandomAccessFile作为输出流时，写出到的文件如果不存在，则在执行过程中自动创建。如果写出到的文件存在，则会对原文件内容进行覆盖。（默认情况下，从头覆盖）
   4. 可以通过相关的操作，实现RandomAccessFile“插入”数据的效果。seek(int pos)

   ```java
   public class RandomAccessFileTest {
   
       @Test
       public void test1() {
   
           RandomAccessFile raf1 = null;
           RandomAccessFile raf2 = null;
           try {
               //1.
               raf1 = new RandomAccessFile(new File("爱情与友情.jpg"),"r");
               raf2 = new RandomAccessFile(new File("爱情与友情1.jpg"),"rw");
               //2.
               byte[] buffer = new byte[1024];
               int len;
               while((len = raf1.read(buffer)) != -1){
                   raf2.write(buffer,0,len);
               }
           } catch (IOException e) {
               e.printStackTrace();
           } finally {
               //3.
               if(raf1 != null){
                   try {
                       raf1.close();
                   } catch (IOException e) {
                       e.printStackTrace();
                   }
   
               }
               if(raf2 != null){
                   try {
                       raf2.close();
                   } catch (IOException e) {
                       e.printStackTrace();
                   }
   
               }
           }
       }
   
       @Test
       public void test2() throws IOException {
   
           RandomAccessFile raf1 = new RandomAccessFile("hello.txt","rw");
   
           raf1.seek(3);//将指针调到角标为3的位置
           raf1.write("xyz".getBytes());//
   
           raf1.close();
   
       }
       /*
       使用RandomAccessFile实现数据的插入效果
        */
       @Test
       public void test3() throws IOException {
   
           RandomAccessFile raf1 = new RandomAccessFile("hello.txt","rw");
   
           raf1.seek(3);//将指针调到角标为3的位置
           //保存指针3后面的所有数据到StringBuilder中
           StringBuilder builder = new StringBuilder((int) new File("hello.txt").length());
           byte[] buffer = new byte[20];
           int len;
           while((len = raf1.read(buffer)) != -1){
               builder.append(new String(buffer,0,len)) ;
           }
           //调回指针，写入“xyz”
           raf1.seek(3);
           raf1.write("xyz".getBytes());
   
           //将StringBuilder中的数据写入到文件中
           raf1.write(builder.toString().getBytes());
   
           raf1.close();
   
           //思考：将StringBuilder替换为ByteArrayOutputStream
       }
   }
   ```



## Path、Paths、Files的说明

1. NIO的使用说明：

   >Java NIO (New IO，Non-Blocking IO)是从Java 1.4版本开始引入的一套新的IO API，可以替代标准的Java 
   >IO AP。
   >NIO与原来的IO同样的作用和目的，但是使用的方式完全不同，NIO支持面向缓冲区的(IO是面向流的)、基于
   >通道的IO操作。
   >NIO将以更加高效的方式进行文件的读写操作。
   >随着 JDK 7 的发布，Java对NIO进行了极大的扩展，增强了对文件处理和文件系统特性的支持，以至于我们称他们为 NIO.2。

2. Path的使用 ---jdk7提供

   1. Path的说明：Path替换原有的File类。

   2. 如何实例化：

      <a href="https://sm.ms/image/lNpyGWjIV8nfrw9" target="_blank"><img src="https://i.loli.net/2021/05/22/lNpyGWjIV8nfrw9.png" ></a>

   3. 常用方法

      <a href="https://sm.ms/image/sjIM5nzTE9ubVka" target="_blank"><img src="https://i.loli.net/2021/05/22/sjIM5nzTE9ubVka.png" ></a>

3. Files工具类 ---jdk7提供

   1. 作用

      操作文件或文件目录的工具类

   2. 常用方法：

   <a href="https://sm.ms/image/ugqN7kdEb3MDGjS" target="_blank"><img src="https://i.loli.net/2021/05/22/ugqN7kdEb3MDGjS.png" ></a>

   <a href="https://sm.ms/image/8tCrFbuHi69aAIS" target="_blank"><img src="https://i.loli.net/2021/05/22/8tCrFbuHi69aAIS.png" ></a>

   

   

   

## 经典例题统计字符出现次数

```java
/**
 * 练习3:获取文本上字符出现的次数,把数据写入文件
 *
 * 思路：
 * 1.遍历文本每一个字符
 * 2.字符出现的次数存在Map中
 *
 * Map<Character,Integer> map = new HashMap<Character,Integer>();
 * map.put('a',18);
 * map.put('你',2);
 *
 * 3.把map中的数据写入文件
 *
 * @author shkstart
 * @create 2019 下午 3:47
 */
public class WordCount {
    /*
    说明：如果使用单元测试，文件相对路径为当前module
          如果使用main()测试，文件相对路径为当前工程
     */
    @Test
    public void testWordCount() {
        FileReader fr = null;
        BufferedWriter bw = null;
        try {
            //1.创建Map集合
            Map<Character, Integer> map = new HashMap<Character, Integer>();

            //2.遍历每一个字符,每一个字符出现的次数放到map中
            fr = new FileReader("dbcp.txt");
            int c = 0;
            while ((c = fr.read()) != -1) {
                //int 还原 char
                char ch = (char) c;
                // 判断char是否在map中第一次出现
                if (map.get(ch) == null) {
                    map.put(ch, 1);
                } else {
                    map.put(ch, map.get(ch) + 1);
                }
            }

            //3.把map中数据存在文件count.txt
            //3.1 创建Writer
            bw = new BufferedWriter(new FileWriter("wordcount.txt"));

            //3.2 遍历map,再写入数据
            Set<Map.Entry<Character, Integer>> entrySet = map.entrySet();
            for (Map.Entry<Character, Integer> entry : entrySet) {
                switch (entry.getKey()) {
                    case ' ':
                        bw.write("空格=" + entry.getValue());
                        break;
                    case '\t'://\t表示tab 键字符
                        bw.write("tab键=" + entry.getValue());
                        break;
                    case '\r'://
                        bw.write("回车=" + entry.getValue());
                        break;
                    case '\n'://
                        bw.write("换行=" + entry.getValue());
                        break;
                    default:
                        bw.write(entry.getKey() + "=" + entry.getValue());
                        break;
                }
                bw.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //4.关流
            if (fr != null) {
                try {
                    fr.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
            if (bw != null) {
                try {
                    bw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        }

    }
}
```







# 十四、网络编程

## InetAddress类的使用

1. 实现网络通信需要解决的两个问题

   1. 如何准确地定位网络上一台或多态主机；定位主机上的特定的应用
   2. 找到主机后如何可靠高效地进行数据传输

2. 网络通信的两个要素：

   1. 对应问题一：IP和端口号
   2. 对应问题二：提供网络通信协议；TCP/IP参考模型（应用层、传输层、网络层、物理+数据链路层）

3. 通信要素一：IP和端口号

   1. IP的理解

      * IP:唯一的标识Internet上的计算机（通信实体）

      * 在java中使用InetAddress类代表IP

      * IP分类：IPv4和IPv6；万维网和局域网

      * 域名：www.baidu.com   www.mi.com  www.sina.com  www.jd.com

        域名解析：域名容易记忆，当在连接网络时输入一个主机的域名后，域名服务器（DNS）负责将域名转化成IP地址，这样才能和主机建立连接。

      * 本地回路地址：127.0.0.1对应这：localhost

   2. InetAddress类：此类的一个对象就代表这一个具体的IP地址

      * 实例化

        getByName(String host)、getLocalHost()

      * 常用方法

        getHostName()/getHostAddress()

        ```java
        public class InetAddressTest {
        
            public static void main(String[] args) {
        
                try {
                    //File file = new File("hello.txt");
                    InetAddress inet1 = InetAddress.getByName("192.168.10.14");
        
                    System.out.println(inet1);
        
                    InetAddress inet2 = InetAddress.getByName("www.atguigu.com");
                    System.out.println(inet2);
        
                    InetAddress inet3 = InetAddress.getByName("127.0.0.1");
                    System.out.println(inet3);
        
                    //获取本地ip
                    InetAddress inet4 = InetAddress.getLocalHost();
                    System.out.println(inet4);
        
                    //getHostName()
                    System.out.println(inet2.getHostName());
                    //getHostAddress()
                    System.out.println(inet2.getHostAddress());
        
                } catch (UnknownHostException e) {
                    e.printStackTrace();
                }
        
        
            }
        }
        ```

        

   3. 端口号：正在计算机上运行的进程。

      * 要求：不同的进程不同的端口号
      * 范围：被规定为一个16位的整数0~65535

      端口号与IP地址的组合得出一个网络套接字：Socket

4. 通信要素二：网络通信协议

   * 分型模型

     <a href="https://sm.ms/image/d8DcxEjnXW5eR17" target="_blank"><img src="https://i.loli.net/2021/05/22/d8DcxEjnXW5eR17.png" ></a>

   * TCP和UDP的区别

     <a href="https://sm.ms/image/aPmdM1gy62kRJni" target="_blank"><img src="https://i.loli.net/2021/05/22/aPmdM1gy62kRJni.png" ></a>

   * TCP三次握手和四次挥手

     <a href="https://sm.ms/image/zgRQvElG23KTuPt" target="_blank"><img src="https://i.loli.net/2021/05/22/zgRQvElG23KTuPt.png" ></a>

     <a href="https://sm.ms/image/ljTROir4ptQxFgL" target="_blank"><img src="https://i.loli.net/2021/05/22/ljTROir4ptQxFgL.png" ></a>





## TCP网络编程

### 例子一

客户端发送信息给服务端，服务端将数据显示在控制台上

```java
 //客户端
    @Test
    public void client()  {
        Socket socket = null;
        OutputStream os = null;
        try {
            //1.创建Socket对象，指明服务器端的ip和端口号
            InetAddress inet = InetAddress.getByName("127.0.0.1");
            socket = new Socket(inet,8899);
            //2.获取一个输出流，用于输出数据
            os = socket.getOutputStream();
            //3.写出数据的操作
            os.write("你好，我是客户端mm".getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //4.资源的关闭
            if(os != null) {
                try {
                    os.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
            if(socket != null){
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        }



    }
    //服务端
    @Test
    public void server()  {

        ServerSocket ss = null;
        Socket socket = null;
        InputStream is = null;
        ByteArrayOutputStream baos = null;
        try {
            //1.创建服务器端的ServerSocket，指明自己的端口号
            ss = new ServerSocket(8899);
            //2.调用accept()表示接收来自于客户端的socket
            socket = ss.accept();
            //3.获取输入流
            is = socket.getInputStream();

            //不建议这样写，可能会有乱码
//        byte[] buffer = new byte[1024];
//        int len;
//        while((len = is.read(buffer)) != -1){
//            String str = new String(buffer,0,len);
//            System.out.print(str);
//        }
            //4.读取输入流中的数据
            baos = new ByteArrayOutputStream();
            byte[] buffer = new byte[5];
            int len;
            while((len = is.read(buffer)) != -1){
                baos.write(buffer,0,len);
            }

            System.out.println(baos.toString());

            System.out.println("收到了来自于：" + socket.getInetAddress().getHostAddress() + "的数据");

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(baos != null){
                //5.关闭资源
                try {
                    baos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(is != null){
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(socket != null){
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(ss != null){
                try {
                    ss.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }
 }
```



### 例子二

客户端发送文件给服务器，服务器将文件保存在本地

```java
    /*
    这里涉及到的异常，应该使用try-catch-finally处理
     */
    @Test
    public void client() throws IOException {
        //1.
        Socket socket = new Socket(InetAddress.getByName("127.0.0.1"),9090);
        //2.
        OutputStream os = socket.getOutputStream();
        //3.
        FileInputStream fis = new FileInputStream(new File("beauty.jpg"));
        //4.
        byte[] buffer = new byte[1024];
        int len;
        while((len = fis.read(buffer)) != -1){
            os.write(buffer,0,len);
        }
        //5.
        fis.close();
        os.close();
        socket.close();
    }

    /*
    这里涉及到的异常，应该使用try-catch-finally处理
     */
    @Test
    public void server() throws IOException {
        //1.
        ServerSocket ss = new ServerSocket(9090);
        //2.
        Socket socket = ss.accept();
        //3.
        InputStream is = socket.getInputStream();
        //4.
        FileOutputStream fos = new FileOutputStream(new File("beauty1.jpg"));
        //5.
        byte[] buffer = new byte[1024];
        int len;
        while((len = is.read(buffer)) != -1){
            fos.write(buffer,0,len);
        }
        //6.
        fos.close();
        is.close();
        socket.close();
        ss.close();

    }
```





### 例子三

从客户端发送文件给服务器，服务器保存到本地。并返回“发送成功”给客户端。并关闭相应的连接

```java
/*
        这里涉及到的异常，应该使用try-catch-finally处理
         */
    @Test
    public void client() throws IOException {
        //1.
        Socket socket = new Socket(InetAddress.getByName("127.0.0.1"),9090);
        //2.
        OutputStream os = socket.getOutputStream();
        //3.
        FileInputStream fis = new FileInputStream(new File("beauty.jpg"));
        //4.
        byte[] buffer = new byte[1024];
        int len;
        while((len = fis.read(buffer)) != -1){
            os.write(buffer,0,len);
        }
        //关闭数据的输出
        socket.shutdownOutput();

        //5.接收来自于服务器端的数据，并显示到控制台上
        InputStream is = socket.getInputStream();
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        byte[] bufferr = new byte[20];
        int len1;
        while((len1 = is.read(buffer)) != -1){
            baos.write(buffer,0,len1);
        }

        System.out.println(baos.toString());

        //6.
        fis.close();
        os.close();
        socket.close();
        baos.close();
    }

    /*
    这里涉及到的异常，应该使用try-catch-finally处理
     */
    @Test
    public void server() throws IOException {
        //1.
        ServerSocket ss = new ServerSocket(9090);
        //2.
        Socket socket = ss.accept();
        //3.
        InputStream is = socket.getInputStream();
        //4.
        FileOutputStream fos = new FileOutputStream(new File("beauty2.jpg"));
        //5.
        byte[] buffer = new byte[1024];
        int len;
        while((len = is.read(buffer)) != -1){
            fos.write(buffer,0,len);
        }

        System.out.println("图片传输完成");

        //6.服务器端给予客户端反馈
        OutputStream os = socket.getOutputStream();
        os.write("你好，美女，照片我已收到，非常漂亮！".getBytes());

        //7.
        fos.close();
        is.close();
        socket.close();
        ss.close();
        os.close();

    }
```



## UDP网络编程

```java
//发送端
    @Test
    public void sender() throws IOException {

        DatagramSocket socket = new DatagramSocket();



        String str = "我是UDP方式发送的导弹";
        byte[] data = str.getBytes();
        InetAddress inet = InetAddress.getLocalHost();
        DatagramPacket packet = new DatagramPacket(data,0,data.length,inet,9090);

        socket.send(packet);

        socket.close();

    }
    //接收端
    @Test
    public void receiver() throws IOException {

        DatagramSocket socket = new DatagramSocket(9090);

        byte[] buffer = new byte[100];
        DatagramPacket packet = new DatagramPacket(buffer,0,buffer.length);

        socket.receive(packet);

        System.out.println(new String(packet.getData(),0,packet.getLength()));

        socket.close();
    }
```





## URL编程

1. URL(Uniform Resource Locator)的理解:
   统一资源定位符，对应着互联网的某一资源地址

2. URL的5个基本结构：

   *  http://localhost:8080/examples/beauty.jpg?username=Tom
   *  协议   主机名    端口号  资源地址           参数列表

3. 如何实例化：

   URL url = new URL("http://localhost:8080/examples/beauty.jpg?username=Tom");

4. 常用方法：

   <a href="https://sm.ms/image/yt5sCNoaPfr7IYU" target="_blank"><img src="https://i.loli.net/2021/05/22/yt5sCNoaPfr7IYU.png" ></a>

5. 可以读取、下载对应的url资源：

   ```java
   public class URLTest {
   
       public static void main(String[] args) {
   
           try {
   
               URL url = new URL("http://localhost:8080/examples/beauty.jpg?username=Tom");
   
   //            public String getProtocol(  )     获取该URL的协议名
               System.out.println(url.getProtocol());
   //            public String getHost(  )           获取该URL的主机名
               System.out.println(url.getHost());
   //            public String getPort(  )            获取该URL的端口号
               System.out.println(url.getPort());
   //            public String getPath(  )           获取该URL的文件路径
               System.out.println(url.getPath());
   //            public String getFile(  )             获取该URL的文件名
               System.out.println(url.getFile());
   //            public String getQuery(   )        获取该URL的查询名
               System.out.println(url.getQuery());
   
   
   
   
           } catch (MalformedURLException e) {
               e.printStackTrace();
           }
   
       }
   
   
   }
   ```

   ```java
   public class URLTest1 {
   
       public static void main(String[] args) {
   
           HttpURLConnection urlConnection = null;
           InputStream is = null;
           FileOutputStream fos = null;
           try {
               URL url = new URL("http://localhost:8080/examples/beauty.jpg");
   
               urlConnection = (HttpURLConnection) url.openConnection();
   
               urlConnection.connect();
   
               is = urlConnection.getInputStream();
               fos = new FileOutputStream("day10\\beauty3.jpg");
   
               byte[] buffer = new byte[1024];
               int len;
               while((len = is.read(buffer)) != -1){
                   fos.write(buffer,0,len);
               }
   
               System.out.println("下载完成");
           } catch (IOException e) {
               e.printStackTrace();
           } finally {
               //关闭资源
               if(is != null){
                   try {
                       is.close();
                   } catch (IOException e) {
                       e.printStackTrace();
                   }
               }
               if(fos != null){
                   try {
                       fos.close();
                   } catch (IOException e) {
                       e.printStackTrace();
                   }
               }
               if(urlConnection != null){
                   urlConnection.disconnect();
               }
           }
   
       }
   }
   ```

   



​				

