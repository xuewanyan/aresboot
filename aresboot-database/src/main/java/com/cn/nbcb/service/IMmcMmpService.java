package com.cn.nbcb.service;

import org.junit.Assert;
import org.springframework.stereotype.Service;

import java.lang.reflect.InvocationHandler;
import java.util.Map;

/**
 * mmp mmc 2张表的查询
 * @author xy
 * @date 2021-9-8
 */
interface InterfaceA {
    String S = "good";
    void f();
}
abstract class ClassA{
    abstract void g();
}
class ClassB extends ClassA implements InterfaceA{

    @Override
    public void f() {
        System.out.print(" "+S);
    }

    @Override
    void g() {
        System.out.print(S);
    }

}
class TEST1{
    public static void main(String[] args) {
        ClassA a = new ClassB();
        InterfaceA b = new ClassB();
        a.g();
        b.f();

    }
}