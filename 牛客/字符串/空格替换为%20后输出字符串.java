package com.bit;

import java.util.Scanner;
/*
请实现一个函数，将一个字符串中的每个空格替换成“%20”。
例如，当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy。
 */

public class replaceSpace {

    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        String sc=in.nextLine();
        StringBuffer sb=new StringBuffer(sc);
        System.out.println(replaceSpace(sb));;
    }


    public static   String replaceSpace(StringBuffer str) {
        StringBuffer sb=new StringBuffer();
        for(int i=0;i<str.length();i++){
            char ch=str.charAt(i);
            if(String.valueOf(ch).equals(" ")){
                sb.append("%20");
            }else{
                sb.append(ch);
            }
        }
        return sb.toString();


    }
}
