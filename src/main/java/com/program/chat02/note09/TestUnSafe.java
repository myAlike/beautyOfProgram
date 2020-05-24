package com.program.chat02.note09;

import sun.misc.Unsafe;

public class TestUnSafe {
    //获取Unsafe的实例（2.2.1）
    static final Unsafe UNSAFE = Unsafe.getUnsafe();
    //记录变量state在类TestUnSafe中的偏移量（2.2.2）
    static final long stateOffset = 0;
    //变量（2.2.3）
    private volatile long state=0;
    static {
        try {
            UNSAFE.objectFieldOffset(TestUnSafe.class.getDeclaredField("state"));
        } catch (NoSuchFieldException e) {
            System.out.println(e.getLocalizedMessage());
            throw new Error(e);
        }
    }

    public static void main(String[] args) {
        //创建实例，并且设置state值为1（2.2.5）
        TestUnSafe test = new TestUnSafe();
        //(2.2.6)
        boolean sucess = UNSAFE.compareAndSwapInt(test, stateOffset, 0, 1);
        System.out.println(sucess);
    }
}
