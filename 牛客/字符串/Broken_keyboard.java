
链接：https://www.nowcoder.com/questionTerminal/b24930625eb24a159f25bca43814e50d
来源：牛客网

On a broken keyboard, some of the keys are worn out. So when you type some sentences, the characters 
corresponding to those keys will not appear on screen.

Now given a string that you are supposed to type, and the string that you actually type out, please list those keys 
which are for sure worn out.

输入描述:
Each input file contains one test case. For each case, the 1st line contains the original string, and the 2nd line contains the typed-out string. Each string contains 
no more than 80 characters which are either English letters [A-Z] (case 
insensitive), digital numbers [0-9], or "_" (representing the space). It is guaranteed that both strings are non-empty.


输出描述:
For each test case, print in one line the keys that are worn out, in the order of being detected. The English letters must be capitalized. 
Each worn out key must be printed once only. It is guaranteed that there is at least one worn out key.
示例1
输入
7_This_is_a_test
_hs_s_a_es
输出


思路：就是找出没有重复的元素并且输出


import java.util.Scanner;
/**
*先把两个句子里面的所有小写的英文字母全部变成大写的
*然后以第一个句子从左向右遍历，第二个里面没有的都输出
*/
public class Main{
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        String str1 = in.next();
        String str2 = in.next();
        str1 = str1.toUpperCase();
        str2 = str2.toUpperCase();
        for (int i = 0; i < str2.length(); i++) {
            //把str1中和str2中重复的元素替换为都有“”的标记
            str1=str1.replace(str2.charAt(i)+"","");
        }
        String s="";
        for(int i=0;i<str1.length();i++){
            //在str1中进行判断，含有标记的不输出，
            if(s.contains(str1.charAt(i)+"")){
                continue;
            }else{
                System.out.print(str1.charAt(i));
                //把不重复的元素添加到中去
                s+=str1.charAt(i);
            }
        }
        System.out.println();
    }
}