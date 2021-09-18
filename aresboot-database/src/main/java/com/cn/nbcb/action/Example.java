package com.cn.nbcb.action;

/**
 * @author xy
 * @date 2021-8-30
 */
public class Example {
    String str = new String("good");
    char[] ch = {'a','b','c'};

    public static void main(String[] args) {
        Example example = new Example();
        example.change(example.str, example.ch);
        System.out.print(example.str + "and");
        System.out.print(example.ch);
    }

    public  void  change(String str,char chr[]){
        str = "test ok";
        chr[0] = 'g';
    }
}
