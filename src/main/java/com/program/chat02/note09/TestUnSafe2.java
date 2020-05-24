package com.program.chat02.note09;

import sun.misc.Unsafe;

import java.lang.reflect.Field;

public class TestUnSafe2 {
    //获取Unsafe的实例（2.2.1）
    static final Unsafe UNSAFE;
    //记录变量state在类TestUnSafe中的偏移量（2.2.2）
    static final long stateOffset;
    //变量（2.2.3）
    private volatile long state=0;
    static {
        try {
            //使用反射获取UnSafe的成员变量theUnSafe
            Field field = Unsafe.class.getDeclaredField("theUnsafe");
            //设置为可存取
            field.setAccessible(true);
            //获取该变量的值
            UNSAFE= (Unsafe)field.get(null);
            //获取state在TestUnSafe中的偏移量
            stateOffset = UNSAFE.objectFieldOffset(TestUnSafe2.class.getDeclaredField("state"));
        } catch (Exception e) {
            System.out.println(e.getLocalizedMessage());
            throw new Error(e);
        }
    }

    public static void main(String[] args) {
        //创建实例，并且设置state值为1（2.2.5）
        TestUnSafe2 test = new TestUnSafe2();
        //(2.2.6)
        boolean sucess = UNSAFE.compareAndSwapInt(test, stateOffset, 0, 1);
        System.out.println(sucess);
        System.out.println(stateOffset);
    }
}
