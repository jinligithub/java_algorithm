package com.bite.科大飞讯;
/*
输入一端字符然后把，里面的输入拿出来然后按从小到大的顺序进行排序
 */
import java.util.*;
public class findNumber {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        char[] ch=sc.nextLine().toCharArray();
        if(ch==null||ch.length==0){
            System.out.println("-1");
        }
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<ch.length;i++){
            if(ch[i]>='0'&&ch[i]<='9'){
                sb.append(ch[i]);
            }
        }
        if(sb==null||sb.length()==0){
            System.out.println(-1);
        }else {
            char[] re=sb.toString().toCharArray();
            Arrays.sort(re);
            System.out.println(re);
        }

    }
}