链接：https://www.nowcoder.com/questionTerminal/bb4f1a23dbb84fd7b77be1fbe9eaaf32
来源：牛客网

编程题]乒乓球筐
热度指数：1268时间限制：1秒空间限制：32768K
 算法知识视频讲解
nowcoder有两盒（A、B）乒乓球，有红双喜的、有亚力亚的……现在他需要判别A盒是否包含了B盒中所有的种类，并且每种球的数量不少于B盒中的数量，该怎么办呢？

输入描述:
输入有多组数据。
每组数据包含两个字符串A、B，代表A盒与B盒中的乒乓球，每个乒乓球用一个大写字母表示，即相同类型的乒乓球为相同的大写字母。
字符串长度不大于10000。


输出描述:
每一组输入对应一行输出：如果B盒中所有球的类型在A中都有，并且每种球的数量都不大于A，则输出“Yes”；否则输出“No”。
示例1
输入
ABCDFYE CDE
ABCDGEAS CDECDE
输出
Yes
No


方法一：答案错误:您提交的程序没有通过所有的测试用例
case通过率为47.62%
import java.util.*;
public class Main{
    public static void main(String[] args){
        Scanner in =new Scanner(System.in);
        while(in.hasNext()){
            String str1=new String();
            String str2=new String();
            str1=in.next();
            str2=in.next();
            if(str1==null&&str2==null){
                System.out.println("Yes");
            }
            for(int i=0;i<str2.length();i++){
                if(!str1.contains(str2.charAt(i)+"")){
                    System.out.println("No");
                    break;
                }
                if(str1.contains(str2.charAt(i)+"")){
                    if(i==str2.length()-1) {
                        System.out.println("Yes");
                    }
                    str1=str1.replace(str2.charAt(i),'#');
                }
            }
        }
    }
}

import java.util.*;
public class Main {
   public static void main(String[] args) {
        Scanner read = new Scanner(System.in);
        while(read.hasNextLine()) {
            String r = read.nextLine();
            String[] boxs = r.split(" ");
            ArrayList<Character> A = new ArrayList<Character>();
            ArrayList<Character> B = new ArrayList<Character>();
            for(int i = 0; i < boxs[0].length(); i++) {
                A.add(boxs[0].charAt(i));
            }
            for(int i = 0; i < boxs[1].length(); i++) {
                B.add(boxs[1].charAt(i));
            }
            for(int i = 0; i < B.size(); i++) {
                if(A.contains(B.get(i))) {
				    //get(int index) 返回此列表中指定位置的元素。  
                    //indexOf(Object o) 返回此列表中指定元素的第一次出现的索引，如果此列表不包含元素，则返回-1。					
                    A.remove(A.get(A.indexOf(B.get(i))));
                    B.remove(i);
					//保证他都是从B箱子里第一个元素开始的
                    i--;
                }
            }
            if(B.size() == 0) {
                System.out.println("Yes");
            } else {
                System.out.println("No");
            }
            A = null;
            B = null;
        }
    }
}