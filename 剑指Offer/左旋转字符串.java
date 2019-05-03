题目描述
汇编语言中有一种移位指令叫做循环左移（ROL），现在有个简单的任务，就是用字符串模拟这个指令的运算结果。对于一个给定的字符序列S，请你把其循环左移K位后的序列输出。例如，字符序列S=”abcXYZdef”,要求输出循环左移3位后的结果，即“XYZdefabc”。是不是很简单？OK，搞定它！

方法一：利用Java里面的StringBuffer类的 substring（）方法截取字符串，然后再用append（）方法追加字符串

注意：

1.将string转为stringbuffer使用stringbuffer的构造方法即可,而如果想把stringbuffer转为string则需要使用stringbuffer类中的tostring()方法. 例:
String -> StringBuffer －－－－ StringBuffer sb=new StringBuffer(String)
StringBuffer -> String －－－－ String s=StringBuffer.toString();

2.

String    substring(int beginIndex)
返回一个字符串，该字符串是此字符串的子字符串。

String    substring(int beginIndex, int endIndex)
返回一个字符串，该字符串是此字符串的子字符串。


import java.util.*;
public class Solution {
    public String LeftRotateString(String str,int n) {
        if(str==null||n<0||str.length()==0)//只要字符串为空或者，n<0直接返回null
            return "";
        StringBuffer s1=new StringBuffer(str.substring(n,str.length()));
        StringBuffer s2=new StringBuffer(str.substring(0,n));
        s1.append(s2);//利用qppend方法吧字符串追加上去
        return s1.toString();//把StringBuffer转为String输出
    }
}

方法二：直接用String的substring 方法，

用substring把字符串交截取之后，用+把两个字符串拼接起来，直接返回

import java.util.*;
public class Solution {
    public String LeftRotateString(String str,int n) {
         if(str==null||n<0||str.length()==0)//只要字符串为空或者，n<0直接返回null
            return "";
        String s1=str.substring(n);
        String s2=str.substring(0,n);
        return s1+s2;//用+把两个字符串连接起来
    }
}

方法三：记得还有个三步翻转法

思路：

Arrays.toString(Object[] obj); // 返回指定数组内容的字符串表示形式。

但是我写出来返回的是数字，不是字符串，我要哭了

import java.util.*;
public class Solution {
    public static void reverse(char[] ch,int left,int right){ 
        while(left<right){
            char temp=ch[left];
            ch[left]=ch[right];
            ch[right]=temp;
            left++;
            right--;
        }
    }
    public String LeftRotateString(String str,int n) {
        //三步翻转法
        if(str==null||n<0||str.length()==0)//只要字符串为空或者，n<0直接返回null
            return "";
        int len=str.length();
        char[] ch=new char[len];
        ch=str.toCharArray();//假设n=2
        reverse(ch,0,n-1);//反转前n个字符，得到cbaXYZdef
        reverse(ch,n,len-1);//反转第n个字符后面所有的字符cbafedZYX
        reverse(ch,0,len-1); //反转整个字符串XYZdefabc
        return Arrays.toString(ch);
	}

}

