# 基本数据类型之间的运算规则

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

# 进制

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

# 流程控制

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

# 数组

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
		//3.void fill(int[] a,int val):将指定值填充到数组之中。
		Arrays.fill(arr1,10);
		System.out.println(Arrays.toString(arr1));


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

