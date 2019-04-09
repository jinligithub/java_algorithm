
时间限制：1秒 空间限制：32768K 热度指数：919092
本题知识点： 字符串

题目描述

请实现一个函数，将一个字符串中的每个空格替换成
“%20”。例如，当字符串为We Are Happy.
则经过替换之后的字符串为We%20Are%20Happy。


public class Solution {
    public String replaceSpace(StringBuffer str) {
        if(str==null){//如果字符串为空，直接返回空
            return null;
        }
        StringBuffer newStr=new StringBuffer();
        for(int i=0;i<str.length();i++){
            if(str.charAt(i)==' '){//如过遇到空格直接在字符串后边追加%20
                newStr.append('%');
                newStr.append('2');
                newStr.append('0');
            }else{
                newStr.append(str.charAt(i));
            }
        }
        return newStr.toString();
    }
}