链接：https://www.nowcoder.com/questionTerminal/aced908691df4ebca6744f9fbd437749
来源：牛客网

[编程题]说反话 (20)
热度指数：3147时间限制：1秒空间限制：32768K

给定一句英语，要求你编写程序，将句中所有单词的顺序颠倒输出。

输入描述:
测试输入包含一个测试用例，在一行内给出总长度不超过80的字符串。字符串由若干单词和若干空格组成，其中单词是由英文字母（大小写有区分）组成的字符串，单词之间用1个空格分开，输入保证句子末尾没有多余的空格。


输出描述:
每个测试用例的输出占一行，输出倒序后的句子。
示例1
输入
Hello World Here I Come
输出
Come I Here World Hello


方法一：用字符数组方法输出
import java.util.Scanner;
public class Main{
    public static void main(String[] args){
        Scanner in =new Scanner(System.in);
            String str=in.nextLine();
            String[] s=str.split(" ");//按照空格分成字符数组
            for(int i=s.length;i>0;i--){
                System.out.print(s[i-1]+" ");
                //if(i!=0){
                //    System.out.print(" ");//可以这样输出空格，也可以在单词后边直接输出字符
                //}
            }
    }
}

方法二：针对于有多个空格的
import java.util.Scanner;
public class Main{
    public static void main(String[] args){
            Scanner in =new Scanner(System.in);
            String str=in.nextLine();
            String[] s=str.split("\\s+ ");//   "\\s+"取得多个空
			]格
            for(int i=s.length;i>0;i--){
                System.out.print(s[i-1]+" ");
            }
	}
}


去掉方法空格方法：
1.String.trim():去掉首位空格
2.String.replace(" ",""):去掉所有空格，包括首尾，中间的
3.String.replaceAll(" +",""):去掉所有空格
4.String.split("\\s+"):去掉连续多个空格